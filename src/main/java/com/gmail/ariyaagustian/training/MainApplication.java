package com.gmail.ariyaagustian.training;

import com.gmail.ariyaagustian.training.configuration.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainApplication {

    private static final Logger log = LoggerFactory.getLogger(MainApplication.class);

    public static void main(String[] args) {
        System.out.println("halo saya sedang belajar maven!");

        SessionFactoryUtil util = new SessionFactoryUtil();
        SessionFactory sessionFactory = util.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        log.info("hibernate connection open!");

        session.close();
        sessionFactory.close();

        log.info("hibernate conneciton close!");

    }
}