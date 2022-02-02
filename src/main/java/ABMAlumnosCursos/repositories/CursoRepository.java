package ABMAlumnosCursos.repositories;

import java.util.List;

import ABMAlumnosCursos.models.Alumno;
import ABMAlumnosCursos.models.Curso;

public interface CursoRepository {

	public void registrarCurso(Curso curso);

	public void agregarAlumno(Integer idAlumno, Integer idCurso);

	public Curso listarUnCurso(Integer id);

	public List<Alumno> alumnosIncriptos(Integer id);

	public List<Curso> listarCursos();

	public List<Alumno> alumnosSinCurso();

	public void eliminarAlumnoDeCurso(Integer idCurso, Integer idAlumno);
}
