package com.gted.x.controller;

import com.gted.x.entity.*;
import com.gted.x.exception.EntityNotFoundException;
import com.gted.x.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.MalformedURLException;
import java.net.URL;

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

        Job savedJob = jobService.add(requestJobBody.getJob());
        JobBody body = new JobBody(savedJob.getJobId());
        return new JobResponseBody<JobBody>(body);
    }

    @GetMapping(value = "/jobs/{job_id}")
    public JobResponseBody<Job> get(@PathVariable ("job_id") long id){
        Job job = jobService.getById(id);
        if(job == null){
            throw new EntityNotFoundException(String.format("job with %s not found", id));
        }
        return new JobResponseBody<Job>(job);
    }

    @DeleteMapping(value = "/jobs/{job_id}")
    @SuppressWarnings("unchecked")
    public Response delete(@PathVariable ("job_id") long id){
        Job job = jobService.getById(id);
        if(job == null){
            throw new EntityNotFoundException(String.format("job with ID %s not found", id));
        }
        jobService.delete(id);
        return new Response(200, "jod deleted successfully");
    }

    @PostMapping(value = "/jobs/{callbackUrl}")
    public ResponseEntity<Job> getByCallbackUrl(@PathVariable("callbackUrl") String callbackUrl){
        Job job = null;
        try {
            job = jobService.getByCallbackUrl(new URL(callbackUrl));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println(job);
        return ResponseEntity.ok(job);
    }
}
