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
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreP;
    private String descriptionP;
    private String link;
    private Date periodoI;
    private Date periodoF;

    public Proyecto() {
    }

    public Proyecto(String nombreP, String descriptionP, Date periodoI, Date periodoF, String link) {
        this.nombreP = nombreP;
        this.descriptionP = descriptionP;
        this.periodoF = periodoF;
        this.periodoI = periodoI;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    
}
