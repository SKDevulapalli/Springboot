package com.karthik.springboot.testdemo.common;

import com.karthik.springboot.testdemo.common.Coach;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component //this will mark it as Spring Bean and Makes it available for dependency Injection
public class CricketCoach implements Coach {


    public CricketCoach() {
        System.out.println("Inside cricket");
    }

    @Override
    public String getDailyWorkout(){
        return "Practice for World Cup!";
    }
}
