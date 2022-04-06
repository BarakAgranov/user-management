package com.barak.group;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
    @NotBlank(message = "must have a name!")
    @Size(min = 2, max = 30)
    private String name;

    @Column(name = "creator_id", nullable = false)
    private long creatorId;

    @ManyToOne
    private Group mainGroup;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mainGroup", cascade = CascadeType.REMOVE)
    private List<Group> groups;

    public Group(String name, long creatorId) {
        this.name = name;
        this.creatorId = creatorId;
    }
}
