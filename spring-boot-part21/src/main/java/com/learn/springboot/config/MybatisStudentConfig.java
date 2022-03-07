package com.learn.springboot.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import javax.sql.DataSource;



@Configuration
//数据源student库接口存放目录
@MapperScan(basePackages = "com.learn.springboot.entity.student",
        sqlSessionTemplateRef = "sqlSessionTemplateStudent")
public class MybatisStudentConfig {

    /**
     * 主数据源默认使用Student
     *
     * @return
     */
    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.student")
    public DataSource studentDataSource() {
        return DataSourceBuilder.create().build();
    }



    @Bean
    public SqlSessionFactory sqlSessionFactoryStudent() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(studentDataSource());
        //设置XML文件存放位置.注意这里student目录
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/student/*.xml"));
        return bean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplateStudent() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryStudent());
    }

}



