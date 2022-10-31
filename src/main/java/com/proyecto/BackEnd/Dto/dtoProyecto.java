/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.BackEnd.Dto;

import java.sql.Date;
import javax.validation.constraints.NotBlank;


public class dtoProyecto {
    @NotBlank
    private String nombreP;
    @NotBlank
    private String descriptionP;
    @NotBlank
    private Date periodoF;
    @NotBlank
    private Date periodoI;
    @NotBlank
    private String link;

    public dtoProyecto() {
    }

    public dtoProyecto(String nombreP, String descriptionP, Date periodoI, Date periodoF, String link) {
        this.nombreP = nombreP;
        this.descriptionP = descriptionP;
        this.periodoF = periodoF;
        this.periodoI = periodoI;
        this.link = link;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getDescriptionP() {
        return descriptionP;
    }

    public void setDescriptionP(String descriptionP) {
        this.descriptionP = descriptionP;
    }

    public Date getPeriodoF() {
        return periodoF;
    }

    public void setPeriodoF(Date periodoF) {
        this.periodoF = periodoF;
    }

    public Date getPeriodoI() {
        return periodoI;
    }

    public void setPeriodoI(Date periodoI) {
        this.periodoI = periodoI;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    
}
