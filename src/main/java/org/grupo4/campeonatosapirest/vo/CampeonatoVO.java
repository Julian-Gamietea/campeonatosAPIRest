package org.grupo4.campeonatosapirest.vo;

import org.grupocuatro.modelo.Campeonato;

import java.io.Serializable;
import java.time.LocalDate;

public class CampeonatoVO implements Serializable {
    private static final long serialVersionUID = -896702539183504958L;
    private Integer idCampeonato;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;
    private String tipoCampeonato;

    public CampeonatoVO () {

    }
    public CampeonatoVO (String descripcion, LocalDate fechaInicio, LocalDate fechaFin, String estado) {
        this.idCampeonato = null;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.tipoCampeonato = "";
    }

    public Integer getIdCampeonato() {
        return idCampeonato;
    }

    public void setIdCampeonato(Integer idCampeonato) {
        this.idCampeonato = idCampeonato;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoCampeonato() {
        return tipoCampeonato;
    }

    public void setTipoCampeonato(String tipoCampeonato) {
        this.tipoCampeonato = tipoCampeonato;
    }

    public Campeonato toModelo(){
        return null;
    }

}
