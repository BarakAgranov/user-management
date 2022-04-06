package com.barak.role.repositories;

import com.barak.role.entities.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolePermissionRepository extends JpaRepository<RolePermission, Integer> {

    boolean existsByName(String name);
}
