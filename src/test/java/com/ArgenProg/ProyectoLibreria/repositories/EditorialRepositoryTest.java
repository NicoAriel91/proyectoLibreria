package com.ArgenProg.ProyectoLibreria.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ArgenProg.ProyectoLibreria.models.Editorial;
import com.ArgenProg.ProyectoLibreria.repository.IEditorialRepository;

@DataJpaTest
public class EditorialRepositoryTest {
	
	@Autowired
	private IEditorialRepository editorialRepository;
	private Editorial editorial;
	
	@BeforeEach
	void setup() {
		editorial = new Editorial(1,"nombre", true);
	}

	@DisplayName("Test para crear una editorial")
	@Test
	void testSaveEditorial() {

		Editorial editorialBD = editorialRepository.save(editorial);

		assertThat(editorialBD).isNotNull();
		assertThat(editorialBD.getIdEditorial()).isGreaterThan(0);
	}

	@DisplayName("Test para listar todos las editoriales")
	@Test
	void testListAllEditoriales() {
		Editorial editorial2 = new Editorial(2,"nombre2",true);
		editorialRepository.save(editorial);
		editorialRepository.save(editorial2);

		List<Editorial> allEditorialBD = editorialRepository.findAll();

		assertThat(allEditorialBD).isNotNull();
		assertThat(allEditorialBD.size()).isEqualTo(2);
	}

	@DisplayName("Test para obtener una editorial por ID")
	@Test
	void testGetEditorialById() {

		editorialRepository.save(editorial);

		Editorial editorialBD = editorialRepository.findById(editorial.getIdEditorial()).get();

		assertThat(editorialBD).isNotNull();

	}

	@DisplayName("Test para actualizar una editorial")
	@Test
	void testUpdateEditorial() {

		editorialRepository.save(editorial);

		Editorial editorialBD = editorialRepository.findById(editorial.getIdEditorial()).get();

		editorialBD.setNombreEditorial("Nombre Cambiado");

		Editorial editorialUpdate = editorialRepository.save(editorialBD);

		assertThat(editorialUpdate.getNombreEditorial()).isEqualTo("Nombre Cambiado");

	}

	@DisplayName("Test para borrar una editorial")
	@Test
	void testDeleteEditorial() {
		
		editorialRepository.save(editorial);
		
		editorialRepository.deleteById(editorial.getIdEditorial());
		
		Optional<Editorial> editorialDeleted = editorialRepository.findById(editorial.getIdEditorial());
		
		assertThat(editorialDeleted).isEmpty();

	}

}
