package com.alekseysamoylov.learn.security.util;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import com.alekseysamoylov.learn.security.entity.User;

public class UserAuthorityUtils {
    private static final List<GrantedAuthority> ADMIN_ROLES = AuthorityUtils.createAuthorityList("ADMIN",
            "USER");
    private static final List<GrantedAuthority> USER_ROLES = AuthorityUtils.createAuthorityList("USER");

    public static Collection<? extends GrantedAuthority> createAuthorities(User user) {
        String username = user.getEmail();
        if (username.startsWith("admin")) {
            return ADMIN_ROLES;
        }
        return USER_ROLES;
    }

    private UserAuthorityUtils() {
    }
}
