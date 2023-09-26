package clases;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego, Adrian, Ander 
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

    public void setDatosUnidad() {
        id = utilidades.Utilidades.leerInt("Introduce el ID: ");
        acronimo = utilidades.Utilidades.introducirCadena("Introduce el actronimo: ");
        titulo = utilidades.Utilidades.introducirCadena("Introduce el titulo: ");
        evaluacion = utilidades.Utilidades.introducirCadena("Introduce la evaluacion: ");
        descripcion = utilidades.Utilidades.introducirCadena("Introduce la descripcion: ");
        //enunciados = insertarEnunciados();
    }

    public void getDatosUnidad() {
        System.out.println("ID:" + id
                + "\nAcronimo: " + acronimo + "\nTitulo: " + titulo + "\nEvaluacion: " + evaluacion + "\nDescripcion: " + descripcion /*+"\nEnunciados: "+ recogerEnunciados()*/);
    }

    /*public List<Enunciado> insertarEnunciados() {
        List<Enunciado> enunciado = new ArrayList<>();
        boolean resp = false;
        do {
            Enunciado enun = new Enunciado();
            enun.setDatosEnunciado();
            enunciado.add(enun);
            resp = utilidades.Utilidades.esBoolean("¿Deseas seguir introduciendo enunciados? (S/N)");
        } while (resp);
        return enunciado;

    }

    public List<Enunciado> recogerEnunciados() {
        for (int i = 0; i < 0; i++) {
            enunciados.get(i).getDatosEnunciado();
        }
        return enunciados;
    }*/
}
