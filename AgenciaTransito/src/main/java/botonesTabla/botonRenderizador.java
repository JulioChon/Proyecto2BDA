/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package botonesTabla;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author julio
 */
public class botonRenderizador implements TableCellRenderer {

    private JButton boton;

    public botonRenderizador() {
        boton = new JButton();
        boton.setText("Seleccionar");
        boton.setBackground(Color.WHITE);
        boton.setForeground(Color.BLACK);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return boton;
    }

}
