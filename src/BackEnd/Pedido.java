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
class Pedido {
    private boolean tipo; //true=comida, false=golosinas
    private double tiempoPreparacion;
    private boolean estado; //true=preparandose, false=listo
    private double tiempoInicio;

    public Pedido(double tiempoLlegada, double random, double random2) {
        this.tipo=false;
        if (random>0.8) 
        {
            this.tipo=true;
            this.tiempoPreparacion= 5+random2*5;
            this.tiempoInicio= tiempoLlegada + 0.1;
        }
        this.estado=true;
        this.tiempoPreparacion=0;
        this.tiempoInicio=0;
        
    }
    
    
    public String getTipo() {
        if(tipo=true){
            return "comida";
        }else{
            return "golosinas";
        }
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public double getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(double tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getTiempoInicio() {
        return tiempoInicio;
    }

    public void setTiempoInicio(double tiempoInicio) {
        this.tiempoInicio = tiempoInicio;
    }
    
    
}
