package com.ArgenProg.ProyectoLibreria.service;

import java.util.List;

import com.ArgenProg.ProyectoLibreria.models.Libro;

public interface ILibroService {

	public void saveLibro(Libro libro);

	public List<Libro> getAllLibros();

	public Libro getLibroById(Integer id);

	public void updateLibro(Libro libro);

	public void deleteLibro(Integer id);

}
