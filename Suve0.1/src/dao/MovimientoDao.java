package dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Movimiento;
import datos.Boleto;
import datos.Recarga;
import datos.TipoTransporte;
import datos.LectoraColectivo;
import datos.LectoraEstacion;

public class MovimientoDao {
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

	public int agregar(Movimiento objeto) {
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

	public void actualizar(Movimiento objeto) throws HibernateException {
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

	public void eliminar(Movimiento objeto) throws HibernateException {
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
	public Recarga traerRecargaEstudiantil() {
		Recarga objeto = null;
		try {
			iniciaOperacion();
			objeto = (Recarga) session.createQuery("from Recarga r where (select Max (r.idMovimiento) from Recarga r where r.esBoletoEstudiantil = 1)=r.idMovimiento").uniqueResult();
		}  finally {
			session.close();
		}
		return objeto;
	}
	
	public Movimiento traerMovimiento(long idMovimiento) {
		Movimiento objeto = null;
		try {
			iniciaOperacion();
			objeto = (Movimiento) session.get(Movimiento.class, idMovimiento);
		}  finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Movimiento> traerMovimientos(){
		List<Movimiento> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Movimiento m order by m.fecha desc ").list();
		} finally {
			session.close();
		}
		return lista;
	}
	@SuppressWarnings("unchecked")
	public List<Movimiento> traerMovimientoCompletoPorTarjeta(long idTarjeta) 
	{
		List<Movimiento> lista = new ArrayList<Movimiento>();
		try {
			iniciaOperacion();
			lista = session.createQuery("from Movimiento m inner join fetch m.lectora inner join fetch m.tarjeta where m.tarjeta=" + idTarjeta+" order by m.fecha desc ").list();
			for(Movimiento m:lista) {
				Hibernate.initialize((m.getTarjeta()).getBeneficios());
				if(m.getLectora() instanceof LectoraColectivo)
				{
					Hibernate.initialize(((LectoraColectivo)m.getLectora()).getTransporte());
					Hibernate.initialize(((Boleto)m).getTramoColectivo());
				}
				if(m.getLectora() instanceof LectoraEstacion)
				{
					Hibernate.initialize(((LectoraEstacion)m.getLectora()).getEstacion());
				}
					
			}
			//("from Movimiento m inner join fetch m.lectora as l CASE where type(l) = LectoraColectivo THEN inner join fetch l.transporte END CASE where type(l) = LectoraEstacion THEN inner join fetch l.estacion END")
			
		} finally {
			session.close();
		}
		return lista;
	}
	@SuppressWarnings("unchecked")
	public List<Movimiento> traerMovimientoCompleto() 
	{
		List<Movimiento> lista = new ArrayList<Movimiento>();
		try {
			iniciaOperacion();
			lista = session.createQuery("from Movimiento m inner join fetch m.tarjeta inner join fetch m.lectora order by m.fecha desc").list();
			for(Movimiento m:lista) {
				Hibernate.initialize((m.getTarjeta()).getBeneficios());
				if(m.getLectora() instanceof LectoraColectivo)
				{
					Hibernate.initialize(((LectoraColectivo)m.getLectora()).getTransporte());
					Hibernate.initialize(((Boleto)m).getTramoColectivo());
				}
				if(m.getLectora() instanceof LectoraEstacion)
				{
					Hibernate.initialize(((LectoraEstacion)m.getLectora()).getEstacion());
				}		
			}
		} finally {
			session.close();
		}
		return lista;
	}
		@SuppressWarnings("unchecked")
	public List<Boleto> traerBoletosRedSubeColectivo(long idTarjeta, GregorianCalendar fechaA) 
	{
		List<Boleto> lista = new ArrayList<Boleto>();
		GregorianCalendar fechaB = (GregorianCalendar) fechaA.clone();
		fechaB.add(Calendar.HOUR, -2);
		try {
			iniciaOperacion();
			lista = session.createQuery("from Boleto b inner join fetch b.lectora l inner join fetch l.transporte where b.fecha < :fechaA and b.fecha > :fechaB and b.tarjeta=" + idTarjeta)
					.setParameter("fechaA", fechaA)
					.setParameter("fechaB", fechaB)
					.list();
		} finally {
			session.close();
		}
		return lista;
	}
	@SuppressWarnings("unchecked")
	public List<Boleto> traerBoletosRedSubeTrenYSubte(long idTarjeta, GregorianCalendar fechaA) 
	{
		List<Boleto> lista = new ArrayList<Boleto>();
		GregorianCalendar fechaB = (GregorianCalendar) fechaA.clone();
		fechaB.add(Calendar.HOUR, -2);
		try {
			iniciaOperacion();
			lista = session.createQuery("from Boleto b inner join fetch b.lectora l inner join fetch l.estacion e inner join fetch e.transporte where b.fecha < :fechaA and b.fecha > :fechaB and b.tarjeta=" + idTarjeta)
					.setParameter("fechaA", fechaA)
					.setParameter("fechaB", fechaB)
					.list();
		} finally {
			session.close();
		}
		return lista;
	}
	//No trae solo ultimo boleto de tren(?
	public Boleto traerUltimoBoleto(long idTarjeta) 
	{
		Boleto objeto = null;
		try 
		{
			iniciaOperacion();
			objeto = (Boleto) session.createQuery("from Boleto b inner join fetch b.tramoTrenYSubte t inner join fetch t.seccionViaje inner join fetch t.estacionA ea inner join fetch ea.transporte inner join fetch b.tarjeta where b.idMovimiento in (select max(bb.idMovimiento) from Boleto bb where bb.tarjeta ="+idTarjeta+" and t.estacionB is null)").uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	public Movimiento traerUltimoMovimiento() 
	{
		Movimiento objeto = null;
		try 
		{
			iniciaOperacion();
			objeto = (Movimiento) session.createQuery("from Movimiento m where (select Max (m.idMovimiento) from Movimiento m )=m.idMovimiento").uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Boleto> viajesRealizadosEnColectivo(GregorianCalendar fechaDesde, GregorianCalendar fechaHasta)
	{
		List<Boleto> lista = new ArrayList<Boleto>();
		try 
		{
			iniciaOperacion();
			lista = session.createQuery("from Boleto b inner join fetch b.tarjeta inner join fetch b.lectora l inner join fetch l.transporte where b.fecha >= :fechaDesde and b.fecha <= :fechaHasta ")
					.setParameter("fechaDesde", fechaDesde)
					.setParameter("fechaHasta", fechaHasta)
					.list();
		} finally {
			session.close(); 
		}
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Boleto> viajesRealizadosEnTrenOSubte(GregorianCalendar fechaDesde, GregorianCalendar fechaHasta,TipoTransporte tipoTransporte) 
	{
		List<Boleto> lista = new ArrayList<Boleto>();
		try 
		{
			iniciaOperacion();
			lista = session.createQuery("from Boleto b inner join fetch b.tarjeta inner join fetch b.lectora l inner join fetch l.estacion e inner join fetch e.transporte t where b.fecha >= :fechaDesde and b.fecha <= :fechaHasta and t.tipoTransporte = "+tipoTransporte.ordinal())
					.setParameter("fechaDesde", fechaDesde)
					.setParameter("fechaHasta", fechaHasta)
					.list();
		} finally {
			session.close(); 
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Boleto> viajesRealizadosEnLineaColectivo(GregorianCalendar fechaDesde, GregorianCalendar fechaHasta, long idTransporte) 
	{
		List<Boleto> lista = new ArrayList<Boleto>();
		try 
		{
			iniciaOperacion();
			lista = session.createQuery("from Boleto b inner join fetch b.tarjeta inner join fetch b.lectora l inner join fetch b.tramoColectivo tc inner join fetch tc.seccionViaje  where b.fecha >= :fechaDesde and b.fecha <= :fechaHasta and l.transporte = "+idTransporte)
					.setParameter("fechaDesde", fechaDesde)
					.setParameter("fechaHasta", fechaHasta)
					.list();
		} finally {
			session.close(); 
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Boleto> viajesRealizadosEnLineaTrenOSubte(GregorianCalendar fechaDesde, GregorianCalendar fechaHasta, long idTransporte) 
	{
		List<Boleto> lista = new ArrayList<Boleto>();
		try 
		{
			iniciaOperacion();
			lista = session.createQuery("from Boleto b inner join fetch b.tarjeta inner join fetch b.tramoTrenYSubte tt inner join fetch tt.estacionA e where b.fecha >= :fechaDesde and b.fecha <= :fechaHasta and e.transporte = "+idTransporte)
					.setParameter("fechaDesde", fechaDesde)
					.setParameter("fechaHasta", fechaHasta)
					.list();
		} finally {
			session.close(); 
		}
		return lista;
	}
	
	
	
}

/* DEPRECADOS
public List<Boleto> traerBoleto(){
	List<Boleto> lista = null;
	try {
		iniciaOperacion();
		lista = session.createQuery("from Boleto").list();
	} finally {
		session.close();
	}
	return lista;
}

public List<Recarga> traerRecarga(){
	List<Recarga> lista = null;
	try {
		iniciaOperacion();
		//lista = session.createQuery("from Movimiento m inner join fetch m.lectora inner join fetch m.tarjeta").list();
		lista = session.createQuery("from Recarga r where saldoPendiente = false").list();
	} finally {
		session.close();
	}
	return lista;
}

public List<Movimiento> traerMovimientosPorTarjeta(long idTarjeta) 
{
	List<Movimiento> lista = new ArrayList<Movimiento>();
	try {
		iniciaOperacion();
		lista = session.createQuery("from Movimiento m inner join fetch m.lectora where m.tarjeta=" + idTarjeta+" order by m.fecha desc ").list();
	} finally {
		session.close();
	}
	return lista;
}
*/

/*

public List<Boleto> traerBoletosRedSube(long idTarjeta, GregorianCalendar fechaA) 
{
	List<Boleto> lista = new ArrayList<Boleto>();
	GregorianCalendar fechaB = (GregorianCalendar) fechaA.clone();
	fechaB.add(Calendar.HOUR, -2);
	try {
		iniciaOperacion();
		lista = session.createQuery("from Boleto b where b.fecha < :fechaA and b.fecha > :fechaB and b.tarjeta=" + idTarjeta)
				.setParameter("fechaA", fechaA)
				.setParameter("fechaB", fechaB)
				.list();
	} finally {
		session.close();
	}
	return lista;
}

*/
/*
public Boleto traerBoleto(long idMovimiento) {
	Boleto objeto = null;
	try {
		iniciaOperacion();
		objeto = (Boleto) session.get(Boleto.class, idMovimiento);
	}  finally {
		session.close();
	}
	return objeto;
}

public Recarga traerRecarga(long idMovimiento) {
	Recarga objeto = null;
	try {
		iniciaOperacion();
		objeto = (Recarga) session.get(Recarga.class, idMovimiento);
	}  finally {
		session.close();
	}
	return objeto;
}
*/
