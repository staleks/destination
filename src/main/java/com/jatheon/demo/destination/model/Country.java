package com.jatheon.demo.destination.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum Country {
    GREECE(1, "Greece"),
    TURKEY(2, "Turkey"),
    EGYPT(3, "Egypt");

    private Integer id;
    private String name;

    private static final Map<Integer, Country> COUNTRIES;

    static {
        Map<Integer, Country> countries = new HashMap<>();
        for (Country c: Country.values()) {
            countries.put(c.getId(), c);
        }
        COUNTRIES = Collections.unmodifiableMap(countries);
    }

    private Country(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public static Country countryById(Integer countryId) {
        return COUNTRIES.get(countryId);
    }
}
