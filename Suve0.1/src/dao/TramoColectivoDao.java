package dao;

	import java.util.List;
	import org.hibernate.HibernateException;
	import org.hibernate.Session;
	import org.hibernate.Transaction;
	import datos.TramoColectivo;
	
public class TramoColectivoDao {
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
		
	public int agregar(TramoColectivo objeto) {
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
	
	public void actualizar(TramoColectivo objeto) throws HibernateException {
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

	public void eliminar(TramoColectivo objeto) throws HibernateException {
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
	public TramoColectivo traerTramoColectivo(long idTramoColectivo) throws HibernateException {
		TramoColectivo objeto = null;
		try {
			iniciaOperacion();
			objeto = (TramoColectivo) session.createQuery("from TramoColectivo t inner join fetch t.seccionViaje where t.idTramoColectivo = "+idTramoColectivo).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	*/		
	@SuppressWarnings ( "unchecked" )
	public List<TramoColectivo> traerTramoColectivo() throws HibernateException {
		List<TramoColectivo> lista= null ;
		try {
			iniciaOperacion();
			lista= session.createQuery( "from TramoColectivo t inner join fetch t.seccionViaje order by t.idTramoColectivo asc" ).list();
		} finally {
			session.close();
		}
		return lista;
	}
	public TramoColectivo traerTramoColectivo(float kMin, float kMax) 
	{
		TramoColectivo objeto = null; 
		try {
			iniciaOperacion();
			objeto = (TramoColectivo) session.createQuery("from TramoColectivo t inner join fetch t.seccionViaje where t.kMin = "+kMin+" and t.kMax ="+kMax).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;	
	}
}
