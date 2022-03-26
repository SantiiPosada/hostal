/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import excepciones.HuespedCedulaExcepcion;
import modelo.Cama;
import modelo.Habitacion;
import modelo.Huesped;

/**
 *
 * @author 415pc9
 */
public class ControladorHuesped {

    private final ControladorHabitacion controladorHabitacion;
    private Huesped huesped;

   
    
    
    public ControladorHuesped(ControladorHabitacion controladorHabitacion) {
        this.controladorHabitacion = controladorHabitacion;
       
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }
    
    
    
    
    private void validarDatosCorrectos(){
        //validar datos correctos
    }

    public void validarInformación() throws HuespedCedulaExcepcion {
        
        
        validarDatosCorrectos();

        Habitacion[][] habitaciones = controladorHabitacion.habitaciones;

        for (int i = 0; i < habitaciones.length; i++) {
            for (int j = 0; j < habitaciones[i].length; j++) {

                Cama[] camas = habitaciones[i][j].getCamas();
                for (int k = 0; k < camas.length; k++) {
                    
                    if(camas[k]!=null){
                        
                        if(huesped.getCedula().equals(camas[k].getHuesped().getCedula())){
                            throw new HuespedCedulaExcepcion(huesped.getCedula());
                        }
                        
                        //resto de validaciones
                        
                        
                    }
                    
                }

            }
        }
    }

}
