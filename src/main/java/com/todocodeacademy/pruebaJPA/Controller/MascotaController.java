package com.todocodeacademy.pruebaJPA.Controller;

import com.todocodeacademy.pruebaJPA.model.Mascota;
import com.todocodeacademy.pruebaJPA.service.IMascotaService;
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
public class MascotaController {
    
    @Autowired
    private IMascotaService Imascota;
    
    @GetMapping ("/mascotas/traer")
    public List<Mascota> getPersonas(){
        
        return Imascota.getMascotas();
    }
    
    @PostMapping ("/mascotas/crear")
    public String saveMascota(@RequestBody Mascota mascota){
        
        Imascota.saveMascota(mascota);
        
        return "Mascota creada correctamente";
    }
    
    @DeleteMapping ("/mascotas/borrar/{id}")
    public String deleteMascota(@PathVariable Long id){
        
        Imascota.deleteMascota(id);
        
        return "Mascota borrada correctamente";
        
    }
    
    @PutMapping ("/mascotas/modificar/{id_original}")
    public Mascota editMascota(@PathVariable Long id_original,
            @RequestParam(required = false, name = "nombre") String nuevoNombre,
            @RequestParam(required = false, name = "especie") String nuevaEspecie,
            @RequestParam(required = false, name = "raza") String nuevaRaza,
            @RequestParam(required = false, name = "color") String nuevoColor){
        
        Imascota.editMascota(id_original, nuevoNombre, nuevaEspecie, nuevaRaza, nuevoColor);
        
        Mascota mascota = Imascota.findMascota(id_original);
        
        return mascota;
    }
    
}
