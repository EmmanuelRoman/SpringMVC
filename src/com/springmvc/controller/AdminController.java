package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springmvc.pojo.Administrador;
import com.springmvc.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/admin")
	public String showAdmin(Model model, @ModelAttribute("resultado") String resultado) {
		model.addAttribute("admin", new Administrador());
		model.addAttribute("resultado", resultado);
		return "admin";
	}

	@RequestMapping(value = "/admin/save", method = RequestMethod.POST)
	public String handleAdmin(@ModelAttribute("admin") Administrador adminForm, Model model,
			RedirectAttributes redirect, @RequestParam("estado") String estado) {
		System.out.println(adminForm);
		System.out.println("RequestParam := " + estado);
		redirect.addFlashAttribute("resultado", "Cambios realizados con �xito");
		return "redirect:/admin";
	}
}
