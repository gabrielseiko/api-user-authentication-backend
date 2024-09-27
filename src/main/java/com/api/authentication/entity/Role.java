package com.api.authentication.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRole")
    private int idRole;

    @Column(name = "role")
    private String role;

    @Column(name = "description")
    private String description;
}
