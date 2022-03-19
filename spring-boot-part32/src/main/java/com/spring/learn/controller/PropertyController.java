package com.spring.learn.controller;

import com.spring.learn.property.TestConfigurationProperties;
import com.spring.learn.property.Testproperties;
import com.spring.learn.property.UidConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: spring-boot-part32
 * @package: com.spring.learn.controller
 * @classname: PropertyController
 * @description:
 * @author: zbb
 * @create: 2022-03-18
 */
@RestController
public class PropertyController {

    @Autowired
    private Testproperties testproperties;

    @Autowired
    private UidConfigurationProperties uidConfigurationProperties;

    @Autowired
    @Qualifier("testconfigurationproperties2")
    private TestConfigurationProperties configurationProperties2;

    @Autowired
    @Qualifier("testconfigurationproperties3")
    private TestConfigurationProperties configurationProperties3;

    @Resource(name = "testconfigurationproperties3")
    private TestConfigurationProperties configurationProperties4;

    @GetMapping("/properties")
    public String testproperties(){
        return testproperties.toString();
    }

    @GetMapping("/configproperties")
    public String configproperties(){
        return configurationProperties3.toString();
    }
    @GetMapping("/configproperties2")
    public String configproperties2(){
        return configurationProperties2.toString();
    }

    @GetMapping("/configurationProperties4")
    public String configurationProperties4(){
        return configurationProperties4.toString();
    }


    @GetMapping("/configproperties3")
    public String configproperties3(){
        return configurationProperties3.toString();
    }

    @GetMapping("/uid")
    public String uid(){
        return uidConfigurationProperties.toString();
    }


}
