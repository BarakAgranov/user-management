package com.barak.group.dto;

public class GroupCreateDto {

    private String name;
    private long creatorId;
    private Integer mainGroupId;

    public GroupCreateDto(String name, long creatorId, Integer mainGroupId) {
        this.name = name;
        this.creatorId = creatorId;
        this.mainGroupId = mainGroupId;
    }

    public GroupCreateDto() {
    }

    public String getName() {
        return name;
    }

    public long getCreatorId() {
        return creatorId;
    }

    public Integer getMainGroupId() {
        return mainGroupId;
    }
}
