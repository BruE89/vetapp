package com.todocodeacademy.pruebaJPA.service;

import com.todocodeacademy.pruebaJPA.model.Mascota;
import java.util.List;

public interface IMascotaService {

    //Lectura
    public List<Mascota> getMascotas();
    
    //alta
    public void saveMascota(Mascota mascota);
    
    //baja
    public void deleteMascota(Long id_mascota);
    
    //lectura de un solo objeto
    public Mascota findMascota(Long id_mascota);
    
    //modificacion
    public void editMascota(Long idOriginal, 
                                String nuevoNombre, String nuevaEspecie,
                                String nuevaRaza, String nuevoColor);
    
}
