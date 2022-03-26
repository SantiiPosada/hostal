/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author santiago.posada
 */
public class Cama {
    
    private Huesped huesped;

    public Cama() {
        
    }

    public Cama(Huesped huesped) {
        this.huesped = huesped;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }  

    @Override
    public String toString() {
        return "Cama{" + "huesped=" + huesped + '}';
    }

  
    
    
    
    
}
