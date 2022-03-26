/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladores.Controlador;
import excepciones.HabitacionLlenaExcepcion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelo.Cama;
import modelo.Habitacion;

/**
 *
 * @author 415pc9
 */
public class VentanaHabitaciones extends javax.swing.JFrame implements ActionListener {

    private JButton[][] botones;
    private Controlador controlador;

    /**
     * Creates new form VistaHabitaciones
     */
    public VentanaHabitaciones() {
        initComponents();
        setLocationRelativeTo(this);
        botones = new JButton[4][3];
        controlador = new Controlador();
        cargarBotones();
        validarPosiciones();
    }

    public Controlador getControlador() {
        return controlador;
    }
    
    private void cargarBotones() {
        
        controlador.cargarBotones(botones, panelHabitaciones, this);
     
    }

    @Override
    public void actionPerformed(ActionEvent ae
    ) {
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[i].length; j++) {

                //mandar si se puede este  if al controlador, se podria retornar un String para mostrar el jopt de la linea 134
                if (ae.getSource().equals(botones[i][j])) {
                    Habitacion habitacion = controlador.obtenerHabitacion(i, j);
                    int peticion = JOptionPane.showConfirmDialog(null, " 'Si' para guardar un nuevo cliente \n 'No' para consultar la información de la habitación \n 'Cancelar' ninguna de las anteriores");

                    switch (peticion) {
                        case 0:
                            try {
                                controlador.validarDisponibilidad(habitacion);

                                VentanaHuesped ventana = new VentanaHuesped(this, i, j);
                                ventana.setVisible(true);
                                this.dispose();

                            } catch (HabitacionLlenaExcepcion ex) {
                                JOptionPane.showMessageDialog(null, ex.getMessage());
                            }


                            /*
                              
                              
                              
                              
                            if (habitacion.getEstado().equals(Habitacion.OCUPADO)) {
                                try {
                                    throw new HabitacionLlenaExcepcion();
                                } catch (HabitacionLlenaExcepcion ex) {
                                    JOptionPane.showMessageDialog(null, ex.getMessage());
                                }
                            } else {
                                VentanaHuesped ventana = new VentanaHuesped(this, i, j);
                                ventana.setVisible(true);
                                this.dispose();
                            }
                            
                             */
                            break;
                        case 1:
                            String mensaje = "\nTotal Camas: " + habitacion.getCamas().length
                                    + "\nTotal Camas Ocupadas: " + controlador.TotalCamasOcupadas(habitacion.getCamas())
                                    + "\nTotal Camas Disponibles: " + controlador.TotalCamasDisponibles(habitacion.getCamas())
                                    + "\n -----------------------------";

                            Cama[] cama = habitacion.getCamas();
                            for (int k = 0; k < cama.length; k++) {

                                if (cama[k] != null) {
                                    if (cama[k] != null) {
                                        mensaje += "\nHuesped Número : " + (k + 1)
                                                + "\nNombre: " + cama[k].getHuesped().getNombre()
                                                + "\nApellido: " + cama[k].getHuesped().getApellido()
                                                + "\nCedula: " + cama[k].getHuesped().getCedula()
                                                + "\nEdad: " + cama[k].getHuesped().getEdad()
                                                + "\nTelefono: " + cama[k].getHuesped().getTelefono()
                                                + "\nGenero: " + cama[k].getHuesped().getGenero()
                                                + "\n -----------------------------";

                                    }
                                }
                            }

                            JOptionPane.showMessageDialog(null, mensaje);

                            break;
                    }
                }
            }
        }
    }

    public void validarPosiciones() {
      
        botones = controlador.validarPosicionesButtons(botones);
       
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHabitaciones = new javax.swing.JPanel();
        btnPrueba = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelHabitaciones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "HABITACIONES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        javax.swing.GroupLayout panelHabitacionesLayout = new javax.swing.GroupLayout(panelHabitaciones);
        panelHabitaciones.setLayout(panelHabitacionesLayout);
        panelHabitacionesLayout.setHorizontalGroup(
            panelHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 436, Short.MAX_VALUE)
        );
        panelHabitacionesLayout.setVerticalGroup(
            panelHabitacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 179, Short.MAX_VALUE)
        );

        btnPrueba.setText("Prueba");
        btnPrueba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPruebaActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelHabitaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(btnPrueba)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelHabitaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrueba)
                    .addComponent(btnSalir))
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPruebaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPruebaActionPerformed
        this.controlador.pruebaCreacionHabitaciones();
    }//GEN-LAST:event_btnPruebaActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaHabitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaHabitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaHabitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaHabitaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaHabitaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrueba;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel panelHabitaciones;
    // End of variables declaration//GEN-END:variables

}
