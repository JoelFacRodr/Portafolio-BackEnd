/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.BackEnd.Dto;

import java.sql.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;


public class dtoEducacion {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    @NotBlank
    @Temporal(TemporalType.DATE)
    private Date periodoI;
    @NotBlank
    @Temporal(TemporalType.DATE)
    private Date periodoF;

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreE, String descripcionE,Date periodoI, Date periodoF) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.periodoF = periodoF;
        this.periodoI = periodoI;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public Date getPeriodoI() {
        return periodoI;
    }

    public void setPeriodoI(Date periodoI) {
        this.periodoI = periodoI;
    }

    public Date getPeriodoF() {
        return periodoF;
    }

    public void setPeriodoF(Date periodoF) {
        this.periodoF = periodoF;
    }
    
    
}
