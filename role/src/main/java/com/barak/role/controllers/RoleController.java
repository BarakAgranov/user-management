package com.barak.role.controllers;

import com.barak.role.entities.Role;
import com.barak.role.exceptions.ApplicationException;
import com.barak.role.logic.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/roles")
public class RoleController {

    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public void createRole(@RequestBody Role role) throws ApplicationException {
        roleService.createRole(role);
    }

    @PutMapping
    public void updateRole(@RequestBody Role role) throws ApplicationException {
        roleService.updateRole(role);
    }


}
