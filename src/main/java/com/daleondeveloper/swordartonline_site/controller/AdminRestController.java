package com.daleondeveloper.swordartonline_site.controller;

import com.daleondeveloper.swordartonline_site.domain.User;
import com.daleondeveloper.swordartonline_site.dto.AdminUserDto;
import com.daleondeveloper.swordartonline_site.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/admin/")
public class AdminRestController {
    private final UserService userService;

    @Autowired
    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "users/{id}")
    public ResponseEntity<AdminUserDto> getUserById(@PathVariable(name = "id") Long id) {
        Optional<User> user = userService.findById(id);

        if (!user.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        AdminUserDto result = AdminUserDto.fromUser(user.get());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
