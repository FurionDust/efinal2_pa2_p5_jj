package com.uce.edu.repository;

import java.util.List;

import com.uce.edu.repository.modelo.Estudiante;

public interface IEstudianteRepository {

	public void insertar(Estudiante estudiante);
	
	public Estudiante seleccionarPorCedula(String cedula);
	
	public List<Estudiante> seleccionarTodos();
	
	
}
