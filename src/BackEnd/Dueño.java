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
    private double tiempoCocina;
    private double tiempoEnMostrador;



    public Dueño() {
        this.cola = new Cola();
        this.estado=estado.LIBRE;
        this.tiempoCocina = 0;
        this.tiempoEnMostrador = 0;
    }
    
    

    public Cola getCola() {
        return cola;
    }
    
    public void setCola(Cola cola) {
        this.cola = cola;
    }
    
    public void setEstado(EstadoDueño i){
        this.estado=i;
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
//    public void addTiempoTotal(double tiempoTotal){
//        this.tiempoTotal+=tiempoTotal;
//    }
    public boolean atender()
    {
        
     return false;   
    }
    
//    public double calcularTiempoEnCocina(){
//        return (this.tiempoTotal-this.tiempoEnMostrador);
//    }
//
//    public double getTiempoTotal() {
//        return tiempoTotal;
//    }
//
//    public void setTiempoTotal(double tiempoTotal) {
//        this.tiempoTotal = tiempoTotal;
//    }

    public double getTiempoEnMostrador() {
        return tiempoEnMostrador;
    }

    public void addTiempoEnMostrador(double tiempoEnMostrador) {
        this.tiempoEnMostrador += tiempoEnMostrador;
    }
public void addTiempoCocina(double tiempoCocina) {
        this.tiempoCocina += tiempoCocina;
    }
public double getTiempoCocina() {
        return tiempoCocina;
    }

    
    
    
}
