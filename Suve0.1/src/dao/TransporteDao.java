package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Transporte;

public class TransporteDao {
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
		
	public int agregar(Transporte objeto) {
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
	
	public void actualizar(Transporte objeto) throws HibernateException {
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

	public void eliminar(Transporte objeto) throws HibernateException {
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
	
	public Transporte traerTransporte(long idTransporte) throws HibernateException {
		Transporte objeto = null;
		try {
			iniciaOperacion();
			objeto = (Transporte) session.get(Transporte.class , idTransporte);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	
	@SuppressWarnings ( "unchecked" )
	public List<Transporte> traerTransporte() throws HibernateException {
		List<Transporte> lista= null ;
		try {
			iniciaOperacion();
			lista= session.createQuery( "from Transporte u order by u.linea asc u.linea asc" ).list();
		} finally {
			session.close();
		}
		return lista;
	}
}
