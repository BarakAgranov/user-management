package com.barak.group.entities;

import com.barak.group.entities.Department;
import com.barak.group.entities.GenericGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "groups")
public class Group extends GenericGroup {

    @ManyToOne
    private Department department;

}
