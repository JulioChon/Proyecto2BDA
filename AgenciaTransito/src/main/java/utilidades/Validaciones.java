/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Julio Chon, Luis Ayon
 */
public class Validaciones {


    /**
     * Método que valida un texto.
     * @param texto nombre a validar.
     * @return Verdadero o falso si se ha validado el nombre.
     */
    public static boolean validaCampoTexto(String texto){
        String patron = "^[\\s\\S]{1,20}$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(texto);
        if(matcher.matches()){
            return true;
        }
        return false;
    }
     /**
     * Método que valida un texto.
     * @param texto nombre a validar.
     * @return Verdadero o falso si se ha validado el nombre.
     */
    public static boolean validaCampoLetras(String texto){
        String patron = "^[a-zA-Z]{1,20}$";
        Pattern p = Pattern.compile(patron);
        Matcher matcher = p.matcher(texto);
        if(matcher.matches()){
            return true;
        }
        return false;
    }
 
}
