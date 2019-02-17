package com.course.bean;

import lombok.Data;
import org.springframework.context.annotation.Bean;

@Data
public class User {
    private String username;
    private String password;
    private String name;
    private int age;
    private String sex;

}
