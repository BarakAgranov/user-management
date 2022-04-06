package com.barak.role;

import com.barak.role.controllers.RoleController;
import com.barak.role.entities.Role;
import com.barak.role.entities.RolePermission;
import com.barak.role.exceptions.ApplicationException;
import com.barak.role.logic.RolePermissionService;
import com.barak.role.logic.RoleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
public class RoleApplication {
    public static void main(String[] args) throws ApplicationException {
        ApplicationContext context = SpringApplication.run(RoleApplication.class, args);

        RoleService roleService = context.getBean(RoleService.class);
        RolePermissionService permissionService = context.getBean(RolePermissionService.class);

        for (Role role: ROLES
        ) {
            roleService.createRole(role);
        }

        for (RolePermission permission: PERMISSIONS
             ) {
            permissionService.createPermission(permission);
        }

        roleService.updateRole(ROLE_TO_UPDATE);
    }

    final static List<Role> ROLES = Arrays.asList(
            new Role(1,"role1", 1, null),
            new Role(2,"role2", 1, null),
            new Role(3,"role3", 2, null)
    );

    final static List<RolePermission> PERMISSIONS = Arrays.asList(
            new RolePermission(1,"permission1", null),
            new RolePermission(2,"permission2", null),
            new RolePermission(3,"permission3", null)
    );

    final static Role ROLE_TO_UPDATE = new Role(1,"role1", 1, PERMISSIONS);
}
