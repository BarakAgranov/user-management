package com.barak.group.enums;

public enum ErrorType {

    GENERAL_ERROR(800, "GENERAL_ERROR","General error", true),
    MUST_INSERT_A_VALUE(801, "MUST_INSERT_A_VALUE", "Must insert a value", false),
    GROUP_DOES_NOT_EXIST(802, "GROUP_DOES_NOT_EXIST", "group with the requested id doesn't exist", false),
    DEPARTMENT_DOES_NOT_EXIST(803, "DEPARTMENT_DOES_NOT_EXIST", "department with the requested id doesn't exist", false),
    ORGANIZATION_DOES_NOT_EXIST(804, "ORGANIZATION_DOES_NOT_EXIST", "organization with the requested id doesn't exist", false),
    MUST_HAVE_NAME(805, "MUST_HAVE_NAME", "name must be declared", false),
    MUST_HAVE_CREATOR_ID(806, "MUST_HAVE_CREATOR_ID", "creator id must be declared", false),
    GROUP_MUST_HAVE_DEPARTMENT(807, "GROUP_MUST_HAVE_DEPARTMENT", "group must be associated with department", false),
    DEPARTMENT_MUST_HAVE_ORGANIZATION(808, "DEPARTMENT_MUST_HAVE_ORGANIZATION", "department must be associated with organization", false);



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
