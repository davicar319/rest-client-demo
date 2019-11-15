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

    public Optional<Location> getLocation() {
        return hasResults() ?
                getFirstResult().getLocation() : Optional.empty();
    }

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
}
