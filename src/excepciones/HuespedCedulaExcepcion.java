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
public class HuespedCedulaExcepcion extends Exception{
    public HuespedCedulaExcepcion(String cedula){
        super("La cedula "+cedula+" ya se encuentra registrada");
    }
}
