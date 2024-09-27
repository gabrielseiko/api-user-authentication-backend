package com.api.authentication.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int userId;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "dni")
    private String dni;
    @Column(name = "birthdate")
    private Date birthdate;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tbl_user_has_role",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "idRole"))
    private List<Role> roles; // Cambiado a una lista de roles


    public String getFullName(){
        if (name != null && lastname != null){
            return lastname.concat(" ").concat(name);
        } else {
            return "";
        }
    }
}
