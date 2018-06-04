/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

/**
 *
 * @author matia
 */
public enum EstadoAyudante {
    TRABAJANDO("Trabajando"),
    OCIO("Ocio");
    
    private final String nombre;
    
    private EstadoAyudante(String nombre)
    {
        this.nombre=nombre;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
}
