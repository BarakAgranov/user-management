package com.barak.group;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class GroupApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(GroupApplication.class, args);

//        System.out.println("YIPPY HOY");
//
//        GroupRepository groupRepository = context.getBean(GroupRepository.class);
//        System.out.println("THANK FOR CONTEXT");
//        Group group1 = new Group(null, "a", 200 , GroupType.DEPARTMENT, null,null);
//        System.out.println("GROUP NUMBER 1 CREATED");
//        Group group2 = new Group(null, "b", 300 , GroupType.GROUP, group1,null);
//
//        System.out.println("GROUP NUMBER 2 CREATED");
//        groupRepository.save(group1);
//        System.out.println("GROUP NUMBER 1 SAVED");
//        groupRepository.save(group2);
//        System.out.println("GROUP NUMBER 2 SAVED");
//
//        List<Group> groups = new ArrayList<>();
//        groups.add(group2);
//        group1.setSubGroups(groups);
//        groupRepository.save(group1);


//        GroupService groupService = context.getBean(GroupService.class);
//
//        Organization group1 = new Organization(null);
//        System.out.println(group1.toString());
//        groupService.createGroup( group1);
    }
}
