/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author 2dam
 */
public class FactoriaDAO {

    public static DAO getImplementacionBD() {
        return new DaoImplementacionBD();
    }

    public static DAO getImplementacionFich() {
        return new DaoImplementacionFich();
    }
}
