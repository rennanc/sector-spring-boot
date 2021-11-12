package com.rennan.sectorspringboot.domain.enums;

public enum ErrorSystemType {

    UNKNOWN("000","UNKNOWN ERROR"),
    ERROR_1("001","PROFILE NAME ALREADY EXISTS");

    private String code;
    private String description;

    ErrorSystemType(String code, String description){
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}