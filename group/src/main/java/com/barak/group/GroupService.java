package com.barak.group;

import com.barak.group.enums.ErrorType;
import com.barak.group.exceptions.ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
            } else throw new ApplicationException(ErrorType.GENERAL_ERROR, "general error occurs while trying to delete groupwith id: " + groupId);
        }
    }

    public Group getGroupById(int groupId) throws ApplicationException {
        try {
            Group group = groupRepository.getById(groupId);
            if (group != null) {
                return group;
            } else throw new ApplicationException(ErrorType.GROUP_DOES_NOT_EXIST, "group with id: " + groupId + " does not exist");
        } catch (Exception e) {
            if (e instanceof ApplicationException) {
                throw e;
            } else throw new ApplicationException(ErrorType.GENERAL_ERROR, "general error occurs while trying to find group with id: " + groupId);
        }
    }

    public List<Group> getAllGroups() throws ApplicationException {
        try {
            return groupRepository.findAll();
        } catch (Exception e) {
            throw new ApplicationException(ErrorType.GENERAL_ERROR, "general error occurs while trying to find all groups");
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

        } catch (Exception e) {
            if (e instanceof ApplicationException) {
                throw e;
            } else throw new ApplicationException(ErrorType.GENERAL_ERROR, "general error occurs while trying to validate group: " + group.getName() + "with id: " + group.getId() );
        }
    }


}
