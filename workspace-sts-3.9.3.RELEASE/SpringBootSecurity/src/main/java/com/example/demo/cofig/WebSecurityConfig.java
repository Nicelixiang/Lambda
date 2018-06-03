package com.example.demo.cofig;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter implements ApplicationContextAware{

//	@Bean
//	public UserDetailsService userDetailsService() {
//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//		manager.createUser(User.withUsername("user").password("password").roles("USER").build());
//		return manager;
//	}
//	
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.authorizeRequests()
//				.anyRequest().authenticated()
//				.and()
//			.formLogin()
//				.and()
//			.httpBasic()
//			;
//	}
//	protected void registerAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("user") // #1
//				.password("password").roles("USER").and().withUser("admin") // #2
//				.password("password").roles("ADMIN", "USER");
//}
//
//@Override
//public void configure(WebSecurity web) throws Exception {
//	web.ignoring().antMatchers("/resources/**"); // #3
//}
//
//@Override
//protected void configure(HttpSecurity http) throws Exception {
//	http.authorizeRequests().antMatchers("/signup", "/about").permitAll() // #4
//			.antMatchers("/admin/**").hasRole("ADMIN") // #6
//			.anyRequest().authenticated() // #7
//			.and().formLogin() // #8
//			.loginPage("/login") // #9
//			.permitAll(); // #5
//}
	@Bean
    public TemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        
        
        engine.addDialect(new SpringSecurityDialect());
        return engine;
    }
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password")
				.roles("USER");
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		//解决重定向问题！
		
		http.authorizeRequests().antMatchers("/signup", "/about","/login").permitAll();
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login").and().httpBasic()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")); // logout;
	} 


	
}