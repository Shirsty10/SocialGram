package com.example.shirsty.demoProject.security;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.shirsty.demoProject.model.Person;
import com.example.shirsty.demoProject.model.Roles;
import com.example.shirsty.demoProject.repository.PersonRepo;


@Component
public class NewUserAuthentication implements AuthenticationProvider{
   
	@Autowired
	private PersonRepo presonRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		String username = authentication.getName();
		String pwd = authentication.getCredentials().toString();
		
		Person person = presonRepo.readByName(username);
		
		if(null !=person && person.getPerson_id()>0 && passwordEncoder.matches(pwd,person.getPwd())) {
			return new UsernamePasswordAuthenticationToken(person.getName(), pwd, getGrantedAuthorities(person.getRoles()));
		}else {
			throw new BadCredentialsException("Invalid credentials!");
		}
	
	}
	
	 private List<GrantedAuthority> getGrantedAuthorities(Roles roles) {
	        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
	        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+roles.getRoleName()));
	        return grantedAuthorities;
	    }

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
		
	}
}
