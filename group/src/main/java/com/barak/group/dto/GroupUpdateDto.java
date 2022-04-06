package com.barak.group.dto;

public class GroupUpdateDto {

    private int id;
    private String name;
    private int mainGroupId;

    public GroupUpdateDto(int id, String name, int mainGroupId) {
        this.id = id;
        this.name = name;
        this.mainGroupId = mainGroupId;
    }

    public GroupUpdateDto() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMainGroupId() {
        return mainGroupId;
    }
}
