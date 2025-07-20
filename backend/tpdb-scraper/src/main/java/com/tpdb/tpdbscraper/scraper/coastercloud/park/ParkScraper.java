package com.tpdb.tpdbscraper.scraper.coastercloud.park;

import com.tpdb.domain.data.enums.ParkStatus;
import com.tpdb.domain.data.enums.types.ParkType;
import com.tpdb.domain.internal.comunication.dto.ParkDto;
import com.tpdb.domain.internal.scraper.PageLink;
import com.tpdb.domain.internal.scraper.enums.ScrapeSource;
import com.tpdb.tpdbscraper.publishers.PageLinkPublisher;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Component
public class ParkScraper {

    public ParkDto scrapePark(PageLink pageLink) throws IOException {

        Optional<Document> docOpt = fetchPage(pageLink.getLink());


        if(docOpt.isPresent()) {

            Element attributes = docOpt.get().selectFirst("dl.divide-y");
            final String DESCR_CLASS = "body > main > div.grid.grid-cols-1.gap-x-8.gap-y-10.md\\:grid-cols-4.py-6 > div.order-2.md\\:order-1.md\\:col-span-2 > p";

            Map<String, String> parkAttributes = fetchAttributes(attributes);
            docOpt.get().select(DESCR_CLASS).text();
            return ParkDto.builder()
                    .source(ScrapeSource.COASTERCLOUD)
                    .sourceId(pageLink.getSourceID())
                    .name(parseAttribute(docOpt.get().select("body > main > div:nth-child(2) > h1").text()))
                    .description(docOpt.get().select(DESCR_CLASS).text())
                    .parkType(
                            determineParkType(parkAttributes.get("category"))
                    )
                    .status(
                            determineParkStatus(parkAttributes.get("status"))
                    )
                    .address(
                            (parkAttributes.get("address") != null)
                                    ? parkAttributes.get("address")
                                    : ""
                    )
                    .areaSize(
                            (parkAttributes.get("area size") != null)
                                    ? Double.parseDouble(parkAttributes.get("area size"))
                                    : 0
                    )
                    .build();
        } return null;
    }

    private Optional<Document> fetchPage(String url) {
        try {
            return Optional.of(Jsoup.connect(url).get());
        } catch (HttpStatusException ex) {
            log.error("HTTP error: " + ex.getStatusCode() + "for url: " + url);
//            pageLinkPublisher.deletePageLink(url);
        } catch (IOException ex) {
            log.error("Unexpected errorfor url: " + url);
        }
        return Optional.empty();
    }

    private Map<String, String> fetchAttributes(Element table) {
        Map<String, String> results = new HashMap<>();
        Elements entries = table.select("div");
        for (Element entry : entries) {
            Element dt = entry.selectFirst("dt");
            Element dd = entry.selectFirst("dd");

            if (dt == null || dd == null) {
                continue; // skip incomplete rows
            }


            String key = dt.text().trim().toLowerCase();

            Element link = dd.selectFirst("a");
            String value = (link != null) ? link.attr("href") : dd.text().trim();
            if (key.equalsIgnoreCase("area size")) {
                String numericString = value.replaceAll("[^\\d.,]", "")
                        .replace(",", "");
                results.put(key, numericString);
            } else {
                results.put(key, value);
            }

        }
        results.forEach((k, v) -> log.info("{} : {}", k, v));
        return results;

    }

    private String parseAttribute(String attr) {
        if (attr != null) return attr;
        else return "";


    }

    private ParkType determineParkType(String type) {
        switch (type) {
            case "Adventure area" -> {
                return ParkType.ADVENTUREAREA;
            }
            case "Amusement park" -> {
                return ParkType.AMUSEMENTPARK;
            }
            case "Indoor playground" -> {
                return ParkType.INDOORPLAYGROUND;
            }
            case "Themepark" -> {
                return ParkType.THEMEPARK;
            }
            case "Water park" -> {
                return ParkType.WATERPARK;
            }

            case "Zoo" -> {
                return ParkType.ANIMALPARK;
            }
            default -> {
                return ParkType.UNKOWN;
            }
        }
    }


    private ParkStatus determineParkStatus(String status) {
        switch (status) {
            case "Defunct" -> {
                return ParkStatus.DEFUNCT;
            }

            case "In operation" -> {
                return ParkStatus.OPERATING;
            }
            case "Out of operation" -> {
                return ParkStatus.OUT_OF_OPERATION;
            }
            case "Under construction" -> {
                return ParkStatus.UNDER_CONSTRUCTION;
            }
            default -> {
                return ParkStatus.UNKNOWN;
            }
        }
    }
}


