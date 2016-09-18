package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.pojo.Administrador;

@Controller
public class AdminController {

	@RequestMapping(value = "/admin")
	public String showAdmin(Model model) {
		model.addAttribute("admin", new Administrador());
		return "admin";
	}

	@RequestMapping(value = "/admin/save", method = RequestMethod.POST)
	public String handleAdmin(@ModelAttribute("admin") Administrador adminForm, Model model) {
		model.addAttribute("adminForm", adminForm);
		return "index";
	}
}
