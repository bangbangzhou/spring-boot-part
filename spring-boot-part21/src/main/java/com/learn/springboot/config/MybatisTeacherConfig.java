package com.learn.springboot.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import javax.sql.DataSource;

@Configuration
//数据源student库接口存放目录
@MapperScan(basePackages = "com.learn.springboot.entity.teacher",
        sqlSessionTemplateRef = "sqlSessionTemplateTeacher")
public class MybatisTeacherConfig {
    /**
     * 主数据源默认使用Student
     *
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.teacher")
    public DataSource teacherDataSource() {
        return DataSourceBuilder.create().build();
    }



    @Bean
    public SqlSessionFactory sqlSessionFactoryTeacher() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(teacherDataSource());
        //设置XML文件存放位置,注意这里teacher目录
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/teacher/*.xml"));
        return bean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplateTeacher() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryTeacher());
    }

}

