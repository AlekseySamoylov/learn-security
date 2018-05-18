package com.alekseysamoylov.learn.security.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.alekseysamoylov.learn.security.authentication.DomainUsernamePasswordAuthenticationFilter;
import com.alekseysamoylov.learn.security.authentication.LearnUserAuthenticationProvider;

/**
 * Spring Security Config Class
 *
 * @see WebSecurityConfigurerAdapter
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger logger = LoggerFactory
            .getLogger(SecurityConfig.class);

    @Autowired
    private LearnUserAuthenticationProvider learnUserAuthenticationProvider;
    /**
     * Configure AuthenticationManager with inMemory credentials.
     *
     * @param auth AuthenticationManagerBuilder
     * @throws Exception Authentication exception
     */
    @Override
    public void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(learnUserAuthenticationProvider);
//        auth.inMemoryAuthentication().withUser("user@noemail.com")
//                .password("$2a$10$mrefvevdqVe.xD3fJW5gqenLLJQYdq2LLD5DqAwYpUYusJky1/O8a").roles("ADMIN");
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
                .antMatchers("/**").permitAll()
                .antMatchers("/login/**").permitAll()
                .antMatchers("/logout").permitAll()
                .antMatchers("/errors/**").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/portal/**").hasRole("USER")

                .and().exceptionHandling()
                .accessDeniedPage("/errors/403")
                .authenticationEntryPoint(loginUrlAuthenticationEntryPoint())

                .and().logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll()

                .and().anonymous()

                // CSRF is enabled by default, with Java Config
                .and().csrf().disable()
                // Add custom DomainUsernamePasswordAuthenticationFilter
                .addFilterAt(domainUsernamePasswordAuthenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(final WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/resources/**")
                .antMatchers("/built/**")
                .antMatchers("/css/**")
                .antMatchers("/webjars/**")
        ;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DomainUsernamePasswordAuthenticationFilter domainUsernamePasswordAuthenticationFilter()
            throws Exception {
        DomainUsernamePasswordAuthenticationFilter dupaf = new DomainUsernamePasswordAuthenticationFilter(
                super.authenticationManagerBean());
        dupaf.setFilterProcessesUrl("/login");
        dupaf.setUsernameParameter("username");
        dupaf.setPasswordParameter("password");

        dupaf.setAuthenticationSuccessHandler(
                new SavedRequestAwareAuthenticationSuccessHandler() {{
                    setDefaultTargetUrl("/");
                }}
        );

        dupaf.setAuthenticationFailureHandler(
                new SimpleUrlAuthenticationFailureHandler() {{
                    setDefaultFailureUrl("/login");
                }}
        );

        dupaf.afterPropertiesSet();

        return dupaf;
    }

    @Bean
    public LoginUrlAuthenticationEntryPoint loginUrlAuthenticationEntryPoint() {
        return new LoginUrlAuthenticationEntryPoint("/login");
    }

}
