package com.bixbysdoghouse.bootfunamentals.module2.restclientdemo.entities;

import lombok.Data;

@Data
public class Site {
    private Integer id;
    private String name;
    private double latitude;
    private double longitude;

    public Site() {
    }

    public Site(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
