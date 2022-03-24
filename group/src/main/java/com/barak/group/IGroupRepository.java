package com.barak.group;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGroupRepository extends JpaRepository<Group, Integer> {

    boolean existsByName(String name);

    List<Group> getAllByName(String name);

    List<Group> getAllByMainGroup_Id(Integer id);
}
