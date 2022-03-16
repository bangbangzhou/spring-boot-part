package com.learn.springboot;

import com.learn.springboot.component.TestComponent1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import sun.security.krb5.Config;

@SpringBootTest
class SpringBootPart31ApplicationTests {



    @Test
    void contextLoads() {

    }

}
