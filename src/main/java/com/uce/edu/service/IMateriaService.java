package com.uce.edu.service;

import java.util.List;

import com.uce.edu.repository.modelo.Materia;

public interface IMateriaService {

	public void insertar(Materia materia);
	
	public Materia seleccionarPorCodigo(String codigo);
	
	public List<Materia> seleccionarTodos();
	

	
}
