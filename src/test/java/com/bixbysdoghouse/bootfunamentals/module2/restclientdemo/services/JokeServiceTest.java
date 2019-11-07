package com.bixbysdoghouse.bootfunamentals.module2.restclientdemo.services;

import static org.junit.jupiter.api.Assertions.*;

import com.bixbysdoghouse.bootfunamentals.module2.restclientdemo.json.JokeResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class JokeServiceTest {
    private Logger log = LoggerFactory.getLogger(JokeServiceTest.class);
    @Autowired
    private JokeService jokeService;

    @Test
    void testJokeService() {
        String joke = jokeService.getJoke("Dave", "Carlson");
        log.info(joke);
        assertTrue(joke.contains("Dave") || joke.contains("Carlson"));
    }

}