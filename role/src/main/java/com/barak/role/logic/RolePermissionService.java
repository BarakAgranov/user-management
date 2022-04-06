package com.barak.role.logic;

import com.barak.role.entities.RolePermission;
import com.barak.role.enums.ErrorType;
import com.barak.role.exceptions.ApplicationException;
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

    public void createPermission(RolePermission rolePermission) throws ApplicationException {
        try {
            validatePermission(rolePermission);
            permissionRepository.save(rolePermission);
        } catch (Exception e) {
            throw e;
        }
    }

    public void updatePermission(RolePermission permission) {
        try {
            if (!permission.getRoles().isEmpty()) {
                RolePermission permissionToUpdate = permissionRepository.findById(permission.getId()).get();
                permissionToUpdate.getRoles().addAll(permission.getRoles());
                permissionRepository.save(permissionToUpdate);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void deletePermission(int permissionId) {
        try {
            permissionRepository.deleteById(permissionId);
        } catch (Exception e) {
            throw e;
        }
    }


    public RolePermission getPermissionById(int permissionId) {
        try {
            return permissionRepository.findById(permissionId).get();
        } catch (Exception e) {
            throw e;
        }
    }

    public List<RolePermission> getAllPermissions() {
        return permissionRepository.findAll();
    }

    private void validatePermission(RolePermission permission) throws ApplicationException {
        try {
            if (permissionRepository.existsByName(permission.getName())) {
                throw new ApplicationException(ErrorType.INVALID_NAME, "permission name must be unique");
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
