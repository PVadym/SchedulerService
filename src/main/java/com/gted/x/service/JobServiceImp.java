package com.gted.x.service;

import com.gted.x.entity.JobCallBackEntity;
import com.gted.x.entity.JobEntity;
import com.gted.x.entity.Response;
import com.gted.x.entity.Result;
import com.gted.x.exception.EntityNotFoundException;
import com.gted.x.exception.JobException;
import com.gted.x.repository.JobRepository;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.TimeZone;

import static org.quartz.CronScheduleBuilder.cronSchedule;

/**
 * Created by Вадим on 27.09.2017.
 */
@Service
public class JobServiceImp implements JobService{

    private final JobRepository jobRepository;

    private final Scheduler scheduler;

    @Autowired
    public JobServiceImp(JobRepository jobRepository, Scheduler scheduler) {
        this.jobRepository = jobRepository;
        this.scheduler = scheduler;
    }


    @Override
    @Transactional
    public JobEntity add(JobEntity jobEntity) {
        return jobRepository.save(jobEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public JobEntity getById(long id) {
        JobEntity jobEntity =  jobRepository.findOne(id);
        if(jobEntity == null){
            throw new EntityNotFoundException(String.format("jobEntity with ID %s not found", id));
        }

        return jobEntity;
    }

    @Override
    public JobEntity startJob(JobEntity jobEntity) {
        JobEntity jobEntityToStart = this.add(jobEntity);
        JobDetail job = createJob(jobEntityToStart.getJobId());

        Date startTime = jobEntityToStart.getStartTime() == null
                ? new Date() : jobEntityToStart.getStartTime();

        Date endTime = jobEntityToStart.getEndTime() == null
                ? new Date(253402293599000L) : jobEntityToStart.getEndTime();

        TimeZone timeZone = jobEntity.getTimeZone() == null
                ? TimeZone.getDefault() : TimeZone.getTimeZone(jobEntity.getTimeZone());


        Trigger trigger = TriggerBuilder
                .newTrigger()
                .startAt(startTime)
                .withSchedule(cronSchedule(jobEntityToStart.getScheduledAt()).inTimeZone(timeZone))
                .endAt(endTime)
                .build();

        try {
            scheduler.scheduleJob(job, trigger);

        } catch (SchedulerException e) {
            throw new JobException(e.getMessage());
        }
        return jobEntityToStart;
    }

    @Override
    public void cancelJob(long id) {
        try {
            scheduler.deleteJob(new JobKey(String.valueOf(id)));
        } catch (Exception ignored) {
            throw new JobException();
        }

        JobEntity jobEntity = jobRepository.findOne(id);
        if (jobEntity == null) throw new EntityNotFoundException(String.format("jobEntity with ID %s not found", id));
        jobEntity.setLastRunResult(new Result(200,"CANCELED"));
        jobRepository.save(jobEntity);
        sendCallback(jobEntity);
    }

    private JobDetail createJob(long id) {
        JobDataMap data = new JobDataMap();
        data.put("repository", jobRepository);

        return JobBuilder
                .newJob(ScheduleJob.class)
                .setJobData(data)
                .withIdentity(String.valueOf(id))
                .build();
    }

    public static class ScheduleJob implements Job {
        @Override
        public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
            JobDataMap data = jobExecutionContext.getJobDetail().getJobDataMap();
            long id = Long.parseLong(jobExecutionContext.getJobDetail().getKey().getName());
            JobRepository jobsRepository = (JobRepository) data.get("repository");

            JobEntity jobEntity = jobsRepository.findOne(id);

            Date nextRunAt = jobExecutionContext.getNextFireTime();
            Date lastRunAt = jobExecutionContext.getPreviousFireTime();
            Result result = new Result();
            if(lastRunAt != null) {
                result.setCode(200);
                result.setBody("OK");
            }

            jobEntity.setNextRunAt(nextRunAt);
            jobEntity.setLastRunAt(lastRunAt);
            jobEntity.setLastRunResult(result);
            jobsRepository.save(jobEntity);
            sendCallback(jobEntity);
        }
    }

    private static void sendCallback(JobEntity job) {
        if (job.getCallbackUrl() == null) return;
        RestTemplate template = new RestTemplate();
        JobCallBackEntity callBackEntity = new JobCallBackEntity(job);
        template.postForEntity(job.getCallbackUrl(), new Response(callBackEntity), Object.class);
    }


}
