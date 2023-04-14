/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.plantillapantallasproyecto2basedatosavanzadas;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.itson.DAO.ParametrosReportes;
import org.itson.DAO.TramitesDAO;
import org.itson.dominio.Persona;
import org.itson.dominio.Tramite;
import utilidades.ReporteDTO;
import utilidades.TipoTramite;

/**
 *
 * @author Julio Chon, Luis Ayon
 */
public class GenerarReporte extends javax.swing.JFrame {
    private Persona persona;
    private String nombre;
    private ParametrosReportes params;
    private List<Tramite> listaTramites;
    /**
     * Constructor que inicializa los parametros del formulario.
     */
    public GenerarReporte() {
        
        initComponents();
        this.setVisible(true);
    }
    /**
     * Metodo que recopila en la variable params los parametros necesarios,
     * utilizandos en la generacion del reporte.
     */
        public void extraerDatos() {
        params = new ParametrosReportes();
        if (!txtNombre.getText().isEmpty()) {
            params.setNombre(txtNombre.getText()); 

        }
        if(!cbPlacas.isSelected() && !cbLicencias.isSelected())
        {
            params.setTipoTramite(TipoTramite.PlacasLicencias);
        }else
        if(cbPlacas.isSelected() && cbLicencias.isSelected())
        {
            params.setTipoTramite(TipoTramite.PlacasLicencias);
        }else
        if (cbPlacas.isSelected()) {
            params.setTipoTramite(TipoTramite.Placas);
        }else
        {
            params.setTipoTramite(TipoTramite.Licencias);
        }

        if (dtInicio.getDate() != null) 
        {
            LocalDate seleccion = dtInicio.getDate();
            Calendar date = new GregorianCalendar(dtInicio.getDate().getYear(),
            dtInicio.getDate().getMonthValue() - 1, dtInicio.getDate().getDayOfMonth());
            params.setFechaInicio(date);
        }
        if (dtFin.getDate() != null) 
        {
            LocalDate seleccion = dtFin.getDate();
            Calendar date = new GregorianCalendar(dtFin.getDate().getYear(),
            dtFin.getDate().getMonthValue() - 1, dtFin.getDate().getDayOfMonth());
            params.setFechaFin(date);
        }
        
    }
        /**
         * Metodo que llena la tabla de previsualizacion de tramites.
         */
        public void llenarTabla(){
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblPrevisualizacion.getModel();
        modeloTabla.setRowCount(0);
        for (Tramite tramite : listaTramites) {
            Object[] fila = {
                tramite.getId(),
                tramite.getTipoTramite(),
                tramite.getEstado(),
                formateador.format(tramite.getFechaExpedicion().getTime()),
                formateador.format(tramite.getVigencia().getTime()) 
            };
            modeloTabla.addRow(fila);
        }
        
    }
        /**
         * Metodo que imprime el reporte mandando a llamar el archivo de jasper reports ReporteTramite.jasper.
         */
        public void imprimirReporte()
        {
            SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
            ArrayList listaReporte = new ArrayList();
            for(int i = 0;i<listaTramites.size(); i++)
            {
                listaReporte.add(new ReporteDTO(listaTramites.get(i).getTipoTramite().toString(),
                        listaTramites.get(i).getEstado().toString() , formateador.format(listaTramites.get(i).getFechaExpedicion().getTime()), 
                        listaTramites.get(i).getPersona().getNombre()+" "+listaTramites.get(i).getPersona().getApellidoMaterno()+" "+listaTramites.get(i).getPersona().getApellidoPaterno(),
                        formateador.format(listaTramites.get(i).getVigencia().getTime()),"$ "+listaTramites.get(i).getCosto()));
            }
            JasperReport jr = null;
            try{
                jr = (JasperReport) JRLoader.loadObjectFromFile("ReporteTramite.jasper");
                HashMap parametro = new HashMap();
                JasperPrint jp = JasperFillManager.fillReport(jr, parametro,new JRBeanCollectionDataSource(listaReporte));
                JasperViewer jv = new JasperViewer(jp,false);
                jv.setVisible(true);
            } catch (JRException ex) {
            Logger.getLogger(GenerarReporte.class.getName()).log(Level.SEVERE, null, ex);
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

        btgTramite = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        dtInicio = new com.github.lgooddatepicker.components.DatePicker();
        dtFin = new com.github.lgooddatepicker.components.DatePicker();
        cbPlacas = new javax.swing.JCheckBox();
        cbLicencias = new javax.swing.JCheckBox();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPrevisualizacion = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(564, 564));

        jPanel2.setBackground(new java.awt.Color(0, 51, 0));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Generar Reporte");
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));

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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 51, 0));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tipo de tramite");
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(0, 51, 0));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Busqueda por nombre");
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Nombre");
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(txtNombre))
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(0, 51, 0));
        jPanel7.setForeground(new java.awt.Color(255, 255, 255));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Periodo de tiempo");
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Inicio");
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Fin");
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel13)
                .addGap(39, 39, 39)
                .addComponent(dtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addGap(31, 31, 31)
                .addComponent(dtFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtFin, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 4, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(dtInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        cbPlacas.setText("Placas");
        cbPlacas.setBackground(new java.awt.Color(153, 0, 51));
        cbPlacas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cbPlacas.setBorderPainted(true);
        cbPlacas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbPlacas.setForeground(new java.awt.Color(255, 255, 255));
        cbPlacas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        cbLicencias.setText("Licencias");
        cbLicencias.setBackground(new java.awt.Color(153, 0, 51));
        cbLicencias.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cbLicencias.setBorderPainted(true);
        cbLicencias.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbLicencias.setForeground(new java.awt.Color(255, 255, 255));
        cbLicencias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addComponent(cbPlacas, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126)
                .addComponent(cbLicencias, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbPlacas, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(cbLicencias, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnAceptar.setText("Generar");
        btnAceptar.setBackground(new java.awt.Color(153, 0, 51));
        btnAceptar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setBackground(new java.awt.Color(153, 0, 51));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        tblPrevisualizacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Tramite", "Estado", "Fecha de Expidicion", "Fecha de Vigencia"
            }
        ));
        jScrollPane1.setViewportView(tblPrevisualizacion);

        btnActualizar.setText("Buscar");
        btnActualizar.setBackground(new java.awt.Color(153, 0, 51));
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(219, 219, 219))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 376, Short.MAX_VALUE)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(82, 82, 82)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(324, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 762, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Metodo oyente que extrae los datos de los parametros a buscar y manda a llamar al metodo
     * imprimirReporte().
     * @param evt evento recibido.
     */
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        extraerDatos();
            listaTramites = new TramitesDAO().buscar(params);
            llenarTabla();
        this.imprimirReporte();
        
    }//GEN-LAST:event_btnAceptarActionPerformed
    /**
     * Metodo oyente vuelve al menu prinicipal.
     * @param evt evento recibido.
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        new MenuInicio();
        this.dispose();
        
    }//GEN-LAST:event_btnCancelarActionPerformed
    /**
     * 
     * Metodo oyente que extrae los datos de los parametros a buscar y manda a llamar al metodo
     * llenarTabla().
     * @param evt evento recibido.
     */
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        extraerDatos();
            listaTramites = new TramitesDAO().buscar(params);
            llenarTabla();
        
    }//GEN-LAST:event_btnActualizarActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgTramite;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JCheckBox cbLicencias;
    private javax.swing.JCheckBox cbPlacas;
    private com.github.lgooddatepicker.components.DatePicker dtFin;
    private com.github.lgooddatepicker.components.DatePicker dtInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPrevisualizacion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
