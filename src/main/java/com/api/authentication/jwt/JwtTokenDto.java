package com.api.authentication.jwt;

import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
@ToString
public class JwtTokenDto {

    private String token;
    private String bearer = "Bearer";
    private int idUser;
    private String username;
    private String fullname;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtTokenDto(String token, String login, String fullname, int idUser, Collection<? extends GrantedAuthority> authorities){
        this.token = token;
        this.username = login;
        this.fullname = fullname;
        this.authorities = authorities;
        this.idUser = idUser;
    }
}
