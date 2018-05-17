package com.alekseysamoylov.learn.security.authentication;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.alekseysamoylov.learn.security.authorisation.UserAuthorityUtils;
import com.alekseysamoylov.learn.security.entity.User;
import com.alekseysamoylov.learn.security.service.UserService;

@Component
public class LearnUserAuthenticationProvider implements AuthenticationProvider {

    private static final Logger logger = LoggerFactory
            .getLogger(LearnUserAuthenticationProvider.class);

    private final UserService userService;

    @Autowired
    public LearnUserAuthenticationProvider(UserService userService) {
        if (userService == null) {
            throw new IllegalArgumentException("calendarService cannot be null");
        }
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        DomainUsernamePasswordAuthenticationToken token = (DomainUsernamePasswordAuthenticationToken) authentication;
        String userName = token.getName();
        String domain = token.getDomain();
        String email = userName + "@" + domain;

//        CalendarUser user = email == null ? null : calendarService.findUserByEmail(email);
        User user = userService.findUserByEmail(email);
        logger.info("learUser: {}", user);

        if (user == null) {
            throw new UsernameNotFoundException("Invalid username/password");
        }
        String password = user.getPassword();
        if (!password.equals(token.getCredentials())) {
            throw new BadCredentialsException("Invalid username/password");
        }
        Collection<? extends GrantedAuthority> authorities = UserAuthorityUtils.createAuthorities(user);
        logger.info("authorities: {}", authorities);
        return new DomainUsernamePasswordAuthenticationToken(user, password, domain, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return DomainUsernamePasswordAuthenticationToken.class.equals(authentication);
    }
}
