package com.daleondeveloper.swordartonline_site.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.daleondeveloper.swordartonline_site.domain.User;
import com.daleondeveloper.swordartonline_site.security.jwt.JwtUser;
import com.daleondeveloper.swordartonline_site.security.jwt.JwtUserFactory;
import com.daleondeveloper.swordartonline_site.service.UserService;

import java.util.Optional;

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        Optional<User> user = userService.findByEmail(mail);

        if( !user.isPresent()){
            throw new UsernameNotFoundException("User with mail : " + mail + " not found");
        }

        JwtUser jwtUser = JwtUserFactory.create(user.get());


        return jwtUser;
    }

}
