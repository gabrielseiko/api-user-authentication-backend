package com.api.authentication.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_user_has_role")
public class UserRole {

    @Id
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "idRole")
    private Role role;
}
