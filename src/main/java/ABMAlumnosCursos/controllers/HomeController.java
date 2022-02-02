package ABMAlumnosCursos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ABMAlumnosCursos.services.AlumnoService;
import ABMAlumnosCursos.services.CursoService;

@Controller
public class HomeController {
	private AlumnoService alumnoService;
	private CursoService cursoService;

	@Autowired
	public HomeController(AlumnoService alumnoService, CursoService cursoService) {
		this.alumnoService = alumnoService;
		this.cursoService = cursoService;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {

		ModelMap model = new ModelMap();

		return new ModelAndView("home", model);
	}

}
