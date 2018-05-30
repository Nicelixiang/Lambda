package com.example.demo.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

	@RestController
	public class HelloController {
		@GetMapping("/")
		public String index() {
			return "Nicelixiang!";
		}
		//设置是否可以联网
		@RequestMapping(value="/health",method=RequestMethod.POST)
		public void showData(Model model,HttpServletRequest request,HttpServletResponse response) {
			
			try {
				response.sendRedirect("www.baidu.com");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			request.setAttribute("data", "这是数据");
//			request.setAttribute("user", user);						
		}
		

	}
	

