/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.ConvocatoriaExamen;
import clases.Enunciado;
import clases.UnidadDidactica;

import excepciones.FormulationDoesNoExistException;
import java.util.List;

/**
 * Métodos de la interfaz DAO asociados a la parte de la base de datos
 * @author Diego
 */
public interface DAO {
    
    public UnidadDidactica createDidaticUnity(UnidadDidactica uni);
    
    public Enunciado createFormulation(Enunciado enun);
    
    public List<Enunciado> consultFormulation(Integer id) throws FormulationDoesNoExistException;
    
    public Enunciado showFormulation(Integer id) ;
    
    public ConvocatoriaExamen createConvocatory(ConvocatoriaExamen covoy);
    
    public List<ConvocatoriaExamen> consultConvocatory(Integer id);
    
    
}
