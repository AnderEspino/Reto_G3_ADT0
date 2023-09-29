/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import excepciones.FormulationDoesNoExistException;

/**
 * Clase con el método main
 *
 * @author Ander, Diego, Adrian
 */
public class Application {

    /**
     * Metodo main
     * @param args
     * @throws excepciones.FormulationDoesNoExistException
     */
    public static void main(String[] args) throws FormulationDoesNoExistException {
       Menu.menu(new Controlador());
    }
    
}
