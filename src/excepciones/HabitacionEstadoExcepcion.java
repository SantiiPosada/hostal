/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author 415pc9
 */
public class HabitacionEstadoExcepcion extends Exception{
    public HabitacionEstadoExcepcion(){
        super("Error interno al asignarle el estado a la habitacón");
    }
}
