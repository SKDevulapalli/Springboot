package com.karthik.springboot.testdemo.rest;

import com.karthik.springboot.testdemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach mycoach;

    /*//Constructor Injection
    @Autowired //tells spring to inject a dependency. //optional if there is only one constructor
    DemoController(Coach theCoach){
        mycoach = theCoach;
    }*/

    @Autowired
    public void setCoach(@Qualifier("swimCoach") Coach theCoach){
        System.out.println("Inside the constructor of  "+getClass().getName());
        mycoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return mycoach.getDailyWorkout();
    }

}
