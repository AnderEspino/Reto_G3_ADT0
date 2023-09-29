/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 * Factoria del DAO, crea implementaciones de base de datos o de ficheros
 * @author Diego
 */
public class FactoriaDAO {
    /**
     * Implementacion de base de datos
     * @return DaoImplementacionBD
     */
    public static DAO getImplementacionBD() {
        return new DaoImplementacionBD();
    }
    /**
     * Implementacion de fichero
     * @return DaoImplementacionFich()
     */
    public static DAO getImplementacionFich() {
        return new DaoImplementacionFich();
    }
}
