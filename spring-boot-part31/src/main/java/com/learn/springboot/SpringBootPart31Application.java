package com.learn.springboot;

import com.learn.springboot.component.TestComponent1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@ComponentScan(basePackages = {"com.learn.springboot2","com.learn.springboot"})
@SpringBootApplication
public class SpringBootPart31Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootPart31Application.class, args);
        //获取所有bean的名称
        String[] names = applicationContext.getBeanDefinitionNames();
        for(String name:names){
            if(name.startsWith("testComponent")){
                System.out.println(name);
            }
        }

    }

}
