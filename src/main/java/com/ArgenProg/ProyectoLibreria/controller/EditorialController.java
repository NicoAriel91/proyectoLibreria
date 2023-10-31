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

import com.ArgenProg.ProyectoLibreria.models.Editorial;
import com.ArgenProg.ProyectoLibreria.service.EditorialServiceImpl;

@RestController
@RequestMapping("/editoriales")
public class EditorialController {

	@Autowired
	private EditorialServiceImpl editorialService;

	@PostMapping("/create")
	public ResponseEntity<String> createEditorial(@RequestBody Editorial editorial) {

		try {
			editorialService.saveEditorial(editorial);
			return new ResponseEntity<>("Editorial agregada!", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/update")
	public ResponseEntity<Editorial> updateEditorial(@RequestBody Editorial editorial) {

		try {
			Editorial editorialUpdated = editorialService.getEditorialById(editorial.getIdEditorial());
			if (editorialUpdated != null) {
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
	public ResponseEntity<List<Editorial>> getAllEditoriales() {
		List<Editorial> allEditoriales = editorialService.getAllEditoriales();

		if (!allEditoriales.isEmpty()) {
			return new ResponseEntity<>(allEditoriales, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

	@DeleteMapping("delete/{idEditorial}")
	public ResponseEntity<String> deleteEditorial(@PathVariable("idEditorial") Integer idEditorial) {

		try {
			Editorial editorial = editorialService.getEditorialById(idEditorial);

			if (editorial != null) {
				editorialService.deleteEditorial(idEditorial);
				return new ResponseEntity<>("Editorial eliminada!", HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
