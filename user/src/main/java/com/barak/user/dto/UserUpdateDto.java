package com.barak.user.dto;

public class UserUpdateDto {

    private long id;
    private String password;
    private String firstName;
    private String lastName;

    public UserUpdateDto(long id, String password, String firstName, String lastName) {
        this.id = id;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public long getId() {
        return id;
    }
}
