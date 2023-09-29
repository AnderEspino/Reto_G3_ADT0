/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import clases.ConvocatoriaExamen;
import clases.Enunciado;
import clases.UnidadDidactica;
import excepciones.FormulationDoesNoExistException;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import modelo.DAO;
import modelo.FactoriaDAO;

/**
 * Controlador de la aplicaciÃ³n
 * @author Ander
 */
public class Controlador {

    private DAO daoBD = FactoriaDAO.getImplementacionBD();
    private DAO daoFich = FactoriaDAO.getImplementacionFich();

    /**
     * Crea una unidad didactica
     * @param unidad
     */
    public void createDidacticUnity(UnidadDidactica unidad) {
        daoBD.createDidaticUnity(unidad);
    }
    /**
     * Crea un enunciado
     * @param enun
     */
    public void createFormulation(Enunciado enun) {
        daoBD.createFormulation(enun);

    }
    /**
     * Comprueba un enunciado a pedir
     * @param id
     * @throws excepciones.FormulationDoesNoExistException
     */
    public void consultFormulation(int id) throws FormulationDoesNoExistException {
        daoBD.consultFormulation(id);
    }
    /**
     * Muestra los enunciados y abre el documento de la ruta especificada
     * @param id
     */
    public void showFormulation(int id) {
        Enunciado enun = new Enunciado();
        enun = daoBD.showFormulation(id);
         try {
             File file = new File (enun.getRuta());
             Desktop.getDesktop().open(file);
         } catch (IOException e) {
             e.printStackTrace();
         } 
    }
    /**
     * Crea una convocatoria
     * @param covoy
     */
    public void createConvocatory(ConvocatoriaExamen covoy) {
        daoFich.createConvocatory(covoy);
    }
    /**
     * Muestra una convocatoria
     * @param id
     */
    public void consultConvocatory(int id) {
        daoFich.consultConvocatory(id);
    }
    
   
        
}

