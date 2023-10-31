package com.ArgenProg.ProyectoLibreria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ArgenProg.ProyectoLibreria.models.Autor;
import com.ArgenProg.ProyectoLibreria.repository.IAutorRepository;

@Service
public class AutorServiceImpl implements IAutorService {

	@Autowired
	private IAutorRepository autorRepository;

	@Override
	public void saveAutor(Autor autor) {
		autorRepository.save(autor);

	}

	@Override
	public List<Autor> getAllAutores() {
		List<Autor> allAutores = autorRepository.findAll();
		return allAutores;
	}

	@Override
	public Autor getAutorById(Integer idAutor) {
		Autor autor = autorRepository.findById(idAutor).orElse(null);
		return autor;
	}

	@Override
	public void updateAutor(Autor autor) {
		this.saveAutor(autor);
	}

	@Override
	public void deleteAutor(Integer idAutor) {
		autorRepository.deleteById(idAutor);

	}

}
