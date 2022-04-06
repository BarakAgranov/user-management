package com.barak.role.logic;

import com.barak.role.entities.Role;
import com.barak.role.entities.RolePermission;
import com.barak.role.enums.ErrorType;
import com.barak.role.exceptions.ApplicationException;
import com.barak.role.repositories.IRoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class RoleService {

    private IRoleRepository roleRepository;
    private RolePermissionService permissionService;

    @Autowired
    public RoleService(IRoleRepository roleRepository, RolePermissionService permissionService) {
        this.roleRepository = roleRepository;
        this.permissionService = permissionService;
    }

    public void createRole(Role role) throws ApplicationException {
        try {
            validateRole(role);
            roleRepository.save(role);
            log.info("role creation request succeed {}", role);
        } catch (Exception e) {
            log.info("role creation request failed {}", role);
            throw e;
        }
    }

    public void deleteRole(int roleId) {
        try {
            roleRepository.deleteById(roleId);
            log.info("role deletion request succeed for id: {}", roleId);
        } catch (Exception e) {
            log.info("role deletion request failed for id: {}", roleId);
            throw e;
        }
    }

    public void updateRole(Role role) throws ApplicationException {
        try {
            Role originalRole = roleRepository.findById(role.getId()).get();
            if (role.getName() != null) {
                originalRole.setName(role.getName());
            }
            if (!role.getRolePermissions().isEmpty()){
                for (RolePermission permission: role.getRolePermissions()
                     ) {
                    assignPermissionToRole(originalRole, permission.getId());

                }

            }
            roleRepository.save(originalRole);
        } catch (Exception e) {
            throw e;
        }
    }

    public Role getRoleById(int roleId) throws ApplicationException {
        try {
            Role role = roleRepository.getById(roleId);
            if (role != null) {
                return role;
            }
            else throw new ApplicationException(ErrorType.ROLE_DOES_NOT_EXIST, "role with id: " + roleId + " does not exist");
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Role> getAllRoles() {
        try {
            return roleRepository.findAll();
        } catch (Exception e) {
            throw e;
        }
    }

    public void assignPermissionToRole(Role role, int permissionId) throws ApplicationException {
        try {
            RolePermission permission = permissionService.getPermissionById(permissionId);
            if (role.getRolePermissions().contains(permission)) {
                throw new ApplicationException(ErrorType.INVALID_PERMISSION,
                        "role with id: " + role.getId() + " already have permission with id: " +permissionId);
            }else {
                permission.getRoles().add(role);
                permissionService.updatePermission(permission);
                role.getRolePermissions().add(permission);

            }
        }catch (Exception e) {
            throw e;
        }
    }

    private void validateRole(Role role) throws ApplicationException {
        if (roleRepository.existsByName(role.getName())) {
            log.info("role validation failed for name not unique");
            throw new ApplicationException(ErrorType.INVALID_NAME, "role name must be unique");
        }
    }
}
