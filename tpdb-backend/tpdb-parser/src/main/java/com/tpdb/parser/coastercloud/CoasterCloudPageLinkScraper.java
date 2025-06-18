package com.tpdb.parser.coastercloud;

import com.tpdb.domain.model.parser.LinkType;
import com.tpdb.domain.model.parser.Pagelink;
import com.tpdb.domain.model.parser.Source;
import com.tpdb.domain.port.parser.coastercloud.PageLinkRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Component
@Slf4j
public class CoasterCloudPageLinkScraper {
    Pattern sourceIDPark = Pattern.compile("/parks/([a-f0-9]+)-");
    Pattern sourceIDAttraction = Pattern.compile("/attractions/([a-f0-9]+)-");

    private final PageLinkRepository repository;

    private String parkLinksUrl = "https://coaster.cloud/sitemap/parks.en.xml";
    private String attractionsLinksUrl = "https://coaster.cloud/sitemap/attractions.en.xml";


    public void scrapeParkLinks() throws IOException {
        Document doc = Jsoup.connect(parkLinksUrl).get();
        Elements elements = doc.selectXpath("//url/loc");
        elements.forEach(element -> {
            Pagelink pageLink = Pagelink.builder()
                    .source(Source.COASTERCLOUD)
                    .sourceId(getSourceId(element.text(), LinkType.PARK))
                    .type(LinkType.PARK)
                    .link(element.text())
                    .build();
            repository.save(pageLink);
        });
    }

    public void scrapeAttractionLinks() throws IOException {
        Document doc = Jsoup.connect(attractionsLinksUrl).get();
        Elements elements = doc.selectXpath("//url/loc");
        elements.forEach(element -> {
            Pagelink pagelink = Pagelink.builder()
                    .source(Source.COASTERCLOUD)
                    .sourceId(getSourceId(element.text(), LinkType.ATTRACTION))
                    .type(LinkType.ATTRACTION)
                    .link(element.text())
                    .build();
            repository.save(pagelink);
        });

    }


    private String getSourceId(String link, LinkType linkType) {
        if (linkType.equals(LinkType.PARK)) {
            Matcher parkIdMatcher = sourceIDPark.matcher(link);
            if (parkIdMatcher.find()) {
                return parkIdMatcher.group(1);
            } else return "";
        } else if (linkType.equals(LinkType.ATTRACTION)) {
            Matcher attractionIdMatcher = sourceIDAttraction.matcher(link);
            if (attractionIdMatcher.find()) {
                return attractionIdMatcher.group(1);
            } else return "";
        } else return "";
    }
}

