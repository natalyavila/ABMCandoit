package ABMAlumnosCursos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ABMAlumnosCursos.models.Alumno;
import ABMAlumnosCursos.services.AlumnoService;

@Controller
@RequestMapping(value = "/alumnos")
public class AlumnoController {

	private AlumnoService alumnoService;

	@Autowired
	public AlumnoController(AlumnoService alumnoService) {
		this.alumnoService = alumnoService;
	}

	@RequestMapping(value = "/alta-alumno", method = RequestMethod.GET)
	public ModelAndView altaAlumno() {

		ModelMap model = new ModelMap();

		Alumno alumno = new Alumno();

		model.put("alumno", alumno);

		return new ModelAndView("alta-alumno", model);
	}

	@RequestMapping(value = "procesar-alumno", method = RequestMethod.POST)
	public ModelAndView procesarAlumno(@ModelAttribute("alumno") Alumno alumno) {

		ModelMap model = new ModelMap();

		if (alumno.getNombre().equals(null) || alumno.getApellido().equals(null) || alumno.getDni() == null) {
			model.put("mensaje", "Complete los campos faltantes.");
			return new ModelAndView("alta-alumno", model);
		}

		if (this.alumnoService.verificarAlumno(alumno) != null) {
			model.put("mensaje", "El alumno ingresado ya se encuentra registrado.");
			return new ModelAndView("alta-alumno", model);
		}

		this.alumnoService.altaAlumno(alumno);
		model.put("alumno", alumno);
		return new ModelAndView("redirect:/alumnos/lista-alumnos");

	}

	@RequestMapping(value = "/alumno-detalle/{alumno.id}", method = RequestMethod.GET)
	public ModelAndView listarUnAlumno(@PathVariable("alumno.id") Integer id) {

		ModelMap model = new ModelMap();

		try {

			Alumno alumno = this.alumnoService.listarUnAlumno(id);

			if (alumno.equals(null)) {
				return new ModelAndView("redirect:/alumnos/lista-alumnos");
			}

			model.put("alumno", alumno);

			return new ModelAndView("alumno-detalle", model);

		} catch (Exception e) {
			model.put("error", e.getMessage());
			return new ModelAndView("error", model);
		}

	}

	@RequestMapping(value = "/lista-alumnos", method = RequestMethod.GET)
	public ModelAndView listarAlumnos() {

		ModelMap model = new ModelMap();

		List<Alumno> listaAlumnos = this.alumnoService.listarAlumnos();

		model.put("listaAlumnos", listaAlumnos);

		return new ModelAndView("listado-alumnos", model);
	}

}
