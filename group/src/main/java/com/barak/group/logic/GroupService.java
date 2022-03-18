package com.barak.group.logic;

import com.barak.group.entities.Group;
import com.barak.group.enums.ErrorType;
import com.barak.group.exceptions.ApplicationException;
import com.barak.group.repositories.GroupRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GroupService {

    private GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public void createGroup(Group group) throws ApplicationException {
        log.info("group creation started");
        validateGroup(group);
        log.info("group validation passed successfully");
        try {
            groupRepository.save(group);
            log.info("group created successfully");
        } catch (Exception e) {
            if (e instanceof ApplicationException) {
                throw e;
            } else throw new ApplicationException(ErrorType.GENERAL_ERROR, "general error occurs while trying to create new group: " + group.getName());
        }
    }

    public void deleteGroup(int groupId) throws ApplicationException {
        log.info("group deletion started");
        try {
            groupRepository.deleteById(groupId);
            log.info("group deleted successfully");
        } catch (Exception e) {
            if (e instanceof ApplicationException) {
                throw e;
            } else throw new ApplicationException(ErrorType.GENERAL_ERROR, "general error occurs while trying to delete group: " + groupId);
        }
    }

    public Group getGroupById(int groupId) {
        try {
            return groupRepository.getById(groupId);
        } catch (Exception e) {
            if (e instanceof ApplicationException) {

            }
        }
    }

    private void validateGroup(Group group) throws ApplicationException {
        try {
            if (group.getName() == null) {
                log.info("validation for group: " + group.getId(), " failed for not having name");
                throw new ApplicationException(ErrorType.MUST_HAVE_NAME, "group must have a name in order to be created");
            }
            if (group.getCreatorId() < 0) {
                log.info("validation for group: " + group.getId(), " failed for not having creator id");
                throw new ApplicationException(ErrorType.MUST_HAVE_CREATOR_ID, "group must have a creator id in order to be created");
            }
            if (group.getDepartment() == null) {
                log.info("validation for group: " + group.getId(), " failed for not having department");
                throw new ApplicationException(ErrorType.GROUP_MUST_HAVE_DEPARTMENT, "group must be associated with department in order to be created");
            }
        } catch (Exception e) {
            if (e instanceof ApplicationException) {
                throw e;
            } else throw new ApplicationException(ErrorType.GENERAL_ERROR, "general error occurs while trying to validate group: " + group.getName() + "with id: " + group.getId() );
        }
    }


}
