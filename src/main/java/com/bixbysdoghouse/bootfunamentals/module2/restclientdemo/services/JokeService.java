package com.bixbysdoghouse.bootfunamentals.module2.restclientdemo.services;

import com.bixbysdoghouse.bootfunamentals.module2.restclientdemo.json.JokeResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JokeService {
    private static final String BASE = "http://api.icndb.com/jokes/random?limitTo=[nerdy]";
    private RestTemplate restTemplate;

    public JokeService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getJoke(String firstName, String lastName){
        String url = String.format("%s&firstName=%s&lastName=%s", BASE, firstName, lastName);
        JokeResponse jokeResponse = restTemplate.getForObject(url, JokeResponse.class);
        String result = "";
        if (jokeResponse != null) {
            result = jokeResponse.getJoke();
        }
        return result;
    }
}
