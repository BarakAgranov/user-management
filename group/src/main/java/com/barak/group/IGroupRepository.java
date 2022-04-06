package com.barak.group;

import com.barak.group.dto.GroupGetAllDto;
import com.barak.group.dto.GroupGetOneDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGroupRepository extends JpaRepository<Group, Integer> {

    boolean existsByName(String name);

    @Query("select new com.barak.group.dto.GroupGetAllDto(g.id, g.name) from Group g where g.mainGroup.id =?1")
    List<GroupGetAllDto> getAllByMainGroup_Id(int id);

    @Query("select new com.barak.group.dto.GroupGetAllDto(g.id, g.name) from Group g")
    List<GroupGetAllDto> getAllGroups();

    @Query("select new com.barak.group.dto.GroupGetOneDto(g.id, g.name) from Group g where g.id =?1")
    GroupGetOneDto getGroupById(int id);
}
