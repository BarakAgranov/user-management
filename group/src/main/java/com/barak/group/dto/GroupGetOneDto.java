package com.barak.group.dto;

public class GroupGetOneDto {

    private int id;
    private String name;

    public GroupGetOneDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public GroupGetOneDto() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
