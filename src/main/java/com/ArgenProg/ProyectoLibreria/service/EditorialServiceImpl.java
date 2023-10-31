package com.ArgenProg.ProyectoLibreria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ArgenProg.ProyectoLibreria.models.Editorial;
import com.ArgenProg.ProyectoLibreria.repository.IEditorialRepository;

@Service
public class EditorialServiceImpl implements IEditorialService {

	@Autowired
	private IEditorialRepository editorialRepository;

	@Override
	public void saveEditorial(Editorial editorial) {
		editorialRepository.save(editorial);

	}

	@Override
	public List<Editorial> getAllEditoriales() {
		List<Editorial> allEditoriales = editorialRepository.findAll();
		return allEditoriales;
	}

	@Override
	public Editorial getEditorialById(Integer idEditorial) {
		Editorial editorial = editorialRepository.findById(idEditorial).orElse(null);
		return editorial;
	}

	@Override
	public void updateEditorial(Editorial editorial) {
		this.saveEditorial(editorial);

	}

	@Override
	public void deleteEditorial(Integer idEditorial) {
		editorialRepository.deleteById(idEditorial);

	}

}
