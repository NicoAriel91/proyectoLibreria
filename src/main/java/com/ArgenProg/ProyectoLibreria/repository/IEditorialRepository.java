package com.ArgenProg.ProyectoLibreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ArgenProg.ProyectoLibreria.models.Editorial;

@Repository
public interface IEditorialRepository extends JpaRepository<Editorial, Integer> {

}
