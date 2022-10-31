/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.BackEnd.Controller;

import com.proyecto.BackEnd.Dto.dtoProyecto;
import com.proyecto.BackEnd.Entity.Proyecto;
import com.proyecto.BackEnd.Security.Controller.Mensaje;
import com.proyecto.BackEnd.Service.SProyecto;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("proyecto")
@CrossOrigin(origins = {"http://localhost:4200/", "https://frontendproyec.web.app/"})
public class CProyecto {
    
    @Autowired    
    SProyecto sProyecto;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list = sProyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtoPro){
      if(StringUtils.isBlank(dtoPro.getNombreP()))
          return new ResponseEntity(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
      if(sProyecto.existsByNombreP(dtoPro.getNombreP()))
          return new ResponseEntity(new Mensaje("El proyecto ya existe"),HttpStatus.BAD_REQUEST);
      Proyecto proyecto = new Proyecto(dtoPro.getNombreP(), dtoPro.getDescriptionP(), dtoPro.getPeriodoF(), dtoPro.getPeriodoI(), dtoPro.getLink());
      sProyecto.save(proyecto);      
      return new ResponseEntity(new Mensaje("Proyecto Agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyecto dtoPro){
    if(!sProyecto.existsById(id))
        return new ResponseEntity(new Mensaje("Id no existe"),HttpStatus.NOT_FOUND);
    if(sProyecto.existsByNombreP(dtoPro.getNombreP()) && sProyecto.getByNombreP(dtoPro.getNombreP()).get().getId() != id)
        return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
    if(StringUtils.isBlank(dtoPro.getNombreP()))
        return new ResponseEntity(new Mensaje("El Nombre es obligatorio"),HttpStatus.BAD_REQUEST);
    Proyecto proyecto = sProyecto.getOne(id).get();
    proyecto.setNombreP(dtoPro.getNombreP());
    proyecto.setDescriptionP(dtoPro.getDescriptionP());
    proyecto.setPeriodoF(dtoPro.getPeriodoF());
    proyecto.setPeriodoI(dtoPro.getPeriodoI());
    proyecto.setLink(dtoPro.getLink());
    
    sProyecto.save(proyecto);
    
    return new ResponseEntity(new Mensaje("Experiencia actualizada"),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}") 
    public ResponseEntity<?> delete(@PathVariable("id") int id){
     if(!sProyecto.existsById(id))
        return new ResponseEntity(new Mensaje("Id no existe"),HttpStatus.BAD_REQUEST);
     sProyecto.delete(id);
     return new ResponseEntity(new Mensaje("Proyecto Eliminado"), HttpStatus.OK);
    }
        @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
        if(!sProyecto.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyecto proyecto = sProyecto.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
}
