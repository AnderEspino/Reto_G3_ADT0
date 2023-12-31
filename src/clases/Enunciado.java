/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Se trata de la clase Enunciado
 *
 * @author Ander, Diego, Adrian
 */
public class Enunciado implements Serializable{

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

    /**
     * Metodo setDatos para introducir Enunciados
     */
    public void setDatosEnunciado() {
        id = utilidades.Utilidades.leerInt("Introduce el ID: ");
        descripcion = utilidades.Utilidades.introducirCadena("Introduce una descripcion: ");
        disponible = utilidades.Utilidades.esBoolean("¿Esta disponible?(S/N)");
        nivel = aplicarDificultad();
        ruta = utilidades.Utilidades.introducirCadena("Introduce la ruta: ");
        

    }
    /**
     * Metodo getDatos para introducir Enunciado
     */
    public void getDatosEnunciado() {
        System.out.println("ID: " + id + "\nDescripcion: " + descripcion + "\nDisponible: " + disponible + "\nRuta: " + ruta + "\nNivel: " + nivel/* + "\nUnidad Didactica: " + UnidadDidactica + "\nConvocatorias: " + recorrerConvocatorias()*/);
    }
    
    /**
     * Metodo aplicarDificultad para introducir una dificultad al enunciado
     * @param enun
     */
    private Dificultad aplicarDificultad() {
        this.nivel = nivel;
        
        Integer[] niveles = {1, 2, 3};
        
        Integer opc = utilidades.Utilidades.leerInt("Introduce una opcion: \n ALTA \n MEDIA \n BAJA");
        switch(opc){
            case 1:
               this.nivel = nivel.ALTA;
               
            break;
            case 2:
                this.nivel = nivel.MEDIA;
                
            break;
            case 3:
                this.nivel = nivel.BAJA;
                
            break;
            
        }
        return nivel;

    }

}
