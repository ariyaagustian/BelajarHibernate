package com.gmail.ariyaagustian.training.spring.beans;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeanA {
    private BeanB b;
}
