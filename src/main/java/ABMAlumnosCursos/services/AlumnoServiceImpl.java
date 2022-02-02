package ABMAlumnosCursos.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ABMAlumnosCursos.models.Alumno;
import ABMAlumnosCursos.repositories.AlumnoRepository;

@Service
@Transactional
public class AlumnoServiceImpl implements AlumnoService {

	private AlumnoRepository alumnoRepository;

	@Autowired
	public AlumnoServiceImpl(AlumnoRepository alumnoRepository) {
		this.alumnoRepository = alumnoRepository;
	}

	@Override
	public void altaAlumno(Alumno alumno) {
		this.alumnoRepository.altaAlumno(alumno);

	}

	@Override
	public void eliminarAlumno(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Alumno listarUnAlumno(Integer id) {
		return this.alumnoRepository.listarUnAlumno(id);
	}

	@Override
	public List<Alumno> listarAlumnos() {
		return this.alumnoRepository.listarAlumnos();
	}

	@Override
	public Alumno verificarAlumno(Alumno alumno) {
		return this.alumnoRepository.verificarAlumno(alumno);
	}

}
