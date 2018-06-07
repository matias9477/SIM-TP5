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
        this.vectorActual=new Object[21];
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
   
    public void newVectorActual() {
        if (vectorAnterior == null) {//PRIMER EXPERIMENTO?
            vectorActual[0] = 0.0;
            vectorActual[1] = "INICIALIZACION";
            vectorActual[2] = Math.random();
            vectorActual[3] = (-5) * Math.log(1 - Double.valueOf(vectorActual[2].toString()));
            vectorActual[4] = Double.valueOf(vectorActual[3].toString()) + Double.valueOf(vectorActual[0].toString());
            vectorActual[5] = null;
            vectorActual[6] = null;
            vectorActual[7] = null;
            vectorActual[8] = null;
            vectorActual[9] = null;
            vectorActual[10] = null;
            vectorActual[11] = null;
            vectorActual[12] = null;
            vectorActual[13] = null;
            vectorActual[14] = null;
            vectorActual[15] = this.dueño.getEstado();
            vectorActual[16] = this.dueño.getCola().genteEnCola();
            this.dueño.addTiempoEnMostrador(Double.valueOf(vectorActual[0].toString()));
            vectorActual[17] = this.dueño.getTiempoEnMostrador();
            vectorActual[18] = this.dueño.getTiempoCocina();
            vectorActual[19] = this.ayudante.getEstado();
            vectorActual[20] = null;
            vectorActual[21] = Double.valueOf(vectorActual[0].toString()) - this.ayudante.getTiempoOcioso();
            vectorActual[22] = this.ayudante.getTiempoOcioso();
            this.vectorAnterior = this.vectorActual;          
        } else {//NO ES EL PRIMERO
            if (calcularProxEvento() == 0) {//PROXIMA LLEGADA?
                if (Double.valueOf(vectorAnterior[16].toString()) != 0) {//HAY GENTE ESPERANDO SER ATENDIDA?
                    vectorActual[0] = this.vectorAnterior[4];
                    vectorActual[1] = "LLEGADA CLIENTE";
                    Cliente c = new Cliente(Double.valueOf(vectorActual[0].toString()));
                    this.dueño.getCola().agregar(c); //AGREGO EL CLIENTE A LA COLA DEL DUEÑO
                    vectorActual[2] = Math.random();//calculo proxima llegada
                    vectorActual[3] = (-5) * Math.log(1 - Double.valueOf(vectorActual[2].toString()));
                    vectorActual[4] = Double.valueOf(vectorActual[3].toString()) + Double.valueOf(vectorActual[0].toString());
                    vectorActual[5] = null;
                    vectorActual[6] = null;
                    vectorActual[7] = null;
                    vectorActual[8] = null;
                    vectorActual[9] = vectorAnterior[9];
                    vectorActual[10] = null;
                    vectorActual[11] = vectorAnterior[11];
                    vectorActual[12] = null;
                    vectorActual[13] = null;
                    vectorActual[14] = vectorAnterior[14];
                    dueño.setEstado(0); //SETEO DUEÑO ATENDIENDO
                    vectorActual[15] = this.dueño.getEstado();
                    vectorActual[16] = this.dueño.getCola().genteEnCola(); //YA AGREGUE ANTES EL CLIENTE A LA COLA, EL SIZE ESTA ACTUALIADO                    
                    vectorActual[17] = this.dueño.getTiempoEnMostrador();
                    vectorActual[18] = this.dueño.getTiempoCocina();
                    vectorActual[19] = this.ayudante.getEstado();
                    vectorActual[20] = 0;
                    vectorActual[21] = Double.valueOf(vectorActual[0].toString()) - this.ayudante.getTiempoOcioso();
                    vectorActual[22] = this.ayudante.getTiempoOcioso();
                    this.vectorAnterior = this.vectorActual;                    
                } else {
                    vectorActual[0] = this.vectorAnterior[4];
                    vectorActual[1] = "LLEGADA CLIENTE";
                    Cliente c = new Cliente(Double.valueOf(vectorActual[0].toString()));
                    this.dueño.getCola().agregar(c); //AGREGO EL CLIENTE A LA COLA DEL DUEÑO                   
                    vectorActual[2] = Math.random();//calculo proxima llegada
                    vectorActual[3] = (-5) * Math.log(1 - Double.valueOf(vectorActual[2].toString()));
                    vectorActual[4] = Double.valueOf(vectorActual[3].toString()) + Double.valueOf(vectorActual[0].toString());
                    vectorActual[5] = Math.random();//calculo el tipo de compra
                    if (Double.valueOf(vectorActual[5].toString()) < 0.8) {//TIPO DE COMPRA?
                        vectorActual[6] = 0;//NO ES COMIDA
                    } else {
                        vectorActual[6] = 1;//ES COMIDA
                    }
                    if (Double.valueOf(vectorActual[6].toString()) == 0) {//CUANTO TARDA EN ATENDER?
                        vectorActual[7] = Math.random();
                        vectorActual[8] = 0.5 + Double.valueOf(vectorActual[7].toString()) * 1.5;
                        vectorActual[9] = Double.valueOf(vectorActual[8].toString()) + Double.valueOf(vectorActual[0].toString());
                        this.dueño.addTiempoEnMostrador(Double.valueOf(vectorActual[9].toString())-Double.valueOf(vectorActual[0].toString()));//AGREGO TIEMPO ATENCION
                        vectorActual[10] = null;
                        vectorActual[11] = null;
                    } else {
                        vectorActual[7] = null;
                        vectorActual[8] = null;
                        vectorActual[9] = null;
                        vectorActual[10] = 0.1;
                        vectorActual[11] = Double.valueOf(vectorActual[10].toString()) + Double.valueOf(vectorActual[0].toString());
                        this.dueño.addTiempoEnMostrador(0.1);//AGREGO TIEMPO ANTENCION
                    }
                    vectorActual[12] = null;
                    vectorActual[13] = null;
                    vectorActual[14] = vectorAnterior[14];//mantiene el tiempo anterior que no fue menor (FIN PREPARACION)
                    dueño.setEstado(0); //SETEO DUEÑO ATENDIENDO
                    vectorActual[15] = this.dueño.getEstado();
                    vectorActual[16] = this.dueño.getCola().genteEnCola();
                    vectorActual[17] = this.dueño.getTiempoEnMostrador();
                    vectorActual[18] = this.dueño.getTiempoCocina();
                    ayudante.setEstado(0);
                    vectorActual[19] = this.ayudante.getEstado();
                    vectorActual[20] = 0;
                    this.ayudante.addTiempoOcioso(Double.valueOf(vectorActual[0].toString()));//AGREGO TIEMPO OCIOSO
                    this.ayudante.addTiempoTrabajando(Double.valueOf(vectorActual[0].toString()) - this.ayudante.getTiempoOcioso());//AGREGO TIEMPO TRABAJANDO
                    vectorActual[21] = this.ayudante.getTiempoTrabajando();
                    vectorActual[22] = this.ayudante.getTiempoOcioso();
                    this.vectorAnterior = this.vectorActual;                    
                }
            } else {//NO ES PROXIMA LLEGADA
                if (calcularProxEvento() == 1) {//FIN ATENCION?
               
                } else {//NO ES FIN  ATENCION
                    if (calcularProxEvento() == 2) {//FIN TRANSMISION?
                        vectorActual[0] = vectorAnterior[11];
                        vectorActual[1] = "FIN TRANSMISION";
                        vectorActual[2] = null;
                        vectorActual[3] = null;
                        vectorActual[4] = vectorAnterior[4];
                        vectorActual[5] = null;
                        vectorActual[6] = null;
                        vectorActual[7] = null;
                        vectorActual[8] = null;
                        vectorActual[9] = null;
                        vectorActual[10] = null;
                        vectorActual[11] = null;
                        vectorActual[12] = Math.random();
                        vectorActual[13] = 5 + Double.valueOf(vectorActual[12].toString()) * 5;
                        vectorActual[14] = Double.valueOf(vectorActual[0].toString()) + Double.valueOf(vectorActual[13].toString());
                        this.dueño.setEstado(2);//SETEO EL DUEÑO COMO LIBRE
                        vectorActual[15] = this.dueño.getEstado();
                        this.dueño.getCola().avanzar();//YA TERMINE DE ATENDER UN CLIENTE
                        vectorActual[16] = this.dueño.getCola().genteEnCola();
                        vectorActual[17] = this.dueño.getTiempoEnMostrador();
                        vectorActual[18] = this.dueño.getTiempoCocina();
                        this.ayudante.setEstado(1);//EL AYUDANTE PASA A TRABAJAR
                        vectorActual[19] = this.ayudante.getEstado();
                        vectorActual[20] = 0;
                        if (this.dueño.getEstado() == EstadoDueño.LIBRE && this.dueño.getCola().estaVacia()) {//SI EL JEFE ESTA LIBRE Y NO HAY NADIE ESPERANDO SER ATENDIDO
                            this.dueño.setEstado(1);//EL JEFE PASA A COCINA
                            vectorActual[13] = Double.valueOf(vectorActual[13].toString()) / 2;//EL TIEMPO PASA A SER LA MITAD
                            vectorActual[14] = Double.valueOf(vectorActual[0].toString()) + Double.valueOf(vectorActual[13].toString());
                            vectorActual[15] = this.dueño.getEstado();
                            if(Double.valueOf(vectorActual[4].toString())<Double.valueOf(vectorActual[14].toString())){//SI MIENTRAS ESTA EN COCINA LLEGA ALGUIEN
                            this.dueño.addTiempoCocina(Double.valueOf(vectorActual[4].toString())-Double.valueOf(vectorActual[0].toString()));
                            vectorActual[18] = this.dueño.getTiempoCocina();
                            }
                            this.dueño.addTiempoCocina(Double.valueOf(vectorActual[14].toString())-Double.valueOf(vectorActual[0].toString()));
                        }
                        this.ayudante.addTiempoTrabajando(Double.valueOf(vectorActual[14].toString()) - Double.valueOf(vectorActual[0].toString()));//AGREGO TIEMPO TRABAJANDO AYUDANTE                            
                        vectorActual[21] = this.ayudante.getTiempoTrabajando();
                        vectorActual[22] = this.ayudante.getTiempoOcioso();
                        this.vectorAnterior = this.vectorActual;                        
                    } else {//NO ES FIN TRANSMISION
                        //ES FIN PREPARACION

                    }
                }
            }
        }
    }

    private int calcularProxEvento() {
        if (Double.valueOf(this.vectorAnterior[4].toString()) < Double.valueOf(this.vectorAnterior[9].toString()) && Double.valueOf(this.vectorAnterior[4].toString()) < Double.valueOf(this.vectorAnterior[11].toString()) && Double.valueOf(this.vectorAnterior[4].toString()) < Double.valueOf(this.vectorAnterior[11].toString())) {
            return 0; //PROXIMA LLEGADA
        } else {
            if(Double.valueOf(this.vectorAnterior[9].toString()) < Double.valueOf(this.vectorAnterior[11].toString()) && Double.valueOf(this.vectorAnterior[9].toString()) < Double.valueOf(this.vectorAnterior[14].toString())){
                return 1;//FIN ATENCION
            }else{
                if(Double.valueOf(this.vectorAnterior[11].toString()) < Double.valueOf(this.vectorAnterior[14].toString())){
                    return 2;//FIN TRANSMISION
                }else{
                    return 3;//FIN PREPARACION
                }
            }
        }
    }
    /*
    public void newVectorActual()
    {
        if (vectorAnterior == null){ //NUEVO TALISTO
            vectorActual[0] = 0.0;
            vectorActual[1] = "Inicializacion";
            vectorActual[2] = Math.random();
            vectorActual[3] = (-5) * Math.log(1 - Double.valueOf(vectorActual[2].toString()));
            vectorActual[4] = Double.valueOf(vectorActual[3].toString()) + Double.valueOf(vectorActual[0].toString());
            vectorActual[5] = 0;
            vectorActual[6] = 0;
            vectorActual[7] = 0;
            vectorActual[8] = 0;
            vectorActual[9] = 0;
            vectorActual[10] = 0;
            vectorActual[11] = 0;
            vectorActual[12] = 0;
            vectorActual[13] = 0;
            vectorActual[14] = 0;
            vectorActual[15] = this.dueño.getEstado();
            vectorActual[16] = 0;
            vectorActual[17] = this.dueño.getTiempoEnMostrador();
            vectorActual[18] = this.dueño.calcularTiempoEnCocina();
            vectorActual[19] = this.ayudante.getEstado();
            vectorActual[20] = 0;
            vectorActual[21] = Double.valueOf(vectorActual[0].toString())-this.ayudante.getTiempoOcioso();
            vectorActual[22] = this.ayudante.getTiempoOcioso();
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
*/
    }
    

