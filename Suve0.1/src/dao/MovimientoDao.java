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
	
	public Boleto traerBoleto(long idMovimiento) {
		Boleto objeto = null;
		try {
			iniciaOperacion();
			objeto = (Boleto) session.get(Boleto.class, idMovimiento);
		}  finally {
			session.close();
		}
		return objeto;
	}
	
	public Recarga traerRecarga(long idMovimiento) {
		Recarga objeto = null;
		try {
			iniciaOperacion();
			objeto = (Recarga) session.get(Recarga.class, idMovimiento);
		}  finally {
			session.close();
		}
		return objeto;
	}
	
	public Movimiento traerMovimiento(long idMovimiento) {
		Movimiento objeto = null;
		try {
			iniciaOperacion();
			objeto = (Movimiento) session.get(Movimiento.class, idMovimiento);
		}  finally {
			session.close();
		}
		return objeto;
	}
	
	public Movimiento traerMovimientoCompleto(long idMovimiento){
		Movimiento objeto = null;
		try {
			iniciaOperacion();
			objeto = (Movimiento) session.createQuery("from Movimiento m inner join fetch m.lectora inner join fetch m.tarjeta where m.idMovimiento="+idMovimiento).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Movimiento> traerMovimientos(){
		List<Movimiento> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Movimiento m").list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<Movimiento> traerMovimientoCompleto(){
		List<Movimiento> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Movimiento m inner join fetch m.lectora inner join fetch m.tarjeta").list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	/*
	public List<Movimiento> traerMovimientoYLectora(){
		List<Movimiento> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Movimiento m inner join fetch m.lectora").list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<Movimiento> traerMovimientoYTarjeta(){
		List<Movimiento> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Movimiento m inner join fetch m.tarjeta").list();
		} finally {
			session.close();
		}
		return lista;
	}
	*/
	public List<Boleto> traerBoleto(){
		List<Boleto> lista = null;
		try {
			iniciaOperacion();
			//lista = session.createQuery("from Boleto b where b.monto > 30 and b.monto < 32 order by b.idMovimiento asc").list();
			lista = session.createQuery("from Boleto").list();
		} finally {
			session.close();
		}
		return lista;
	}
}
