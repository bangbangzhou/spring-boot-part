package com.learn.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyRestTemplate {

    /**
     * 默认使用JDK 自带的HttpURLConnection作为底层实现
     * @return
     */
//    @Bean
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }

//    @Bean
//    public RestTemplate restTemplateOkHttp(){
//        return  new RestTemplate(new OkHttp3ClientHttpRequestFactory());
//    }

    @Bean
    public  RestTemplate restTemplateHttpClient(){
        return new RestTemplate(new HttpComponentsClientHttpRequestFactory());
    }
}
