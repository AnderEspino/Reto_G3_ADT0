/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author Diego
 */
public class DataBaseNotOperativeException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Excepcion para comprobar si la base de datos está operativa o no
     * @param message
     */
    public DataBaseNotOperativeException(String message) {
        super(message);
    }
}
