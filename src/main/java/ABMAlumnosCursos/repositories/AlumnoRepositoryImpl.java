package ABMAlumnosCursos.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ABMAlumnosCursos.models.Alumno;

@Repository
public class AlumnoRepositoryImpl implements AlumnoRepository {

	private SessionFactory sessionFactory;

	@Autowired
	public AlumnoRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * Se registra un alumno en la base de datos
	 */

	@Override
	public void altaAlumno(Alumno alumno) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

		session.save(alumno);

		trans.commit();

	}

	/*
	 * Se lista un alumno mediante su id
	 */
	@Override
	public Alumno listarUnAlumno(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

		Alumno alumno = (Alumno) session.createCriteria(Alumno.class).add(Restrictions.idEq(id)).uniqueResult();

		trans.commit();

		return alumno;
	}

	/*
	 * Se listan todos los alumnos que se encuentran registrados en la base de datos
	 */
	@Override
	public List<Alumno> listarAlumnos() {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

		List<Alumno> listaAlumnos = session.createCriteria(Alumno.class).list();

		trans.commit();

		return listaAlumnos;
	}

	/*
	 * Se verifica que no se puedan registrar alumnos con el mismo numero de dni
	 */
	@Override
	public Alumno verificarAlumno(Alumno alumno) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

		Alumno alumnoEncontrado = (Alumno) session.createCriteria(Alumno.class)
				.add(Restrictions.eqOrIsNull("dni", alumno.getDni())).uniqueResult();

		trans.commit();

		return alumnoEncontrado;
	}

}
