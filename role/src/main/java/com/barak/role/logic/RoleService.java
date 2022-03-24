package com.barak.role.logic;

import com.barak.role.entities.Role;
import com.barak.role.repositories.IRoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RoleService {

    private IRoleRepository roleRepository;

    @Autowired
    public RoleService(IRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void createRole(Role role) {
        roleRepository.save(role);
    }

    public void deleteRole(int roleId) {
        roleRepository.deleteById(roleId);
    }

    public void updateRole(Role role) {
        roleRepository.save(role);
    }

    public Role getRoleById(int roleId) {
        return roleRepository.getById(roleId);
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
