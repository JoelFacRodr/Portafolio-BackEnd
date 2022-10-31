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
public class dtoBanner {
    @NotBlank
    private String img;   

    public dtoBanner() {
    }

    public dtoBanner(String img) {
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
}
