/**
 * Administrador.java 
 * @author Lucas y MATHOV
 * 
 * creado en algun momento
 */

package negocio;

import org.hibernate.HibernateException;

import TestModificaDatos.TraertUsuarioYTarjetas;
import dao.TarjetaDao;
import datos.Tarjeta;
import dao.UsuarioDao;
import datos.Usuario;

import java.util.Iterator;
import java.util.Set;
/**
 * Administrador
 * @author Equipo 1
 * @version 0.1
 * 
 * TODO: -
 * 
 */
public class Administrador {
	//Tarjeta tarjeta;
	//Usuario usuario;
	/**
	 * asignarTarjeta
	 * <p>Se fija que la tarjeta y el usuario existan (Si no existe es null)</p>
	 * <p>Si el usuario Existe comprueba, que sea el mismo que el usuario asignado a la tarjeta,
	 * o que la tarjeta no este asigndada  a ningun usuario.</p>
	 * 
	 * @param u Usuario
	 * @param t Tarjeta
	 * @version 1.0
	 */
	public static void asignarTarjeta(Usuario u, Tarjeta t) throws HibernateException {
		TarjetaDao tdao = new TarjetaDao();
		UsuarioDao udao = new UsuarioDao();
		
		if(u == null || t == null || 
			((t.getUsuario() != null ) && t.getUsuario().getIdUsuario() != u.getIdUsuario())) {
			//TODO ERRROR
			
			System.out.println("ERR");
			System.out.println("Usuario:" + u.getNombre() + " Tarjeta: " + t.getIdTarjeta());
		}
		else {
			Set<Tarjeta> setTarjetas = udao.traerUsuarioYTarjeta(u.getIdUsuario()).getTarjetas();
			//Damos de baja Todas las tarjetas
			for(Tarjeta tar : setTarjetas) {
				if(tar.isActiva() == true){
					tar.setActiva(false);
					tdao.actualizar(tar);
				}
			}
			
			//Activa la tarjeta Actual
			t.setActiva(true);
			t.setUsuario(u);
			
			//Actualiza la tarjeta y si no esta en el sistema la agrega
			if( tdao.traerTarjeta(t.getIdTarjeta()) == null) {
				tdao.agregar(t);
			}
			else {
				tdao.actualizar(t);
			}
		}
		
	}

}
