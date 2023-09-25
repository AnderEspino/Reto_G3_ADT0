package modelo;

import clases.ConvocatoriaExamen;
import clases.Enunciado;
import clases.UnidadDidactica;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.MyObjectOutputStream;
import utilidades.Utilidades;

/**
 *
 * @author 2dam
 */
public class DaoImplementacionFich implements DAO {

    File fich = new File("CExamen.obj");

    private static void volcarListFich(List<ConvocatoriaExamen> convocatoria, File fich) {
        // TODO Auto-generated method stub
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream(fich));

            for (int i = 0; i < convocatoria.size(); i++) {
                oos.writeObject(convocatoria.get(i));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.flush();
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static List<ConvocatoriaExamen> volcarFichList(File fich) {
        // TODO Auto-generated method stub
        List<ConvocatoriaExamen> convocatoria = new ArrayList<>();

        // flujo para leer
        ObjectInputStream ois = null;
        ConvocatoriaExamen cExamen;

        try {
            ois = new ObjectInputStream(new FileInputStream(fich));

            while (true) {
                cExamen = (ConvocatoriaExamen) ois.readObject();
                convocatoria.add(cExamen);
            }
        } catch (EOFException e) {
            System.out.println("Final de fichero");
        } catch (IOException e) {
            System.out.println("Error de entrada salida");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Error al castear el obj");
            e.printStackTrace();
        }

        return convocatoria;
    }

    public UnidadDidactica createDidaticUnity(UnidadDidactica uni) {
        return null;
    }

    public Enunciado createFormulation(Enunciado enun) {
        return null;
    }

    public List<Enunciado> consultFormulation(Integer id) {
        return null;
    }

    public Enunciado showFormulation(Integer id) {
        return null;
    }

    /**
     * Este metodo sirve para crear una convocatoria
     *
     * @param covoy
     * @author Adrian, Ander
     * @return Devuelve el objeto convocatoria examen
     */
    public ConvocatoriaExamen createConvocatory(ConvocatoriaExamen covoy) {
        // Declaración de variables
        ObjectOutputStream os = null;
        ObjectInputStream ois = null;
        String nombre, ip;
        boolean existe = false, esta = false;

        try {
            if (fich.exists()) {
//				El fichero "fich" se crea por primera vez
                os = new MyObjectOutputStream(new FileOutputStream(fich, true));
            } else {
//				Si el fichero "fich" ya existe
                os = new ObjectOutputStream(new FileOutputStream(fich));
            }
            covoy = new ConvocatoriaExamen();
            nombre = Utilidades.introducirCadena("Introduce el nombre de la convocatoria: ");
            ois = new ObjectInputStream(new FileInputStream(fich));
//			Comprobación de datos.

            esta = existeConvocatoria(nombre, fich, covoy);
            if (!esta) {
                covoy.setDatosConvocatoriaExamen(nombre);
                os.writeObject(covoy);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();

                } catch (IOException e) {
                    e.printStackTrace();

                }
            }

        }
        return covoy;

    }

    /**
     * Este metodo muestra la informacion de una convocatoria introducida por el
     * usuario
     *
     * @param id
     * @author Adrian, Ander
     * @return Devuelve el objeto convocatoria examen
     */
    @Override
    public List<ConvocatoriaExamen> consultConvocatory(Integer id) {
        boolean esta;
        String nombre;
        ConvocatoriaExamen covoy = null;
        int calculo = Utilidades.calculoFichero(fich);
        ObjectInputStream ois = null;
        boolean existe = false;
        List<ConvocatoriaExamen> convocatorias = new ArrayList<>();
        if (fich.exists()) {
            try {
//		Recorremos el for para listar las convocatorias
                ois = new ObjectInputStream(new FileInputStream(fich));
                for (int i = 0; i < Utilidades.calculoFichero(fich); i++) {
                    covoy = (ConvocatoriaExamen) ois.readObject();
                    if (covoy.getEnunciado() == id) {
                        covoy.getConvocatoria();
                        convocatorias.add(covoy);
                        existe = true;
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(DaoImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DaoImplementacionFich.class.getName()).log(Level.SEVERE, null, ex);

            }
            if (!existe) {
                System.out.println("No existe ninguna lista que este asociado a esa ID!");
            }
        } else {
            System.out.println("Todavia no hay convocatorias!");
        }
        return convocatorias;
    }

    public boolean existeConvocatoria(String nombre, File fich, ConvocatoriaExamen covoy) {
        ObjectInputStream ois = null;
        boolean existe = false;
        try {
//		Recorremos el for para comprobar si el mundo existe.
            ois = new ObjectInputStream(new FileInputStream(fich));
            for (int i = 0; i < Utilidades.calculoFichero(fich); i++) {
                covoy = (ConvocatoriaExamen) ois.readObject();
                if (covoy.getConvocatoria().equalsIgnoreCase(nombre)) {
                    System.out.println("¡Esa convocatoria ya existe!");
                    existe = true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return existe;
    }

}
