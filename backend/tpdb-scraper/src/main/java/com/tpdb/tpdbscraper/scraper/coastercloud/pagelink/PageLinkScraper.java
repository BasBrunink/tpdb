package com.tpdb.tpdbscraper.scraper.coastercloud.pagelink;

import com.tpdb.domain.internal.comunication.dto.PageLinkDto;
import com.tpdb.domain.internal.scraper.enums.LinkType;
import com.tpdb.domain.internal.scraper.enums.ScrapeSource;
import com.tpdb.tpdbscraper.publishers.PageLinkPublisher;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@RequiredArgsConstructor
public class PageLinkScraper {

    private final PageLinkPublisher pageLinkPublisher;

    private final Pattern sourceIDPark = Pattern.compile("/parks/([a-f0-9]+)-");
    private final Pattern sourceIDAttraction = Pattern.compile("/attractions/([a-f0-9]+)-");


    public void scrapeParkLinks() throws IOException {
        String parkLinksUrl = "https://coaster.cloud/sitemap/parks.en.xml";
        Document doc = Jsoup.connect(parkLinksUrl).get();
        Elements elements = doc.selectXpath("//url/loc");
        elements.forEach(element -> {
            PageLinkDto pageLink = PageLinkDto.builder()
                    .lastParse(null)
                    .link(element.text())
                    .source(ScrapeSource.COASTERCLOUD)
                    .type(LinkType.PARK)
                    .sourceID(getSourceId(element.text(), LinkType.PARK))
                    .build();
            pageLinkPublisher.sendPagelink(pageLink);
        });
    }

    public void scrapeAttractionLinks() throws IOException {
        String attractionsLinksUrl = "https://coaster.cloud/sitemap/attractions.en.xml";
        Document doc = Jsoup.connect(attractionsLinksUrl).get();
        Elements elements = doc.selectXpath("//url/loc");
        elements.forEach(element -> {
            PageLinkDto pagelink = PageLinkDto.builder()
                    .lastParse(null)
                    .link(element.text())
                    .source(ScrapeSource.COASTERCLOUD)
                    .type(LinkType.ATTRACTION)
                    .sourceID(getSourceId(element.text(), LinkType.ATTRACTION))
                    .build();
            pageLinkPublisher.sendPagelink(pagelink);
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
