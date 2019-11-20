package com.bixbysdoghouse.bootfunamentals.module2.restclientdemo.services;

import com.bixbysdoghouse.bootfunamentals.module2.restclientdemo.entities.Site;
import com.bixbysdoghouse.bootfunamentals.module2.restclientdemo.json.GoogleMapsResponse;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeoCoderService {
    private static final String BASE = "https://maps.googleapis.com/maps/api/geocode/json";
    private static final String KEY = "PUT_KEY_IN_HERE";

    private RestTemplate restTemplate;

    @Autowired
    public GeoCoderService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Site getLatLng(String... address) throws GoogleConnectionFailureException {
        URI googleMapsUri = buildRequestUri(address);
        GoogleMapsResponse googleMapsResponse = callGoogle(googleMapsUri);
        if (googleMapsResponse.hasSuccessfulStatus()) {
            return new Site(googleMapsResponse.getFormattedAddress(), googleMapsResponse.getLat(),
                            googleMapsResponse.getLng());
        } else {
            throw new GoogleConnectionFailureException("Failed to connect to the google maps resource at URI: "
                                                               + googleMapsUri + " The status returned was: " + googleMapsResponse
                    .getStatus());
        }
    }

    private @NonNull GoogleMapsResponse callGoogle(URI googleMapsUri) {
        return Objects.requireNonNull(restTemplate.getForObject(googleMapsUri, GoogleMapsResponse.class));
    }

    private URI buildRequestUri(String[] address) {
        String joinedAddress = String.join(",", address);
        String encodedAddress = URLEncoder.encode(joinedAddress, StandardCharsets.UTF_8);
        return URI.create(String.format("%s?address=%s&key=%s", BASE, encodedAddress, KEY));
    }

}
