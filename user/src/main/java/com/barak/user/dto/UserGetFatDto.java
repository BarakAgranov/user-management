package com.barak.user.dto;

import com.barak.user.enums.UserType;

public class UserGetFatDto {

    private long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private UserType userType;

    public UserGetFatDto(long id, String email, String password, String firstName, String lastName, UserType userType) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userType = userType;
    }

    public UserGetFatDto() {
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public UserType getUserType() {
        return userType;
    }
}
