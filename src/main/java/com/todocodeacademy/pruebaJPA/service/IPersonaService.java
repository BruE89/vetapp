package com.todocodeacademy.pruebaJPA.service;

import com.todocodeacademy.pruebaJPA.model.Persona;
import java.util.List;

public interface IPersonaService {
    
    //Lectura
    public List<Persona> getPersonas();
    
    //alta
    public void savePersona(Persona persona);
    
    //baja
    public void deletePersona(Long id);
    
    //lectura de un solo objeto
    public Persona findPersona(Long id);
    
    //modificacion
    public void editPersona(Long idOriginal,
                                String nuevoNombre, String nuevoApellido,
                                    int nuevaEdad);
    
    public void editPersona(Persona persona);
}
