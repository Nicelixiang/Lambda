package com.example.demo.web;

import java.util.Collection;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.util.User1;
@Controller
public class Security {
	
	@GetMapping("/login")
	public String SecurityDemo()  {
//		http.authorizeRequests().antMatchers("/signup", "/about","/login").permitAll();
		return "login";
	}
	@GetMapping("/")
	public String SecurityTijiao(HttpServletRequest reques)  {
//		reques.getSession().setAttribute("ser", user);
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
				.getAuthentication()
				.getPrincipal();
		
		Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
//		reques.getSession().getAttribute("ser");
		return"holle";
	}
//	@GetMapping("getsession")
//	public String index(Model model) {
//		//获取用户对象
//		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
//				.getAuthentication()
//				.getPrincipal();
//		return "index";
//	}

}
