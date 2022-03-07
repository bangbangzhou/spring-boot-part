package com.learn.springboot.entity;

import lombok.Data;

@Data
public class PageNumber  {
    /**
     * 每页数据量
     */
    private int size;
    /**
     * 第几页，从第o开始
     */
    private int number;
}
