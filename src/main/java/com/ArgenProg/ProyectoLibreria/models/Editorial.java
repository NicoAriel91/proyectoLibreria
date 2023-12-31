package com.ArgenProg.ProyectoLibreria.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Editorial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEditorial;
	private String nombreEditorial;
	private Boolean altaEditorial;
	

}
