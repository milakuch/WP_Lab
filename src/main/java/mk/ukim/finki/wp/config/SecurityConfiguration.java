package mk.ukim.finki.wp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;

    public SecurityConfiguration(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers( "/courses/**").hasRole("ADMIN")
//                .antMatchers( "/","/student").hasRole("USER")
                .antMatchers("/coursesList").anonymous()
                .antMatchers("/AddStudent","/", "/default").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
//                .loginPage("/login")
                .defaultSuccessUrl("/default")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and().csrf().disable(); // we'll enable this in a later blog post
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1")
                .password(passwordEncoder.encode(("pass")))
                .roles("USER")
                .and()
                .withUser("admin")
                .password(passwordEncoder.encode(("admin")))
                .roles("ADMIN");
    }
}
