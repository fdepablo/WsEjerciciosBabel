package model.persistencia;

import java.util.ArrayList;
import java.util.List;

import model.entidad.Usuario;

/**
 * 
 * Clase que trabaja con un array list de usuarios en memoria
 * 
 * @author Felix de Pablo Lobo
 * @since 1.0
 *
 */
public class DaoUsuario {

	private static List<Usuario> listaUsuarios; 
	
	/*
	 * Un bloque estatico se ejecuta una unica vez antes de empezar el 
	 * programa, antes incluso que el main.
	 */
	static {		
		listaUsuarios = new ArrayList<Usuario>();				
		Usuario u= new Usuario("Alberto", "1234");
		Usuario a= new Usuario("Felix", "1234");
		Usuario b= new Usuario("Marcos", "1234");
		Usuario c= new Usuario("Nueria", "1234");
		listaUsuarios.add(u);
		listaUsuarios.add(a);
		listaUsuarios.add(b);
		listaUsuarios.add(c);
	}
	
	//El objeto de JavaDoc, es enseñar como se utilizan vuestros métodos
	//clases y atributos. Al menos hay que explicar los posibles casos
	//que devuelve
	
	/**
	 * Método que busca un usuario en un arraylist por nombre
	 * @param nombre que vamos a buscar
	 * @return el usuario en caso de que exista en el arraylist o <b>null</b>
	 * en caso de que no exista.
	 */
	public Usuario busquedaPorNombre(String nombre) {
		//Recorremos la lista de usuarios
		for(Usuario user : listaUsuarios) {
			if(nombre.equals(user.getNombre())) {
				return user;
			}
		}
		
		return null;
	}
}
