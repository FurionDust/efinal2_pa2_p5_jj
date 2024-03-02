package com.uce.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.dto.MatriculaDTO;
import com.uce.edu.service.IMatriculaService;

@Controller
@RequestMapping(value = "/matriculas")
public class MatriculaController {

    @Autowired
    private IMatriculaService iMatriculaService;
    
    @ModelAttribute("matriculaDTO")
    public MatriculaDTO getMatriculaDTO() {
        return new MatriculaDTO();
    }

    @GetMapping("/mostrarFormulario")
    public String mostrarFormularioMatricula(Model model) {
        model.addAttribute("matriculaDTO", new MatriculaDTO());
        return "vistaNuevaMatricula";
    }

    @PostMapping("/matricular")
    public String procesarFormularioMatricula(@ModelAttribute("matriculaDTO") MatriculaDTO matriculaDTO) {
        iMatriculaService.matricularE(
            matriculaDTO.getCedula(),
            matriculaDTO.getCodigo1(),
            matriculaDTO.getCodigo2(),
            matriculaDTO.getCodigo3(),
            matriculaDTO.getCodigo4()
        );
        return "redirect:/matriculas/mostrarFormulario";
    }

    @GetMapping("/matricular")
    public String mostrarFormularioMatricular(Model model) {
    	model.addAttribute("matriculaDTO", new MatriculaDTO());
        return "vistaNuevaMatricula";
    }

    @GetMapping("/buscarTodos")
    public String iniciarReporte(Model model) {
        List<Matricula> matriculas = iMatriculaService.buscarTodos();
        model.addAttribute("matriculas", matriculas);
        return "vistaListaMatriculas";
    }

    @GetMapping("/volver")
    public String volver() {
        return "redirect:/uce/ver";
    }
}