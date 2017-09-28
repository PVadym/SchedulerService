package com.gted.x.controller;

import com.gted.x.entity.Job;
import com.gted.x.entity.JobBody;
import com.gted.x.entity.RequestBody;
import com.gted.x.entity.Response;
import com.gted.x.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    JobService jobService;

    @PostMapping(value = "/jobs", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response create(@Valid @org.springframework.web.bind.annotation.RequestBody RequestBody body){
        System.out.println(body);
        Job savedJob = jobService.add(body.getJob());
        return new Response(new JobBody(savedJob.getJobId()));
    }

    @GetMapping(value = "/jobs/{job_id}")
    public ResponseEntity<RequestBody> get(@PathVariable ("job_id") long id){
        Job job = jobService.getById(id);
        System.out.println(job);
        RequestBody body = new RequestBody(job);
        body.setJob(job);
        return ResponseEntity.ok(body);
    }

    @DeleteMapping(value = "/jobs/{job_id}")
    public ResponseEntity delete(@PathVariable ("job_id") long id){
        jobService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
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
