/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import clases.ConvocatoriaExamen;
import modelo.DaoImplementacionFich;

/**
 *
 * @author Diego, Adrian, Ander
 */
public class menu {

    public static void menu(controlador controlador) {
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

    private static void menu() {
        System.out.println("1.Crear una unidad didactica.\n" + "2.Create a formulation.\n" + "3.Consult a formulation.\n" + "4.Show a formulation.\n" + "5.Create a Convocatory.\n" + "6.Show a convocatory.\n" + "7.Exit.");
    }

    private static void createDidacticUnity(controlador controlador) {

    }

    private static void createFormulation(controlador controlador) {

    }

    private static void consultFormulation(controlador controlador) {

    }

    private static void showFormulation(controlador controlador) {

    }

    private static void createConvocatory(controlador controlador) {
        ConvocatoriaExamen covoy = new ConvocatoriaExamen();
        covoy.setDatosConvocatoriaExamen();
    }

    private static void consultConvocatory(controlador controlador) {

    }

}
