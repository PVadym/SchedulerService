package com.gted.x.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.Date;

import static org.apache.commons.lang3.StringUtils.isNotBlank;


@Entity
@Table(name = "jobs")
public class JobEntity implements Serializable{

    // Max Date: 9999-12-31 23:59:59
    private static final Long FOREVER = 253402293599000L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("job_id")
    @Column(name = "id")
    private Long jobId;

    @Embedded
    @Valid
    @JsonProperty("task")
    private Task task;

    @Column(name = "type")
    @JsonProperty("type")
    private String type;

    @Column(name = "scheduled_at")
    @JsonProperty("scheduled_at")
    private String scheduledAt;

    @Column(name = "execute_times")
    @JsonProperty("execute_times")
    private int executeTimes;

    @Column(name = "start_time")
    @Temporal(value = TemporalType.TIMESTAMP)
    @JsonProperty("start_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @Column(name = "end_time")
    @Temporal(value = TemporalType.TIMESTAMP)
    @JsonProperty("end_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    @Column(name = "time_zone")
    @JsonProperty("time_zone")
    private String timeZone;


    @Column(name = "callback_url")
    @JsonProperty("callback_url")
    private String callbackUrl;

    @Column(name = "next_run_at")
    @Temporal(value = TemporalType.TIMESTAMP)
    @JsonProperty("next_run_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date nextRunAt;

    @Column(name = "last_run_at")
    @Temporal(value = TemporalType.TIMESTAMP)
    @JsonProperty("last_run_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastRunAt;

    @Embedded
    @Valid
    @JsonProperty("last_run_result")
    private Result lastRunResult;

//    public JobEntity() {
//        this.task = new Task();
//        this.type = "http";
//        this.scheduledAt = "";
//        this.executeTimes = 0;
//        this.startTime = new Date();
//        this.endTime = new Date(FOREVER);
//        this.timeZone = "Asia/Singapore";
//        this.callbackUrl = "";
//        this.lastRunResult = new Result();
//
//    }

//    public JobEntity(Task task, String type, String scheduledAt, int executeTimes, Date startTime, Date endTime, String timeZone, String callbackUrl) {
//        this();
//        setTask(task);
//        setType(type);
//        setScheduledAt(scheduledAt);
//        setExecuteTimes(executeTimes);
//        setStartTime(startTime);
//        setEndTime(endTime);
//        setTimeZone(timeZone);
//        setCallbackUrl(callbackUrl);
//    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = isNotBlank(type) ? type : "http";
    }

    public String getScheduledAt() {
        return scheduledAt;
    }

    public void setScheduledAt(String scheduledAt) {
        this.scheduledAt = isNotBlank(scheduledAt) ? scheduledAt : "";
    }

    public int getExecuteTimes() {
        return executeTimes;
    }

    public void setExecuteTimes(int executeTimes) {
        this.executeTimes = executeTimes > 0 ? executeTimes : 0;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime == null ? new Date() : startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime == null ? new Date(Long.MAX_VALUE) : endTime;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = isNotBlank(timeZone)? timeZone : "Asia/Singapore";
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl){
        this.callbackUrl = isNotBlank(callbackUrl)? callbackUrl : "";
    }

    public Date getNextRunAt() {
        return nextRunAt;
    }

    public void setNextRunAt(Date nextRunAt) {
        this.nextRunAt = nextRunAt;
    }

    public Date getLastRunAt() {
        return lastRunAt;
    }

    public void setLastRunAt(Date lastRunAt) {
        this.lastRunAt = lastRunAt;
    }

    public Result getLastRunResult() {
        return lastRunResult;
    }

    public void setLastRunResult(Result lastRunResult) {
        this.lastRunResult = lastRunResult;
    }

    @Override
    public String toString() {
        return "JobEntity{" +
                "jobId=" + jobId +
                ", task=" + task +
                ", type='" + type + '\'' +
                ", scheduledAt='" + scheduledAt + '\'' +
                ", executeTimes=" + executeTimes +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", timeZone='" + timeZone + '\'' +
                ", callbackUrl=" + callbackUrl +
                '}';
    }
}
