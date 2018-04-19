package dao;

	import java.util.List;
	import org.hibernate.HibernateException;
	import org.hibernate.Session;
	import org.hibernate.Transaction;
	import datos.Beneficio;
	
public class BeneficioDao {
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
		
	public int agregar(Beneficio objeto) {
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
	
	public void actualizar(Beneficio objeto) throws HibernateException {
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

	public void eliminar(Beneficio objeto) throws HibernateException {
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
	
	public Beneficio traerBeneficio(long idBeneficio) throws HibernateException {
		Beneficio objeto = null;
		try {
			iniciaOperacion();
			objeto = (Beneficio) session.get(Beneficio.class , idBeneficio);
		} finally {
			session.close();
		}
		return objeto;
	}
			
	@SuppressWarnings ( "unchecked" )
	public List<Beneficio> traerBeneficio() throws HibernateException {
		List<Beneficio> lista= null ;
		try {
			iniciaOperacion();
			lista= session.createQuery( "from Beneficio b order by b.idBeneficio asc" ).list();
		} finally {
			session.close();
		}
		return lista;
	}
}
