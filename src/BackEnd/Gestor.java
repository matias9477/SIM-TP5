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
public class Gestor {
    
    private Object[] vectorActual;
    private Object[] vectorAnterior;
    private Dueño dueño;
    private Ayudante ayudante;


    public Gestor() {
        this.vectorActual=new Object[28];
        
        this.vectorAnterior = null;
        this.dueño = new Dueño();
        this.ayudante = new Ayudante();

    }

    public Object[] getVectorActual() {
        return vectorActual;
    }
    
    public ArrayList crearArrayList()
    {       
        ArrayList a=new ArrayList();
        
        if (vectorActual!=null) 
        {
            for (int i = 0; i < vectorActual.length; i++) {
                a.add(vectorActual[i]);
            }
        }
        return a;
    }
    
    
    public void newVectorActual()
    {
        if (vectorAnterior == null) { //NUEVO TALISTO
            vectorActual[0] = (double) 0;
            vectorActual[1] = "Inicializacion";
            vectorActual[2] = Math.random();
            vectorActual[3] = (-5) * Math.log(1 - (double) vectorActual[2]);
            vectorActual[4] = (double) vectorActual[3] + (double) vectorActual[0];
            vectorActual[5] = 0;
            vectorActual[6] = 0;
            vectorActual[7] = 0;
            vectorActual[8] = 0;
            vectorActual[9] = 0;
            vectorActual[10] = 0;
            vectorActual[11] = 0;
            vectorActual[12] = 0;
            vectorActual[13] = this.dueño.getEstado();
            vectorActual[14] = this.dueño.getCola().genteEnCola();
            vectorActual[15] = this.ayudante.getEstado();
            vectorActual[16] = this.ayudante.getTiempoOcioso();
            vectorActual[17] = this.dueño.getTiempoTotal() - this.dueño.getTiempoEnMostrador();
            vectorActual[18] = this.dueño.getTiempoEnMostrador();
            this.vectorAnterior = this.vectorActual;
            
            //HASTA ACA TODO OK
        } else {//SIGUIENTE
            this.vectorAnterior = this.vectorActual;
            if (Double.valueOf(this.vectorAnterior[4].toString()) < (double) Double.valueOf(this.vectorAnterior[9].toString()) && Double.valueOf(this.vectorAnterior[4].toString()) < Double.valueOf(this.vectorAnterior[12].toString())) {//LLEGADA CLIENTE
                vectorActual[0] = this.vectorAnterior[4];
                vectorActual[1] = "Llegada Cliente";

                if ((double) this.vectorAnterior[14] == 0) {
                    vectorActual[2] = Math.random();
                    vectorActual[3] = (-5) * Math.log(1 - (double) vectorActual[2]);
                    vectorActual[4] = (double) vectorActual[3] + (double) vectorActual[0];
                    vectorActual[5] = Math.random();
                    vectorActual[10] = Math.random();
                    Cliente c = new Cliente(Double.valueOf(this.vectorActual[0].toString()));
                    Pedido p = new Pedido(c.getTiempoLlegada(), Double.valueOf(this.vectorActual[5].toString()), Double.valueOf(this.vectorActual[10].toString()));
                    c.setPedido(p);
                    this.dueño.getCola().agregar(c);
                    vectorActual[6] = this.dueño.getCola().get(this.dueño.getCola().genteEnCola() - 1).getPedido().getTipo();
                    vectorActual[7] = Math.random();
                    if((double)this.vectorActual[7]>=0.8){
                    vectorActual[8] = 0.5+(double)this.vectorActual[7]*1.5;
                    vectorActual[9] = (double) this.vectorActual[0]+(double) this.vectorActual[8];
                    vectorActual[11] = 5*(double) this.vectorActual[10]+5;
                    vectorActual[12] = (double)this.vectorActual[9]+(double)this.vectorActual[11];
                    this.dueño.getCola().avanzar();
                    }else{
                        vectorActual[8]=0.1;
                        vectorActual[9] = (double) this.vectorActual[0]+(double) this.vectorActual[8];
                        vectorActual[10]=0;
                        vectorActual[11]=0;
                        vectorActual[12]=0;
                    }
            vectorActual[13] = this.dueño.getEstado();
            vectorActual[14] = this.dueño.getCola().genteEnCola();
            vectorActual[15] = this.ayudante.getEstado();
            vectorActual[16] = this.ayudante.getTiempoOcioso();
            vectorActual[17] = this.dueño.getTiempoTotal() - this.dueño.getTiempoEnMostrador();
            vectorActual[18] = this.dueño.getTiempoEnMostrador();
                } else {
                    vectorActual[2] = Math.random();
                    vectorActual[3] = (-5) * Math.log(1 - (double) vectorActual[2]);
                    vectorActual[4] = Double.valueOf(this.vectorAnterior[3].toString()) + Double.valueOf(this.vectorAnterior[0].toString());
                    vectorActual[5] = Math.random();
                    vectorActual[10] = Math.random();
                    Cliente c = new Cliente(Double.valueOf(this.vectorActual[0].toString()));
                    Pedido p = new Pedido(c.getTiempoLlegada(), Double.valueOf(this.vectorActual[5].toString()), Double.valueOf(this.vectorActual[10].toString()));
                    c.setPedido(p);
                    this.dueño.getCola().agregar(c);
                    vectorActual[6] = 0;
                    vectorActual[7] = 0;
                    vectorActual[8] = 0;
                    vectorActual[9] = 0;
                    vectorActual[11] = 0;
                    vectorActual[12] = 0;
                    vectorActual[13] = this.dueño.getEstado();
                    vectorActual[14] = this.dueño.getCola().genteEnCola();
                    vectorActual[15] = this.ayudante.getEstado();
                    vectorActual[16] = this.ayudante.getTiempoOcioso();
                    vectorActual[17] = this.dueño.getTiempoTotal() - this.dueño.getTiempoEnMostrador();
                    vectorActual[18] = this.dueño.getTiempoEnMostrador();
                }
            }else{
                if (Double.valueOf(this.vectorAnterior[9].toString()) < Double.valueOf(this.vectorAnterior[12].toString())) {
                    vectorActual[0] = this.vectorAnterior[9];
                    vectorActual[1] = "Fin atencion";
                    
                    vectorActual[2] = 0;
                    vectorActual[3] = 0;
                    vectorActual[4] = 0;
                    vectorActual[5] = 0;
                    vectorActual[6] = this.dueño.getCola().get(0).getPedido();
                    vectorActual[7] = Math.random();
                                      if(Double.valueOf(this.vectorAnterior[7].toString())>=0.8){
                    vectorActual[8] = 0.5+Double.valueOf(this.vectorAnterior[7].toString())*1.5;
                    vectorActual[9] = Double.valueOf(this.vectorAnterior[0].toString())+(double) this.vectorActual[8];
                    vectorActual[11] = 5*(double) this.vectorActual[10]+5;
                    vectorActual[12] = (double)this.vectorActual[9]+(double)this.vectorActual[11];
                    }else{
                        vectorActual[8]=0.1;
                        vectorActual[9] = (double) this.vectorActual[0]+(double) this.vectorActual[8];
                        vectorActual[10]=0;
                        vectorActual[11]=0;
                        vectorActual[12]=0;
                    }
                    vectorActual[13] = this.dueño.getEstado();
            vectorActual[14] = this.dueño.getCola().genteEnCola();
            vectorActual[15] = this.ayudante.getEstado();
            vectorActual[16] = this.ayudante.getTiempoOcioso();
            vectorActual[17] = this.dueño.getTiempoTotal() - this.dueño.getTiempoEnMostrador();
            vectorActual[18] = this.dueño.getTiempoEnMostrador();
                    } else {
                    vectorActual[0] = this.vectorAnterior[12];
                    vectorActual[1] = "Fin preparacion";
                    vectorActual[2] = 0;
                    vectorActual[3] = 0;
                    vectorActual[4] = this.vectorAnterior[4];
                    vectorActual[5] = 0;
                    vectorActual[6] = 0;
                    vectorActual[7] = 0;
                    vectorActual[8] = 0;
                    vectorActual[9] = 0;
                    vectorActual[10] = 0;
                    vectorActual[11] = 0;
                    vectorActual[12] = 0;
                    vectorActual[13] = this.dueño.getEstado();
            vectorActual[14] = this.dueño.getCola().genteEnCola();
            vectorActual[15] = this.ayudante.getEstado();
            vectorActual[16] = this.ayudante.getTiempoOcioso();
            vectorActual[17] = this.dueño.getTiempoTotal() - this.dueño.getTiempoEnMostrador();
            vectorActual[18] = this.dueño.getTiempoEnMostrador();
            

                }
            }

        }
    }
    }
    

