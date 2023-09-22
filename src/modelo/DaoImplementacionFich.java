/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.ConvocatoriaExamen;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

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
}
