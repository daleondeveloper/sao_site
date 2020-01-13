package com.daleondeveloper.swordartonline_site.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.daleondeveloper.swordartonline_site.domain.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Modifying
    @Query("UPDATE User c SET c.image_main = :image WHERE c.id = :id")
    void updateAvatar(@Param("id") Long id, @Param("image") byte[] image);

    @Query("SELECT c FROM User c WHERE c.email = :email")
    Optional<User> findByEmail(@Param("email") String email);
}
