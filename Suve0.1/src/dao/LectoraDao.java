package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Lectora;
//import negocio.LectoraColectivo;
import datos.LectoraColectivo;
import datos.LectoraEstacion;


public class LectoraDao {
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
		
	public int agregar(Lectora objeto) {
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
	
	public void actualizar(Lectora objeto) throws HibernateException {
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

	public void eliminar(Lectora objeto) throws HibernateException {
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
	
	/*
	public Lectora traerLectora(long idLectora) throws HibernateException {
		Lectora objeto = null;
		try {
			iniciaOperacion();
			objeto = (Lectora) session.get(Lectora.class , idLectora);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Lectora traerLectoraCompleta(long idLectora) throws HibernateException {
		Lectora objeto = null;
		try {
			iniciaOperacion();
			objeto = (Lectora) session.createQuery("from Lectora l inner join fetch l.estacion inner join fetch l.transporte where m.idLectora="+idLectora).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	public List<Lectora> traerLectora() throws HibernateException {
		List<Lectora> lista = null ;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Lectora").list();
		} finally {
			session.close();
		}
		return lista;
	}
	public List<Lectora> traerLectoraCompleta() throws HibernateException {
		List<Lectora> lista = null ;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Lectora l inner join fetch l.estacion inner join fetch l.transporte").list();
		} finally {
			session.close();
		}
		return lista;
	}
	*/
	@SuppressWarnings("unchecked")
	public List<Lectora> traerLectorasPorLinea(long idTransporte) throws HibernateException {
		List<Lectora> lista = null ;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Lectora l where l.transporte="+idTransporte).list();
		} finally {
			session.close();
		}
		return lista;
	}
	@SuppressWarnings("unchecked")
	public List<Lectora> traerLectorasPorEstacion(long idEstacion) throws HibernateException {
		List<Lectora> lista = null ;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Lectora l where l.estacion="+idEstacion).list();
		} finally {
			session.close();
		}
		return lista;
	}
	public LectoraColectivo traerLectoraColectivo(int numeroSerieLectora) 
	{
		LectoraColectivo objeto = null;
		try {
			iniciaOperacion();
			objeto = (LectoraColectivo) session.createQuery("from LectoraColectivo l inner join fetch l.transporte where l.numeroSerieLectora ="+numeroSerieLectora).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	@SuppressWarnings("unchecked")
	public List<LectoraColectivo> traerLectoraColectivo() throws HibernateException {
		List<LectoraColectivo> lista = null ;
		try {
			iniciaOperacion();
			lista = session.createQuery("from LectoraColectivo l inner join fetch l.transporte").list();
		} finally {
			session.close();
		}
		return lista;
	}
	public LectoraEstacion traerLectoraEstacion(int numeroSerieLectora) 
	{
		LectoraEstacion objeto = null;
		try 
		{
			iniciaOperacion();
			objeto = (LectoraEstacion) session.createQuery("from LectoraEstacion l inner join fetch l.estacion e inner join fetch e.transporte where l.numeroSerieLectora ="+numeroSerieLectora).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	@SuppressWarnings("unchecked")
	public List<LectoraEstacion> traerLectoraEstacion() throws HibernateException {
		List<LectoraEstacion> lista = null ;
		try {
			iniciaOperacion();
			lista = session.createQuery("from LectoraEstacion l inner join fetch l.estacion as e inner join fetch e.transporte").list();
		} finally {
			session.close();
		}
		return lista;
	}
	
}
