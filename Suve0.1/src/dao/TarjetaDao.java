package dao;

	import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
	import org.hibernate.Session;
	import org.hibernate.Transaction;
	import datos.Tarjeta;
	
public class TarjetaDao {
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
		
	public int agregar(Tarjeta objeto) {
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
	
	public void actualizar(Tarjeta objeto) throws HibernateException {
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

	public void eliminar(Tarjeta objeto) throws HibernateException {
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
	
	public Tarjeta traerTarjeta(long idTarjeta) throws HibernateException {
		Tarjeta objeto = null;
		try {
			iniciaOperacion();
			objeto = (Tarjeta) session.get(Tarjeta.class , idTarjeta);
		} finally {
			session.close();
		}
		return objeto;
	}
	public Tarjeta traerTarjetaPorNumeroSerie(int numeroSerie) throws HibernateException {
		Tarjeta objeto = null;
		try {
			iniciaOperacion();
			objeto = (Tarjeta) session.createQuery( "from Tarjeta t inner join fetch t.usuario where t.numeroSerieTarjeta="+numeroSerie).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings ( "unchecked" )
	public List<Tarjeta> traerTarjeta() throws HibernateException {
		List<Tarjeta> lista= null ;
		try {
			iniciaOperacion();
			lista= session.createQuery( "from Tarjeta t order by t.idTarjeta asc" ).list();
		} finally {
			session.close();
		}
		return lista;
	}

	public long traerIdTarjeta(int numeroSerieTarjeta) throws HibernateException {
		long objeto = -1;
		try {
			iniciaOperacion();
			objeto = (long) session.createQuery( "select idTarjeta from Tarjeta t where t.numeroSerieTarjeta="+numeroSerieTarjeta).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Tarjeta> traerTarjetaConBeneficios() throws HibernateException {
		List<Tarjeta> lista= null ;
		try {
			iniciaOperacion();
			lista= session.createQuery( "from Tarjeta t order by t.idTarjeta asc" ).list();
			for(Tarjeta t:lista) {
				Hibernate.initialize(t.getBeneficios());
			}
		} finally {
			session.close();
		}
		return lista;
	}
	
	public Tarjeta traerTarjetaConBeneficios(long idTarjeta) 
	{
		Tarjeta objeto = null;
		try {
			iniciaOperacion();
			objeto = (Tarjeta) session.createQuery("from Tarjeta t where t.idTarjeta="+idTarjeta).uniqueResult();
			if(objeto!=null)
				Hibernate.initialize(objeto.getBeneficios());
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Tarjeta traerTarjetaConBeneficios(int numeroSerieTarjeta) 
	{
		Tarjeta objeto = null;
		try {
			iniciaOperacion();
			objeto = (Tarjeta) session.createQuery("from Tarjeta t where t.numeroSerieTarjeta="+numeroSerieTarjeta).uniqueResult();
			if(objeto!=null)
				Hibernate.initialize(objeto.getBeneficios());
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Tarjeta traerTarjetaActiva(long idUsuario)
	{
		Tarjeta objeto = null;
		try {
			iniciaOperacion();
			objeto = (Tarjeta) session.createQuery("from Tarjeta t where t.activa = :true and t.usuario = "+idUsuario+")").setParameter("true", true).uniqueResult();
			if (objeto!=null)
				Hibernate.initialize(objeto.getBeneficios());
		} finally {
			session.close();
		}
		return objeto;
	}
}
