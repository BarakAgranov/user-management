package com.barak.user.dto;

public class UserGetAllDto {

    private long id;
    private String firstName;
    private String lastName;

    public UserGetAllDto(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
