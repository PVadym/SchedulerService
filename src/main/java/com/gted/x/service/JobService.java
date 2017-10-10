package com.gted.x.service;

import com.gted.x.entity.JobEntity;

/**
 * Created by Вадим on 27.09.2017.
 */
public interface JobService {

    JobEntity add (JobEntity jobEntity);
    JobEntity getById(long id);
    JobEntity startJob(JobEntity jobEntity);
    void cancelJob(long id);
}
