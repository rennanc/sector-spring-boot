package com.rennan.sectorspringboot.util.exception;

import com.rennan.sectorspringboot.domain.enums.ErrorSystemType;

public class DomainException extends Exception {

    private ErrorSystemType errorType;


    public DomainException(ErrorSystemType errorType){
        this.errorType = errorType;
    }

    public ErrorSystemType getErrorType(){
        return this.errorType;
    }

}