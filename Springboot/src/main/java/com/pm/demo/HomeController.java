package com.pm.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("home")
	public String home(HttpServletRequest request,HttpServletResponse response) {
		
		return "home";
	}
	
	@RequestMapping("home2")
	public ModelAndView home2(@RequestParam("name") String myname, HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", myname);
		mv.setViewName("home");
		System.out.println(myname);
		return mv;
	}
	
	@RequestMapping("home3")
	public ModelAndView home3(Alien alien) {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("obj", alien);
		mv.setViewName("home");
		return mv;
	}
	
	
}
