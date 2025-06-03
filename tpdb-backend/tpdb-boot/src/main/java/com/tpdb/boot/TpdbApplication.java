package com.tpdb.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.tpdb.infrastructure.repository.jpa")
@EntityScan(basePackages = "com.tpdb.infrastructure.repository.entity")
@SpringBootApplication(scanBasePackages = {
        "com.tpdb.domain",
        "com.tpdb.application",
        "com.tpdb.infrastructure",
        "com.tpdb.interfaceadapter"
})
public class TpdbApplication {
    public static void main(String[] args) {
        SpringApplication.run(TpdbApplication.class, args);
    }
}
