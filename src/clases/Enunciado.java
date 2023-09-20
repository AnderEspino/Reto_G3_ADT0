/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 2dam
 */
public class Enunciado {

    private Dificultad nivel;
    private int id;
    private String descripcion;
    private boolean disponible;
    private String ruta;
    private List<UnidadDidactica> UnidadDidactica;
    private List<ConvocatoriaExamen> convocatorias;

    public Enunciado() {

    }

    public Dificultad getNivel() {
        return nivel;
    }

    public void setNivel(Dificultad nivel) {
        this.nivel = nivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public List<UnidadDidactica> getUnidadDidactica() {
        return UnidadDidactica;
    }

    public void setUnidadDidactica(List<UnidadDidactica> UnidadDidactica) {
        this.UnidadDidactica = UnidadDidactica;
    }

    public List<ConvocatoriaExamen> getConvocatorias() {
        return convocatorias;
    }

    public void setConvocatorias(List<ConvocatoriaExamen> convocatorias) {
        this.convocatorias = convocatorias;
    }

    public void setDatosEnunciado() {
        id = utilidades.Utilidades.leerInt("Introduce el ID: ");
        descripcion = utilidades.Utilidades.introducirCadena("Introduce una descripcion: ");
        disponible = utilidades.Utilidades.esBoolean("¿Esta disponible?(S/N)");
        nivel = aplicarDificultad();
        ruta = utilidades.Utilidades.introducirCadena("Introduce la ruta: ");
        convocatorias = introducirConvocatorias();

    }

    public void getDatosEnunciado() {
        System.out.println("ID: " + id + "\nDescripcion: " + descripcion + "\nDisponible: " + disponible + "\nRuta: " + ruta + "\nUnidad Didactica: " + UnidadDidactica + "\nConvocatorias: " + recorrerConvocatorias());
    }

    private List<ConvocatoriaExamen> introducirConvocatorias() {
        convocatorias = new ArrayList<>();
        ConvocatoriaExamen convocatoria;
        boolean seguir;

        do {
            convocatoria = new ConvocatoriaExamen();
            //setdatos
            convocatorias.add(convocatoria);
            seguir = utilidades.Utilidades.esBoolean("¿Deseas seguir introduciendo convocatorias?(S/N)");
        } while (seguir);
        return convocatorias;
    }

    public List<ConvocatoriaExamen> recorrerConvocatorias() {
        for (int i = 0; i < 0; i++) {
            convocatorias.get(i).getConvocatoria();
        }
        return convocatorias;
    }

    private Dificultad aplicarDificultad() {
        int opc;
        Dificultad difi = null;

        switch (opc = utilidades.Utilidades.leerInt("Introduce una opcion: \n ALTA \n MEDIA \n BAJA")) {
            case 1:
                difi = Dificultad.ALTA;
                break;
            case 2:
                difi = Dificultad.MEDIA;
                break;
            case 3:
                difi = Dificultad.BAJA;
                break;
        }
        return difi;
    }

}
