package com.barak.clients.role;

import java.util.List;

public class RoleCreateDto {

    private String name;
    private long creatorId;
    private List<RolePermissionDto> rolePermissionDto;

    public RoleCreateDto(String name, long creatorId, List<RolePermissionDto> rolePermissionDto) {
        this.name = name;
        this.creatorId = creatorId;
        this.rolePermissionDto = rolePermissionDto;
    }

    public String getName() {
        return name;
    }

    public long getCreatorId() {
        return creatorId;
    }

    public List<RolePermissionDto> getRolePermissionDto() {
        return rolePermissionDto;
    }
}
