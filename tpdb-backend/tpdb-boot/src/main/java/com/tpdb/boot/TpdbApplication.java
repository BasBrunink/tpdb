package com.tpdb.boot;

import com.tpdb.parser.coastercloud.CoasterCloudPageLinkScraper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
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
        "com.tpdb.interfaceadapter",
        "com.tpdb.parser"
})
@RequiredArgsConstructor
public class TpdbApplication implements CommandLineRunner {
    public final CoasterCloudPageLinkScraper ccScraper;
    public static void main(String[] args) {
        SpringApplication.run(TpdbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ccScraper.scrapeParkLinks();
        ccScraper.scrapeAttractionLinks();
    }
}
