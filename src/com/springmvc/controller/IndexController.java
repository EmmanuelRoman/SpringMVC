package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@SessionAttributes("resultado")
@Controller
public class IndexController {

	@RequestMapping(value = "/")
	public String showIndex(Model model) {
		model.addAttribute("resultado", "Mensaje desde la Sesión.");
		return "index";
	}

	@RequestMapping(value = "/about")
	public String showAbout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "about";
	}
}
