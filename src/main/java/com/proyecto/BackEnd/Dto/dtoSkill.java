/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.BackEnd.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Facu
 */
public class dtoSkill {
    @NotBlank
    private String nombreSkill;
    @NotBlank
    private Number porcSkill;

    public dtoSkill() {
    }

    public dtoSkill(String nombreSkill, Number porcSkill) {
        this.nombreSkill = nombreSkill;
        this.porcSkill = porcSkill;
    }

    public String getNombreSkill() {
        return nombreSkill;
    }

    public void setNombreSkill(String nombreSkill) {
        this.nombreSkill = nombreSkill;
    }

    public Number getPorcSkill() {
        return porcSkill;
    }

    public void setPorcSkill(Number porcSkill) {
        this.porcSkill = porcSkill;
    }
    
    
    
}
