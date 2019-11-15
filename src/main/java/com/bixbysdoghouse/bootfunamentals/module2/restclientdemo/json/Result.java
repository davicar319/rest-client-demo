package com.bixbysdoghouse.bootfunamentals.module2.restclientdemo.json;

import java.util.Optional;
import lombok.Data;

@Data
class Result {
    private Geometry geometry;
    private String formattedAddress;

    Optional<Location> getLocation() {
        return geometry == null ? Optional.empty() : Optional.ofNullable(geometry.getLocation());
    }
}
