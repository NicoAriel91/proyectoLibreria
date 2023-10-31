package com.ArgenProg.ProyectoLibreria.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAutor;
	private String nombreAutor;
	private Boolean altaAutor;
	
	
	public Autor(String nombreAutor, Boolean altaAutor) {
		
		this.nombreAutor = nombreAutor;
		this.altaAutor = altaAutor;
	}
	
	

}
