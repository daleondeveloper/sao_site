package com.daleondeveloper.swordartonline_site.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.daleondeveloper.swordartonline_site.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
}
