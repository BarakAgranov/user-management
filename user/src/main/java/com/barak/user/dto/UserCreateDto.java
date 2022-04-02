package com.barak.user.dto;


import javax.validation.constraints.Size;

public class UserCreateDto {

    private String email;
    @Size(min = 8, max = 32)
    private String password;
    private String firstName;
    private String lastName;



    public UserCreateDto(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UserCreateDto() {
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

}
