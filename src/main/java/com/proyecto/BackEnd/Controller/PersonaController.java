
package com.proyecto.BackEnd.Controller;

import com.proyecto.BackEnd.Dto.dtoPersona;
import com.proyecto.BackEnd.Entity.Persona;
import com.proyecto.BackEnd.Security.Controller.Mensaje;
import com.proyecto.BackEnd.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("personas")
@CrossOrigin(origins = {"http://localhost:4200/","https://frontendproyec.web.app/"})
public class PersonaController {
   @Autowired
    ImpPersonaService PersonaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
    List<Persona> list = PersonaService.list();
    return new ResponseEntity(list, HttpStatus.OK);
    }
   /* @DeleteMapping("/delete/{id}")    
    public ResponseEntity<?> delete(@PathVariable("id")int id){
    if(!PersonaService.existsById(id)){
    return new ResponseEntity(new Mensaje("No existe el id"), HttpStatus.NOT_FOUND);
    }    
    PersonaService.delete(id);    
    return new ResponseEntity(new Mensaje("Se borro correctamente la educacion"), HttpStatus.OK);
        
    }*/
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id ){
    if(!PersonaService.existsById(id)){
        return new ResponseEntity(new Mensaje("Id no existe"),HttpStatus.NOT_FOUND);
    }
    Persona persona = PersonaService.getOne(id).get();    
    return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    /*@PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeducacion){
    if(StringUtils.isBlank(dtoeducacion.getNombreE())){
     return new ResponseEntity(new Mensaje("El nombre es Obligatorio"),HttpStatus.BAD_REQUEST);
    }
    if(sEducacion.existsByNombreE(dtoeducacion.getNombreE())){
    return new ResponseEntity(new Mensaje("Ese nombre ya existe"),HttpStatus.BAD_REQUEST);
    }
    Educacion educacion = new Educacion(dtoeducacion.getNombreE(), dtoeducacion.getDescripcionE(), dtoeducacion.getPeriodoF(),dtoeducacion.getPeriodoI());
    sEducacion.save(educacion);
    
    return new ResponseEntity(new Mensaje("Se creo correctamente la educacion"),HttpStatus.OK);
    }*/
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona){
    if(!PersonaService.existsById(id)){
    return new ResponseEntity(new Mensaje("No existe el id"),HttpStatus.NOT_FOUND);
    }
    if(PersonaService.existsByNombre(dtopersona.getNombre()) && PersonaService.getByNombre(dtopersona.getNombre()).get().getId() != id){
        return new ResponseEntity(new Mensaje("Ese nombre ya existe"),HttpStatus.BAD_REQUEST);
    }
    if(StringUtils.isBlank(dtopersona.getNombre())){
    return new ResponseEntity(new Mensaje("El campo esta vacio"),HttpStatus.BAD_REQUEST);

    }
    
    Persona persona = PersonaService.getOne(id).get();
    persona.setNombre(dtopersona.getNombre());
    persona.setApellido(dtopersona.getApellido());
    persona.setInformacion(dtopersona.getInformacion());
    persona.setImg(dtopersona.getImg());
    persona.setPerfil(dtopersona.getPerfil());
    
    PersonaService.save(persona);
    
    return new ResponseEntity(new Mensaje("Se actualizo la persona"),HttpStatus.OK);

    }
   
    
}
