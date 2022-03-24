package com.barak.permission;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PermissionService {

    private IPermissionRepository permissionRepository;

    @Autowired
    public PermissionService(IPermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    public void createPermission(Permission permission) {
        permissionRepository.save(permission);
    }

    public void deletePermission(int permissionId) {
        permissionRepository.deleteById(permissionId);
    }

    public void updatePermission(Permission permission) {
        permissionRepository.save(permission);
    }

    public Permission getPermissionById(int permissionId) {
        return permissionRepository.getById(permissionId);
    }

    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }
}
