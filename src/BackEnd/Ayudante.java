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
class Ayudante {
    private EstadoAyudante estado; 
    private double tiempoOcioso;
    private double tiempoTrabajando;

    public Ayudante() {
        this.estado=EstadoAyudante.OCIO;
        this.tiempoOcioso=0;
    }

    public EstadoAyudante getEstado() {
        return this.estado;
    }

    public boolean trabajar(){
        
        return false;
    }

    public double getTiempoOcioso() {
        return tiempoOcioso;
    }
    public void setEstado(int i){
        if(i ==0){
            this.estado = EstadoAyudante.OCIO;
        }else{
            this. estado = EstadoAyudante.TRABAJANDO;
        }
    }
        public double getTiempoTrabajando() {
        return tiempoTrabajando;
    }
    public void addTiempoTrabajando(double tiempoTrabajando) {
        this.tiempoTrabajando += tiempoTrabajando;
    }
    public void addTiempoOcioso(double tiempoOcioso) {
        this.tiempoOcioso += tiempoOcioso;
    }
    
}
