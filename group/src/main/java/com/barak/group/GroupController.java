package com.barak.group;

import com.barak.group.dto.GroupCreateDto;
import com.barak.group.dto.GroupGetAllDto;
import com.barak.group.dto.GroupGetOneDto;
import com.barak.group.dto.GroupUpdateDto;
import com.barak.group.exceptions.ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/groups")
public class GroupController {

    private GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    public void createGroup(@RequestBody GroupCreateDto group) throws ApplicationException {
        log.info("group creation request {}", group);
        groupService.createGroup(group);
    }

    @PutMapping
    public void updateGroup(@RequestBody GroupUpdateDto group) throws ApplicationException {
        log.info("group update request {}", group);
        groupService.update(group);
    }

    @DeleteMapping(path = "{groupId}")
    public void deleteGroup(@PathVariable("groupId") int groupId) throws ApplicationException {
        log.info("group deletion request {}", groupId);
        groupService.deleteGroup(groupId);
    }

    @GetMapping
    public List<GroupGetAllDto> getAllGroups() throws ApplicationException {
        log.info("get all groups request");
        return groupService.getAllGroups();
    }

    @GetMapping(path = "{groupId}")
    public GroupGetOneDto getGroupById(@PathVariable("groupId") int groupId) throws ApplicationException {
        log.info("get one group request {}", groupId);
        return groupService.getGroupById(groupId);
    }

    @GetMapping(path = "/sub-groups/{mainGroupId}")
    public List<GroupGetAllDto> getGroupsByMainGroupId(@PathVariable int mainGroupId){
        return groupService.getAllGroupsByMainGroupId(mainGroupId);
    }
}
