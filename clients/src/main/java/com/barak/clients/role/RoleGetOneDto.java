package com.barak.clients.role;

import java.util.List;

public class RoleGetOneDto {

    private int id;
    private String name;
    private long creatorId;
    private List<RolePermissionDto> rolePermissionDto;

    public RoleGetOneDto(int id, String name, long creatorId, List<RolePermissionDto> rolePermissionDto) {
        this.id = id;
        this.name = name;
        this.creatorId = creatorId;
        this.rolePermissionDto = rolePermissionDto;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<RolePermissionDto> getRolePermissionDto() {
        return rolePermissionDto;
    }

    public long getCreatorId() {
        return creatorId;
    }
}
