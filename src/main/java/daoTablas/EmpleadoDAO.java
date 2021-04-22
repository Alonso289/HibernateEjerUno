package daoTablas;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import FilesMapping.Departamento;
import FilesMapping.Empleado;

public class EmpleadoDAO {

	//INSERTA UN EMPLEADO
	public static void insertEmpleado(Session s, Empleado empleado) {				
		s.save(empleado);		
	}
	
	//ACTUALIZA UN EMPLEADO
	public static void updateEmpleado(Session s, Empleado empleadoActualizado) {				

		Empleado empleado = s.get(Empleado.class, empleadoActualizado.getCodigo());
		empleado.setNombre(empleadoActualizado.getNombre());
		empleado.setApellido1(empleadoActualizado.getApellido1());
		empleado.setApellido2(empleadoActualizado.getApellido2());
		empleado.setDireccion(empleadoActualizado.getDireccion());
		empleado.setFechaNacimiento(empleadoActualizado.getFechaNacimiento());
		empleado.setLugarNacimiento(empleadoActualizado.getLugarNacimiento());
		empleado.setPuesto(empleadoActualizado.getPuesto());
		empleado.setTelefono(empleadoActualizado.getTelefono());
		empleado.setCodDepartamento(empleadoActualizado.getCodDepartamento());
		
		if (empleado != null) 
			empleado = empleadoActualizado;
					
	}
	
	//ELIMINA UN EMPLEADO
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
