package com.mobileshop.group5.repository;

import com.mobileshop.group5.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Member, String> {
    Member findByUserId(@Param("userID")String userId);
}
