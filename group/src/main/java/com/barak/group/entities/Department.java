package com.barak.group.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "departments")
public class Department extends GenericGroup {


    @ManyToOne
    private Organization organization;
    @OneToMany
    private List<Group> groups;
}
