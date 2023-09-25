/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.ConvocatoriaExamen;
import clases.Enunciado;
import clases.UnidadDidactica;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

/**
 *
 * @author 2dam
 */
public class DaoImplementacionBD implements DAO{

    private Connection con;
    private PreparedStatement stmt;
    private ResourceBundle configFichero;
    private String driverBD;
    private String urlBD;
    private String userBD;
    private String passwordBD;
    
     private final String SELECT_ENUNCIADO = "SELECT * FROM enunciado WHERE id=?";

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
    
    
    
     public Enunciado recogerEnunciadoId(String id) {
        this.openConnection();
        Enunciado enun = null;
        ResultSet rs;

        try {
            stmt = (PreparedStatement) con.prepareStatement(SELECT_ENUNCIADO);
            stmt.setString(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                enun = new Enunciado();
                enun.setId(rs.getInt("id"));
                enun.setDescripcion(rs.getString("descripcion"));
                enun.isDisponible();
                enun.setRuta(rs.getString("ruta"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            this.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enun;

    }

    @Override
    public UnidadDidactica createDidaticUnity(UnidadDidactica uni) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Enunciado createFormulation(Enunciado enun) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Enunciado> consultFormulation(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Enunciado showFormulation(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ConvocatoriaExamen createConvocatory(ConvocatoriaExamen covoy) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ConvocatoriaExamen> consultConvocatory(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

 

}
