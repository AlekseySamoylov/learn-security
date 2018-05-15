package com.alekseysamoylov.learn.security.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Spring Security Config Class
 *
 * @see WebSecurityConfigurerAdapter
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger logger = LoggerFactory
            .getLogger(SecurityConfig.class);

    /**
     * Configure AuthenticationManager with inMemory credentials.
     *
     * @param auth AuthenticationManagerBuilder
     * @throws Exception Authentication exception
     */
    @Override
    public void configure(final AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication().withUser("user")
                .password("$2a$10$mrefvevdqVe.xD3fJW5gqenLLJQYdq2LLD5DqAwYpUYusJky1/O8a").roles("USER");

        auth.inMemoryAuthentication().withUser("admin")
                .password("$2a$10$mrefvevdqVe.xD3fJW5gqenLLJQYdq2LLD5DqAwYpUYusJky1/O8a").roles("ADMIN");

        logger.info("***** Password for user 'user1@example.com' is 'secret'");
    }

    /**
     * HTTP Security configuration
     * <p>
     * <http auto-config="true"> is equivalent to:
     * <pre>
     *  <http>
     *      <form-login />
     *      <http-basic />
     *      <logout />
     *  </http>
     * </pre>
     * <p>
     * Which is equivalent to the following JavaConfig:
     *
     * <pre>
     *     http.formLogin()
     *          .and().httpBasic()
     *          .and().logout();
     * </pre>
     *
     * @param http HttpSecurity configuration.
     * @throws Exception Authentication configuration exception
     */
    @Override
    protected void configure(final HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin/**").access("hasRole('ADMIN')")
                .and().formLogin().loginPage("/login")
                .loginProcessingUrl("/login").successForwardUrl("/")
                .usernameParameter("username")
                .passwordParameter("password")
                .and().httpBasic()
                .and().logout().logoutUrl("/logout")

                // CSRF is enabled by default, with Java Config
                .and().csrf().disable();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
