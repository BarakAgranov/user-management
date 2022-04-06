package com.barak.group.dto;

public class GroupGetAllDto {

    private int id;
    private String name;

    public GroupGetAllDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public GroupGetAllDto() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
