package com.barak.group.entities;


import com.barak.group.entities.Department;
import com.barak.group.entities.GenericGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "organizations")
public class Organization extends GenericGroup {


    @OneToMany
    private List<Department> departments;
}
