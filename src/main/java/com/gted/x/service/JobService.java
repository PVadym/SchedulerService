package com.gted.x.service;

import com.gted.x.entity.JobEntity;

/**
 * Created by Вадим on 27.09.2017.
 */
public interface JobService {

    void delete (long id);
    JobEntity add (JobEntity jobEntity);
    JobEntity getById(long id);
    JobEntity startJob(JobEntity jobEntity);


}
