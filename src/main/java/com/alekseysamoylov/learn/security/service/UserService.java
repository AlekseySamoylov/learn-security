package com.alekseysamoylov.learn.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alekseysamoylov.learn.security.entity.User;
import com.alekseysamoylov.learn.security.repository.UserRepository;
import com.alekseysamoylov.learn.security.util.SecurityUtil;

@Transactional
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityUtil securityUtil;

    public User save(User user) {
        user = securityUtil.encodeUserPassword(user);
        user = userRepository.save(user);
        return user;
    }
}
