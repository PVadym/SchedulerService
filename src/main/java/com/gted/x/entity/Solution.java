package com.gted.x.entity;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Вадим on 27.09.2017.
 */
public class Solution {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPATest");
    static EntityManager em = emf.createEntityManager();

    private static String path = "C:\\IdeaProjectProg\\SchedulerService\\src\\main\\java\\com\\gted\\x\\test.txt";

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
        Job job = mapper.readValue(new FileReader(path),Job.class);
        System.out.println(job);
        em.getTransaction().begin();
        em.persist(job);
        em.getTransaction().commit();
        System.out.println("++++++++++++++++++++++++++");


        em.close();
        emf.close();




    }
}
