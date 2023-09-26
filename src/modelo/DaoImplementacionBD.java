/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.ConvocatoriaExamen;
import clases.Dificultad;
import clases.Enunciado;
import clases.UnidadDidactica;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Métodos, conexiones y consultas SQL para realizar la parte de Base de datos
 * del proyecto
 *
 * @author Diego
 */
public class DaoImplementacionBD implements DAO {

    private Connection con;
    private PreparedStatement stmt;
    private ResourceBundle configFichero;
    private String driverBD;
    private String urlBD;
    private String userBD;
    private String passwordBD;

    private final String CREATEUNID = "INSERT INTO unidad (id, acronimo, titulo, evaluacion, descripcion) VALUES (?,?,?,?,?) ON DUPLICATE KEY UPDATE id= 1";
    private final String CREATEENUN = "INSERT INTO enunciado (id, descripcion, nivel, disponible, ruta) VALUES (?,?,?,?,?) ON DUPLICATE KEY UPDATE id= 1";
    //SELECT m.* FROM accoun a, movement m WHERE m.account_id = a.id AND m.id = ?
    private final String CONSULTENUN = "SELECT e.* FROM enunciado e, unidad u WHERE e.id = u.id AND u.id = ?";
    private final String CONSULTENUNDOCU = "SELECT * FROM enunciado WHERE id = ?";

    // Metodo para conectarnos a la base de datos
    public DaoImplementacionBD() {
        this.configFichero = ResourceBundle.getBundle("modelo.configuracion");
        this.driverBD = this.configFichero.getString("Driver");
        this.urlBD = this.configFichero.getString("Conn");
        this.userBD = this.configFichero.getString("DBUser");
        this.passwordBD = this.configFichero.getString("DBPass");
    }

    private void openConnection() {
        try {
            // Class.forName(this.driverBD);
            con = (Connection) DriverManager.getConnection(this.urlBD, this.userBD, this.passwordBD);
        } catch (SQLException e) {
            System.out.println("Error al intentar abrir la BD");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Se ha abierto la base de datos");
            e.printStackTrace();
        }
    }

    private void closeConnection() throws SQLException {
        if (stmt != null) {
            stmt.close();
        }
        if (con != null) {
            con.close();
        }
    }

    @Override
    public UnidadDidactica createDidaticUnity(UnidadDidactica uni) {
        this.openConnection();
        ResultSet rs = null;
        
        try {
            uni = new UnidadDidactica();
            uni.setDatosUnidad();
            stmt = con.prepareStatement(CREATEUNID);

            stmt.setInt(1, uni.getId());
            stmt.setString(2, uni.getAcronimo());
            stmt.setString(3, uni.getTitulo());
            stmt.setString(4, uni.getEvaluacion());
            stmt.setString(5, uni.getDescripcion());
            
            stmt.executeUpdate();
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return uni;
    }

    @Override
    public Enunciado createFormulation(Enunciado enun) {
        this.openConnection();
        ResultSet rs = null;
       
        try {
            enun = new Enunciado();
            enun.setDatosEnunciado();
            stmt = con.prepareStatement(CREATEENUN);

            stmt.setInt(1, enun.getId());
            stmt.setString(2, enun.getDescripcion());
            stmt.setString(3, enun.getNivel().toString());
            stmt.setBoolean(4, enun.isDisponible());
            stmt.setString(5, enun.getRuta());

            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return enun;
    }

    @Override
    public List<Enunciado> consultFormulation(Integer id) {
        
        this.openConnection();
        List<Enunciado> listEnum = new ArrayList<>();
        ResultSet rs = null;
        try {

            stmt = con.prepareStatement(CONSULTENUN);
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Dificultad nivel = null;
                
                Enunciado enunciado = new Enunciado();
                enunciado.setId(id);
                enunciado.setDescripcion(rs.getString("descripcion"));
                //enunciado.setNivel(Dificultad.values()[rs.getInt("nivel")]);
                enunciado.setDisponible(rs.getBoolean("disponible"));
                enunciado.setRuta(rs.getString("ruta"));
                               
                listEnum.add(enunciado);    
                enunciado.getDatosEnunciado();
                
            }
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listEnum;
    }

    @Override
    public Enunciado showFormulation(Integer id) {
        Enunciado enun = new Enunciado();
        ResultSet rs = null;
        this.openConnection();
        try {
        
            stmt = con.prepareStatement(CONSULTENUNDOCU);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();
            while (rs.next()) {
                enun.setId(id);
                enun.setDescripcion(rs.getString("descripcion"));
                enun.setNivel(Dificultad.values()[rs.getInt("enunciado.nivel")]);
                enun.setDisponible(rs.getBoolean("disponible"));
                enun.setRuta(rs.getString("ruta"));
                
                enun.getDatosEnunciado();
                
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return enun;
    }

    //Ignorar, estos métodos se hacen en el fichero
    @Override
    public ConvocatoriaExamen createConvocatory(ConvocatoriaExamen covoy) {
        return null;
    }

    @Override
    public List<ConvocatoriaExamen> consultConvocatory(Integer id) {
        return null;
    }
}
