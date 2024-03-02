package com.uce.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.service.IEstudianteService;

@Controller
@RequestMapping(value = "/estudiantes")
public class EstudianteController {

	@Autowired
	private IEstudianteService estudianteService;

	@GetMapping("/buscarTodos")
	public String buscarTodos(Model modelo) {
		List<Estudiante> lista = this.estudianteService.buscarTodos();
		modelo.addAttribute("estudiantes", lista);
		return "vistaListaEstudiantes";
	}

	@PostMapping("/insertar")
	public String insertar(Estudiante estudiante) {
		this.estudianteService.guardar(estudiante);
		return "redirect:/estudiantes/nuevoEstudiante";
	}

	@GetMapping("/nuevoEstudiante")
	public String mostrarNuevoEstudiante(Model modelo) {

		modelo.addAttribute("estudiante", new Estudiante());
		
		return "vistaNuevoEstudiante";
	}
    @GetMapping("/volver")
    public String volver() {
        return "redirect:/uce/ver";
    }
}