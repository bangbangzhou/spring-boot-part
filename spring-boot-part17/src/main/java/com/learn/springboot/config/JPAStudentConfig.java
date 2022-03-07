package com.learn.springboot.config;

import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
        entityManagerFactoryRef="entityManagerFactoryStudent",
        transactionManagerRef="transactionManagerStudent",
        basePackages= {"com.learn.springboot.entity.student"}) //换成你自己的Repository所在位置
public class JPAStudentConfig {

    @Resource
    private JpaProperties jpaProperties;

    @Resource
    private HibernateProperties hibernateProperties;

    /**
     * 主数据源默认使用Student
     * @return
     */
    @Primary
    @Bean(name = "studentDataSource")
    @ConfigurationProperties(prefix="spring.datasource.student")  //使用application.yml的primary数据源配置
    public DataSource studentDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 数据管理器
     * @param builder
     * @return
     */
    @Primary
    @Bean(name = "entityManagerStudent")        //primary实体管理器
    public EntityManager entityManagerStudent(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryStudent(builder).getObject().createEntityManager();
    }

    /**
     * 实体惯例工厂实体惯例工厂
     * @param builder
     * @return
     */
    @Primary
    @Bean(name = "entityManagerFactoryStudent")    //primary实体工厂
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryStudent (EntityManagerFactoryBuilder builder) {

        Map<String,Object> properties =
                hibernateProperties.determineHibernateProperties(
                        jpaProperties.getProperties(),
                        new HibernateSettings());

        return builder.dataSource(studentDataSource())
                .properties(properties)
                //换成数据表对应实体类所在包
                .packages("com.learn.springboot.entity.student")
                .persistenceUnit("primaryPersistenceUnit")
                .build();
    }

    /**
     * 事务管理器
     * @param builder
     * @return
     */
    @Primary
    @Bean(name = "transactionManagerStudent")         //primary事务管理器
    public PlatformTransactionManager transactionManagerStudent(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryStudent(builder).getObject());
    }
}