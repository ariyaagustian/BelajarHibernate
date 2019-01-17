package com.gmail.ariyaagustian.training.spring.beans;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Data
@Component
public class BeanB {

    @Autowired
    public BeanB(
            @Qualifier("beanC") BeanC c,
            @Qualifier("beanD") BeanD d,
            @Qualifier("beanD1") BeanD d1) {
        this.c = c;
        this.d = d;
        this.d1 = d1;
    }

    private BeanC c;
    private BeanD d;
    private BeanD d1;

}