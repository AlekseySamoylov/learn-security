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
import com.alekseysamoylov.learn.security.repository.UserRepository;
import com.alekseysamoylov.learn.security.util.SecurityUtil;

@Component
public class LearnUserAuthenticationProvider implements AuthenticationProvider {

    private static final Logger logger = LoggerFactory
            .getLogger(LearnUserAuthenticationProvider.class);

    private final UserRepository userRepository;
    private final SecurityUtil securityUtil;

    @Autowired
    public LearnUserAuthenticationProvider(UserRepository userRepository, SecurityUtil securityUtil) {
        if (userRepository == null) {
            throw new IllegalArgumentException("calendarService cannot be null");
        }
        this.userRepository = userRepository;
        this.securityUtil = securityUtil;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        DomainUsernamePasswordAuthenticationToken token = (DomainUsernamePasswordAuthenticationToken) authentication;
        String email = token.getName();
        String domain = token.getDomain();
        if (domain != null) {
            email += "@" + domain;
        }

        User user = userRepository.findOneByEmail(email);
        logger.info("learUser: {}", user);

        if (user == null) {
            throw new UsernameNotFoundException("Invalid username/password");
        }
        String password = user.getPassword();
        if (!securityUtil.matchPasswords((String) token.getCredentials(), password)) {
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
