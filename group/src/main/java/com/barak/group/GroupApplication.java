package com.barak.group;

import com.barak.group.dto.GroupCreateDto;
import com.barak.group.exceptions.ApplicationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class GroupApplication {
    public static void main(String[] args) throws ApplicationException {
        ApplicationContext context = SpringApplication.run(GroupApplication.class, args);

        GroupController groupController = context.getBean(GroupController.class);

        for (GroupCreateDto group: GROUPS) {
            groupController.createGroup(group);
        }
    }

    final static List<GroupCreateDto> GROUPS = Arrays.asList(
            new GroupCreateDto("group1", 1, null),
            new GroupCreateDto("group2",2, 1),
            new GroupCreateDto("group3",3, 1)
    );
}
