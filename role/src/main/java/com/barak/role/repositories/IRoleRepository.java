package com.barak.role.repositories;

import com.barak.role.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer> {

    boolean existsByName(String name);


}
