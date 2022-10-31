/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.BackEnd.Controller;

import com.proyecto.BackEnd.Dto.dtoSkill;
import com.proyecto.BackEnd.Entity.Skills;
import com.proyecto.BackEnd.Security.Controller.Mensaje;
import com.proyecto.BackEnd.Service.SSkills;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("skill")
@CrossOrigin(origins = {"http://localhost:4200/", "https://frontendproyec.web.app/"})
public class CSkill {
    @Autowired
    SSkills sSkills;
    
 @GetMapping("/lista")
 public ResponseEntity<List<Skills>> list(){
 List<Skills> list = sSkills.list();
 return new ResponseEntity(list, HttpStatus.OK);
 }
 
 @PostMapping("/create")
 public ResponseEntity<?> create(@RequestBody dtoSkill dtoskill){
 if(StringUtils.isBlank(dtoskill.getNombreSkill()))
    return new ResponseEntity(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
 if(sSkills.existsByNombreSkill(dtoskill.getNombreSkill()))
     return new ResponseEntity(new Mensaje("Estas skill ya existe"),HttpStatus.BAD_REQUEST);
 Skills skills = new Skills(dtoskill.getNombreSkill(), dtoskill.getPorcSkill());
 sSkills.save(skills); 
 return new ResponseEntity(new Mensaje("Skill Agregada"), HttpStatus.OK);
 }
 @PutMapping("/update/{id}")
 public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkill dtoskill){
 if(!sSkills.existsById(id))
    return new ResponseEntity(new Mensaje("Id no existe"),HttpStatus.NOT_FOUND); 
 if(sSkills.existsByNombreSkill(dtoskill.getNombreSkill()) && sSkills.getByNombreSkill(dtoskill.getNombreSkill()).get().getId() != id)
     return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
 if(StringUtils.isBlank(dtoskill.getNombreSkill()))
   return new ResponseEntity(new Mensaje("El Nombre es obligatorio"),HttpStatus.BAD_REQUEST);
 Skills skills = sSkills.getOne(id).get();
 skills.setNombreSkill(dtoskill.getNombreSkill());
 skills.setPorcSkill(dtoskill.getPorcSkill());
 sSkills.save(skills); 
   return new ResponseEntity(new Mensaje("Experiencia actualizada"),HttpStatus.OK); 
 }
 
 @DeleteMapping("/delete/{id}")
 public ResponseEntity<?> delete(@PathVariable("id") int id){
    if(!sSkills.existsById(id))
    return new ResponseEntity(new Mensaje("Id no existe"),HttpStatus.NOT_FOUND);
    sSkills.delete(id);
     return new ResponseEntity(new Mensaje("Experiencia Eliminada"), HttpStatus.OK);
      }

@GetMapping("/detail/{id}")
public ResponseEntity<Skills> getById(@PathVariable("id") int id){
if(!sSkills.existsById(id))
    return new ResponseEntity(new Mensaje("Id no existe"),HttpStatus.NOT_FOUND);
Skills skills = sSkills.getOne(id).get();
return new ResponseEntity(skills, HttpStatus.OK);
}

}
