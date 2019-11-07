package com.bixbysdoghouse.bootfunamentals.module2.restclientdemo.json;

import java.util.Collection;
import java.util.Objects;

public class Value {
    private int id;
    private String joke;
    private Collection<String> categories;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public Collection<String> getCategories() {
        return categories;
    }

    public void setCategories(Collection<String> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Value value = (Value) o;
        return id == value.id &&
                Objects.equals(joke, value.joke) &&
                Objects.equals(categories, value.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, joke, categories);
    }

    @Override
    public String toString() {
        return "Value{" +
                "id=" + id +
                ", joke='" + joke + '\'' +
                ", categories=" + categories +
                '}';
    }
}
