package dao;

	import java.util.List;
	import org.hibernate.HibernateException;
	import org.hibernate.Session;
	import org.hibernate.Transaction;
	import datos.Boleto;
	
public class BoletoDao {
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
		
	public int agregar(Boleto objeto) {
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
	
	public void actualizar(Boleto objeto) throws HibernateException {
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

	public void eliminar(Boleto objeto) throws HibernateException {
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
	
	public Boleto traerBoleto(long idBoleto) throws HibernateException {
		Boleto objeto = null;
		try {
			iniciaOperacion();
			objeto = (Boleto) session.get(Boleto.class , idBoleto);
		} finally {
			session.close();
		}
		return objeto;
	}
			
	@SuppressWarnings ( "unchecked" )
	public List<Boleto> traerBoleto() throws HibernateException {
		List<Boleto> lista= null ;
		try {
			iniciaOperacion();
			lista= session.createQuery( "from Boleto b order by b.idBoleto asc" ).list();
		} finally {
			session.close();
		}
		return lista;
	}
}
