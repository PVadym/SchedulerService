package com.gted.x.service;

import com.gted.x.entity.Job;
import com.gted.x.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URL;

/**
 * Created by Вадим on 27.09.2017.
 */
@Service
public class JobServiceImp implements JobService{

    private final JobRepository repository;

    @Autowired
    public JobServiceImp(JobRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void delete(long id) {
        repository.delete(id);
    }

    @Override
    @Transactional
    public Job add(Job job) {
        return repository.save(job);
    }

    @Override
    @Transactional(readOnly = true)
    public Job getById(long id) {
        return repository.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Job getByCallbackUrl(URL callBack) {
        return repository.findByCallbackUrl(callBack);
    }
}
