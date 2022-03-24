package com.barak.role.logic;

import com.barak.role.entities.RolePermission;
import com.barak.role.repositories.IRolePermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolePermissionService {

    private IRolePermissionRepository permissionRepository;

    @Autowired
    public RolePermissionService(IRolePermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    public void createPermission(RolePermission rolePermission) {
        permissionRepository.save(rolePermission);
    }

    public void deletePermission(int permissionId) {
        permissionRepository.deleteById(permissionId);
    }

    public void updatePermission(RolePermission rolePermission) {
        permissionRepository.save(rolePermission);
    }

    public RolePermission getPermissionById(int permissionId) {
        return permissionRepository.getById(permissionId);
    }

    public List<RolePermission> getAllPermissions() {
        return permissionRepository.findAll();
    }

}
