package com.ArgenProg.ProyectoLibreria.service;

import java.util.List;

import com.ArgenProg.ProyectoLibreria.models.Editorial;

public interface IEditorialService {

	public void saveEditorial(Editorial editorial);

	public List<Editorial> getAllEditoriales();

	public Editorial getEditorialById(Integer idEditorial);

	public void updateEditorial(Editorial editorial);

	public void deleteEditorial(Integer idEditorial);

}
