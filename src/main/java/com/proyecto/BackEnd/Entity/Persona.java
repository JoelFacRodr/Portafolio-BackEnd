package com.proyecto.BackEnd.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;    
    @NotNull
    @Size(min = 1, max = 50, message= "No cumple con la longitud.")
    private String nombre;
    @NotNull
    @Size(min = 1, max = 50, message= "No cumple con la longitud.")
    private String apellido;
    @NotNull
    @Size(min = 1, max = 50, message= "No cumple con la longitud.")
    private String perfil;
             
    @NotNull
    private String informacion;
    
    private String img;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String informacion, String img, String perfil){
        this.nombre = nombre;
        this.apellido = apellido;
        this.perfil = perfil;
        this.informacion = informacion;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
    
}
