package ABMAlumnosCursos.services;

import java.util.List;

import ABMAlumnosCursos.models.Alumno;

public interface AlumnoService {

	public void altaAlumno(Alumno alumno);
	
	public void eliminarAlumno(Integer id);
	
	public Alumno listarUnAlumno(Integer id);
	
	public List<Alumno> listarAlumnos();

	public Alumno verificarAlumno(Alumno alumno);
}
