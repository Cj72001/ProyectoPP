package com.uca.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.spring.model.Carrera;


public interface CarreraRepository extends JpaRepository<Carrera, Integer> {
	
}
