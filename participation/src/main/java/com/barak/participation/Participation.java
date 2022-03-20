package com.barak.participation;

import com.barak.participation.enums.ParticipationType;
import com.barak.participation.enums.StatusType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "participations")
public class Participation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "participant_id", nullable = false)
    private long participantId;

    @Column(name = "participant_name", nullable = false)
    private String participantName;

    @Column(name = "participation_type", nullable = false)
    private ParticipationType participationType;

    @Column(name = "invitor_id", nullable = false)
    private long invitorId;

    @Column(name = "invitor_name", nullable = false)
    private String invitorName;

    @Column(name = "group_id", nullable = false)
    private int groupId;

    @Column(name = "group_name", nullable = false)
    private String groupName;

    @Column(name = "role_id", nullable = false)
    private int roleId;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "status")
    private StatusType status;

    @Column(name = "creation_date", nullable = false)
    private Date creationDate;

}
