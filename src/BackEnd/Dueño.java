/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.util.ArrayList;

/**
 *
 * @author matia
 */
public class Dueño {
    private Cola cola;
    private EstadoDueño estado;
    private double tiempoTotal;
    private double tiempoEnMostrador;



    public Dueño() {
        this.cola = new Cola();
        this.estado=estado.LIBRE;
        this.tiempoTotal = 0;
        this.tiempoEnMostrador = 0;
    }
    
    

    public Cola getCola() {
        return cola;
    }

    public void setCola(Cola cola) {
        this.cola = cola;
    }

    public EstadoDueño getEstado() {
        return this.estado;
    }

    /*
    Si la cola para atender esta vacia, pasa a cocina el dueño a ayudar
    */
    public boolean cocinar()
    {
        if (this.cola.estaVacia()) {
            this.estado=EstadoDueño.EN_COCINA;
            return true;
        }
        return false;
    }
    
    public boolean atender()
    {
        
     return false;   
    }
    
    public double calcularTiempoEnCocina(){
        return (this.tiempoTotal-this.tiempoEnMostrador);
    }

    public double getTiempoTotal() {
        return tiempoTotal;
    }

    public void setTiempoTotal(double tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
    }

    public double getTiempoEnMostrador() {
        return tiempoEnMostrador;
    }

    public void setTiempoEnMostrador(double tiempoEnMostrador) {
        this.tiempoEnMostrador = tiempoEnMostrador;
    }



    
    
    
}
