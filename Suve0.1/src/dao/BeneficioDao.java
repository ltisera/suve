package dao;

//import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.BoletoEstudiantil;
import datos.Beneficio;
import datos.TarifaSocial;

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
	
	/*
	public List<Beneficio> traerBeneficio(){
		List<Beneficio> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Beneficio m").list();
		} finally {
			session.close();
		}
		return lista;
	}
	*/

	public TarifaSocial traerTarifaSocial()
	{
		TarifaSocial objeto = null;
		try {
			iniciaOperacion();
			objeto = (TarifaSocial) session.createQuery("from TarifaSocial").uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public BoletoEstudiantil traerBoletoEstudiantil()
	{
		BoletoEstudiantil objeto = null;
		try {
			iniciaOperacion();
			objeto = (BoletoEstudiantil) session.createQuery("from BoletoEstudiantil").uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
}
