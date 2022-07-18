package com.mobileshop.group5.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="Member", schema="dbo")
public class Member {
    private String fullName;
    private String userId;
    private String password;
    private String email;
    private String phone;
    private Role roleByRoleId;


    private String passwordComfirm;
    @Transient
    public String getPasswordComfirm() {
        return passwordComfirm;
    }

    public void setPasswordComfirm(String passwordComfirm) {
        this.passwordComfirm = passwordComfirm;
    }




    @Basic
    @Column(name = "fullName", nullable = true, length = 50)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Id
    @Column(name = "userID", nullable = false, length = 20)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(fullName, member.fullName) && Objects.equals(userId, member.userId) && Objects.equals(password, member.password) && Objects.equals(email, member.email) && Objects.equals(phone, member.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, userId, password, email, phone);
    }

    @ManyToOne
    @JoinColumn(name = "roleID", referencedColumnName = "roleID")
    public Role getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(Role roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }
}
