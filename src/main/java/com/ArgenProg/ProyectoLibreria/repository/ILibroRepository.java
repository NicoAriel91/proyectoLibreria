package com.ArgenProg.ProyectoLibreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ArgenProg.ProyectoLibreria.models.Libro;

public interface ILibroRepository extends JpaRepository<Libro, Integer> {

}
