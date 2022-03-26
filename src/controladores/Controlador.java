/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import excepciones.HabitacionEstadoExcepcion;
import excepciones.HabitacionLlenaExcepcion;
import java.awt.Color;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JPanel;
import modelo.Cama;
import modelo.Habitacion;
import modelo.Huesped;
import vistas.VentanaHabitaciones;

/**
 *
 * @author 415pc9
 */
public class Controlador {

    Habitacion[][] habitaciones;

    public Controlador() {
        habitaciones = new Habitacion[4][3];
        initHabitaciones();
    }

    private void initHabitaciones() {
        for (int i = 0; i < habitaciones.length; i++) {
            for (int j = 0; j < habitaciones[i].length; j++) {
                habitaciones[i][j] = new Habitacion();
            }
        }
    }

    public void agregarHuesped(Huesped huesped, int fila, int columna) throws HabitacionLlenaExcepcion, HabitacionEstadoExcepcion {

        Cama[] cama = habitaciones[fila][columna].getCamas();

        Boolean condicion = false;
        for (int i = 0; i < cama.length; i++) {
            if (cama[i] == null) {

                cama[i] = new Cama(huesped);
                condicion = true;
                break;

            }
        }

        if (condicion == false) {
            throw new HabitacionLlenaExcepcion();
        }

        habitaciones[fila][columna].setCamas(cama);

        habitaciones[fila][columna].setEstado(asignarEstado(cama));
    }

    private String asignarEstado(Cama[] cama) throws HabitacionEstadoExcepcion {
        int camasDisponibles = cama.length;
        int camasOpcupadas = 0;
        for (int i = 0; i < cama.length; i++) {

            if (cama[i] != null) {

                camasOpcupadas++;

            }

        }

        int resultado = camasDisponibles - camasOpcupadas;

        if (resultado == camasDisponibles) {
            return Habitacion.DISPONIBLE;
        } else if (resultado == 0) {
            return Habitacion.OCUPADO;
        } else if (resultado > 0 && resultado < camasDisponibles) {
            return Habitacion.SEMIFULL;
        } else {
            throw new HabitacionEstadoExcepcion();
        }

    }

    public Habitacion obtenerHabitacion(int fila, int columna) {
        return habitaciones[fila][columna];
    }

    public void validarDisponibilidad(Habitacion habitasao) throws HabitacionLlenaExcepcion {
        if (habitasao.getEstado().equals(Habitacion.OCUPADO)) {
            throw new HabitacionLlenaExcepcion();
        }
    }

    public int TotalCamasDisponibles(Cama[] camas) {
        int contador = 0;

        for (int i = 0; i < camas.length; i++) {
            if (camas[i] == null) {
                contador++;
            }
        }

        return contador;
    }

    public int TotalCamasOcupadas(Cama[] camas) {
        int contador = 0;

        for (int i = 0; i < camas.length; i++) {
            if (camas[i] != null) {
                contador++;
            }
        }

        return contador;
    }

    public void pruebaCreacionHabitaciones() {

        for (int i = 0; i < habitaciones.length; i++) {//numero de filas
            for (int j = 0; j < habitaciones[i].length; j++) {//numero de columnas
                System.out.print(" [" + habitaciones[i][j].getEstado() + " ," + Arrays.toString(habitaciones[i][j].getCamas()) + "] ----");
            }
            System.out.println("");
        }
        System.out.println("----------------------------------------------");

    }

    public JButton[][] validarPosicionesButtons(JButton[][] botones) {

        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[i].length; j++) {
                Habitacion habitacion = obtenerHabitacion(i, j);
                switch (habitacion.getEstado()) {
                    case Habitacion.DISPONIBLE:
                        botones[i][j].setBackground(Color.white);
                        break;
                    case Habitacion.SEMIFULL:
                        botones[i][j].setBackground(Color.yellow);
                        break;
                    default:
                        botones[i][j].setBackground(Color.blue);
                        break;
                }
            }
        }

        return botones;

    }
    
    
    
      public  JButton[][] cargarBotones(JButton[][] botones,JPanel panelHabitaciones,VentanaHabitaciones ventana) {
        
        int ancho = 60;
        int alto = 40;
        int separado = 20;
        int numeroBoton = 1;
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[i].length; j++) {

                botones[i][j] = new JButton();
                botones[i][j].setBounds(
                        (j * ancho + separado),
                        (i * alto + separado),
                        ancho, alto);
                botones[i][j].setText(String.valueOf(numeroBoton));
                botones[i][j].addActionListener(ventana);
                panelHabitaciones.add(botones[i][j]);
                numeroBoton++;
            }
        }
          
        return botones;
          
      }

}
