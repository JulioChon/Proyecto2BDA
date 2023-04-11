/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.plantillapantallasproyecto2basedatosavanzadas;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import org.itson.DAO.VehiculosDAO;
import org.itson.dominio.Automovil;
import org.itson.dominio.Persona;
import org.itson.dominio.Placa;
import org.itson.dominio.Vehiculo;
import utilidades.Validaciones;
import utilidades.Ventana;

/**
 *
 * @author Zaurus
 */
public class RegistrarVehiculo extends javax.swing.JFrame {
    private Ventana ventanaSiguiente;
    /**
     * Creates new form TramiteLicencia
     */
    public RegistrarVehiculo(Ventana ventanaSiguiente) {
        this.ventanaSiguiente = ventanaSiguiente;
        initComponents();
        
        this.setVisible(true);
        
    }
    public boolean acreeditarCampos()
    {
        
        if(Validaciones.validaCampoTexto(txtSerie.getText()) && Validaciones.validaCampoTexto(txtMarca.getText()) && Validaciones.validaCampoTexto(txtLinea.getText()) &&  Validaciones.validaCampoTexto(txtColor.getText())
                &&  Validaciones.validaCampoTexto(txtModelo.getText())&& new VehiculosDAO().buscarVehiculo(txtSerie.getText()).isEmpty())
        {
         return true;
        } else {
            String mensaje = "Campo(s) invalido(s) [Formato(s) valido(s)]\n";
            if (!Validaciones.validaCampoTexto(txtSerie.getText())) {
                mensaje +=   "- Serie del vehiculo   [ABC-123]\n";
            }
            if (!Validaciones.validaCampoTexto(txtMarca.getText())) {
                mensaje +=   "- Marca del vehiculo   [Honda]\n";
            }
            if (!Validaciones.validaCampoTexto(txtLinea.getText())) {
                mensaje +=   "- Linea del vehiculo   [Civic]\n";
            }
            if (!Validaciones.validaCampoTexto(txtColor.getText())) {
                mensaje +=   "- Color del vehiculo   [Negro]\n";
            }
            if (!Validaciones.validaCampoTexto(txtModelo.getText())) {
                mensaje +=   "- Modelo del vehiculo  [2003]\n";
            }
            if (! new VehiculosDAO().buscarVehiculo(txtSerie.getText()).isEmpty()) {
                mensaje +=   "- El vehiculo ya esta registrado\n";
            }
            JOptionPane.showMessageDialog(this, mensaje);
            return false;
        }
        
    
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        lblSerie = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        lblMarca = new javax.swing.JLabel();
        txtLinea = new javax.swing.JTextField();
        lblLinea = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        lblColor = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtModelo = new javax.swing.JTextField();
        lblModelo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(564, 564));

        lblSerie.setBackground(new java.awt.Color(204, 204, 0));
        lblSerie.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lblSerie.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSerie.setText("Serie");

        txtSerie.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        txtMarca.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        lblMarca.setBackground(new java.awt.Color(204, 204, 0));
        lblMarca.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lblMarca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMarca.setText("Marca");

        txtLinea.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        lblLinea.setBackground(new java.awt.Color(204, 204, 0));
        lblLinea.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lblLinea.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLinea.setText("Linea");

        txtColor.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        lblColor.setBackground(new java.awt.Color(204, 204, 0));
        lblColor.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lblColor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblColor.setText("Color");

        jPanel2.setBackground(new java.awt.Color(0, 51, 0));

        jLabel1.setBackground(new java.awt.Color(0, 51, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registrar Vehiculo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnAceptar.setBackground(new java.awt.Color(153, 0, 51));
        btnAceptar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(153, 0, 51));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtModelo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        lblModelo.setBackground(new java.awt.Color(204, 204, 0));
        lblModelo.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lblModelo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblModelo.setText("Modelo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtModelo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSerie))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMarca))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLinea))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblColor, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtColor)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSerie, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                    .addComponent(txtSerie))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                    .addComponent(txtMarca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLinea, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                    .addComponent(txtLinea))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblColor, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                    .addComponent(txtColor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblModelo, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                    .addComponent(txtModelo))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if(acreeditarCampos() )
        {
            
            Automovil automovil = new Automovil(txtSerie.getText(), txtColor.getText(), txtLinea.getText(), txtMarca.getText(), txtModelo.getText());
            
            new VehiculosDAO().registrarAutomovil(automovil);
            if(ventanaSiguiente == Ventana.TRAMITEPLACAS)
            {
                
                new BusquedaPersona(ventanaSiguiente);
                this.dispose();
            }
            if(ventanaSiguiente == Ventana.MENU)
            {
                
                new MenuInicio();
                this.dispose();
            }
        }
        
        
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if(ventanaSiguiente == Ventana.TRAMITEPLACAS)
            {
                
                new BusquedaPersona(ventanaSiguiente);
                this.dispose();
            }
            if(ventanaSiguiente == Ventana.MENU)
            {
                
                new MenuInicio();
                this.dispose();
            }
    }//GEN-LAST:event_btnCancelarActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblLinea;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblSerie;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtLinea;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtSerie;
    // End of variables declaration//GEN-END:variables
}
