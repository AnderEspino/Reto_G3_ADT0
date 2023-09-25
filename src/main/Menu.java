/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import clases.ConvocatoriaExamen;
import clases.Enunciado;
import clases.UnidadDidactica;
import modelo.DaoImplementacionBD;
import modelo.DaoImplementacionFich;

/**
 *
 * @author Diego, Adrian, Ander
 */
public class Menu {

    public static void menu(Controlador controlador) {
        Integer eleccion;

        do {
            menu();
            switch (eleccion = utilidades.Utilidades.leerInt("Introduce una opcion: ")) {
                case 1:
                    createDidacticUnity(controlador);
                    break;
                case 2:
                    createFormulation(controlador);
                    break;
                case 3:
                    consultFormulation(controlador);
                    break;
                case 4:
                    showFormulation(controlador);
                    break;
                case 5:
                    createConvocatory(controlador);
                    break;
                case 6:
                    consultConvocatory(controlador);
                    break;
                case 7:
                    System.out.println("El programa ha finalizado!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Esa opcion no es posible!");
            }
        } while (eleccion != 7);
    }

    public static void menu() {
        System.out.println("1.Create a Didactic Unity.\n" + "2.Create a formulation.\n" + "3.Consult a formulation.\n" + "4.Show a formulation.\n" + "5.Create a Convocatory.\n" + "6.Show a convocatory.\n" + "7.Exit.");
    }

    private static void createDidacticUnity(Controlador controlador) {
        DaoImplementacionBD daoBd = new DaoImplementacionBD();
        UnidadDidactica uni = new UnidadDidactica();
        daoBd.createDidaticUnity(uni);
    }

    private static void createFormulation(Controlador controlador) {
        DaoImplementacionBD daoBd = new DaoImplementacionBD();
        Enunciado enun = new Enunciado();
        daoBd.createFormulation(enun);
    }

    private static void consultFormulation(Controlador controlador) {
        DaoImplementacionBD daoBd = new DaoImplementacionBD();
        int id = utilidades.Utilidades.leerInt("Introduce el id: ");
        daoBd.consultFormulation(id);
    }

    private static void showFormulation(Controlador controlador) {
        DaoImplementacionBD daoBd = new DaoImplementacionBD();
        int id = utilidades.Utilidades.leerInt("Introduce el id: ");
        daoBd.showFormulation(id);
    }

    private static void createConvocatory(Controlador controlador) {
        ConvocatoriaExamen con = new ConvocatoriaExamen();
        DaoImplementacionFich daofich = new DaoImplementacionFich();
        int enun = utilidades.Utilidades.leerInt("Introduce el id del enunciado: ");
        int existe = con.existeEnun();
        do {
            con.setDatosConvocatoriaExamen(enun);
           
        } while (existe != enun);
        controlador.createConvocatory(con);

    }

    private static void consultConvocatory(Controlador controlador) {
        controlador.consultConvocatory(0);

    }

}
