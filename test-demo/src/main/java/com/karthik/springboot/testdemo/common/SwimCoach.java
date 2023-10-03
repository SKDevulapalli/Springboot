package com.karthik.springboot.testdemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


public class SwimCoach implements Coach {

    public SwimCoach(){
        System.out.println("Inside SwimCoach");
    }

    @Override
    public String getDailyWorkout(){
        return "Practice for Olympic swimming!";
    }
}
