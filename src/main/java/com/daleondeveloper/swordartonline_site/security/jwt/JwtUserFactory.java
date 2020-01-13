package com.daleondeveloper.swordartonline_site.security.jwt;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.daleondeveloper.swordartonline_site.domain.User;
import com.daleondeveloper.swordartonline_site.domain.UserRole;
import com.daleondeveloper.swordartonline_site.domain.dao_enum.User_Role_Enum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    public JwtUserFactory() {
    }


    public static JwtUser create (User user){
        return new JwtUser(
                user.getId(),
                user.getNickname(),
                user.getEmail(),
                user.getPassword(),
                true,
                user.getLastUpdateDate(),
                mapToGrantedAuthorities(new ArrayList<>(user.getRoles()))
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<UserRole> userRoles){
        return userRoles.stream()
                .map(role ->
                    new SimpleGrantedAuthority(role.getName())
                ).collect(Collectors.toList());
    }
}
