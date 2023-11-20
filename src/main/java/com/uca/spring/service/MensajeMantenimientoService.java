package com.uca.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.spring.model.MensajeMantenimiento;
import com.uca.spring.repository.MensajeMantenimientoRepository;

@Service
public class MensajeMantenimientoService {

    @Autowired
    private MensajeMantenimientoRepository mMR;

    //Para iniciar el primer registro:
    public MensajeMantenimiento createMensajeMantenimiento(MensajeMantenimiento m) {
		return mMR.save(m);
	}

    public MensajeMantenimiento getMensajeMantenimientoById(int id){
        return mMR.findById(id).orElse(null);
    }

    
    
}
