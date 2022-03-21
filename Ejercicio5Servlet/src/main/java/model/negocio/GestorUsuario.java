package model.negocio;

import model.entidad.Usuario;
import model.persistencia.DaoUsuario;

public class GestorUsuario {

	/**
	 * Este método valida si un usuario esta registrado en el sistema
	 * @param usuario a validar
	 * @return 0 en caso de que el usuario este validado, 1 en caso de
	 * que el usuario no exista y un 2 en caso de que el usuario y el 
	 * password sean incorectos.
	 */
	public int validarUsuario(Usuario usuario) {
		DaoUsuario du = new DaoUsuario();
		Usuario user = du.busquedaPorNombre(usuario.getNombre());
		
		if(user == null) {
			return 1;
		}
		
		if(user.getPassword().equals(usuario.getPassword())) {
			return 0;
		}else {
			return 2;
		}
	}
}
