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

import com.ArgenProg.ProyectoLibreria.models.Libro;
import com.ArgenProg.ProyectoLibreria.service.LibroServiceImpl;

@RestController
@RequestMapping("/libros")
public class LibroController {

	@Autowired
	private LibroServiceImpl libroService;

	@PostMapping("/create")
	public ResponseEntity<String> createLibro(@RequestBody Libro libro) {
		try {
			libroService.saveLibro(libro);
			return new ResponseEntity<>("Libro agregado!", HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/update")
	public ResponseEntity<Libro> updateLibro(@RequestBody Libro libro) {
		try {
			libroService.updateLibro(libro);
			Libro libroUpdated = libroService.getLibroById(libro.getIdLibro());

			if (libroUpdated != null) {
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
	public ResponseEntity<List<Libro>> getAllLibros() {
		List<Libro> allLibros = libroService.getAllLibros();

		if (!allLibros.isEmpty()) {
			return new ResponseEntity<>(allLibros, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

	@DeleteMapping("/delete/{idLibro}")
	public ResponseEntity<String> deleteLibro(@PathVariable("idLibro") Integer idLibro) {
		try {
			Libro libro = libroService.getLibroById(idLibro);

			if (libro != null) {
				libroService.deleteLibro(idLibro);
				return new ResponseEntity<>("Libro borrado!", HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
