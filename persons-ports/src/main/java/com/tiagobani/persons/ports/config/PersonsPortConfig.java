package com.tiagobani.persons.ports.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.tiagobani.persons" })
@EnableJpaRepositories("com.tiagobani.persons.data.repositories")
@EnableTransactionManagement
public class PersonsPortConfig {
}

