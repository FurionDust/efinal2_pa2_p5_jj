package com.uce.edu.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IEstudianteRepository;
import com.uce.edu.repository.IMateriaRepository;
import com.uce.edu.repository.IMatriculaRepository;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.repository.modelo.Materia;
import com.uce.edu.repository.modelo.Matricula;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class MatriculaServiceImpl implements IMatriculaService{

	@Autowired
	private IMatriculaRepository iMatriculaRepository;
	@Autowired
	private IEstudianteRepository estudianteRepository;
	@Autowired
	private IMateriaRepository iMateriaRepository;
	
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void guardar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.iMatriculaRepository.insertar(matricula);
	}


	@Override
	public List<Matricula> buscarTodos() {
		// TODO Auto-generated method stub
		return this.iMatriculaRepository.seleccionar();
	}


	@Override
	public void matricularE(String cedula, String codigo1, String codigo2, String codigo3, String codigo4) {
      
        Estudiante estudiante = estudianteRepository.seleccionarPorCedula(cedula);

    
        if (estudiante == null) {
       
            throw new RuntimeException("No se encontró un estudiante con la cédula: " + cedula);
        }

     
        Materia materia1 = iMateriaRepository.seleccionarPorCodigo(codigo1);
        Materia materia2 = iMateriaRepository.seleccionarPorCodigo(codigo2);
        Materia materia3 = iMateriaRepository.seleccionarPorCodigo(codigo3);
        Materia materia4 = iMateriaRepository.seleccionarPorCodigo(codigo4);

     
        if (materia1 == null || materia2 == null || materia3 == null || materia4 == null) {
       
            throw new RuntimeException("No se encontró una o varias materias con los códigos proporcionados.");
        }


        LocalDateTime fechaMatricula = LocalDateTime.now();

 
        Matricula matricula1 = crearMatricula(estudiante, materia1, codigo1, fechaMatricula);
        Matricula matricula2 = crearMatricula(estudiante, materia2, codigo2, fechaMatricula);
        Matricula matricula3 = crearMatricula(estudiante, materia3, codigo3, fechaMatricula);
        Matricula matricula4 = crearMatricula(estudiante, materia4, codigo4, fechaMatricula);

        
        iMatriculaRepository.insertar(matricula1);
        iMatriculaRepository.insertar(matricula2);
        iMatriculaRepository.insertar(matricula3);
        iMatriculaRepository.insertar(matricula4);
    }

    private Matricula crearMatricula(Estudiante estudiante, Materia materia, String codigo, LocalDateTime fechaMatricula) {
        Matricula matricula = new Matricula();
        matricula.setEstudiante(estudiante);
        matricula.setMateria(materia);
        matricula.setCodigo1(codigo);
        matricula.setFechaMatricula(fechaMatricula);
        matricula.setNombreHilo(Thread.currentThread().getName());
        return matricula;
    }
}
