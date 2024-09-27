package com.api.authentication.repository;

import com.api.authentication.entity.Role;
import com.api.authentication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    @Query("SELECT r FROM UserRole ur JOIN ur.role r WHERE ur.user.userId = ?1")
    List<Role> getRolesUser(int userId);


}
