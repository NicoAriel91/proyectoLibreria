package com.ArgenProg.ProyectoLibreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ArgenProg.ProyectoLibreria.models.Autor;

@Repository
public interface IAutorRepository extends JpaRepository<Autor, Integer> {

}
