package com.learn.springboot;

import com.learn.springboot.component.ComponentTask;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SpringBootPart27ApplicationTests {
    @Autowired
    private ComponentTask componentTask;

    @Test
    void contextLoads() throws InterruptedException {
        componentTask.asyncMethodWithVoidReturnType_One();
        componentTask.asyncMethodWithVoidReturnType_Two();
        componentTask.asyncMethodWithVoidReturnType_Three();

        Thread.currentThread().join();

    }

}
