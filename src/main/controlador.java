/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import clases.ConvocatoriaExamen;
import clases.UnidadDidactica;
import modelo.DAO;
import modelo.FactoriaDAO;

/**
 *
 * @author Ander
 */
public class controlador {

    private DAO daoBD = FactoriaDAO.getImplementacionBD();
    private DAO daoFich = FactoriaDAO.getImplementacionFich();

    private static void createDidacticUnity(UnidadDidactica unidad) {

    }

    private static void createFormulation() {

    }

    private static void consultFormulation() {

    }

    private static void showFormulation() {

    }

    private void createConvocatory() {
        ConvocatoriaExamen covoy;
        covoy = new ConvocatoriaExamen();
        daoFich.createConvocatory(covoy);
    }

    private static void consultConvocatory() {

    }
}

