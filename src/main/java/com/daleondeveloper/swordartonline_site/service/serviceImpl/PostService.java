package com.daleondeveloper.swordartonline_site.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.daleondeveloper.swordartonline_site.dao.PostRepository;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;
}
