/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.BackEnd.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreSkill;
    private Number porcSkill;

    public Skills() {
    }

    public Skills(String nombreSkill, Number porcSkill) {
        this.nombreSkill = nombreSkill;
        this.porcSkill = porcSkill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
