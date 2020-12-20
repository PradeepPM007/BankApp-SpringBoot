package application;

import javax.sql.DataSource;

//import application.Service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Value("${spring.queries.users-query}")
    private String usernameQuery;
//
    @Value("${spring.queries.roles-query}")
    private String roleQuery;

    @Autowired
    private DataSource dataSource;

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
    	httpSecurity.authorizeRequests().antMatchers("/", "/resources/**",
                "/styles/**", "/js/**","/less/**","/css/**").permitAll()
                .antMatchers("/admin/*").hasRole("ADMIN")
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .formLogin().defaultSuccessUrl("/index",true)
                .loginPage("/login").permitAll()
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login").permitAll()
                .and().exceptionHandling().accessDeniedPage("/403");
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//    	PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    	 auth.inMemoryAuthentication().withUser("user").password(encoder.encode("user")).roles("USER");
//    	 auth.inMemoryAuthentication().withUser("admin").password(encoder.encode("admin")).roles("ADMIN");
    	
    	auth.jdbcAuthentication()
        .usersByUsernameQuery(usernameQuery)
        .authoritiesByUsernameQuery(roleQuery)
        .dataSource(dataSource);
    }
    


    @SuppressWarnings("deprecation")
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
    	return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

}
