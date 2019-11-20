package com.bixbysdoghouse.bootfunamentals.module2.restclientdemo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.bixbysdoghouse.bootfunamentals.module2.restclientdemo.entities.Site;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
class GeoCoderServiceTest {

    @Autowired
    private GeoCoderService geoCoderService;

    @Test
    void getLatLngForGoogleHeadquaraters() throws Exception {
        Site googleHeadquartersSite = geoCoderService.getLatLng("1600 Ampitheatre Parkway",
                                                                "Mountain View", "CA");
        log.info("Site: {}", googleHeadquartersSite);
        assertEquals(37.423021, googleHeadquartersSite.getLatitude(), 0.01);
        assertEquals(-122.083739, googleHeadquartersSite.getLongitude(), 0.01);

    }

    @Test
    void getLatLngWithoutStreet() throws Exception {
        Site orieillyTown = geoCoderService.getLatLng("Boston", "MA");
        log.info("Site: {}", orieillyTown);
        assertEquals(42.36, orieillyTown.getLatitude(), 0.01);
        assertEquals(-71.06, orieillyTown.getLongitude(), 0.01);

    }
}