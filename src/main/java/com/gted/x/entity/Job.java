package com.gted.x.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.net.URL;
import java.util.Date;

/**
 * Created by Вадим on 27.09.2017.
 */
@Entity
@Table(name = "jobs")
//@JsonRootName(value = "body")
public class Job implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("job_id")
    @Column(name = "id")
    private Long jobId;

    @Embedded
    @JsonProperty("task")
    private Task task;

    @Column(name = "type")
    @JsonProperty("type")
    private String type;

    @Column(name = "scheduled_at")
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
    private URL callbackUrl;

    public Job() {
    }

    public Job(Task task, String type, String scheduledAt, int executeTimes, Date startTime, Date endTime, String timeZone, URL callbackUrl) {
        this.task = task;
        this.type = type;
        this.scheduledAt = scheduledAt;
        this.executeTimes = executeTimes;
        this.startTime = startTime;
        this.endTime = endTime;
        this.timeZone = timeZone;
        this.callbackUrl = callbackUrl;
    }

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
        this.type = type;
    }
    @JsonProperty("scheduled_at")
    public String getScheduledAt() {
        return scheduledAt;
    }
    @JsonProperty("scheduled_at")
    public void setScheduledAt(String scheduledAt) {
        this.scheduledAt = scheduledAt;
    }

    public int getExecuteTimes() {
        return executeTimes;
    }

    public void setExecuteTimes(int executeTimes) {
        this.executeTimes = executeTimes;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public URL getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(URL callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    @Override
    public String toString() {
        return "Job{" +
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
