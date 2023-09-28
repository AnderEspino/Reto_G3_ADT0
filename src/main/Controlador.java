/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

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
 *
 * @author Ander
 */
public class Controlador {

    private DAO daoBD = FactoriaDAO.getImplementacionBD();
    private DAO daoFich = FactoriaDAO.getImplementacionFich();

    public void createDidacticUnity(UnidadDidactica unidad) {
        daoBD.createDidaticUnity(unidad);
    }

    public void createFormulation(Enunciado enun) {
        daoBD.createFormulation(enun);

    }

    public void consultFormulation(int id) throws FormulationDoesNoExistException {
        daoBD.consultFormulation(id);
    }

    public void showFormulation(int id) {
        Enunciado enun = new Enunciado();
        daoBD.showFormulation(id);
         enun = daoBD.showFormulation(id);
         try {
             File file = new File (enun.getRuta());
             Desktop.getDesktop().open(file);
         } catch (IOException e) {
             e.printStackTrace();
         } 
    }

    public void createConvocatory(ConvocatoriaExamen covoy) {
        daoFich.createConvocatory(covoy);
    }

    public void consultConvocatory(int id) {
        daoFich.consultConvocatory(id);
    }
    
   
        
}

