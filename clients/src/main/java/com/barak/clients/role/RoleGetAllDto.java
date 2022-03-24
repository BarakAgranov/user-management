package com.barak.clients.role;

public class RoleGetAllDto {

    private int id;
    private String name;

    public RoleGetAllDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
