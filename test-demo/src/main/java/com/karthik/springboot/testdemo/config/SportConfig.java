package com.karthik.springboot.testdemo.config;

import com.karthik.springboot.testdemo.common.Coach;
import com.karthik.springboot.testdemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
