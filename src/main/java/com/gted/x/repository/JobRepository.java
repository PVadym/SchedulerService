package com.gted.x.repository;

import com.gted.x.entity.JobEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Вадим on 27.09.2017.
 */

public interface JobRepository extends CrudRepository<JobEntity,Long> {

}
