package com.uca.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.spring.model.Comentario;
import com.uca.spring.repository.ComentarioRepository;

@Service
public class ComentarioService {

	@Autowired
	private ComentarioRepository comentarioRepository;
	
	public Comentario createComentario(Comentario mensaje) {
		return comentarioRepository.save(mensaje);
	}
}


