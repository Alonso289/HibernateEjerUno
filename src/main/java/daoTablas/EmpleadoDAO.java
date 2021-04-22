package daoTablas;

import java.util.Calendar;
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

	//OBTIENE LISTADO EMPLEADO
	public static List<Empleado> getAllEmpleados(Session s, int idDepartamento) {
		String hQuery = "from Empleado where cod_departamento ="+idDepartamento;
		List<Empleado> empleadoList = s.createQuery(hQuery, Empleado.class)
				   	   			           .list();
		return empleadoList;
	}
	
	//OBTIENE LISTADO EMPLEADO MAYORES DE UNA EDAD
	public static List<Empleado> getAllEmpleadosMayores(Session s, int edad) {
		
		Criteria cr = s.createCriteria(Empleado.class);	
		Calendar cal= Calendar.getInstance();
		int ano = cal.get(Calendar.YEAR);		
		int anoReal = (ano - edad); 
		
		String fecha =  "00/00/"+(anoReal-2000);
		cr.add(Restrictions.le("fechaNacimiento", fecha));
		List listaEmpleados = cr.list();
		
		return listaEmpleados;
	}
	
	//OBTIENE UN EMPLEADO
	public static Empleado getEmpleado(Session s, int codigo) {
		// deprecado desde 5.2
		Criteria criteria = s.createCriteria(Empleado.class);
		Empleado result = (Empleado)criteria.add(Restrictions.eq("codigo", codigo))
											.setMaxResults(1)
											.uniqueResult();		
		return result;
	}	
}
