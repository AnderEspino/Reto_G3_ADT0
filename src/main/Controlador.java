/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import clases.ConvocatoriaExamen;
import clases.Enunciado;
import clases.UnidadDidactica;
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

    public void consultFormulation(int id) {
        daoBD.consultFormulation(id);
    }

    public void showFormulation(int id) {
        daoBD.showFormulation(id);
    }

    public void createConvocatory(ConvocatoriaExamen covoy) {
        daoFich.createConvocatory(covoy);
    }

    public void consultConvocatory(int id) {
        daoFich.consultConvocatory(id);
    }
}

