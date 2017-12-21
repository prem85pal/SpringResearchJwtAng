package com.auth;


import java.util.List;
import java.util.Map;

public class JsonResult<T> {

    private String message;
    private T record;
    private List<T> records;
    private String total;

    public JsonResult(T record, String message) {
        this.record = record;
        this.message = message;
    }

    public JsonResult(List<T> records, String message) {
        this.records = records;
        this.message = message;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getRecord() {
        return record;
    }

    public void setRecord(T record) {
        this.record = record;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
