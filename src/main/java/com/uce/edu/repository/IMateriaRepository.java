package com.uce.edu.repository;

import java.util.List;

import com.uce.edu.repository.modelo.Materia;

public interface IMateriaRepository {

	public void insertar(Materia materia);
	
	public Materia seleccionarPorCodigo(String codigo);
	
	public List<Materia> seleccionarTodos();
	
	
}
