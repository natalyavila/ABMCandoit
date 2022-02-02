package ABMAlumnosCursos.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ABMAlumnosCursos.models.Alumno;
import ABMAlumnosCursos.models.Curso;

@Repository
public class CursoRepositoryImpl implements CursoRepository {

	private SessionFactory sessionFactory;

	@Autowired
	public CursoRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	/*
	 * Se registra un curso en la base de datos
	 */
	@Override
	public void registrarCurso(Curso curso) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

		session.save(curso);

		trans.commit();

	}

	/*
	 * Se lista un curso mediante su id
	 */
	@Override
	public Curso listarUnCurso(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

		Curso curso = (Curso) session.createCriteria(Curso.class).add(Restrictions.idEq(id)).uniqueResult();

		trans.commit();

		return curso;
	}

	/*
	 * Se listan todos los cursos que se encuentran registrados en la base de datos
	 */
	@Override
	public List<Curso> listarCursos() {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();
		List<Curso> listaCursos = session.createCriteria(Curso.class).list();

		trans.commit();

		return listaCursos;
	}

	/*
	 * Se agrega un alumno a un curso
	 */
	@Override
	public void agregarAlumno(Integer idAlumno, Integer idCurso) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

		Alumno alumno = (Alumno) session.createCriteria(Alumno.class).add(Restrictions.idEq(idAlumno)).uniqueResult();

		Curso curso = (Curso) session.createCriteria(Curso.class).add(Restrictions.idEq(idCurso)).uniqueResult();

		alumno.setCurso(curso);

		session.update(alumno);

		trans.commit();
	}

	/*
	 * Se listan todos alumnos que se encuentran registrados en un curso
	 * especificado por el id que se pasa por paramatro
	 */
	@Override
	public List<Alumno> alumnosIncriptos(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

		List<Alumno> listaInscriptos = session.createCriteria(Alumno.class).createAlias("curso", "cursoBuscado")
				.add(Restrictions.eq("cursoBuscado.id", id)).list();

		trans.commit();

		return listaInscriptos;
	}

	/*
	 * Se listan todos los alumnos que no se encuentran en un curso
	 */
	@Override
	public List<Alumno> alumnosSinCurso() {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

		List<Alumno> alumnosSinCurso = session.createCriteria(Alumno.class).add(Restrictions.isNull("curso")).list();

		trans.commit();

		return alumnosSinCurso;
	}

	/*
	 * Se elimina un alumno de un curso especificados los ids pasados por parametro
	 */
	@Override
	public void eliminarAlumnoDeCurso(Integer idCurso, Integer idAlumno) {
		Session session = sessionFactory.getCurrentSession();
		Transaction trans = session.beginTransaction();

		Alumno alumno = (Alumno) session.createCriteria(Alumno.class).add(Restrictions.idEq(idAlumno)).uniqueResult();

		Curso curso = (Curso) session.createCriteria(Curso.class).add(Restrictions.idEq(idCurso)).uniqueResult();

		alumno.setCurso(null);

		trans.commit();

	}

}
