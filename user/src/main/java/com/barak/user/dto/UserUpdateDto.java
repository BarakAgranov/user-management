package com.barak.user.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserUpdateDto {


    private long id;
    @Size(min = 8, max = 32)
    private String password;
    private String firstName;
    private String lastName;

    public UserUpdateDto(long id, String password, String firstName, String lastName) {
        this.id = id;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UserUpdateDto() {
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

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }
}
