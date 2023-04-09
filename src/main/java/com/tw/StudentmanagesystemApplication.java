package com.tw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tw.dao")
public class StudentmanagesystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentmanagesystemApplication.class, args);
    }

}
