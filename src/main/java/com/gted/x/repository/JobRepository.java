package com.gted.x.repository;

import com.gted.x.entity.Job;
import org.springframework.data.repository.CrudRepository;

import java.net.URL;

/**
 * Created by Вадим on 27.09.2017.
 */

public interface JobRepository extends CrudRepository<Job,Long> {

    Job findByCallbackUrl(URL callBack);
}
