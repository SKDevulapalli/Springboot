package com.karthik.springboot.testdemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component //this will mark it as Spring Bean and Makes it available for dependency Injection
public class TennisCoach implements Coach {

    public TennisCoach() {
        System.out.println("inside tennis");
    }

    @Override
    public String getDailyWorkout(){
        return "Practice for US Open!";
    }
}
