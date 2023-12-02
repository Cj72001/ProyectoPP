package com.uca.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mensaje_mantenimiento")

//Verificar la generacion de los getters y setters, lombok

public class MensajeMantenimiento {

    @Id
	@Column(name="id_mensaje")
	Integer idMensaje;

    @Column(name="mensaje_activo")
	Boolean mensajeActivo;

    @Column(name="dia_inicio")
	String diaInicio;

    @Column(name="hora_inicio")
	String horaInicio;

    @Column(name="dia_fin")
	String diaFin;

    @Column(name="hora_fin")
	String horaFin;


    public Boolean getMensajeActivo() {
        return mensajeActivo;
    }

    public Integer getIdMensaje() {
        return idMensaje;
    }

    public String getDiaInicio() {
        return diaInicio;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getDiaFin() {
        return diaFin;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setMensajeActivo(Boolean mensajeActivo) {
        this.mensajeActivo = mensajeActivo;
    }

    public void setIdMensaje(Integer idMensaje) {
        this.idMensaje = idMensaje;
    }

    public void setDiaInicio(String diaInicio) {
        this.diaInicio = diaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setDiaFin(String diaFin) {
        this.diaFin = diaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    

    

    

    

    





    
}
