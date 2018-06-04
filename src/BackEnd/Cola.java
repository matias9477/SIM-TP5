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
    private LinkedList<Cliente> cola;

    public Cola() {
        cola = new LinkedList<Cliente>();
    }
    
    public boolean estaVacia(){
        return this.cola.isEmpty();
    }
    
    public void agregar(Cliente c){
        cola.addLast(c);
    }
    
    public Cliente avanzar(){
        return cola.removeFirst();
    }
    
    public int genteEnCola(){
        return cola.size();
    }
    
    public Cliente get(int index)
    {
        return cola.get(index);
    }
}
