package com.alekseysamoylov.learn.security.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.alekseysamoylov.learn.security.entity.User;

@Component
public class SecurityUtil {
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User encodeUserPassword(User user) {
        final String rawPassword = user.getRawPassword();
        if (passwordIsCorrect(rawPassword)) {
            return user.setPassword(encodePassword(rawPassword));
        } else {
            throw new IllegalArgumentException("User password is incorrect");
        }
    }

    private String encodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    private boolean passwordIsCorrect(String password) {
        return password != null && password.length() > 4;
    }
}
