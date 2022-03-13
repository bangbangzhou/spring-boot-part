package com.learn.springboot.component;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

@Component
public class ComponentTask {

    public static Random random =new Random();

    /**
     * 无返回值
     */
    @Async("threadPoolTaskExecutor2")
    public void asyncMethodWithVoidReturnType_One() throws InterruptedException {
        System.out.println("开始做asyncMethodWithVoidReturnType_One");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end = System.currentTimeMillis();
        System.out.println("完成asyncMethodWithVoidReturnType_One，耗时：" + (end - start) + "毫秒"+"  threadname:"+Thread.currentThread().getName());


    }
    @Async("threadPoolTaskExecutor1")
    public void asyncMethodWithVoidReturnType_Two() throws InterruptedException {
        System.out.println("开始做asyncMethodWithVoidReturnType_Two");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(2000));
        long end = System.currentTimeMillis();
        System.out.println("完成asyncMethodWithVoidReturnType_Two，耗时：" + (end - start) + "毫秒" +"  threadname:"+Thread.currentThread().getName());

    }
    @Async("threadPoolTaskExecutor1")
    public void asyncMethodWithVoidReturnType_Three() throws InterruptedException {
        System.out.println("开始做asyncMethodWithVoidReturnType_Three");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(3000));
        long end = System.currentTimeMillis();
        System.out.println("完成asyncMethodWithVoidReturnType_Three，耗时：" + (end - start) + "毫秒"+ "  threadname:"+Thread.currentThread().getName());

    }


    /**
     * 有返回值的
     * @return
     */
    @Async
    public Future<String> asyncMethodWithReturnType_One() throws InterruptedException {
        System.out.println("开始asyncMethodWithReturnType_One");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成asyncMethodWithReturnType_One，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务一完成");
    }
}
