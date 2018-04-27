package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Boleto;
import datos.Movimiento;
import datos.Recarga;
	
public class MovimientoDao {
	private static Session session;
	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException( "ERROR en la capa de acceso a datos" , he);
	}
		
	public int agregar(Movimiento objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}
	
	public void actualizar(Movimiento objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}	
	}

	public void eliminar(Movimiento objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	public Boleto traerMovimientoBoleto(long idMovimiento) throws HibernateException {
		Boleto objeto = null;
		try {
			iniciaOperacion();
			objeto = (Boleto) session.get(Boleto.class , idMovimiento);
		} finally {
			session.close();
		}
		return objeto;
	}
	public Recarga traerMovimientoRecarga(long idMovimiento) throws HibernateException {
		Recarga objeto = null;
		try {
			iniciaOperacion();
			objeto = (Recarga) session.get(Recarga.class , idMovimiento);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Movimiento traerMovimiento(long idMovimiento) throws HibernateException {
		Movimiento objeto = null;
		try {
			iniciaOperacion();
			objeto = (Movimiento) session.get(Movimiento.class , idMovimiento);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	/*
	public List<Movimiento> traerMovimientoIdTarjeta(long idTarjeta){
		List<Movimiento> lista= null ;
		try {
			iniciaOperacion();
			lista= session.createQuery( "from Movimiento b where b.idTarjeta =" + idTarjeta +  " order by b.fecha asc" ).list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	public Movimiento traerUltimoBoletaDeTarjeta(long idTarjeta) {
		return traerMovimientoIdTarjeta(idTarjeta).get(traerMovimientoIdTarjeta(idTarjeta).size()-1);
	}
	*/
	
	@SuppressWarnings ( "unchecked" )
	public List<Movimiento> traerMovimiento() throws HibernateException {
		List<Movimiento> lista= null ;
		try {
			iniciaOperacion();
			lista= session.createQuery( "from Movimiento b order by b.idMovimiento asc" ).list();
		} finally {
			session.close();
		}
		return lista;
	}
}
