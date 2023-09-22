/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.time.LocalDate;

/**
 * Se trata de la clase convocatoria
 * @author Ander, Diego, Adrian
 */
public class ConvocatoriaExamen {

    private String convocatoria;
    private String descripcion;
    private LocalDate fecha;
    private String curso;
    private Enunciado enunciado;

    
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

    public Enunciado getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(Enunciado enunciado) {
        this.enunciado = enunciado;
    }
    
    public void setDatosConvocatoriaExamen() {
        convocatoria = utilidades.Utilidades.introducirCadena("Introduce la convocatoria: ");
        descripcion = utilidades.Utilidades.introducirCadena("Introduce la descripcion: ");
        fecha = utilidades.Utilidades.leerFecha("Introduce la fecha del examen: ");
        curso = utilidades.Utilidades.introducirCadena("Introduce el curso: ");
        enunciado = introducirEnunciado();
    }

    private Enunciado introducirEnunciado() {
        enunciado = new Enunciado();
        enunciado.setDatosEnunciado();
        return enunciado;
    }
    
      public void getDatosConvocatoriaExamen() {
          System.out.println("Convocatoria: " +"\nDesctripcion: "+"\nFecha: "+"\nCurso: "+"\nEnunciado: ");
    }
      
    
}
