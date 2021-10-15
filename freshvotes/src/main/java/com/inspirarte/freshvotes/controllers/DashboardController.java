package com.inspirarte.freshvotes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class DashboardController {
	@RequestMapping(value="/ping", method=RequestMethod.GET)
	@ResponseBody
	public String ping() {
		System.out.println("Service is UP!");
		return "Service is Up!";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String rootView() {
		return "index"; // normally we can say /src/main/templates/index.html but thymeleaf will know where to find it
	}
	
	@GetMapping(value="/login")
	public String loginView() {
		return "login"; 
	}
	
	@GetMapping("/dashboard")
	public String dashboardView(){
		return "dashboard";
	}
}
