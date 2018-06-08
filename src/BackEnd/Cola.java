/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.util.LinkedList;

/**
 *
 * @author matia
 */
public class Cola {
    private int cola;

    public Cola() {
        cola = 0;
    }
    
    public boolean estaVacia(){
        if(cola==0){
            return true;
        }
        return false;
    }
    
    public void agregar(){
        cola++;
    }
    
    public void avanzar(){
         cola--;
    }
    
    public int genteEnCola(){
        return cola;
    }
    
 
}
