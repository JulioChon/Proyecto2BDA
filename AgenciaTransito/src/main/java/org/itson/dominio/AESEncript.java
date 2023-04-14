/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
/**
 * 
 * @author Julio Chon, Luis Ayon
 */
@Converter
public class AESEncript implements AttributeConverter<String, String> {

    // Esta es la clave secreta que se utiliza para cifrar y descifrar valores.
    // Debería mantenerse en un lugar seguro y no estar en texto plano en el código.
    private static final String SECRET_KEY = "mi clave secreta";

    private static final String INIT_VECTOR = "RandomInitVector"; // Vector de inicialización

    private final IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes(StandardCharsets.UTF_8));

    private final SecretKeySpec secretKeySpec;

    /**
     *
     * Constructor de la clase AESEncript. La clave secreta se deriva de la
     * contraseña y se almacena como una instancia de SecretKeySpec. Se utiliza
     * el algoritmo SHA-1 para obtener la clave a partir de la contraseña. En
     * caso de que ocurra un error al obtener la clave, se lanza una excepción
     * RuntimeException.
     */
    public AESEncript() {
        try {
            byte[] key = (SECRET_KEY).getBytes("UTF-8");
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = java.util.Arrays.copyOf(key, 16);
            secretKeySpec = new SecretKeySpec(key, "AES");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * Método encargado de cifrar un valor utilizando el algoritmo
     * AES/CBC/PKCS5PADDING. Se utiliza la clave secreta y el vector de
     * inicialización para generar el cifrado. En caso de que ocurra un error al
     * cifrar el valor, se lanza una excepción RuntimeException.
     *
     * @param value valor a cifrar.
     * @return valor cifrado en Base64.
     */
    @Override
    public String convertToDatabaseColumn(String value) {
        if (value == null) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, iv);
            byte[] encrypted = cipher.doFinal(value.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * Método encargado de descifrar un valor cifrado en Base64 utilizando el
     * algoritmo AES/CBC/PKCS5PADDING. Se utiliza la clave secreta y el vector
     * de inicialización para generar el descifrado. En caso de que ocurra un
     * error al descifrar el valor, se lanza una excepción RuntimeException.
     *
     * @param encryptedValue valor cifrado en Base64.
     * @return valor descifrado.
     */
    @Override
    public String convertToEntityAttribute(String encryptedValue) {
        if (encryptedValue == null) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, iv);
            byte[] original = cipher.doFinal(Base64.getDecoder().decode(encryptedValue));
            return new String(original);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
