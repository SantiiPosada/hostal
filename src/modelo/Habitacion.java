/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author 415pc9
 */
public class Habitacion {
    
    public static final String DISPONIBLE = "Disponible";
    public static final String SEMIFULL = "Semifull";
    public static final String OCUPADO = "Ocupado";
    
    private String estado;
    private Cama [] camas;

    public Habitacion() {
        this.estado = DISPONIBLE;
        this.camas = new Cama[generarNumeroAleatorio()];
        
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

  

    public Cama[] getCamas() {
        return camas;
    }

    public void setCamas(Cama[] camas) {
        this.camas = camas;
    }
    
    
    
    private int generarNumeroAleatorio(){
  
        Random random = new Random();
        return random.nextInt(3 + 1 - 1) + 1; //(max+1-min)+min;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "cama=" + Arrays.toString(camas) + '}';
    }
    
    
    

   
    
    
}
