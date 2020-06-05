package jp.co.aivick.demo;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    private DataSource datasource;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/", "/index.html", "/signup", "/login", "/password/*", "/calculator/**")
            .permitAll()
            .antMatchers("/admin/**")
            .hasAuthority("ADMIN")
            .anyRequest()
            .authenticated();
        http
            .formLogin()
            .loginPage("/login")
            .loginProcessingUrl("/login")
            .defaultSuccessUrl("/recipes")
            .usernameParameter("login_id")
            .passwordParameter("password")
            .failureUrl("/login");
        http
            .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
            .dataSource(datasource)
            .usersByUsernameQuery(
                "SELECT login_id, password, is_active from users where login_id = ?")
            .authoritiesByUsernameQuery("SELECT login_id, role from users where login_id = ?")
            .passwordEncoder(passwordEncoder());
    }
}
