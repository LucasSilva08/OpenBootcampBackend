package com.sinfloo.demo.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sinfloo.demo.interfaceService.IPersonaService;
import com.sinfloo.demo.modelo.Persona;

@Controller
@RequestMapping
public class Controlador {

	@Autowired
	private IPersonaService servicio;
	
	@GetMapping("/listar")
	public String listar(Model modelo) {
		
		List<Persona> personas = servicio.listar();
		modelo.addAttribute("personas",personas);
		return "index";
	}
	
	@GetMapping("/nuevo")
	public String agregar(Model modelo) {
		
		modelo.addAttribute("personas",new Persona());
		return "formulario";
	}
	
	@PostMapping("/save")
	public String save(@Validated Persona miPersona,Model modelo) {
		
		servicio.save(miPersona);
		return "redirect:/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id ,Model modelo) {
		
		Optional<Persona> persona = servicio.listarId(id);
		modelo.addAttribute("personas",persona);
		return "formulario";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable int id ,Model modelo) {
		
		servicio.delete(id);
		return "redirect:/listar";
	}
}
