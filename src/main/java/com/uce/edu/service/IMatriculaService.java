package com.uce.edu.service;

import java.util.List;

import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.dto.MatriculaDTO;


public interface IMatriculaService {

    public void guardar(Matricula matricula);

    List<Matricula> buscarTodos();
    
    public void matricularE(String cedula, String codigo1,String codigo2,String codigo3,String codigo4);
}