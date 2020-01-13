package com.daleondeveloper.swordartonline_site.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.daleondeveloper.swordartonline_site.domain.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Long> {

    UserRole findByName(@Param("name")String name);
}
