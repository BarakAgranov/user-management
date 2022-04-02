package com.barak.group.exceptions;

public class ErrorBean {
    private int errorNumber;
    private String errorName;
    private String errorMessage;
    
    public ErrorBean(int errorNumber, String errorName, String errorMessage) {
    }

    public ErrorBean() {
    }

    public int getErrorNumber() {
        return errorNumber;
    }

    public String getErrorName() {
        return errorName;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorNumber(int errorNumber) {
        this.errorNumber = errorNumber;
    }

    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "ErrorBean{" +
                "errorNumber=" + errorNumber +
                ", errorName='" + errorName + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
