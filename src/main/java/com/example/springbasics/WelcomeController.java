package com.example.springbasics;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	//Project files from: https://www.baeldung.com/spring-controllers
	
	@GetMapping
	@RequestMapping(value = "/welcome")
	public ModelAndView getTestData() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hello");
		mv.getModel().put("data", "Glad to have you!");

		return mv;
	}
}
