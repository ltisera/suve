package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Boleto;
import datos.Beneficio;
import datos.Recarga;

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
	
	public Boleto traerBoleto(long idBeneficio) {
		Boleto objeto = null;
		try {
			iniciaOperacion();
			objeto = (Boleto) session.get(Boleto.class, idBeneficio);
		}  finally {
			session.close();
		}
		return objeto;
	}
	
	public Recarga traerRecarga(long idBeneficio) {
		Recarga objeto = null;
		try {
			iniciaOperacion();
			objeto = (Recarga) session.get(Recarga.class, idBeneficio);
		}  finally {
			session.close();
		}
		return objeto;
	}
	
	public Beneficio traerBeneficio(long idBeneficio) {
		Beneficio objeto = null;
		try {
			iniciaOperacion();
			objeto = (Beneficio) session.get(Beneficio.class, idBeneficio);
		}  finally {
			session.close();
		}
		return objeto;
	}
	
	public Beneficio traerBeneficioCompleto(long idBeneficio){
		Beneficio objeto = null;
		try {
			iniciaOperacion();
			objeto = (Beneficio) session.createQuery("from Beneficio m inner join fetch m.lectora inner join fetch m.tarjeta where m.idBeneficio="+idBeneficio).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Beneficio> traerBeneficios(){
		List<Beneficio> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Beneficio m").list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<Beneficio> traerBeneficioCompleto(){
		List<Beneficio> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Beneficio m inner join fetch m.lectora inner join fetch m.tarjeta").list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	/*
	public List<Beneficio> traerBeneficioYLectora(){
		List<Beneficio> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Beneficio m inner join fetch m.lectora").list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	public List<Beneficio> traerBeneficioYTarjeta(){
		List<Beneficio> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Beneficio m inner join fetch m.tarjeta").list();
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
			//lista = session.createQuery("from Boleto b where b.monto > 30 and b.monto < 32 order by b.idBeneficio asc").list();
			lista = session.createQuery("from Boleto").list();
		} finally {
			session.close();
		}
		return lista;
	}
}
