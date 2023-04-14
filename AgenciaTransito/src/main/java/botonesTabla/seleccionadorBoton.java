/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package botonesTabla;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
/**
 * 
 * @author Julio Chon, Luis Ayon
 */
public class seleccionadorBoton extends AbstractCellEditor implements TableCellEditor {

    private JButton boton;

    /**
     *
     * Constructor de la clase. Crea un nuevo botón con el texto "Mi botón".
     */
    public seleccionadorBoton() {
        boton = new JButton("Mi botón");
    }

    /**
     *
     * Devuelve el valor actual de la celda editada. No se utiliza en este caso.
     *
     * @return null, ya que no se necesita devolver ningún valor.
     */
    @Override
    public Object getCellEditorValue() {
        return null;
    }

    /**
     *
     * Devuelve el componente que se utilizará para editar la celda. En este
     * caso, se devuelve el botón.
     *
     * @param table La tabla que contiene la celda a editar.
     * @param value El valor actual de la celda.
     * @param isSelected true si la celda está seleccionada, false en caso
     * contrario.
     * @param row El índice de la fila de la celda a editar.
     * @param column El índice de la columna de la celda a editar.
     * @return El componente que se utilizará para editar la celda.
     */
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        Object valor = table.getValueAt(row, column);
        return boton;
    }
}
