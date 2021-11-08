package com.rennan.sectorspringboot.util.exception;

public class DomainException extends Exception {

    private ErrorSystemType errorType;


    public DomainException(ErrorSystemType errorType){
        this.errorType = errorType;
    }

    public ErrorSystemType getErrorType(){
        return this.errorType;
    }

}