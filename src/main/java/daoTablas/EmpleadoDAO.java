package daoTablas;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import FilesMapping.Empleado;

public class EmpleadoDAO {

	public static void insertProviders(Session s, int numEmpleado) {
		for (int id = 1; id <= numEmpleado; id++) {
			insertEmpleado(s, id);
		}
	}
	
	public static void insertEmpleado(Session s, int codigo) {
		
		String nombre = "nombre "+codigo;
		String apellido1 = "apellido1 "+codigo;
		String apellido2 = "apellido2 "+codigo;
		String lugarNacimiento = "lugarNacimiento "+codigo;
		String fechaNacimiento = "fechaNacimiento "+codigo;
		String direccion = "direccion "+codigo;
		String telefono = "telefono "+codigo;
		String puesto = "puesto "+codigo;
		int codDepartamento = 12;
		
		Empleado empleado = new Empleado(codigo, nombre, apellido1, apellido2, lugarNacimiento, fechaNacimiento, direccion, telefono, puesto, codDepartamento);
		s.save(empleado);
	}

	// hql queries

	// Native queries
		
	// Criteria queries
	public static List<Empleado> getAllProviders(Session s) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Empleado.class);
		List<Empleado> result = criteria.getExecutableCriteria(s).list();
		return result;
	}
	
	public static Empleado getProvider(Session s, int codigo) {
		// deprecado desde 5.2
		Criteria criteria = s.createCriteria(Empleado.class);
		Empleado result = (Empleado)criteria.add(Restrictions.eq("codigo", codigo))
											.setMaxResults(1)
											.uniqueResult();
		
//		CriteriaBuilder builder = s.getCriteriaBuilder();
//		CriteriaQuery<Provider> query = builder.createQuery(Provider.class);
//		Root<Provider> root = query.from(Provider.class);
//     	query.select(root).where(builder.equal(root.get("providerId"), providerId));
//      Query<Provider> q = s.createQuery(query);
//      Provider result = q.getSingleResult();
		return result;
	}
}
