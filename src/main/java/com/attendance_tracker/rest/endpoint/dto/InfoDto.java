package com.attendance_tracker.rest.endpoint.dto;

public class InfoDto {

    private String info;

    public InfoDto() {
    }

    public InfoDto(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
