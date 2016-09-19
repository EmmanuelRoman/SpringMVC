package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springmvc.pojo.Administrador;
import com.springmvc.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/admin")
	public String showAdmin(Model model, @ModelAttribute("resultado") String resultado) {
		List<Administrador> administradores = adminService.findAll();
		model.addAttribute("admin", new Administrador());
		model.addAttribute("administradores", administradores);
		model.addAttribute("resultado", resultado);
		return "admin";
	}

	@RequestMapping(value = "/admin/save", method = RequestMethod.POST)
	public String handleAdmin(@ModelAttribute("admin") Administrador adminForm, Model model,
			RedirectAttributes redirect) {
		if (adminService.save(adminForm)) {
			redirect.addFlashAttribute("resultado", "Cambios realizados con éxito");
		} else {
			redirect.addFlashAttribute("resultado", "Error al realizar los cambios");
		}
		return "redirect:/admin";
	}

	@RequestMapping(value = "/admin/{id}/update")
	public String showUpdate(Model model, @PathVariable("id") int id) {
		Administrador admin = adminService.findById(id);
		model.addAttribute("admin", admin);
		return "admin";
	}
}
