package com.barak.role.enums;

public enum ErrorType {

    GENERAL_ERROR(800, "GENERAL_ERROR","General error", true),
    LOGIN_FAILED(801, "LOGIN_FAILED", "Login failed. Please try again.", false),
    SIGNUP_FAILED(802, "SIGNUP FAILED", "signup failed, please try again", false),
    USER_DOES_NOT_EXIST(803, "USER_DOES_NOT_EXIST", "user with the requested id doesn't exist", false),
    INVALID_PASSWORD(804, "INVALID_PASSWORD", "Password must contain at least 8 characters and at least one digit", false),
    INVALID_EMAIL(805, "INVALID_EMAIL", "Email address is invalid, Please enter a valid email address", false),
    MUST_INSERT_A_VALUE(806, "MUST_INSERT_A_VALUE", "Must insert a value", false);

    private int errorNumber;
    private String errorName;
    private String errorMessage;
    private boolean isShowingStackTrace;

    ErrorType(int errorNumber, String errorName, String errorMessage, boolean isShowingStackTrace) {
        this.errorNumber = errorNumber;
        this.errorMessage = errorMessage;
        this.isShowingStackTrace = isShowingStackTrace;
        this.errorName = errorName;
    }

    public int getErrorNumber() {
        return errorNumber;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean isShowingStackTrace() {
        return isShowingStackTrace;
    }

    public String getErrorName() {
        return errorName;
    }
}
