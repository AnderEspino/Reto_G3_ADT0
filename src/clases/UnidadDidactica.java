package clases;

import java.util.ArrayList;
import java.util.List;

/**
 * Se trata de la clase unidad didática
 *
 * @author Ander, Diego, Adrian
 */
public class UnidadDidactica {

    private int id;
    private String acronimo;
    private String titulo;
    private String evaluacion;
    private String descripcion;
    private List<Enunciado> enunciados;

    public UnidadDidactica() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAcronimo() {
        return acronimo;
    }

    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(String evaluacion) {
        this.evaluacion = evaluacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Enunciado> getEnunciados() {
        return enunciados;
    }

    public void setEnunciados(List<Enunciado> enunciados) {
        this.enunciados = enunciados;
    }

    /**
     * Metodo setdatos para introducir unidades
     */
    public void setDatosUnidad() {
        id = utilidades.Utilidades.leerInt("Introduce el ID: ");
        acronimo = utilidades.Utilidades.introducirCadena("Introduce el actronimo: ");
        titulo = utilidades.Utilidades.introducirCadena("Introduce el titulo: ");
        evaluacion = utilidades.Utilidades.introducirCadena("Introduce la evaluacion: ");
        descripcion = utilidades.Utilidades.introducirCadena("Introduce la descripcion: ");
        
    }
    /**
     * Metodo getdatos para introducir Convocatorias
     */
    public void getDatosUnidad() {
        System.out.println("ID:" + id
                + "\nAcronimo: " + acronimo + "\nTitulo: " + titulo + "\nEvaluacion: " + evaluacion + "\nDescripcion: " + descripcion );
    }

    
}
