package com.barak.group.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class GenericGroup {

    @Id
    private Integer id;
    @Column
    private String name;
    @Column
    private long creatorId;

}
