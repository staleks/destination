package com.jatheon.demo.destination.model.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class DestinationDTO {

    private Long id;
    private String name;
    private Integer starRating;
    private String  country;

    public DestinationDTO(Long id, String name, Integer starRating, String  country) {
        this.id = id;
        this.name = name;
        this.starRating = starRating;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getStarRating() {
        return starRating;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }
}
