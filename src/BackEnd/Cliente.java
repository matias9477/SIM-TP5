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
public class Cliente {
    private double tiempoLlegada;
    private double tiempoFinAtencion;
    private Pedido pedido;
    private int estadoCliente;

    public String getEstadoCliente() {
        if(this.estadoCliente==1){
            return "espera at";
        }else{
            if(this.estadoCliente==2){
                return "espera ped";
            }else{
                return "siendo at";
            }
        }
    }

    public void setEstadoCliente(int estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

    public Cliente(double tiempoLlegada) {
        this.tiempoLlegada=tiempoLlegada;
        this.tiempoFinAtencion=0;
        this.pedido=null;
        this.estadoCliente=1;
    }

    public double getTiempoLlegada() {
        return tiempoLlegada;
    }

    public void setTiempoLlegada(double tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    public double getTiempoFinAtencion() {
        return tiempoFinAtencion;
    }

    public void setTiempoFinAtencion(double tiempoFinAtencion) {
        this.tiempoFinAtencion = tiempoFinAtencion;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
}
