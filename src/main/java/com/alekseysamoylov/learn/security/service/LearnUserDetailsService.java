package com.alekseysamoylov.learn.security.service;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.alekseysamoylov.learn.security.authorisation.UserAuthorityUtils;
import com.alekseysamoylov.learn.security.entity.User;
import com.alekseysamoylov.learn.security.repository.UserRepository;

//@Component
public class LearnUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory
            .getLogger(UserDetailsService.class);

    private final UserRepository userRepository;

    @Autowired
    public LearnUserDetailsService(UserRepository userRepository) {
        if (userRepository == null) {
            throw new IllegalArgumentException("calendarUserDao cannot be null");
        }
        this.userRepository = userRepository;
    }

    /**
     * Lookup a {@link User} by the username representing the email address. Then, convert the
     * {@link User} into a {@link UserDetails} to conform to the {@link UserDetails} interface.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findOneByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username/password.");
        }
        return new LearnUserDetails(user);
    }

    /**
     * There are advantages to creating a class that extends {@link User}, our domain notion of a user, and
     * implements {@link UserDetails}, Spring Security's notion of a user.
     * <ul>
     * <li>First we can obtain all the custom information in the {@link User}</li>
     * <li>Second, we can use this service to integrate with Spring Security in other ways (i.e. when implementing
     * Spring Security's <a
     * href="http://static.springsource.org/spring-security/site/docs/3.1.x/reference/remember-me.html">Remember-Me
     * Authentication</a></li>
     * </ul>
     *
     * @author Rob Winch
     */
    private final class LearnUserDetails extends User implements UserDetails {
        LearnUserDetails(User user) {
            setId(user.getId());
            setEmail(user.getEmail());
            setFirstName(user.getName());
            setPassword(user.getPassword());
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return UserAuthorityUtils.createAuthorities(this);
        }

        @Override
        public String getUsername() {
            return getEmail();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

        private static final long serialVersionUID = 3384436451564509032L;
    }
}
