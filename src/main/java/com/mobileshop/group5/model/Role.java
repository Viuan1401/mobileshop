package com.mobileshop.group5.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Role", schema = "dbo")
public class Role {
    private int roleId;
    private String name;

    @Id
    @Column(name = "roleID", nullable = false)
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return roleId == role.roleId &&
                Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, name);
    }


}
