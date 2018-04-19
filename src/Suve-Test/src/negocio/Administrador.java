/**
 * Administrador.java 
 * @author Lucas y MATHOV
 * 
 * creado en algun momento
 */

package negocio;

import org.hibernate.HibernateException;

import dao.TarjetaDao;
import datos.Tarjeta;
import dao.UsuarioDao;
import datos.Usuario;

public class Administrador {
	//Tarjeta tarjeta;
	//Usuario usuario;
	/**
	 * asignarTarjeta
	 * <p>Se fija que la tarjeta y el usuario existan PARA MI SI NO EXISTE ES NULL!!!!!!</p> 
	 * 
	 * <p>Si el usuario Existe comprueba, que sea el mismo que el usuario asignado a la tarjeta,
	 * o que la tarjeta no este asigndada  a ningun usuario.</p>
	 * 
	 * @param u Usuario
	 * @param t Tarjeta
	 */
	public static void asignarTarjeta(Usuario u, Tarjeta t) throws HibernateException {
		TarjetaDao tdao = new TarjetaDao();
		
		if(u == null || t == null || 
			((t.getUsuario() != null ) && t.getUsuario().getIdUsuario() != u.getIdUsuario())) {
			//ERRROR
			System.out.println("ERR");
		}
		else {
			System.out.println(u.getTarjetas());
			System.out.println("HOLA");
			for (Tarjeta i : u.getTarjetas()) {
				System.out.println(i);
				i.setBaja(true);
			}
			
			t.setBaja(false);
			t.setUsuario(u);
			
			if( tdao.traerTarjeta(t.getIdTarjeta()) == null) {
				//Damos de baja Todas las tarjetas
				tdao.agregar(t);
			}
			System.out.println("WUJU");	
		}
		
	}

}
