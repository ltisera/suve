package dao;

	import java.util.List;
	import org.hibernate.HibernateException;
	import org.hibernate.Session;
	import org.hibernate.Transaction;

import datos.Estacion;
import datos.TramoTrenYSubte;
	
public class TramoTrenYSubteDao {
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
		
	public int agregar(TramoTrenYSubte objeto) {
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
	
	public void actualizar(TramoTrenYSubte objeto) throws HibernateException {
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

	public void eliminar(TramoTrenYSubte objeto) throws HibernateException {
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
	
	public TramoTrenYSubte traerTramoTrenYSubte(long idTramoTrenYSubte) throws HibernateException {
		TramoTrenYSubte objeto = null;
		try {
			iniciaOperacion();
			objeto = (TramoTrenYSubte) session.createQuery("from TramoTrenYSubte t inner join fetch t.seccionViaje where t.idTramoTrenYSubte = "+idTramoTrenYSubte).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
			
	@SuppressWarnings ( "unchecked" )
	public List<TramoTrenYSubte> traerTramoTrenYSubte() throws HibernateException {
		List<TramoTrenYSubte> lista= null ;
		try {
			iniciaOperacion();
			lista= session.createQuery( "from TramoTrenYSubte t order by t.idTramoTrenYSubte asc" ).list();
		} finally {
			session.close();
		}
		return lista;
	}

	public TramoTrenYSubte traerTramoTrenYSubte(Estacion estacionA, Estacion estacionB) 
	{
		TramoTrenYSubte objeto = null;
		try {
			iniciaOperacion();
			objeto = (TramoTrenYSubte) session.createQuery("from TramoTrenYSubte t inner join fetch t.seccionViaje where (t.estacionA = "+estacionA.getIdEstacion()+" and t.estacionB="+estacionB.getIdEstacion()+") or (t.estacionA ="+estacionB.getIdEstacion()+" and t.estacionB="+estacionA.getIdEstacion()).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public TramoTrenYSubte traerTramoUnaEstacion(Estacion estacionA)
	{
		TramoTrenYSubte objeto = null;
		try {
			iniciaOperacion();
			objeto = (TramoTrenYSubte) session.createQuery("from TramoTrenYSubte t inner join fetch t.seccionViaje inner join fetch t.estacionA where t.estacionA = "+estacionA.getIdEstacion()+" and t.estacionB is null").uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
}
