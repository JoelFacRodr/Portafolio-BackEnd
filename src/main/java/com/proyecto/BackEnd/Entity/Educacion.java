/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.BackEnd.Entity;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;
    private String descripcionE;
    private Date periodoI;
    private Date periodoF;

    public Educacion() {
    }

    public Educacion(String nombreE, String descripcionE,Date periodoI, Date periodoF) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.periodoI = periodoI;
        this.periodoF = periodoF;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
