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
    private UserContext userContext;

    @Autowired
    private SecurityUtil securityUtil;

    public User registration(User user) {
        user = securityUtil.encodeUserPassword(user);
        user = userRepository.save(user);
        userContext.setCurrentUser(user);
        return user;
    }

    public User findUserByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }
}
