/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.BackEnd.Controller;

import com.proyecto.BackEnd.Dto.dtoBanner;
import com.proyecto.BackEnd.Entity.Banner;
import com.proyecto.BackEnd.Security.Controller.Mensaje;
import com.proyecto.BackEnd.Service.SBanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("banner")
@CrossOrigin(origins = {"http://localhost:4200/","https://frontendproyec.web.app/"})
public class CBanner {
    @Autowired SBanner sBanner;
    
   @GetMapping("/lista")
    public ResponseEntity<List<Banner>> list(){
    List<Banner> list = sBanner.list();
    return new ResponseEntity(list, HttpStatus.OK);
    } 
    
   @GetMapping("/detail/{id}")
    public ResponseEntity<Banner> getById(@PathVariable("id") int id ){
    if(!sBanner.existsById(id)){
        return new ResponseEntity(new Mensaje("Id no existe"),HttpStatus.NOT_FOUND);
    }
    Banner banner = sBanner.getOne(id).get();    
    return new ResponseEntity(banner, HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoBanner dtobanner){
    if(!sBanner.existsById(id)){
    return new ResponseEntity(new Mensaje("No existe el id"),HttpStatus.NOT_FOUND);
    }
    
    Banner banner = sBanner.getOne(id).get();
    banner.setImg(dtobanner.getImg());
    
    sBanner.save(banner);
    
    return new ResponseEntity(new Mensaje("Se actualizo el banner"),HttpStatus.OK);

    }
   
}
