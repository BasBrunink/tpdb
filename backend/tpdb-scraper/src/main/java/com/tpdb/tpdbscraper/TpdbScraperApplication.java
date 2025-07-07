package com.tpdb.tpdbscraper;

import com.tpdb.tpdbscraper.scraper.coastercloud.pagelink.PageLinkScraper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class TpdbScraperApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TpdbScraperApplication.class, args);
    }

    private final PageLinkScraper pageLinkScraper;
    @Override
    public void run(String... args) throws Exception {
        pageLinkScraper.scrapeParkLinks();
        pageLinkScraper.scrapeAttractionLinks();
    }
}
