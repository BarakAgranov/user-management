package com.barak.user;

import com.barak.user.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @SequenceGenerator(
            name = "user_id_sequence",
            sequenceName = "user_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_id_sequence"
    )
    private long id;
    @Column(name = "email", nullable = false, unique = true)
    @NotBlank(message = "must have email!")
    @Email(message = "must be in form of email!")
    private String email;
    @Column(name = "password", nullable = false)
    @Size(min = 8, max = 32)
    @NotBlank
    private String password;
    @Column(name = "first_name", nullable = false)
    @Size(min = 2, max = 30)
    @NotBlank
    private String firstName;
    @Column(name = "last_name", nullable = false)
    @Size(min = 2, max = 30)
    @NotBlank
    private String lastName;
    @Column(name = "user_type", nullable = false)
    private UserType userType;




}
