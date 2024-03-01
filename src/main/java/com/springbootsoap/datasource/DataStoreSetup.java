package com.springbootsoap.datasource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = ("com.springbootsoap.repository"))
@ComponentScan(value = "com.springbootsoap.*")
@EntityScan(basePackages = ("com.springbootsoap.model"))
public class DataStoreSetup {

    @Value("spring.datasource.url")
    String dbUrl;

    @Value("spring.datasource.username")
    String dbUser;

    @Value("spring.datasource.password")
    String dbPswd;

    public DataSource dataSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setPassword(dbPswd);
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUser);

        return dataSource;
    }
}
