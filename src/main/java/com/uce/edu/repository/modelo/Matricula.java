package com.uce.edu.repository.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "matricula")
public class Matricula {
	
	@Id

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_matricula")
	@SequenceGenerator(name = "seq_matricula", sequenceName = "seq_matricula", allocationSize = 1)

	@Column(name ="matri_id")
	private Integer id;
	
	@Column(name ="matri_fecha_matricula")
	private LocalDateTime fecha;
	
	@Column(name ="matri_nombre_hilo")
	private String nombreHilo;
	
	@Column(name ="matri_codigo_materia1")
	private String codigo1;
	
	@Column(name ="matri_codigo_materia2")
	private String codigo2;
	
	@Column(name ="matri_codigo_materia3")
	private String codigo3;
	
	@Column(name ="matri_codigo_materia4")
	private String codigo4;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "matri_id_estudiante")
	private Estudiante estudiante;
	
	@ManyToOne
	@JoinColumn(name = "matri_id_materia")
	private Materia materia;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFechaMatricula() {
		return fecha;
	}

	public void setFechaMatricula(LocalDateTime fechaMatricula) {
		this.fecha = fechaMatricula;
	}

	public String getNombreHilo() {
		return nombreHilo;
	}

	public void setNombreHilo(String nombreHilo) {
		this.nombreHilo = nombreHilo;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public String getCodigo1() {
		return codigo1;
	}

	public void setCodigo1(String codigo1) {
		this.codigo1 = codigo1;
	}

	public String getCodigo2() {
		return codigo2;
	}

	public void setCodigo2(String codigo2) {
		this.codigo2 = codigo2;
	}

	public String getCodigo3() {
		return codigo3;
	}

	public void setCodigo3(String codigo3) {
		this.codigo3 = codigo3;
	}

	public String getCodigo4() {
		return codigo4;
	}

	public void setCodigo4(String codigo4) {
		this.codigo4 = codigo4;
	}

	@Override
	public String toString() {
		return "Matricula [id=" + id + ", fechaMatricula=" + fecha + ", nombreHilo=" + nombreHilo
				+ ", codigo1=" + codigo1 + ", codigo2=" + codigo2 + ", codigo3=" + codigo3 + ", codigo4=" + codigo4
				+ ", estudiante=" + estudiante + ", materia=" + materia + "]";
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
}
