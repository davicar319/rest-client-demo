package com.bixbysdoghouse.bootfunamentals.module2.restclientdemo.json;

import lombok.Data;

@Data
public class JokeResponse {
    private String status;
    private Value value;

    public String getJoke() {
        return value.getJoke();
    }
}
