package com.barak.clients.role;

import java.util.List;

public class RoleUpdateDto {

    private int id;
    private String name;
    private List<RolePermissionDto> rolePermissionDto;

    public RoleUpdateDto(int id, String name, List<RolePermissionDto> rolePermissionDto) {
        this.id = id;
        this.name = name;
        this.rolePermissionDto = rolePermissionDto;
    }

    public String getName() {
        return name;
    }

    public List<RolePermissionDto> getRolePermissionDto() {
        return rolePermissionDto;
    }

    public int getId() {
        return id;
    }
}
