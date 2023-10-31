package com.ArgenProg.ProyectoLibreria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ArgenProg.ProyectoLibreria.models.Autor;
import com.ArgenProg.ProyectoLibreria.service.AutorServiceImpl;

@RestController
@RequestMapping("/autores")
public class AutorController {

	@Autowired
	private AutorServiceImpl autorService;

	@PostMapping("/create")
	public ResponseEntity<String> createAutor(@RequestBody Autor autor) {

		try {
			autorService.saveAutor(autor);
			return new ResponseEntity<>("Autor agregado!", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/update")
	public ResponseEntity<Autor> updateAutor(@RequestBody Autor autor) {
		try {
			Autor autorUpdated = autorService.getAutorById(autor.getIdAutor());
			if (autorUpdated != null) {
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("")
	public ResponseEntity<List<Autor>> getAllAutores() {
		List<Autor> allAutores = autorService.getAllAutores();

		if (!allAutores.isEmpty()) {
			return new ResponseEntity<>(allAutores, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

	@DeleteMapping("/delete/{idAutor}")
	public ResponseEntity<String> deleteAutor(@PathVariable("idAutor") Integer idAutor) {
		try {
			Autor autor = autorService.getAutorById(idAutor);

			if (autor != null) {
				autorService.deleteAutor(idAutor);
				return new ResponseEntity<>("Autor eliminado!", HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
