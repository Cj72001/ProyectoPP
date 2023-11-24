package com.uca.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.uca.spring.model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer>{
	
	
}
