package com.pm.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pm.demo.dao.AlienRepo;

@Controller
public class HomeController {

	@Autowired
	AlienRepo aRepo;
	
	@RequestMapping("/")
	public String indexPage() {
		
		return "home";
	}
	
	@RequestMapping("/addAlien")
	public String add(Alien alien) {
		aRepo.save(alien);
		return "home";
	}
}
