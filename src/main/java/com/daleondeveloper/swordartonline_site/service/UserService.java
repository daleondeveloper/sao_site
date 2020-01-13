package com.daleondeveloper.swordartonline_site.service;

import com.daleondeveloper.swordartonline_site.domain.User;

import java.util.Optional;

public interface UserService {

    User register(User user);

    Optional<User> findByEmail(String mail);

    Optional<User> findById(Long id);

}
