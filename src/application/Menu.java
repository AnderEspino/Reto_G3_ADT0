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
import modelo.DaoImplementacionBD;
import modelo.DaoImplementacionFich;

/**
 * Menu
 *
 * @author Diego, Adrian, Ander
 */
public class Menu {

    /**
     * Menu de la aplicacionn con sus metodos correspondientes
     *
     * @param controlador
     * @throws excepciones.FormulationDoesNoExistException
     */
    public static void menu(Controlador controlador) throws FormulationDoesNoExistException {
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
        System.out.println("1.Crear unidad didactica.\n" + "2.Crear un enunciado.\n" + "3.Consultar enunciado.\n" + "4.Mostrar enunciado.\n" + "5.Crear convocatoria.\n" + "6.Enseñar convocatoria.\n" + "7.Salir.");
    }

    private static void createDidacticUnity(Controlador controlador) {
        UnidadDidactica uni = new UnidadDidactica();
        controlador.createDidacticUnity(uni);

    }

    private static void createFormulation(Controlador controlador) {
        Enunciado enun = new Enunciado();
        controlador.createFormulation(enun);

    }

    private static void consultFormulation(Controlador controlador) throws FormulationDoesNoExistException {
        int id = utilidades.Utilidades.leerInt("Introduce el id: ");
        controlador.consultFormulation(id);

    }

    private static void showFormulation(Controlador controlador) {
        int id = utilidades.Utilidades.leerInt("Introduce el id: ");
        controlador.showFormulation(id);

    }

    private static void createConvocatory(Controlador controlador) {
        ConvocatoriaExamen con = new ConvocatoriaExamen();
        int enun = utilidades.Utilidades.leerInt("Introduce el id del enunciado: ");
        con.setDatosConvocatoriaExamen(enun);
        controlador.createConvocatory(con);
    }

    private static void consultConvocatory(Controlador controlador) {
        int id = utilidades.Utilidades.leerInt("Introduce el id del enunciado que quieras visualizar: ");
        controlador.consultConvocatory(id);

    }

}

