package com.project.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.demo.models.service.UserService;


@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/","/css/bootstrap.min.css","/css/all.css","/webfonts/**","/css/estilo.css",
				"/js/jquery-3.5.1.min.js","/js/bootstrap.bundle.min.js","/Imagen/**").permitAll()
		.antMatchers("/","factura/**").hasAnyRole("USER")
		.antMatchers("/tienda/**","/empleado/**","/categoria/**","/productos/**","/almacen/**").hasAnyRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/autenticacion/").defaultSuccessUrl("/",true).permitAll()
		.and()
		.logout().permitAll();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
		PasswordEncoder encoder = passwordEncoder();
		UserBuilder users = User.builder().passwordEncoder(password ->{return encoder.encode(password);});
		auth.inMemoryAuthentication()
		.withUser(users.username("admin").password("123").roles("ADMIN","USER"))
		.withUser(users.username("jorge").password("123").roles("USER"));
		
	}
	
	
}
