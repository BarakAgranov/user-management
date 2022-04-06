package com.barak.role.enums;

public enum ErrorType {

    GENERAL_ERROR(800, "GENERAL_ERROR","General error", true),
    ROLE_DOES_NOT_EXIST(803, "ROLE_DOES_NOT_EXIST", "role with the requested id doesn't exist", false),
    INVALID_NAME(804, "INVALID_NAME", "name must be unique", false),
    INVALID_PERMISSION(805, "INVALID_PERMISSION", "permission can only appear once per role", false),
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
