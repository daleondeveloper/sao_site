package com.daleondeveloper.swordartonline_site.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.daleondeveloper.swordartonline_site.service.serviceImpl.PostService;
import com.daleondeveloper.swordartonline_site.service.serviceImpl.VideoService;

@RestController
@AllArgsConstructor
@RequestMapping("/post")
public class PostController {
    private PostService postService;
    private VideoService videoService;

}
