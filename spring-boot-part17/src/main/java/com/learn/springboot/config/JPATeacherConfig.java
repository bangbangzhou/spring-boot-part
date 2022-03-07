package com.learn.springboot.config;

import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactoryTeacher",
        transactionManagerRef="transactionManagerTeacher",
        basePackages= {"com.learn.springboot.entity.teacher"}) //换成你自己的Repository所在位置
public class JPATeacherConfig {

    @Resource
    private JpaProperties jpaProperties;

    @Resource
    private HibernateProperties hibernateProperties;


    @Bean(name = "teacherDataSource")
    //使用application.yml的teacher数据源配置
    @ConfigurationProperties(prefix="spring.datasource.teacher")
    public DataSource teacherDataSource() {
        return DataSourceBuilder.create().build();
    }

    //teacher实体管理器
    @Bean(name = "entityManagerTeacher")
    public EntityManager entityManagerTeacher(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryTeacher(builder).getObject().createEntityManager();

    }



    @Bean(name = "entityManagerFactoryTeacher")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryTeacher (EntityManagerFactoryBuilder builder) {

        Map<String,Object> properties =
                hibernateProperties.determineHibernateProperties(
                        jpaProperties.getProperties(),
                        new HibernateSettings());

        return builder
                .dataSource(teacherDataSource())
                .properties(properties)
                //换成数据表对应实体类所在包
                .packages("com.learn.springboot.entity.teacher")
                .persistenceUnit("secondaryPersistenceUnit")
                .build();
    }


    @Bean(name = "transactionManagerTeacher")
    PlatformTransactionManager transactionManagerTeacher(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryTeacher(builder).getObject());

    }

}