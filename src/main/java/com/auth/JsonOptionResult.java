package com.auth;


import java.util.List;

public class JsonOptionResult<T> {

    private String message;
    private String result;
    private List<T> options;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<T> getOptions() {
        return options;
    }

    public void setOptions(List<T> options) {
        this.options = options;
    }
}
