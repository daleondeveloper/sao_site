package com.daleondeveloper.swordartonline_site.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.daleondeveloper.swordartonline_site.dao.VideoRepository;

@Service
public class VideoService {
    @Autowired
    VideoRepository videoRepository;
}
