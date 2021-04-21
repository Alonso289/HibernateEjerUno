package daoTablas;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import FilesMapping.Departamento;

public class DepartamentoDAO {

	public static void insertProviders(Session s, int numDepartamento) {
		for (int id = 1; id <= numDepartamento; id++) {
			insertEmpleado(s, id);
		}
	}
	
	public static void insertEmpleado(Session s, int codigo) {
		
		String nombre = "nombre "+codigo;
		int codResponsable = 12;
		
		Departamento departamento = new Departamento(codigo, nombre, codResponsable);
		s.save(departamento);
	}

	// hql queries

	// Native queries
		
	// Criteria queries
	public static List<Departamento> getAllProviders(Session s) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Departamento.class);
		List<Departamento> result = criteria.getExecutableCriteria(s).list();
		return result;
	}
	
	public static Departamento getProvider(Session s, int codigo) {
		// deprecado desde 5.2
		Criteria criteria = s.createCriteria(Departamento.class);
		Departamento result = (Departamento)criteria.add(Restrictions.eq("codigo", codigo))
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
