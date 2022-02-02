package ABMAlumnosCursos.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ABMAlumnosCursos.models.Alumno;
import ABMAlumnosCursos.models.Curso;
import ABMAlumnosCursos.repositories.CursoRepository;

@Transactional
@Service
public class CursoServiceImpl implements CursoService {

	private CursoRepository cursoRepository;

	@Autowired
	public CursoServiceImpl(CursoRepository cursoRepository) {
		this.cursoRepository = cursoRepository;
	}

	@Override
	public void registrarCurso(Curso curso) {
		this.cursoRepository.registrarCurso(curso);

	}

	@Override
	public Curso listarUnCurso(Integer id) {
		return this.cursoRepository.listarUnCurso(id);
	}

	@Override
	public List<Curso> listarCursos() {
		return this.cursoRepository.listarCursos();
	}

	@Override
	public void agregarAlumno(Integer idAlumno, Integer idCurso) {
		this.cursoRepository.agregarAlumno(idAlumno, idCurso);
		
	}

	@Override
	public List<Alumno> alumnosIncriptos(Integer id) {
		return this.cursoRepository.alumnosIncriptos(id);
	}

	@Override
	public List<Alumno> alumnosSinCurso() {
		return this.cursoRepository.alumnosSinCurso();
	}

	@Override
	public void eliminarAlumnoDeCurso(Integer idCurso, Integer idAlumno) {
		this.cursoRepository.eliminarAlumnoDeCurso(idCurso, idAlumno);
		
	}

}
