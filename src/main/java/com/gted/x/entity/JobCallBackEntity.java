package com.gted.x.entity;

/**
 * Created by Вадим on 10.10.2017.
 */
public class JobCallBackEntity {
    private JobEntity jobEntity;
    private long id;
    private Result result;

    public JobCallBackEntity() {
    }

    public JobCallBackEntity(JobEntity jobEntity) {
        this.id = jobEntity.getJobId();
        this.result = jobEntity.getLastRunResult();
    }

    @Override
    public String toString() {
        return "JobCallBackEntity{" +
                "id=" + id +
                ", result=" + result +
                '}';
    }
}
