/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.BackEnd.Service;

import com.proyecto.BackEnd.Entity.Skills;
import com.proyecto.BackEnd.Repository.RSkills;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SSkills {
    @Autowired
    RSkills rSkills;
    
    public List<Skills> list(){
    return rSkills.findAll();
    }
    
     public Optional<Skills> getOne(int id){
        return rSkills.findById(id);
    }
    
    public Optional<Skills> getByNombreSkill(String nombreSkill){
        return rSkills.findByNombreSkill(nombreSkill);
    }
    
    public void save(Skills expe){
    rSkills.save(expe);
    }
    
    public void delete(int id){
    rSkills.deleteById(id);
    }
    
    public boolean existsById(int id){
     return rSkills.existsById(id);
    }
    
    public boolean existsByNombreSkill(String nombreSkill){
    return rSkills.existsByNombreSkill(nombreSkill);
    }
    
}
