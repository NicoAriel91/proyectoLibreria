package com.ArgenProg.ProyectoLibreria.service;

import java.util.List;

import com.ArgenProg.ProyectoLibreria.models.Autor;

public interface IAutorService {

	public void saveAutor(Autor autor);

	public List<Autor> getAllAutores();

	public Autor getAutorById(Integer idAutor);

	public void updateAutor(Autor autor);

	public void deleteAutor(Integer idAutor);

}
