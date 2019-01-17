package com.gmail.ariyaagustian.training.spring;

import com.gmail.ariyaagustian.training.spring.beans.BeanA;
import com.gmail.ariyaagustian.training.spring.beans.BeanD;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@ComponentScan(basePackages = "com.gmail.ariyaagustian.training.spring.beans")
public class MainApplication {

    @Bean
    public BeanD beanD() {
        BeanD d = new BeanD();
        d.setNomor(10);
        return d;
    }

    @Bean
    public BeanD beanD1() {
        BeanD d = new BeanD();
        d.setNomor(11);
        return d;
    }


    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(MainApplication.class);
        BeanA a = container.getBean(BeanA.class);
        log.info("{}", a);

    }
}