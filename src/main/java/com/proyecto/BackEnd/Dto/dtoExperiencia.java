/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.BackEnd.Dto;

import java.sql.Date;
import javax.validation.constraints.NotBlank;


public class dtoExperiencia {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    @NotBlank
    private String tituloP;
    @NotBlank
    private Date periodoI;
  
    private Date periodoF;
    

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String descripcionE, String tituloP, Date periodoI, Date periodoF) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.periodoI = periodoI;
        this.periodoF = periodoF;
        this.tituloP = tituloP;
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

    public String getTituloP() {
        return tituloP;
    }

    public void setTituloP(String tituloP) {
        this.tituloP = tituloP;
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
