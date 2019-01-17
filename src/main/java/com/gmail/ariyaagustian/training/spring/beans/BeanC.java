package com.gmail.ariyaagustian.training.spring.beans;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class BeanC {

    public BeanC() {
    }

    public BeanC(Integer no) {
        this.nomor = no;
    }


    @Value("Dimas Maryanto")
    private String namaLengkap;
    @Value("10")
    private Integer nomor;

}