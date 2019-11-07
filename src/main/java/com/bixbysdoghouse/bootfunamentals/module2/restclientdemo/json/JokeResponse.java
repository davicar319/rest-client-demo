package com.bixbysdoghouse.bootfunamentals.module2.restclientdemo.json;

import java.util.Objects;

public class JokeResponse {
    private String status;
    private Value value;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JokeResponse that = (JokeResponse) o;
        return Objects.equals(status, that.status) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, value);
    }

    @Override
    public String toString() {
        return "JokeResponse{" +
                "status='" + status + '\'' +
                ", value=" + value +
                '}';
    }

    public String getJoke() {
        String result = "";
        if (value != null) {
            result = value.getJoke();
        }
        return result;
    }
}
