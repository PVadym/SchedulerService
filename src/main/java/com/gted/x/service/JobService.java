package com.gted.x.service;

import com.gted.x.entity.Job;

import java.net.URL;

/**
 * Created by Вадим on 27.09.2017.
 */
public interface JobService {

    void delete (long id);
    Job add (Job job);
    Job getById(long id);
    Job getByCallbackUrl(URL callBack);

}
