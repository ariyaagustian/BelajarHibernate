package com.gmail.ariyaagustian.training.spring;

import com.gmail.ariyaagustian.training.spring.beans.BeanA;
import com.gmail.ariyaagustian.training.spring.beans.BeanB;
import com.gmail.ariyaagustian.training.spring.beans.BeanC;
import com.gmail.ariyaagustian.training.spring.beans.BeanD;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
@Configuration
public class MainApplication {

    @Bean
    public BeanD beanD() {
        return new BeanD(20);
    }

    @Bean
    public BeanD beanD1(){
        return new BeanD(27);
    }

    @Bean
    public BeanC beanC() {
        return new BeanC("Ariya Agustian",10);

    }

    @Bean
    public BeanB beansB(
            BeanC c,
            @Qualifier("beanD1") BeanD d) {
        return new BeanB(c, d);
    }

    @Bean
    public BeanA beanA(BeanB b) {
        return new BeanA(b);
    }

    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(MainApplication.class);
        BeanA a = container.getBean(BeanA.class);
        log.info("{}", a);

    }

}