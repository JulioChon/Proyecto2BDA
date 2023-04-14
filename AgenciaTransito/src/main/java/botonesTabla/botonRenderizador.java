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
 * @author Julio Chon, Luis Ayon
 */
public class botonRenderizador implements TableCellRenderer {

    private JButton boton;

    /**
     *
     * Constructor de la clase botonRenderizador que inicializa un objeto
     * JButton con el texto "Seleccionar", fondo blanco y letra negra.
     */
    public botonRenderizador() {
        boton = new JButton();
        boton.setText("Seleccionar");
        boton.setBackground(Color.WHITE);
        boton.setForeground(Color.BLACK);
    }

    /**
     *
     * Método que se llama automáticamente para obtener el componente que se
     * usará para renderizar una celda de una tabla con un botón. Retorna el
     * objeto JButton inicializado en el constructor.
     *
     * @param table la tabla donde se encuentra la celda
     * @param value el valor del objeto de la celda
     * @param isSelected true si la celda está seleccionada
     * @param hasFocus true si la celda tiene el foco
     * @param row el número de fila de la celda
     * @param column el número de columna de la celda
     * @return el componente JButton para renderizar la celda
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return boton;
    }

}
