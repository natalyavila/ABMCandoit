package ABMAlumnosCursos.repositories;

import java.util.List;

import ABMAlumnosCursos.models.Alumno;

public interface AlumnoRepository {

	public void altaAlumno(Alumno alumno);

	public Alumno listarUnAlumno(Integer id);

	public Alumno verificarAlumno(Alumno alumno);

	public List<Alumno> listarAlumnos();

}
