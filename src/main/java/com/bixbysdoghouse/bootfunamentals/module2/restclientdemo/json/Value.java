package com.bixbysdoghouse.bootfunamentals.module2.restclientdemo.json;

import java.util.Collection;
import lombok.Data;

@Data
class Value {
    private int id;
    private String joke;
    private Collection<String> categories;
}