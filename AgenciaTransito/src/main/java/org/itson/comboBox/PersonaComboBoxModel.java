/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.comboBox;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import org.itson.dominio.Persona;

/**
 *
 * @author julio
 */
public class PersonaComboBoxModel  extends AbstractListModel<Persona> implements ComboBoxModel<Persona> {

    private List<Persona> persona;
   
    private Persona personaSeleccionada;
    
    public PersonaComboBoxModel(List<Persona> persona) {
        this.persona=persona;
    }
   
    @Override
    public int getSize() {
        return persona.size();
    }
    
    @Override
    public Persona getElementAt(int index) {
        return persona.get(index);
    }
    
    @Override
    public void setSelectedItem(Object item) {
        personaSeleccionada = (Persona) item;
    }
   
    @Override
    public Object getSelectedItem() {
        return personaSeleccionada;
    }
}
    

