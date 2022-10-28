package com.example.shirsty.demoProject.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
public class ProjectConfiguration{
    @Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	http.csrf().ignoringAntMatchers("/saveProfile").ignoringAntMatchers("/public/newUser.html").and()
    	.authorizeRequests()
    	.mvcMatchers("/login").permitAll()
    	.mvcMatchers("/home").authenticated()
    	.mvcMatchers("/myProfile").authenticated()
    	.mvcMatchers("/notification").authenticated()
    	.mvcMatchers("/messages").authenticated()
    	.and().formLogin().loginPage("/login")
        .defaultSuccessUrl("/home").failureUrl("/login?error=true").permitAll()
        .and().logout().logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll()
        .and().httpBasic();
    	// if we are working with h2 database 
//        .antMatchers("/h2-console/**").permitAll()
//        .anyRequest().permitAll();
//
//        // disable frame options
//        http.headers().frameOptions().disable();
    	
        return http.build();
	}
    
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        UserDetails user = User.withUsername("user")
            .password(encoder.encode("12345"))
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(user);
    }
    
//	@Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//		// The builder will ensure the passwords are encoded before saving in memory
//        UserDetails admin = User.builder()
//                .username("user")
//                .password("12345")
//                .roles("USER")
//                .build();
//        UserDetails user = User.builder()
//                .username("admin")
//                .password("54321")
//                .roles("USER","ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }
//	
//	  @Bean
//	    public PasswordEncoder passwordEncoder() {
//	        return new BCryptPasswordEncoder();
//	    }
}
