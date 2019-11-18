package com.bixbysdoghouse.bootfunamentals.module2.restclientdemo.json;

import java.util.List;
import java.util.Optional;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

@Data
public class GoogleMapsResponse {
    private List<Result> results;
    private String status;

    public String getFormattedAddress() {
        return hasResults() ?
                getFirstResult().getFormattedAddress() : StringUtils.EMPTY;
    }

    private Result getFirstResult() {
        return results.get(0);
    }

    private boolean hasResults() {
        return !CollectionUtils.isEmpty(results);
    }

    public double getLat() {
        Optional<Location> location = getLocation();
        return location.isPresent() ? location.get().getLat() : 0.00D;
    }

    public double getLng() {
        Optional<Location> location = getLocation();
        return location.isPresent() ? location.get().getLng() : 0.00D;
    }

    private Optional<Location> getLocation() {
        return hasResults() ?
                getFirstResult().getLocation() : Optional.empty();
    }
}
