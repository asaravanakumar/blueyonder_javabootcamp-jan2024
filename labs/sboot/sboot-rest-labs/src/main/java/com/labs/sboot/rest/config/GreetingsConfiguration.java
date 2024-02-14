package com.labs.sboot.rest.config;

import com.labs.sboot.rest.dao.GreetingsDao;
import com.labs.sboot.rest.dao.GreetingsDaoJdbcTempImpl;
import com.labs.sboot.rest.dao.GreetingsDaoJpaImpl;
import com.labs.sboot.rest.service.GreetingsService1;
import com.labs.sboot.rest.service.GreetingsServiceImpl1;
import com.labs.sboot.rest.service.GreetingsServiceImpl2;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class GreetingsConfiguration {

    @Bean
    public GreetingsService1 greetingsService1() {
//        return new GreetingsServiceImpl1();
        return new GreetingsServiceImpl2();
    }

//    @Bean
//    public GreetingsDao greetingsDao() {
//        return new GreetingsDaoJdbcImpl();
//        return new GreetingsDaoJdbcTempImpl();
//        return new GreetingsDaoJpaImpl();
//    }

//    @Bean
//    public DataSource dataSource() {
//        PGSimpleDataSource datasource = new PGSimpleDataSource();
//        datasource.setServerNames(new String[]{"localhost"});
//        datasource.setDatabaseName("fsd_training");
//        datasource.setUser("postgres");
//        datasource.setPassword("postgres");
//        return datasource;
//    }

//    @Bean
//    public DataSource driverManagerDataSource() {
//        DriverManagerDataSource datasource = new DriverManagerDataSource();
//        // Enable for MySQL
////		datasource.setUrl("jdbc:mysql://localhost:3306/jdbctraining");
////		datasource.setUsername("training");
////		datasource.setPassword("training");
//
//        datasource.setUrl("jdbc:postgresql://localhost:5432/fsd_training");
//        datasource.setUsername("postgres");
//        datasource.setPassword("postgres");
//
//        return datasource;
//    }

//    @Bean
//    public JdbcTemplate jdbcTemplate() {
//        return new JdbcTemplate(dataSource());
//    }
}
