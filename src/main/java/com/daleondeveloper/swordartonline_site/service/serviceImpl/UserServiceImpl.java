package com.daleondeveloper.swordartonline_site.service.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import com.daleondeveloper.swordartonline_site.dao.UserRepository;
import com.daleondeveloper.swordartonline_site.dao.UserRoleRepository;
import com.daleondeveloper.swordartonline_site.domain.DBFile;
import com.daleondeveloper.swordartonline_site.domain.User;
import com.daleondeveloper.swordartonline_site.domain.UserRole;
import com.daleondeveloper.swordartonline_site.exception.FileStorageException;
import com.daleondeveloper.swordartonline_site.exception.MyFileNotFoundException;
import com.daleondeveloper.swordartonline_site.service.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;
    private UserRoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserRoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void addUser(User user){userRepository.save(user);}

    @Transactional
    public void updateAvatar (Long id, MultipartFile file){
        //Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

      //  if(file.getContentType().equals("jpg")) {
            try {
                //Check if the files name contains invalid characters
                if (fileName.contains("src/test")) {
                    throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
                }
                System.out.println(file.getContentType());
                userRepository.updateAvatar(id,file.getBytes());


            } catch (IOException e) {
                throw new FileStorageException("Could not store file " + fileName + ". Please try again!", e);
            }
     //   }

    }

    @Transactional
    public Optional<User> findByEmail(String email){return userRepository.findByEmail(email);}

    @Override
    @Transactional
    public User register(User user) {
        if(user.getEmail() != null && user.getPassword() != null) {
            UserRole role = roleRepository.findByName("ROLE_USER");
            List<UserRole> roles_list = new ArrayList<>();
            roles_list.add(role);

            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(roles_list);
            user = userRepository.save(user);

            return user;
        }else{
            return null;
        }
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

}
