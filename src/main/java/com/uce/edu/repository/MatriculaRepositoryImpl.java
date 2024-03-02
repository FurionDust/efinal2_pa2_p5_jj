package com.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Matricula;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Transactional
@Repository
public class MatriculaRepositoryImpl implements IMatriculaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.entityManager.persist(matricula);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Matricula> seleccionar() {

		TypedQuery<Matricula> myQuery = this.entityManager.createQuery("SELECT m FROM Matricula m", Matricula.class);
		return myQuery.getResultList();
	}
    @Override
    @Transactional(value = TxType.MANDATORY)
    public void insertarTodas(List<Matricula> matriculas) {
        for (Matricula matricula : matriculas) {
            insertar(matricula);
        }
    }

}
