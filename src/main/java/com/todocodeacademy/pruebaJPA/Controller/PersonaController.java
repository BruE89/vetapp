package com.todocodeacademy.pruebaJPA.Controller;

import com.todocodeacademy.pruebaJPA.model.Persona;
import com.todocodeacademy.pruebaJPA.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    
    @Autowired
    private IPersonaService Ipersona;
    
    @GetMapping ("/personas/traer")
    public List<Persona> getPersonas(){
        
        return Ipersona.getPersonas();
    }
    
    @PostMapping ("/personas/crear")
    public String savePersona(@RequestBody Persona perso){
        
        Ipersona.savePersona(perso);
        
        return "Persona creada correctamente";
    }
    
    @DeleteMapping ("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        
        Ipersona.deletePersona(id);
        
        return "Persona borrada correctamente";
        
    }
    
    @PutMapping ("/personas/modificar/{id_original}")
    public Persona editPersona(@PathVariable Long id_original, 
            @RequestParam(required = false, name = "nombre") String nuevoNombre,
            @RequestParam(required = false, name = "apellido") String nuevoApellido,
            @RequestParam(required = false, name = "edad") int nuevaEdad){
        
        Ipersona.editPersona(id_original, nuevoNombre, nuevoApellido, nuevaEdad);
        
        Persona perso = Ipersona.findPersona(id_original);
        
        return perso;
    }
    
    @PutMapping ("/personas/modificar/")
    public Persona editPersona(@RequestBody Persona persona){
        
         Ipersona.editPersona(persona);
         
         return Ipersona.findPersona(persona.getId());
    }
    
}
