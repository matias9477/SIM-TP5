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
        this.vectorActual=new Object[22];
        this.vectorAnterior = null;
        this.dueño = new Dueño();
        this.ayudante = new Ayudante();

    }
    public double getTiempoOcioso()
    {
        return this.ayudante.getTiempoOcioso();
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
    
    public void limpiarVectores()
    {
        this.vectorActual=new Object[22];
        this.vectorAnterior = null;
        this.dueño = new Dueño();
        this.ayudante = new Ayudante();
    }
    
    public double calcularPorcentajeOcioso()
    {
        double total=this.ayudante.getTiempoOcioso()+this.ayudante.getTiempoTrabajando();
        return (this.ayudante.getTiempoOcioso()/total)*100;
    }
   
    public double calcularPorcentajeEnCocina()
    {
        double total=this.dueño.getTiempoCocina()+this.dueño.getTiempoEnMostrador();
        return (this.dueño.getTiempoCocina()/total)*100;
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
            vectorActual[20] = this.ayudante.getTiempoTrabajando();
            vectorActual[21] = this.ayudante.getTiempoOcioso();
            this.vectorAnterior = this.vectorActual;
        } else {//NO ES EL PRIMERO
            if (this.dueño.getEstado() == EstadoDueño.LIBRE && this.dueño.getCola().genteEnCola() > 0 && Double.valueOf(vectorAnterior[0].toString()) < Double.valueOf(vectorAnterior[4].toString())) {//ATIENDE AL QUE ESTA EN COLA PERO NO CALCULA LA PROXIMA LLEGADA PORQUE YA CALCULO ANTES
                vectorActual[0]=vectorAnterior[0];
                vectorActual[1] = "LLEGADA CLIENTE";
                vectorActual[2] = null;
                vectorActual[3] = null;
                vectorActual[4] = vectorAnterior[4];
                vectorActual[5] = Math.random();
                if (Double.valueOf(vectorActual[5].toString()) < 0.8) {//TIPO DE COMPRA? 
                        vectorActual[6] = 0;//NO ES COMIDA
                        vectorActual[7] = Math.random();
                        vectorActual[8] = 0.5 + Double.valueOf(vectorActual[7].toString()) * 1.5;
                        vectorActual[9] = Double.valueOf(vectorActual[8].toString()) + Double.valueOf(vectorActual[0].toString());
                       this.dueño.addTiempoEnMostrador((Double.valueOf(vectorActual[0].toString())-this.dueño.getTiempoCocina())-this.dueño.getTiempoEnMostrador());//AGREGO TIEMPO ATENCION
                        vectorActual[10] = null;
                        vectorActual[11] = null;                        
                    } else {
                        vectorActual[6] = 1;//ES COMIDA
                        vectorActual[7] = null;
                        vectorActual[8] = null;
                        vectorActual[9] = null;
                        vectorActual[10] = 0.1;
                        vectorActual[11] = 0.1 + Double.valueOf(vectorActual[0].toString());
                        this.dueño.addTiempoEnMostrador((Double.valueOf(vectorActual[0].toString())-this.dueño.getTiempoCocina())-this.dueño.getTiempoEnMostrador());//AGREGO TIEMPO ATENCION
                    } 
                vectorActual[12] = null;
                vectorActual[13] = null;
                vectorActual[14] = vectorAnterior[14];
                this.dueño.setEstado(EstadoDueño.ATENDIENDO);
                vectorActual[15] = this.dueño.getEstado();
                vectorActual[16] = this.dueño.getCola().genteEnCola();
                vectorActual[17] = this.dueño.getTiempoEnMostrador();
                vectorActual[18] = this.dueño.getTiempoCocina();
                vectorActual[19] = this.ayudante.getEstado();
                vectorActual[20] = this.ayudante.getTiempoTrabajando();
                vectorActual[21] = this.ayudante.getTiempoOcioso();
                this.vectorAnterior = this.vectorActual;
            }else{
            if (calcularProxEvento() == 0) {//PROXIMA LLEGADA?
                if (this.dueño.getCola().genteEnCola() != 0) {//HAY GENTE ESPERANDO SER ATENDIDA?
                    vectorActual[0] = this.vectorAnterior[4];
                    vectorActual[1] = "LLEGADA CLIENTE";
                    Cliente c = new Cliente(Double.valueOf(vectorActual[0].toString()));
                    this.dueño.getCola().agregar(); //AGREGO EL CLIENTE A LA COLA DEL DUEÑO
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
                    dueño.setEstado(EstadoDueño.ATENDIENDO); //SETEO DUEÑO ATENDIENDO
                    vectorActual[15] = this.dueño.getEstado();
                    vectorActual[16] = this.dueño.getCola().genteEnCola(); //YA AGREGUE ANTES EL CLIENTE A LA COLA, EL SIZE ESTA ACTUALIADO  
                    this.dueño.addTiempoEnMostrador((Double.valueOf(vectorActual[0].toString())-this.dueño.getTiempoCocina())-this.dueño.getTiempoEnMostrador());//AGREGO TIEMPO ATENCION
                    vectorActual[17] = this.dueño.getTiempoEnMostrador();
                    vectorActual[18] = this.dueño.getTiempoCocina();
                    vectorActual[19] = this.ayudante.getEstado();
                    vectorActual[20] = this.ayudante.getTiempoTrabajando();
                    vectorActual[21] = this.ayudante.getTiempoOcioso();
                    this.vectorAnterior = this.vectorActual;                    
                } else { //NO HAY GENTE ESPERANDO SER ATENDIDA
                    vectorActual[0] = this.vectorAnterior[4];
                    if(this.dueño.getEstado().equals(EstadoDueño.EN_COCINA)){
                         this.dueño.addTiempoCocina((Double.valueOf(vectorActual[0].toString()) - this.dueño.getTiempoEnMostrador())-this.dueño.getTiempoCocina());
                        vectorActual[14]=((Double.valueOf(vectorAnterior[14].toString())-Double.valueOf(vectorActual[0].toString()))*2)+Double.valueOf(vectorActual[0].toString());
                    }else{
                                            vectorActual[14] = vectorAnterior[14];//mantiene el tiempo anterior que no fue menor (FIN PREPARACION)                    

                    }
                    
                    vectorActual[1] = "LLEGADA CLIENTE";
                    Cliente c = new Cliente(Double.valueOf(vectorActual[0].toString()));
                    this.dueño.getCola().agregar(); //AGREGO EL CLIENTE A LA COLA DEL DUEÑO                   
                    vectorActual[2] = Math.random();//calculo proxima llegada
                    vectorActual[3] = (-5) * Math.log(1 - Double.valueOf(vectorActual[2].toString()));
                    vectorActual[4] = Double.valueOf(vectorActual[3].toString()) + Double.valueOf(vectorActual[0].toString());
                    vectorActual[5] = Math.random();//calculo el tipo de compra
                    if (Double.valueOf(vectorActual[5].toString()) < 0.8) {//TIPO DE COMPRA?
                        vectorActual[6] = 0;//NO ES COMIDA
                        vectorActual[7] = Math.random();
                        vectorActual[8] = 0.5 + Double.valueOf(vectorActual[7].toString()) * 1.5;
                        vectorActual[9] = Double.valueOf(vectorActual[8].toString()) + Double.valueOf(vectorActual[0].toString());
                        
                        vectorActual[10] = null;
                        vectorActual[11] = null;                        
                    } else {
                        vectorActual[6] = 1;//ES COMIDA
                        vectorActual[7] = null;
                        vectorActual[8] = null;
                        vectorActual[9] = null;
                        vectorActual[10] = 0.1;
                        vectorActual[11] = 0.1 + Double.valueOf(vectorActual[0].toString());
                        
                    }                    
                    vectorActual[12] = null;
                    vectorActual[13] = null;
                    dueño.setEstado(EstadoDueño.ATENDIENDO);//SETEO DUEÑO ATENDIENDO
                    vectorActual[15] = this.dueño.getEstado();
                    vectorActual[16] = this.dueño.getCola().genteEnCola();
                    this.dueño.addTiempoEnMostrador((Double.valueOf(vectorActual[0].toString())-this.dueño.getTiempoCocina())-this.dueño.getTiempoEnMostrador());//AGREGO TIEMPO ATENCION
                    vectorActual[17] = this.dueño.getTiempoEnMostrador();
                    
                    vectorActual[18] = this.dueño.getTiempoCocina();
                    if(this.ayudante.getEstado().equals(EstadoAyudante.OCIO)){
                    vectorActual[20]=vectorAnterior[20];
                    this.ayudante.addTiempoOcioso((Double.valueOf(vectorActual[0].toString())-this.ayudante.getTiempoTrabajando())-this.ayudante.getTiempoOcioso());
                    }
                    vectorActual[19] = this.ayudante.getEstado();                               
                    //this.ayudante.addTiempoTrabajando(Double.valueOf(vectorActual[0].toString()) - this.ayudante.getTiempoOcioso());//AGREGO TIEMPO TRABAJANDO
                    vectorActual[20] = this.ayudante.getTiempoTrabajando();
                    vectorActual[21] = this.ayudante.getTiempoOcioso();
                    this.vectorAnterior = this.vectorActual;
                }
            } else {//NO ES PROXIMA LLEGADA
                if (calcularProxEvento() == 1) {//FIN ATENCION?
                    
                    vectorActual[0] = vectorAnterior[9];
                    vectorActual[1] = "FIN ATENCION";
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
                    vectorActual[12] = null;
                    vectorActual[13] = null;
                    vectorActual[14] = vectorAnterior[14];
                    this.dueño.setEstado(EstadoDueño.LIBRE);
                    this.dueño.getCola().avanzar();
                    vectorActual[15] = this.dueño.getEstado();
                    vectorActual[16] = this.dueño.getCola().genteEnCola();
                    this.dueño.addTiempoEnMostrador((Double.valueOf(vectorActual[0].toString())-this.dueño.getTiempoCocina())-this.dueño.getTiempoEnMostrador());//AGREGO TIEMPO ATENCION
                    vectorActual[17] = this.dueño.getTiempoEnMostrador();
                    vectorActual[18] = this.dueño.getTiempoCocina();
                    vectorActual[19] = this.ayudante.getEstado();
                    vectorActual[20] = this.ayudante.getTiempoTrabajando();
                    vectorActual[21] = this.ayudante.getTiempoOcioso();
                    this.vectorAnterior = this.vectorActual;
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
                        if(Double.valueOf(vectorAnterior[14].toString())!= null &&  Double.valueOf(vectorActual[14].toString())< Double.valueOf(vectorAnterior[14].toString())){
                            vectorActual[14]=vectorAnterior[14];
                        }
                        if(Double.valueOf(vectorAnterior[14].toString())!=null && Double.valueOf(vectorActual[0].toString())<Double.valueOf(vectorAnterior[14].toString())){
                        this.ayudante.addTiempoTrabajando((Double.valueOf(vectorActual[0].toString()) - this.ayudante.getTiempoOcioso())-this.ayudante.getTiempoTrabajando());
                        }
                        this.dueño.setEstado(EstadoDueño.LIBRE);//SETEO EL DUEÑO COMO LIBRE
                        vectorActual[15] = this.dueño.getEstado();
                        this.dueño.getCola().avanzar();//YA TERMINE DE ATENDER UN CLIENTE
                        vectorActual[16] = this.dueño.getCola().genteEnCola();
                        this.dueño.addTiempoEnMostrador((Double.valueOf(vectorActual[0].toString())-this.dueño.getTiempoCocina())-this.dueño.getTiempoEnMostrador());//AGREGO TIEMPO ATENCION
                        vectorActual[17] = this.dueño.getTiempoEnMostrador();
                        vectorActual[18] = this.dueño.getTiempoCocina();
                        this.ayudante.setEstado(EstadoAyudante.TRABAJANDO);//EL AYUDANTE PASA A TRABAJAR
                        vectorActual[19] = this.ayudante.getEstado();                      
                        if (this.dueño.getEstado() == EstadoDueño.LIBRE && this.dueño.getCola().estaVacia()) {//SI EL JEFE ESTA LIBRE Y NO HAY NADIE ESPERANDO SER ATENDIDO
                            this.dueño.setEstado(EstadoDueño.EN_COCINA);//EL JEFE PASA A COCINA
                            vectorActual[13] = Double.valueOf(vectorActual[13].toString()) / 2;//EL TIEMPO PASA A SER LA MITAD
                            vectorActual[14] = Double.valueOf(vectorActual[0].toString()) + Double.valueOf(vectorActual[13].toString());
                            vectorActual[15] = this.dueño.getEstado();
                               
                                //his.dueño.addTiempoCocina((Double.valueOf(vectorActual[0].toString())) - (Double.valueOf(vectorAnterior[0].toString())));
                        }               
                        
                        vectorActual[20] = this.ayudante.getTiempoTrabajando();
                        this.ayudante.addTiempoOcioso((Double.valueOf(vectorActual[0].toString())-this.ayudante.getTiempoTrabajando())-this.ayudante.getTiempoOcioso());
                        vectorActual[21] = this.ayudante.getTiempoOcioso();
                        this.vectorAnterior = this.vectorActual;
                    } else {//NO ES FIN TRANSMISION
                        //ES FIN PREPARACION
                        vectorActual[0] = vectorAnterior[14];
                        vectorActual[1] = "FIN PREPARACION";
                        vectorActual[2] = null;
                        vectorActual[3] = null;
                        vectorActual[4] = vectorAnterior[4];
                        vectorActual[5] = null;
                        vectorActual[6] = null;
                        vectorActual[7] = null;
                        vectorActual[8] = null;
                        vectorActual[9] = vectorAnterior[9];
                        vectorActual[10] = null;
                        vectorActual[11] = null;
                        vectorActual[12] = null;
                        vectorActual[13] = null;
                        vectorActual[14] = null;
                        if(this.dueño.getEstado().equals(EstadoDueño.ATENDIENDO) || this.dueño.getEstado().equals(EstadoDueño.LIBRE)){
                            this.dueño.addTiempoEnMostrador((Double.valueOf(vectorActual[0].toString())-this.dueño.getTiempoCocina())-this.dueño.getTiempoEnMostrador());//AGREGO TIEMPO ATENCION
                        }else{
                            this.dueño.addTiempoCocina((Double.valueOf(vectorActual[0].toString())-this.dueño.getTiempoEnMostrador())-this.dueño.getTiempoCocina());
                        }
                         this.ayudante.addTiempoTrabajando((Double.valueOf(vectorActual[0].toString()) - this.ayudante.getTiempoOcioso())-this.ayudante.getTiempoTrabajando());
                        this.dueño.setEstado(EstadoDueño.LIBRE);
                        vectorActual[15] = this.dueño.getEstado();
                        vectorActual[16] = this.dueño.getCola().genteEnCola();
                        
                        vectorActual[17] = this.dueño.getTiempoEnMostrador();
                        vectorActual[18] = this.dueño.getTiempoCocina();
                        this.ayudante.setEstado(EstadoAyudante.OCIO);
                        vectorActual[19] = this.ayudante.getEstado();
                        vectorActual[20] = this.ayudante.getTiempoTrabajando();
                        vectorActual[21] = this.ayudante.getTiempoOcioso();
                        this.vectorAnterior = this.vectorActual;
                    }
                }
            }
        }
        }
    }

    private int calcularProxEvento() {
        
        double cuatro;
        double nueve;
        double once;
        double catorce;
        if (this.vectorAnterior[4] == null) {
            cuatro = 100000000;
        } else {
            cuatro = Double.valueOf(this.vectorAnterior[4].toString());
        }

        if (this.vectorAnterior[9] == null) {
            nueve = 100000000;
        } else {
            nueve = Double.valueOf(this.vectorAnterior[9].toString());
        }

        if (this.vectorAnterior[11] == null) {
            once = 100000000;
        } else {
            once = Double.valueOf(this.vectorAnterior[11].toString());
        }
        if (this.vectorAnterior[14] == null) {
            catorce = 100000000;
        } else {
            catorce = Double.valueOf(this.vectorAnterior[14].toString());
        }

        if (cuatro < nueve && cuatro < once && cuatro < catorce) {
            return 0; //PROXIMA LLEGADA
        } else {
            if (nueve < once && nueve < catorce) {
                return 1;//FIN ATENCION
            } else {
                if (once < catorce) {
                    return 2;//FIN TRANSMISION
                } else {
                    return 3;//FIN PREPARACION
                }
            }
        }
    }

//        if (Double.valueOf(this.vectorAnterior[4].toString()) < Double.valueOf(this.vectorAnterior[9].toString()) && Double.valueOf(this.vectorAnterior[4].toString()) < Double.valueOf(this.vectorAnterior[11].toString()) && Double.valueOf(this.vectorAnterior[4].toString()) < Double.valueOf(this.vectorAnterior[11].toString())) {
//            return 0; //PROXIMA LLEGADA
//        } else {
//            if(Double.valueOf(this.vectorAnterior[9].toString()) < Double.valueOf(this.vectorAnterior[11].toString()) && Double.valueOf(this.vectorAnterior[9].toString()) < Double.valueOf(this.vectorAnterior[14].toString())){
//                return 1;//FIN ATENCION
//            }else{
//                if(Double.valueOf(this.vectorAnterior[11].toString()) < Double.valueOf(this.vectorAnterior[14].toString())){
//                    return 2;//FIN TRANSMISION
//                }else{
//                    return 3;//FIN PREPARACION
//                }
//            }
//        }
//    }
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
    

