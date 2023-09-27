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
 * @author Ander, Diego, Adrianssss
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

    public void setDatosConvocatoriaExamen(int enun) {
        convocatoria = utilidades.Utilidades.introducirCadena("Introduce la convocatoria: ");
        descripcion = utilidades.Utilidades.introducirCadena("Introduce la descripcion: ");
        fecha = utilidades.Utilidades.leerFecha("Introduce la fecha del examen: ");
        curso = utilidades.Utilidades.introducirCadena("Introduce el curso: ");
        enunciado = enun;
    }

    public void getDatosConvocatoriaExamen() {
        System.out.println("Convocatoria: "+ convocatoria + "\nDesctripcion: "+ descripcion + "\nFecha: "+ fecha + "\nCurso: "+ curso + "\nID del Enunciado: "+enunciado+"\n");
    }
    
    /*public int existeEnun() {
        DaoImplementacionBD daoBD = new DaoImplementacionBD();
        Enunciado enun;
        int id = 0;
        boolean crear = false;

        enun = (Enunciado) daoBD.consultFormulation(id);
        
        do {
            if (enun != null) {
                id = enun.getId();
            } else {

                System.out.println("No existe  ese enunciado!");
                if (crear = utilidades.Utilidades.esBoolean("¿Deseas crear un enunciado?(S/N)")) {
                    enun = new Enunciado();
                    enun.setDatosEnunciado();
                    daoBD.createFormulation(enun);

                } else {
                    System.out.println("Se ha cancelado el creado!");
                }
            }
        } while (enun == null);
        
        return id;
    }*/
}
