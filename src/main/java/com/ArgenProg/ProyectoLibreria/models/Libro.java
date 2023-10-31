package com.ArgenProg.ProyectoLibreria.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idLibro;
	private Integer isbn;
	private String titulo;
	private Integer anio;
	private Integer ejemplares;
	private Integer ejemplaresPrestados;
	private Integer ejemplaresRestantes;
	private Boolean altaLibro;
	

	public Libro(Integer isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados,
			Integer ejemplaresRestantes, Boolean altaLibro) {
		
		this.isbn = isbn;
		this.titulo = titulo;
		this.anio = anio;
		this.ejemplares = ejemplares;
		this.ejemplaresPrestados = ejemplaresPrestados;
		this.ejemplaresRestantes = ejemplaresRestantes;
		this.altaLibro = altaLibro;
	}

	@OneToOne
	@JoinColumn(name = "nombreAutor")
	private Autor autor;
	
	@OneToOne
	@JoinColumn(name = "nombreEditorial")
	Editorial editorial;
}
