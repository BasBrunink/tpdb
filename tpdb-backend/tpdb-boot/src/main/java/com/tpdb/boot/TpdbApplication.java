package com.tpdb.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
