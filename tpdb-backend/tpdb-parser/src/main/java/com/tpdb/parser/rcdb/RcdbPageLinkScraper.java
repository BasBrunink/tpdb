package com.tpdb.parser.rcdb;

import com.tpdb.domain.model.parser.LinkType;
import com.tpdb.domain.model.parser.Pagelink;
import com.tpdb.domain.model.parser.Source;
import com.tpdb.domain.port.parser.coastercloud.PageLinkRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Component
@Slf4j
public class RcdbPageLinkScraper {

    private final String parkLinksUrl = "https://rcdb.com/r.htm?ot=3";
    private final String rollercoasterLinksUrl = "https://rcdb.com/r.htm?ot=2";

    private final PageLinkRepository repository;

    public void scrapeParkLinks() throws IOException {
        Document doc = Jsoup.connect(parkLinksUrl).get();
        for(int i = 1; i < determineTotalPages(doc); i++) {
            String link = parkLinksUrl + "&page=" + 1;
            Document page = Jsoup.connect(link).get();
            Element table = page.select(".stdtbl").first();
            assert table != null;
            Elements rows = table.selectXpath("//table/tbody/tr");
            rows.forEach(row -> {
                String pageLink = "https://rcdb.com" + row.select("td:nth-of-type(2) a").attr("href");
                if(!pageLink.equals("https://rcdb.com")) {
                    repository.save(Pagelink.builder()
                                    .source(Source.RCDB)
                                    .sourceId(getSourceId(pageLink))
                                    .type(LinkType.PARK)
                                    .link(pageLink)
                            .build());
                }
            });
        }


    }
    public void scrapeAttractionLinks() {

    }

    public void scrapeCompanyLinks() {

    }
    public void scrapePeopleLinks() {}

    private Integer determineTotalPages(Document doc) {
        int totalparks = Integer.parseInt(doc.getElementsByClass("int").getFirst().text());
        return (int) totalparks / 24;

    }

    private String getSourceId(String link) {
        Pattern pattern = Pattern.compile("/(\\d+)\\.htm");
        Matcher matcher = pattern.matcher(link);
        if(matcher.find()) {
            return matcher.group(1);
        } else return "";
    }
}
