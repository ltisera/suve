package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import datos.SeccionViaje;
import datos.TramoColectivo;

public class SeccionViajeDao 
{
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
		
	public int agregar(SeccionViaje objeto) {
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
	
	public SeccionViaje traerSeccionViaje(long idSeccionViaje) throws HibernateException {
		SeccionViaje objeto = null;
		try {
			iniciaOperacion();
			objeto = (SeccionViaje) session.get(SeccionViaje.class , idSeccionViaje);
		} finally {
			session.close();
		}
		return objeto;
	}
/*
	public SeccionViaje traerSeccionSubte() 
	{
		SeccionViaje objeto = null;
		try {
			iniciaOperacion();
			objeto = (SeccionViaje) session.createQuery("from SeccionViaje sv where sv.seccion = 'Seccion Subte'").uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	public SeccionViaje traerSeccionMaximaTren() 
	{
		SeccionViaje objeto = null;
		try {
			iniciaOperacion();
			objeto = (SeccionViaje) session.createQuery("from SeccionViaje sv where sv.seccion = 'Seccion Maxima Tren'").uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	*/
}
