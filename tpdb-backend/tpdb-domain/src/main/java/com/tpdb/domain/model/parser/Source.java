package com.tpdb.domain.model.parser;

public enum Source {
    COASTERCLOUD("Coast cloud"),
    RCDB("rcdb");

    private final String value;

    Source(String value) {
        this.value = value;
    }
}
