package com.tpdb.domain.model.parser;

import lombok.Getter;

@Getter
public enum LinkType {
    PARK("Park"),
    ATTRACTION("Attraction"),
    ROLLERCOASTER("RollerCoaster"),
    COMPANY("Comnpany"),
    PERSON("Person");

    private final String value;

    LinkType(String value) {
        this.value = value;
    }

}
