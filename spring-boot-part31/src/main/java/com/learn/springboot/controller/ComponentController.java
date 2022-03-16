package com.learn.springboot.controller;

import com.learn.springboot.component.TestComponent1;
import com.learn.springboot2.Testcomponent3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ComponentController {

    @Autowired
    private TestComponent1 component;

    @GetMapping("testcomponent")
    public void component(){
        component.component();
    }
}
