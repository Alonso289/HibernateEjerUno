package daoTablas;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import FilesMapping.Departamento;
import FilesMapping.Empleado;

public class EmpleadoDAO {

	public static void insertEmpleado(Session s, Empleado empleado) {				
		s.save(empleado);		
	}
	
	public static void updateEmpleado(Session s, Empleado empleadoActualizado) {				

		Empleado empleado = s.get(Empleado.class, empleadoActualizado.getCodigo());
		if (empleado != null) 
			empleado = empleadoActualizado;
					
	}
	
	public static void deleteEmpleado(Session s, int codigo) {			
		
		Empleado empleado = s.get(Empleado.class, codigo);		
		s.delete(empleado);	
	}
	// hql queries

	// Native queries
		
	// Criteria queries
	public static List<Empleado> getAllEmpleados(Session s) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Empleado.class);
		List<Empleado> result = criteria.getExecutableCriteria(s).list();
		return result;
	}
	
	public static Empleado getEmpleado(Session s, int codigo) {
		// deprecado desde 5.2
		Criteria criteria = s.createCriteria(Empleado.class);
		Empleado result = (Empleado)criteria.add(Restrictions.eq("codigo", codigo))
											.setMaxResults(1)
											.uniqueResult();		
		return result;
	}
}
