package com.mobileshop.group5.repository;


import com.mobileshop.group5.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRoleId(@Param("roleID") Integer id);
}
