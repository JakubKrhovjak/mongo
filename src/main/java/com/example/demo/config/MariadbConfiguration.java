package com.example.demo.config;

import org.mariadb.r2dbc.MariadbConnectionConfiguration;
import org.mariadb.r2dbc.MariadbConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

/**
 * Created by Jakub krhovják on 5/13/21.
 */
@Configuration
//@Profile("maria")
public class MariadbConfiguration {

    @Bean
    public MariadbConnectionFactory mariadbConnectionFactory() {
        MariadbConnectionConfiguration conf = MariadbConnectionConfiguration.builder()
                .host("localhost")
                .port(3320)
                .username("user")
                .password("passport")
                .database("reactivedb")
                .build();
        return new MariadbConnectionFactory(conf);

    }

}
