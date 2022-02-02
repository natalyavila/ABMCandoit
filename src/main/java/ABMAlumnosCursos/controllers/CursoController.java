package ABMAlumnosCursos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ABMAlumnosCursos.models.Alumno;
import ABMAlumnosCursos.models.Curso;
import ABMAlumnosCursos.services.AlumnoService;
import ABMAlumnosCursos.services.CursoService;

@Controller
@RequestMapping(value = "cursos")
public class CursoController {
	private CursoService cursoService;
	private AlumnoService alumnoService;

	@Autowired
	public CursoController(CursoService cursoService, AlumnoService alumnoService) {
		this.cursoService = cursoService;
		this.alumnoService = alumnoService;
	}

	@RequestMapping(value = "/registrar-curso", method = RequestMethod.GET)
	public ModelAndView registrarCurso() {

		ModelMap model = new ModelMap();

		Curso curso = new Curso();

		model.put("curso", curso);

		return new ModelAndView("registrar-curso", model);
	}

	@RequestMapping(value = "procesar-curso", method = RequestMethod.POST)
	public ModelAndView procesarCurso(@ModelAttribute("curso") Curso curso) {

		ModelMap model = new ModelMap();

		if (curso.getNombre() == "" || curso.getProfesor() == "" || curso.getTurno() == "") {
			model.put("mensaje", "Complete los campos faltantes.");
			return new ModelAndView("registrar-curso", model);
		}

		this.cursoService.registrarCurso(curso);
		model.put("curso", curso);
		return new ModelAndView("redirect:/cursos/lista-cursos");
	}

	@RequestMapping(value = "/lista-cursos", method = RequestMethod.GET)
	public ModelAndView listarCursos() {

		ModelMap model = new ModelMap();

		List<Curso> listaCursos = this.cursoService.listarCursos();

		model.put("listaCursos", listaCursos);

		return new ModelAndView("listado-cursos", model);
	}

	@RequestMapping(value = "/curso-detalle/{curso.id}", method = RequestMethod.GET)
	public ModelAndView listarUnCurso(@PathVariable("curso.id") Integer id) {

		ModelMap model = new ModelMap();

		try {

			Curso curso = this.cursoService.listarUnCurso(id);

			List<Alumno> alumnos = this.cursoService.alumnosIncriptos(id);

			if (curso.equals(null)) {
				return new ModelAndView("redirect:/cursos/lista-cursos");
			}

			model.put("curso", curso);

			model.put("cantidad", alumnos.size());

			model.put("alumnos", alumnos);

			return new ModelAndView("curso-detalle", model);

		} catch (Exception e) {
			model.put("error", e.getMessage());
			return new ModelAndView("error", model);

		}

	}

	@RequestMapping(value = "/agregar-alumno/{curso.id}", method = RequestMethod.GET)
	public ModelAndView alumnosSinCurso(@PathVariable("curso.id") Integer idCurso) {

		ModelMap model = new ModelMap();

		try {

			Curso curso = this.cursoService.listarUnCurso(idCurso);

			List<Alumno> alumnosSinCurso = this.cursoService.alumnosSinCurso();

			if (curso.equals(null)) {
				return new ModelAndView("redirect:/cursos/lista-cursos");
			}

			model.put("curso", curso);
			model.put("listaAlumnosSinCurso", alumnosSinCurso);
			model.put("cantidad", alumnosSinCurso.size());

			return new ModelAndView("alumnos-sin-curso", model);

		} catch (Exception e) {
			model.put("error", e.getMessage());
			return new ModelAndView("error", model);

		}

	}

	@RequestMapping(value = "/agregar-alumno/{curso.id}/{alumno.id}", method = RequestMethod.GET)
	public ModelAndView agregarAlumno(@PathVariable("curso.id") Integer idCurso,
			@PathVariable("alumno.id") Integer idAlumno) {

		ModelMap model = new ModelMap();

		Curso curso = this.cursoService.listarUnCurso(idCurso);
		Alumno alumno = this.alumnoService.listarUnAlumno(idAlumno);

		this.cursoService.agregarAlumno(idAlumno, idCurso);

		model.put("curso", curso);
		model.put("alumno", alumno);

		return new ModelAndView("redirect:/cursos/curso-detalle/{curso.id}");

	}

	@RequestMapping(value = "eliminar-alumno-curso/{curso.id}/{alumno.id}", method = RequestMethod.GET)
	public ModelAndView eliminarAlumnoDeCurso(@PathVariable("curso.id") Integer idCurso,
			@PathVariable("alumno.id") Integer idAlumno) {

		ModelMap model = new ModelMap();

		Curso curso = this.cursoService.listarUnCurso(idCurso);
		Alumno alumno = this.alumnoService.listarUnAlumno(idAlumno);

		this.cursoService.eliminarAlumnoDeCurso(idCurso, idAlumno);

		model.put("alumno", alumno);
		model.put("curso", curso);

		return new ModelAndView("redirect:/cursos/curso-detalle/{curso.id}");
	}

}
