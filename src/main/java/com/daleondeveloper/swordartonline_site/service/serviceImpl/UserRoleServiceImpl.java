package com.daleondeveloper.swordartonline_site.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.daleondeveloper.swordartonline_site.dao.UserRoleRepository;
import com.daleondeveloper.swordartonline_site.domain.UserRole;
import com.daleondeveloper.swordartonline_site.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRoleRepository userRoleRepository;

    @Transactional
    public UserRole saveUserRole(UserRole role){return userRoleRepository.save(role);}

   public UserRole findByName(String name){return userRoleRepository.findByName(name);}


}
