package principal;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import daoTablas.EmpleadoDAO;
import FilesMapping.Empleado;
import FilesMapping.Departamento;

public class HibernateMain {
	
	private static Logger logger = LogManager.getLogger(HibernateMain.class);
	
	static SessionFactory sessionFactory;
	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		logger.info("Proceso inicializado");
		// La SessionFactory se instancia 1 vez por ejecucion del programa.
		// Todas las sesiones de hibernate se obtienen de esa SessionFactory;	
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
		  
			tx = session.beginTransaction();
			
		//Operaciones de empleado
			Empleado empleado = new Empleado();
			//INSERTA
			/*
			System.out.println("Registrando empleado");
			pideDatosEmpleado(empleado);			
			EmpleadoDAO.insertEmpleado(session, empleado);
			logger.info("Empleado insertado");
			*/
			
			//ACTUALIZA
			/*
			System.out.println("Actualizando empleado");
			pideDatosEmpleado(empleado);
			EmpleadoDAO.updateEmpleado(session, empleado);
			logger.info("Empleado actualizado");
			*/
			
			//ELIMINA
			/*
			System.out.println("Eliminando empleado");
			int codigo = pideCodigo();
			EmpleadoDAO.deleteEmpleado(session, codigo);
			logger.info("Empleado eliminado");
			*/
			
			//Muestra el listado de empleados
			/*
			System.out.println("Obteniendo lista de empleados");
			System.out.println("Introduzca un codigo de departamento: ");
			int idDepartamento = teclado.nextInt();
			List<Empleado> empleados = EmpleadoDAO.getAllEmpleados(session, idDepartamento);
			logger.info("Numero de empleados = "+ empleados.size());
			empleados.stream().forEach(x -> logger.info(x.toString()));
			*/
			//Muestra los empleados mayores de una cierta edad
			System.out.println("Obteniendo lista de empleados mayores a cierta edad");
			System.out.println("Introduzca una edad: ");
			int edad = teclado.nextInt();
			List<Empleado> empleados = EmpleadoDAO.getAllEmpleadosMayores(session, edad);
			logger.info("Numero de empleados mayores a "+ edad +"= "+ empleados.size());
			empleados.stream().forEach(x -> logger.info(x.toString()));
			
		//OPERACIONES DEPARTAMENTO
			Departamento departamento = new Departamento();
			
			 //INSERTA
			/*
			System.out.println("Registrando departamento");
			pideDatosDepartamento(departamento);			
			DepartamentoDAO.insertDepartamento(session, departamento);
			logger.info("Departamento insertado");
			*/
			
			//ACTUALIZA
			/*
			System.out.println("Actualizando departamento");
			pideDatosDepartamento(departamento);
			DepartamentoDAO.updateDepartamento(session, departamento);
			logger.info("Departamento actualizado");
			*/
			//ELIMINA
			/*
			System.out.println("Eliminando departamento");
			codigo = pideCodigo();
			DepartamentoDAO.deleteDepartamento(session, codigo);
			logger.info("Departamento eliminado");
			*/
			tx.commit();
			session.close();
			
			//Crea una nueva session para comprobar los cambios
			/*
			 System.out.println("Comprobando cambios");
			*/
			//comprobacion(session);
									

			System.out.println("Se ha cerrado la aplicacion");
			
		}finally {
			if (session != null) {
				session.close();
			}
		}				
		logger.info("Proceso finalizado");
	}

	//Obtiene los datos del departamento	
	private static void pideDatosDepartamento(Departamento departamento) {
		
		System.out.println("Proceso de recopilacion de datos del departamento.");
		System.out.println("Introduzca el codigo del departamento");
		departamento.setCodigo(teclado.nextInt());
		System.out.println("Introduzca el nombre del departamento");
		teclado.nextLine();
		departamento.setNombre(teclado.nextLine());
		System.out.println("Introduzca el codigo departamento del departamento");
		departamento.setCodResponsable(teclado.nextInt());
		
	}

	//Obtiene un id
	private static int pideCodigo() {
		
		System.out.print("Introduzca el id del elemento a borrar");
		return teclado.nextInt();
	}

	//Obtiene un id de empleado y lo muestra 
	private static void comprobacion(Session session) {
		// Abrimos nueva sesion y recuperamos el empleado para comprobar que se ha actualizado
		session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("Introduzca un id de empleado");
		Empleado empleadoModificado = EmpleadoDAO.getEmpleado(session, teclado.nextInt());
		logger.info(empleadoModificado.toString());
		System.out.println(empleadoModificado.toString());
		
	}

	//Obtiene los datos del empleado
	private static void pideDatosEmpleado(Empleado empleado) {
		System.out.println("Proceso de recopilacion de datos del empleado.");
		System.out.println("Introduzca el codigo del empleado");
		empleado.setCodigo(teclado.nextInt());
		System.out.println("Introduzca el nombre del empleado");
		teclado.nextLine();
		empleado.setNombre(teclado.nextLine());
		System.out.println("Introduzca el apellido1 del empleado");
		empleado.setApellido1(teclado.nextLine());
		System.out.println("Introduzca el apellido2 del empleado");
		empleado.setApellido2(teclado.nextLine());
		System.out.println("Introduzca el lugar de nacimiento del empleado");
		empleado.setLugarNacimiento(teclado.nextLine());
		System.out.println("Introduzca la fecha de nacimiento del empleado");
		empleado.setFechaNacimiento(teclado.nextLine());
		System.out.println("Introduzca la direccion del empleado");
		empleado.setDireccion(teclado.nextLine());
		System.out.println("Introduzca el telefono del empleado");
		empleado.setTelefono(teclado.nextLine());
		System.out.println("Introduzca el puesto del empleado");
		empleado.setPuesto(teclado.nextLine());
		System.out.println("Introduzca el codido del Departamento del empleado");
		empleado.setCodDepartamento(teclado.nextInt());
		
	}	
}
