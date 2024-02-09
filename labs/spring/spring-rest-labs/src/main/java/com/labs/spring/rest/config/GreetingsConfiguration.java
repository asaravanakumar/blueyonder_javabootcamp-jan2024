package com.labs.spring.rest.config;

import com.labs.spring.rest.dao.GreetingsDao;
import com.labs.spring.rest.dao.GreetingsDaoJdbcImpl;
import com.labs.spring.rest.service.GreetingsService1;
import com.labs.spring.rest.service.GreetingsServiceImpl1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;

@Configuration
public class GreetingsConfiguration {

    @Bean
    public GreetingsService1 greetingsService1() {
        return new GreetingsServiceImpl1();
    }

    @Bean
    public GreetingsDao greetingsDao() {
        return new GreetingsDaoJdbcImpl();
    }

    @Bean
    public DataSource dataSource() {
        PGSimpleDataSource datasource = new PGSimpleDataSource();
        datasource.setServerNames(new String[]{"localhost"});
        datasource.setDatabaseName("fsd_training");
        datasource.setUser("postgres");
        datasource.setPassword("postgres");
        return datasource;
    }
}
