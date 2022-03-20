package com.barak.group;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "creator_id", nullable = false)
    private long creatorId;

    @ManyToOne
    private Group mainGroup;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mainGroup", cascade = CascadeType.REMOVE)
    private List<Group> groups;


}
