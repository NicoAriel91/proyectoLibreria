package com.ArgenProg.ProyectoLibreria.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ArgenProg.ProyectoLibreria.models.Libro;
import com.ArgenProg.ProyectoLibreria.repository.ILibroRepository;

@DataJpaTest
public class LibroRepositoryTest {

	@Autowired
	private ILibroRepository libroRepository;
	private Libro libro;

	@BeforeEach
	void setup() {
		libro = new Libro(12345678,"Titulo",1900,10,4,6,true);
	}

	@DisplayName("Test para crear un libro")
	@Test
	void testSaveLibro() {

		Libro libroBD = libroRepository.save(libro);

		assertThat(libroBD).isNotNull();
		assertThat(libroBD.getIdLibro()).isGreaterThan(0);
	}

	@DisplayName("Test para listar todos los libros")
	@Test
	void testListAllLibros() {
		Libro libro2 = new Libro(87654321,"Titulo2",1950,15,10,5,true);
		libroRepository.save(libro);
		libroRepository.save(libro2);

		List<Libro> allLibroBD = libroRepository.findAll();

		assertThat(allLibroBD).isNotNull();
		assertThat(allLibroBD.size()).isEqualTo(2);
	}

	@DisplayName("Test para obtener un libro por ID")
	@Test
	void testGetLibroById() {

		libroRepository.save(libro);

		Libro libroBD = libroRepository.findById(libro.getIdLibro()).get();

		assertThat(libroBD).isNotNull();

	}

	@DisplayName("Test para actualizar un libro")
	@Test
	void testUpdateLibro() {

		libroRepository.save(libro);

		Libro libroBD = libroRepository.findById(libro.getIdLibro()).get();

		libroBD.setTitulo("Nombre Cambiado");
		libroBD.setAnio(1901);
		libroBD.setAltaLibro(false);

		Libro libroUpdate = libroRepository.save(libroBD);

		assertThat(libroUpdate.getTitulo()).isEqualTo("Nombre Cambiado");
		assertThat(libroUpdate.getAnio()).isEqualTo(1901);
		assertThat(libroUpdate.getAltaLibro()).isEqualTo(false);

	}

	@DisplayName("Test para borrar un libro")
	@Test
	void testDeleteLibro() {
		
		libroRepository.save(libro);
		
		libroRepository.deleteById(libro.getIdLibro());
		
		Optional<Libro> libroDeleted = libroRepository.findById(libro.getIdLibro());
		
		assertThat(libroDeleted).isEmpty();

	}

}
