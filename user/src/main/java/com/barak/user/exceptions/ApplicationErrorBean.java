package com.barak.user.exceptions;

public class ApplicationErrorBean {
    private int errorNumber;
    private String errorName;
    private String errorMessage;
    
    public ApplicationErrorBean(int errorNumber, String errorName, String errorMessage) {
    }

    public ApplicationErrorBean() {
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
