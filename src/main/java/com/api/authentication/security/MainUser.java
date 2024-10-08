package com.api.authentication.security;

import com.api.authentication.entity.Role;
import com.api.authentication.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@CommonsLog
@ToString
public class MainUser implements UserDetails {

    private int userId;
    private String username;
    private String password;
    private String fullName;
    private Collection<? extends GrantedAuthority> authorities;

    public static MainUser build(User user, List<Role> roles){
        log.info("> Usuario Principal >> " + user);
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (Role x : roles){
            authorities.add(new SimpleGrantedAuthority(x.getRole()));
        }
        return new MainUser(user.getUserId(), user.getUsername(), user.getPassword(), user.getFullName(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getFullName() {
        return fullName;
    }

}
