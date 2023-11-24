package com.uca.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Comentario")

//Verificar la generacion de los getters y setters, lombok
@Getter
@Setter

public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idComentario")
	Integer idComentario;
	
	@Column(name="mensaje")
	String mensaje;
	
	@Column(name="idEstudiante")
	Integer idEstudiante;

	public Integer getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(Integer idComentario) {
		this.idComentario = idComentario;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Integer getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(Integer idEstudiante) {
		this.idEstudiante = idEstudiante;
	}



	

}
