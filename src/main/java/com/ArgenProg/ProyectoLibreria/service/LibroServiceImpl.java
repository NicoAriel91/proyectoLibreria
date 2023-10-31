package com.ArgenProg.ProyectoLibreria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ArgenProg.ProyectoLibreria.models.Libro;
import com.ArgenProg.ProyectoLibreria.repository.ILibroRepository;

@Service
public class LibroServiceImpl implements ILibroService {

	@Autowired
	private ILibroRepository libroRepository;

	@Override
	public void saveLibro(Libro libro) {
		libroRepository.save(libro);
	}

	@Override
	public List<Libro> getAllLibros() {
		List<Libro> allLibros = libroRepository.findAll();
		return allLibros;
	}

	@Override
	public Libro getLibroById(Integer idLibro) {
		Libro libro = libroRepository.findById(idLibro).orElse(null);
		return libro;
	}

	@Override
	public void updateLibro(Libro libro) {
		this.saveLibro(libro);

	}

	@Override
	public void deleteLibro(Integer idLibro) {
		libroRepository.deleteById(idLibro);

	}

}
