package com.ArgenProg.ProyectoLibreria.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ArgenProg.ProyectoLibreria.models.Autor;
import com.ArgenProg.ProyectoLibreria.repository.IAutorRepository;

@DataJpaTest
public class AutorRepositoryTest {
	
	@Autowired
	private IAutorRepository autorRepository;
	private Autor autor;
	
	@BeforeEach
	void setup() {
		autor = new Autor("nombre", true);
	}

	@DisplayName("Test para crear un autor")
	@Test
	void testSaveAutor() {

		Autor autorBD = autorRepository.save(autor);

		assertThat(autorBD).isNotNull();
		assertThat(autorBD.getIdAutor()).isGreaterThan(0);
	}

	@DisplayName("Test para listar todos los autores")
	@Test
	void testListAllAutores() {
		Autor autor2 = new Autor("nombre2",true);
		autorRepository.save(autor);
		autorRepository.save(autor2);

		List<Autor> allAutorBD = autorRepository.findAll();

		assertThat(allAutorBD).isNotNull();
		assertThat(allAutorBD.size()).isEqualTo(2);
	}

	@DisplayName("Test para obtener un autor por ID")
	@Test
	void testGetAutorById() {

		autorRepository.save(autor);

		Autor autorBD = autorRepository.findById(autor.getIdAutor()).get();

		assertThat(autorBD).isNotNull();

	}

	@DisplayName("Test para actualizar un autor")
	@Test
	void testUpdateAutor() {

		autorRepository.save(autor);

		Autor autorBD = autorRepository.findById(autor.getIdAutor()).get();

		autorBD.setNombreAutor("Nombre Cambiado");

		Autor autorUpdate = autorRepository.save(autorBD);

		assertThat(autorUpdate.getNombreAutor()).isEqualTo("Nombre Cambiado");

	}

	@DisplayName("Test para borrar un autor")
	@Test
	void testDeleteAutor() {
		
		autorRepository.save(autor);
		
		autorRepository.deleteById(autor.getIdAutor());
		
		Optional<Autor> autorDeleted = autorRepository.findById(autor.getIdAutor());
		
		assertThat(autorDeleted).isEmpty();

	}

}
