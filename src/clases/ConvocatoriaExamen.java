/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Se trata de la clase convocatoria
 *
 * @author Ander, Diego, Adrian
 */
public class ConvocatoriaExamen implements Serializable {

    private String convocatoria;
    private String descripcion;
    private LocalDate fecha;
    private String curso;
    private int enunciado;

    //Getters y setters 
    public ConvocatoriaExamen() {

    }

    public String getConvocatoria() {
        return convocatoria;
    }

    public void setConvocatoria(String convocatoria) {
        this.convocatoria = convocatoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(int enunciado) {
        this.enunciado = enunciado;
    }

    /**
     * Metodo setdatos para introducir Convocatorias
     * @param enun
     */
    public void setDatosConvocatoriaExamen(int enun) {
        convocatoria = utilidades.Utilidades.introducirCadena("Introduce la convocatoria: ");
        descripcion = utilidades.Utilidades.introducirCadena("Introduce la descripcion: ");
        fecha = utilidades.Utilidades.leerFecha("Introduce la fecha del examen: ");
        curso = utilidades.Utilidades.introducirCadena("Introduce el curso: ");
        enunciado = enun;
    }
    /**
     * Metodo Para mostrar los datos de la convocatoria
     */
    public void getDatosConvocatoriaExamen() {
        System.out.println("Convocatoria: "+ convocatoria + "\nDesctripcion: "+ descripcion + "\nFecha: "+ fecha + "\nCurso: "+ curso + "\nID del Enunciado: "+enunciado+"\n");
    }
    
    
}
