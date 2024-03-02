package com.uce.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.repository.modelo.Materia;
import com.uce.edu.service.IMateriaService;

@Controller
@RequestMapping(value = "/materias")
public class MateriaController {

	@Autowired
	private IMateriaService iMateriaService;

	@GetMapping("/buscarTodos")
	public String buscarTodos(Model modelo) {
		List<Materia> lista = this.iMateriaService.seleccionarTodos();
		modelo.addAttribute("materias", lista);
		return "vistaListaMaterias";
	}

	@PostMapping("/insertar")
	public String insertar(Materia materia) {
		this.iMateriaService.insertar(materia);
		return "redirect:/materias/nuevaMateria";
	}

	@GetMapping("/nuevaMateria")
	public String mostrarNuevoEstudiante(Model modelo) {

		modelo.addAttribute("materia", new Materia());
		
		return "vistaNuevaMateria";
	}
    @GetMapping("/volver")
    public String volver() {
        return "redirect:/uce/ver";
    }

}