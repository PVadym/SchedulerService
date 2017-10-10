package com.gted.x.controller;

import com.gted.x.entity.*;
import com.gted.x.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Вадим on 27.09.2017.
 */
@RestController
public class JobController {


    @Autowired
    private JobService jobService;

    @PostMapping(value = "/jobs")
    @SuppressWarnings("unchecked")
    public JobResponseBody<JobBody> createJob(@Valid @RequestBody JobRequestBody requestJobBody){

        JobBody body = new JobBody(jobService.startJob(requestJobBody.getJobEntity()).getJobId());
        return new JobResponseBody<JobBody>(body);
    }

    @GetMapping(value = "/jobs/{job_id}")
    public JobResponseBody<JobEntity> get(@PathVariable ("job_id") long id){
        JobEntity jobEntity = jobService.getById(id);
        return new JobResponseBody<JobEntity>(jobEntity);
    }

    @DeleteMapping(value = "/jobs/{job_id}")
    @SuppressWarnings("unchecked")
    public Response delete(@PathVariable ("job_id") long id){
        jobService.cancelJob(id);
        return new Response(200, "jod deleted successfully");
    }

}
