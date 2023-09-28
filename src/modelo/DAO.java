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
     /**
     * Método createDidaticUnity
     * @param uni
     * @return 
     */
    public UnidadDidactica createDidaticUnity(UnidadDidactica uni);
    /**
     * Método createFormulation
     * @param enun
     * @return 
     */
    public Enunciado createFormulation(Enunciado enun);
    /**
     * Método consultFormulation
     * @param id
     * @return 
     * @throws excepciones.FormulationDoesNoExistException 
     */
    public List<Enunciado> consultFormulation(Integer id) throws FormulationDoesNoExistException;
    /**
     * Método showFormulation
     * @param id
     * @return 
     */
    public Enunciado showFormulation(Integer id) ;
    /**
     * Método createConvocatory
     * @param covoy
     * @return 
     */
    public ConvocatoriaExamen createConvocatory(ConvocatoriaExamen covoy);
    /**
     * Método consultConvocatory
     * @param id
     * @return 
     */
    public List<ConvocatoriaExamen> consultConvocatory(Integer id);
    
    
}
