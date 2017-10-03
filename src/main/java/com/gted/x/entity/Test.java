package com.gted.x.entity;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Вадим on 27.09.2017.
 */
public class Test {

//    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPATest");
//
//    static EntityManager em = emf.createEntityManager();
//
//    private static String path = "C:\\IdeaProjectProg\\SchedulerService\\src\\main\\java\\com\\gted\\x\\test.txt";

    public static void main(String[] args) throws IOException, ParseException {
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
//        Job job = mapper.readValue(new FileReader(path),Job.class);
//        System.out.println(job);
//        em.getTransaction().begin();
//        em.persist(job);
//        em.getTransaction().commit();
//        System.out.println("++++++++++++++++++++++++++");
//
//
//        em.close();
//        emf.close();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = format.parse("9999-12-31 23:59:59");
        String str = format.format(date);

        System.out.println(new Date(253402293599000L));




    }
}
