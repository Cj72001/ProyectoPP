package com.uca.spring.controller;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uca.spring.model.ActividadesExtra;
import com.uca.spring.model.Carrera;
import com.uca.spring.model.Comentario;
import com.uca.spring.model.Estudiante;
import com.uca.spring.model.Logs;
import com.uca.spring.model.Materia;
import com.uca.spring.model.MateriaAprobada;
import com.uca.spring.model.MensajeMantenimiento;
import com.uca.spring.service.ActividadesExtraService;
import com.uca.spring.service.CarreraService;
import com.uca.spring.service.ComentarioService;
import com.uca.spring.service.EstudianteService;
import com.uca.spring.service.LogsService;
import com.uca.spring.service.MateriaService;
import com.uca.spring.service.MensajeMantenimientoService;
import com.uca.spring.util.Util2;

@Controller
@RequestMapping("/")
public class AppController {

	// services para DML de la bdd
	@Autowired
	ActividadesExtraService actividadesExtraService;
	@Autowired
	CarreraService carreraService;
	@Autowired
	EstudianteService estudianteService;
	@Autowired
	MateriaService materiaService;
	@Autowired
	LogsService logsService;
	@Autowired
	MensajeMantenimientoService mensajeService;
	@Autowired
	ComentarioService comentarioService;

	
	//Creación de variables que se ocupan a nivel global para cada action
	boolean estudianteExiste = false;
	boolean contraActualizada = false;
	boolean usuarioActualizado = false;
	boolean miMateriaEncontrada = false;
	boolean materiaPosible = false;
	String nuevasMateriasPosibles = "";
	String nuevasMateriasAprobadas = "";
	
	//Mensaje de mantenimiento inicializacion
	//MensajeMantenimiento mensaje = new MensajeMantenimiento();
	
	// Estudiante logueado
	Estudiante estudianteLogeado = new Estudiante();
	Carrera carreraEstudianteLogeado = new Carrera(); 

	//Creando un estudiante de ejemplo
	Estudiante estudianteEjemplo = new Estudiante();
	Carrera carreraEstudianteEjemplo = new Carrera();

	// Creando estudiante Omar
	Estudiante estudianteOmar = new Estudiante();
	Carrera carreraEstudianteOmar = new Carrera();
	ActividadesExtra actividadEstudianteOmar1 = new ActividadesExtra();
	ActividadesExtra actividadEstudianteOmar2 = new ActividadesExtra();
	
	
	/* Creando todos los objetos Materia para la malla curricular (ing informatica): */
	
	Materia materia0 = new Materia();
	Materia materia1 = new Materia();
	Materia materia2 = new Materia();
	Materia materia3 = new Materia();
	Materia materia4 = new Materia();
	Materia materia5 = new Materia();
	Materia materia6 = new Materia();
	Materia materia7 = new Materia();
	Materia materia8 = new Materia();
	Materia materia9 = new Materia();
	Materia materia10 = new Materia();
	Materia materia11 = new Materia();
	Materia materia12 = new Materia();
	Materia materia13 = new Materia();
	Materia materia14 = new Materia();
	Materia materia15 = new Materia();
	Materia materia16 = new Materia();
	Materia materia17 = new Materia();
	Materia materia18 = new Materia();
	Materia materia19 = new Materia();
	Materia materia20 = new Materia();
	Materia materia21 = new Materia();
	Materia materia22 = new Materia();
	Materia materia23 = new Materia();
	Materia materia24 = new Materia();
	Materia materia25 = new Materia();
	Materia materia26 = new Materia();
	Materia materia27 = new Materia();
	Materia materia28 = new Materia();
	Materia materia29 = new Materia();
	Materia materia30 = new Materia();
	Materia materia31 = new Materia();
	Materia materia32 = new Materia();
	Materia materia33 = new Materia();
	Materia materia34 = new Materia();
	Materia materia35 = new Materia();
	Materia materia36 = new Materia();
	Materia materia37 = new Materia();
	Materia materia38 = new Materia();
	Materia materia39 = new Materia();
	Materia materia40 = new Materia();
	Materia materia41 = new Materia();
	Materia materia42 = new Materia();
	Materia materia43 = new Materia();
	Materia materia44 = new Materia();
	
	

	       /* ACTIONS PARA RUTAS (para cargar jsp): */
	// -------------------------------------------------------------------------------------------------------------------------	
	
	// Action que se invoca al iniciar la app en la ruta (/)
	@GetMapping("/")
	public String getForm(Model model) {

		//creando el mensaje de mantenimiento iniciado en false (no hay mantenimiento programado)
		/*mensaje.setIdMensaje(1);
		mensaje.setDiaInicio("");
		mensaje.setHoraInicio("");
		mensaje.setDiaFin("");
		mensaje.setHoraFin("");
		mensaje.setMensajeActivo(false);
		mensajeService.createMensajeMantenimiento(mensaje); */


		// Seteando atributos para estudianteOmar
		estudianteOmar.setCarnetEstudiante(38619);
		estudianteOmar.setIdEstudiante(1);
		estudianteOmar.setNombreEstudiante("Omar Flores Alas");
		estudianteOmar.setContrasenaEstudiante("123");
		estudianteOmar.setCarreraEstudiante(1);
		estudianteService.createEstudiante(estudianteOmar);

		// seteando carrera para el estudiante Omar
		carreraEstudianteOmar.setIdCarrera(1);
		carreraEstudianteOmar.setUvAprobadas(102);
		carreraEstudianteOmar.setCantidadMateriasAprobadas(4);
		carreraEstudianteOmar.setMateriasAprobadas("1,2,3,4");
		carreraEstudianteOmar.setNotaAprobada("10,7,10,8");
		carreraEstudianteOmar.setCantidadMateriasPosibles(4);
		carreraEstudianteOmar.setMateriasPosibles("5,6,7,8");
		carreraEstudianteOmar.setCantidadActividadesExtracurriculares(2);
		carreraService.createCarrera(carreraEstudianteOmar);
		
		//Creando actividades para estudianteOmar
		actividadEstudianteOmar1.setIdActividadesExtra(2);
		actividadEstudianteOmar1.setIdEstudiante(1);
		actividadEstudianteOmar1.setNombreActividadesExtra("Reunirse con el grupo de ARI 10:00pm");

		actividadEstudianteOmar2.setIdActividadesExtra(3);
		actividadEstudianteOmar2.setIdEstudiante(1);
		actividadEstudianteOmar2.setNombreActividadesExtra("Renovar CARNET miercoles 7 junio");

		actividadesExtraService.createActividadExtra(actividadEstudianteOmar1);
		actividadesExtraService.createActividadExtra(actividadEstudianteOmar2);



		// seteando materias (seran las materias aprobadas relacionadas al estudiante)
		// para ejemplo (este objeto se enlazara con Estudiante por medio de su FK)
		// OBJETO DE MALLA (prerequisito =0 cuando sea bachillerato)
		// materias de ingenieria informatica:
		
		materia0.setNombreMateria("Bachillerato");
		materia0.setIdMateria(0);
		materia0.setUv(0);
		materia0.setPreRequisito("0");
		materiaService.createMateria(materia0);

		materia1.setNombreMateria("Precálculo");
		materia1.setIdMateria(1);
		materia1.setUv(4);
		materia1.setPreRequisito("0");
		materiaService.createMateria(materia1);

		materia2.setNombreMateria("Optativa Técnica I");
		materia2.setIdMateria(2);
		materia2.setUv(3);
		materia2.setPreRequisito("0");
		materiaService.createMateria(materia2);

		materia3.setNombreMateria("Matemática Discreta I");
		materia3.setIdMateria(3);
		materia3.setUv(3);
		materia3.setPreRequisito("0");
		materiaService.createMateria(materia3);

		materia4.setNombreMateria("Fundamentos de Programación");
		materia4.setIdMateria(4);
		materia4.setUv(4);
		materia4.setPreRequisito("0");
		materiaService.createMateria(materia4);

		materia5.setNombreMateria("Álgebra Vectorial y Matrices");
		materia5.setIdMateria(5);
		materia5.setUv(4);
		materia5.setPreRequisito("1");
		materiaService.createMateria(materia5);

		materia6.setNombreMateria("Cálculo I");
		materia6.setIdMateria(6);
		materia6.setUv(4);
		materia6.setPreRequisito("1");
		materiaService.createMateria(materia6);

		materia7.setNombreMateria("Programación de Estructuras Dinámicas");
		materia7.setIdMateria(7);
		materia7.setUv(4);
		materia7.setPreRequisito("3,4");
		materiaService.createMateria(materia7);

		materia8.setNombreMateria("Matemática Discreta II");
		materia8.setIdMateria(8);
		materia8.setUv(3);
		materia8.setPreRequisito("3");
		materiaService.createMateria(materia8);

		materia9.setNombreMateria("Física I");
		materia9.setIdMateria(9);
		materia9.setUv(5);
		materia9.setPreRequisito("5,6");
		materiaService.createMateria(materia9);

		materia10.setNombreMateria("Cálculo II");
		materia10.setIdMateria(10);
		materia10.setUv(4);
		materia10.setPreRequisito("5,6");
		materiaService.createMateria(materia10);

		materia11.setNombreMateria("Programación Orientada a Objetos");
		materia11.setIdMateria(11);
		materia11.setUv(4);
		materia11.setPreRequisito("7");
		materiaService.createMateria(materia11);

		materia12.setNombreMateria("Bases de Datos");
		materia12.setIdMateria(12);
		materia12.setUv(4);
		materia12.setPreRequisito("7");
		materiaService.createMateria(materia12);

		materia13.setNombreMateria("Electricidad y Magnetismo");
		materia13.setIdMateria(13);
		materia13.setUv(5);
		materia13.setPreRequisito("9,10");
		materiaService.createMateria(materia13);

		materia14.setNombreMateria("Cálculo III");
		materia14.setIdMateria(14);
		materia14.setUv(4);
		materia14.setPreRequisito("10");
		materiaService.createMateria(materia14);

		materia15.setNombreMateria("Programación WEB");
		materia15.setIdMateria(15);
		materia15.setUv(4);
		materia15.setPreRequisito("11");
		materiaService.createMateria(materia15);

		materia16.setNombreMateria("Administración de Bases de Datos");
		materia16.setIdMateria(16);
		materia16.setUv(4);
		materia16.setPreRequisito("12");
		materiaService.createMateria(materia16);

		materia17.setNombreMateria("Optativa Humanístico Social I");
		materia17.setIdMateria(17);
		materia17.setUv(3);
		materia17.setPreRequisito("0");
		materiaService.createMateria(materia17);

		materia18.setNombreMateria("Análisis Numérico");
		materia18.setIdMateria(18);
		materia18.setUv(4);
		materia18.setPreRequisito("14");
		materiaService.createMateria(materia18);

		materia19.setNombreMateria("Redes de Computadoras");
		materia19.setIdMateria(19);
		materia19.setUv(4);
		materia19.setPreRequisito("15");
		materiaService.createMateria(materia19);

		materia20.setNombreMateria("Programación de Dispositivos Móviles");
		materia20.setIdMateria(20);
		materia20.setUv(4);
		materia20.setPreRequisito("11");
		materiaService.createMateria(materia20);

		materia21.setNombreMateria("Análisis de Sistemas");
		materia21.setIdMateria(21);
		materia21.setUv(3);
		materia21.setPreRequisito("15");
		materiaService.createMateria(materia21);

		materia22.setNombreMateria("Física II");
		materia22.setIdMateria(22);
		materia22.setUv(5);
		materia22.setPreRequisito("9,10");
		materiaService.createMateria(materia22);

		materia23.setNombreMateria("Optativa Humanístico Social II");
		materia23.setIdMateria(23);
		materia23.setUv(3);
		materia23.setPreRequisito("0");
		materiaService.createMateria(materia23);

		materia24.setNombreMateria("Análisis de Algoritmos");
		materia24.setIdMateria(24);
		materia24.setUv(4);
		materia24.setPreRequisito("8");
		materiaService.createMateria(materia24);

		materia25.setNombreMateria("Programación de Artefactos");
		materia25.setIdMateria(25);
		materia25.setUv(4);
		materia25.setPreRequisito("13,15");
		materiaService.createMateria(materia25);

		materia26.setNombreMateria("Probabilidad y Estadística");
		materia26.setIdMateria(26);
		materia26.setUv(4);
		materia26.setPreRequisito("14");
		materiaService.createMateria(materia26);

		materia27.setNombreMateria("Seguridad en Entornos de Desarrollo");
		materia27.setIdMateria(27);
		materia27.setUv(4);
		materia27.setPreRequisito("8,16");
		materiaService.createMateria(materia27);

		materia28.setNombreMateria("Arquitectura de Computadoras");
		materia28.setIdMateria(28);
		materia28.setUv(4);
		materia28.setPreRequisito("13");
		materiaService.createMateria(materia28);

		materia29.setNombreMateria("Técnicas de Simulación en Computadoras");
		materia29.setIdMateria(29);
		materia29.setUv(4);
		materia29.setPreRequisito("26");
		materiaService.createMateria(materia29);

		materia30.setNombreMateria("Programación N-Capas");
		materia30.setIdMateria(30);
		materia30.setUv(4);
		materia30.setPreRequisito("11");
		materiaService.createMateria(materia30);

		materia31.setNombreMateria("Fundamentos de Inteligencia de Negocios");
		materia31.setIdMateria(31);
		materia31.setUv(4);
		materia31.setPreRequisito("16");
		materiaService.createMateria(materia31);

		materia32.setNombreMateria("Optativa Humanístico Social III");
		materia32.setIdMateria(32);
		materia32.setUv(3);
		materia32.setPreRequisito("0");
		materiaService.createMateria(materia32);

		materia33.setNombreMateria("Sistemas Operativos");
		materia33.setIdMateria(33);
		materia33.setUv(4);
		materia33.setPreRequisito("28");
		materiaService.createMateria(materia33);

		materia34.setNombreMateria("Programación Declarativa");
		materia34.setIdMateria(34);
		materia34.setUv(4);
		materia34.setPreRequisito("15");
		materiaService.createMateria(materia34);

		materia35.setNombreMateria("Ingeniería de Software");
		materia35.setIdMateria(35);
		materia35.setUv(4);
		materia35.setPreRequisito("21");
		materiaService.createMateria(materia35);

		materia36.setNombreMateria("Formulación y Evaluación de Proyectos");
		materia36.setIdMateria(36);
		materia36.setUv(4);
		materia36.setPreRequisito("21");
		materiaService.createMateria(materia36);

		materia37.setNombreMateria("Optativa Humanístico Social IV");
		materia37.setIdMateria(37);
		materia37.setUv(3);
		materia37.setPreRequisito("0");
		materiaService.createMateria(materia37);

		materia38.setNombreMateria("Optativa Técnica II");
		materia38.setIdMateria(38);
		materia38.setUv(4);
		materia38.setPreRequisito("0");
		materiaService.createMateria(materia38);

		materia39.setNombreMateria("Aplicaciones de Código Abierto");
		materia39.setIdMateria(39);
		materia39.setUv(4);
		materia39.setPreRequisito("21");
		materiaService.createMateria(materia39);

		materia40.setNombreMateria("Práctica Profesional I");
		materia40.setIdMateria(40);
		materia40.setUv(4);
		materia40.setPreRequisito("36");
		materiaService.createMateria(materia40);

		materia41.setNombreMateria("Optativa Técnica III");
		materia41.setIdMateria(41);
		materia41.setUv(4);
		materia41.setPreRequisito("0");
		materiaService.createMateria(materia41);

		materia42.setNombreMateria("Teorías de Lenguaje de Programación");
		materia42.setIdMateria(42);
		materia42.setUv(4);
		materia42.setPreRequisito("24");
		materiaService.createMateria(materia42);

		materia43.setNombreMateria("Optativa Humanístico Social V");
		materia43.setIdMateria(43);
		materia43.setUv(3);
		materia43.setPreRequisito("0");
		materiaService.createMateria(materia43);

		materia44.setNombreMateria("Práctica Profesional II");
		materia44.setIdMateria(44);
		materia44.setUv(4);
		materia44.setPreRequisito("40");
		materiaService.createMateria(materia44);

		return "login.jsp";
	}
	
	
	// para loggearse: Accion al dar click en el botón entrar
		@PostMapping("/loginn")
		public String login(@RequestParam("CARNET") Integer CARNET, @RequestParam("PASSWORD") String PASSWORD,
				ModelMap modelMap) {

			if (CARNET.toString().isEmpty() || PASSWORD.toString().isEmpty() || CARNET.toString() == null || PASSWORD.toString() == null) {
				modelMap.put("errorL", "No deje espacios en blanco");
				return "login.jsp";
			} else {

				// Registrando log
				Logs newLog = new Logs();
				// Obteniendo la fecha y hora actual
				LocalDateTime fechaActual = LocalDateTime.now();

				// Formateando la fecha como una cadena de texto en el formato deseado
				DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String fechaFormateada = fechaActual.format(formatoFecha);

				// Estableciendo la fecha en el objeto newLog
				newLog.setFecha(fechaFormateada);
				newLog.setCarnet(CARNET);
				logsService.createLog(newLog);

				// Lista de tabla Estudiante
				List<Estudiante> estudiantes = new ArrayList<Estudiante>();
				estudianteService.getEstudiantes().forEach(e -> estudiantes.add(e));

				// Lista tabla Carrera
				List<Carrera> carreras = new ArrayList<Carrera>();
				carreraService.getCarreras().forEach(c -> carreras.add(c));

				// Si no hay usuarios:
				if (estudiantes.isEmpty() || carreras.isEmpty()) {
					modelMap.put("errorL", "Datos incorrectos");
					return "login.jsp";
				}

				// Vamos a evaluar si el estudiante que desea logearse existe y manipular sus
				// respectivas banderas:
				estudiantes.forEach(e -> {
					if (e.getCarnetEstudiante().toString().equals(CARNET.toString()) && e.getContrasenaEstudiante().equals(PASSWORD)) {
						estudianteLogeado = e;
						estudianteExiste = true;
					}
				});

				if (estudianteExiste) {

					carreras.forEach(c -> {
						if (estudianteLogeado.getCarreraEstudiante().equals(c.getIdCarrera())) {
							carreraEstudianteLogeado = c;
						}
					});

					// menu atributos sobre la carrera del estudiante:
					modelMap.put("nombreEstudiante", estudianteLogeado.getNombreEstudiante());
					modelMap.put("numeroMateriasAprobadasEstudiante",
							carreraEstudianteLogeado.getCantidadMateriasAprobadas());
					modelMap.put("materiasDisponiblesEstudiante", carreraEstudianteLogeado.getCantidadMateriasPosibles());
					modelMap.put("actividadesExtracurricularesEstudiante",
							carreraEstudianteLogeado.getCantidadActividadesExtracurriculares());

					return "mainPage.jsp";

				}

				else {
					modelMap.put("errorL", "Datos incorrectos");
					return "login.jsp";
				}
			}

		}

		// para registrar estudiante
		@PostMapping("/registrarEstudiante")
		public String registrarEstudiante(@RequestParam("nombreRe") String nombreRe,
				@RequestParam("carnetRe") String carnetRe, @RequestParam("passwordRe") String passwordRe,
				@RequestParam("passwordRe2") String passwordRe2, ModelMap modelMap) {

			if (nombreRe.isEmpty() || carnetRe.isEmpty() || passwordRe.isEmpty() || passwordRe.isEmpty()) {
				// Se actualizo la contrasena

				modelMap.put("errorRe", "No deje espacios en blanco");
				return "register.jsp";
			} else {

				Estudiante newEstudiante = new Estudiante();
				newEstudiante.setNombreEstudiante(nombreRe);
				newEstudiante.setCarnetEstudiante(Integer.parseInt(carnetRe));
				newEstudiante.setContrasenaEstudiante(passwordRe2);

				// id autoincrementable:

				// Lista de tabla Estudiante
				List<Estudiante> estudiantes = new ArrayList<Estudiante>();
				estudianteService.getEstudiantes().forEach(e -> estudiantes.add(e));

				int lastIdx = estudiantes.size() - 1;
				Estudiante lastEstudiante = estudiantes.get(lastIdx);

				int idEstudiante = lastEstudiante.getIdEstudiante() + 1;
				newEstudiante.setIdEstudiante(idEstudiante);
				newEstudiante.setCarreraEstudiante(idEstudiante);

				// creando estudiante:
				estudianteService.createEstudiante(newEstudiante);

				// creando Actividades Extra, Carrera y Ciclo, que esta relacionado con el
				// estudiante
				ActividadesExtra newActividadExtra = new ActividadesExtra();
				newActividadExtra.setIdActividadesExtra(idEstudiante);

				// carrera de nuewEstudiante
				Carrera newCarrera = new Carrera();
				newCarrera.setIdCarrera(idEstudiante);
				newCarrera.setUvAprobadas(0);
				newCarrera.setCantidadMateriasAprobadas(0);
				newCarrera.setMateriasAprobadas("0");
				newCarrera.setNotaAprobada("0");
				newCarrera.setCantidadMateriasPosibles(9);
				newCarrera.setMateriasPosibles("1,2,3,4,17,23,32,37,43");
				newCarrera.setCantidadActividadesExtracurriculares(0);
				carreraService.createCarrera(newCarrera);

				modelMap.put("nombreEstudianteRegistrado", nombreRe);
				return "regUpdateSuccess.jsp";
			}

		}
		
	
		// para actualizar contrasena
		@PostMapping("/actualizarContrasena")
		public String actualizarContrasena(@RequestParam("nombrePR") String nombrePR,
				@RequestParam("carnetPR") String carnetPR, @RequestParam("passwordPR") String passwordPR,
				ModelMap modelMap) {

			// Lista de tabla Estudiante
			List<Estudiante> estudiantes = new ArrayList<Estudiante>();
			estudianteService.getEstudiantes().forEach(e -> estudiantes.add(e));

			estudiantes.forEach(e -> {
				if (e.getNombreEstudiante().equals(nombrePR) && e.getCarnetEstudiante().toString().equals(carnetPR)) {
					estudianteService.updateEstudiante(e, passwordPR);
					contraActualizada = true;
				}
			});

			// Si los datos escritos estan en la bdd
			if (contraActualizada) {
				// Se actualizo la contrasena

				modelMap.put("nombreEstudiantePUS", estudianteEjemplo.getNombreEstudiante());
				return "passUpdateSucess.jsp";
			} else if (nombrePR.isEmpty() || carnetPR.isEmpty() || passwordPR.isEmpty()) {
				modelMap.put("errorPR", "No deje espacios en blanco");
				return "passwordRecover.jsp";
			} else {
				modelMap.put("errorPR", "Usuario no encontrado");
				return "passwordRecover.jsp";
			}

		}	
	
	

	// Para menu:
	@GetMapping("/mainPage")
	public String mainPage(ModelMap modelMap) {
		if(estudianteLogeado != null) {
		// Lista de tabla Estudiante
		List<Estudiante> estudiantes = new ArrayList<Estudiante>();
		estudianteService.getEstudiantes().forEach(e -> estudiantes.add(e));

		estudiantes.forEach(e -> {
			if (e.getIdEstudiante().toString().equals(estudianteLogeado.getIdEstudiante().toString())) {
				estudianteLogeado = e;
				carreraEstudianteLogeado = carreraService.getCarreraById(e.getIdEstudiante());
			}
		});

		// menu atributos sobre la carrera del estudiante:
		modelMap.put("nombreEstudiante", estudianteLogeado.getNombreEstudiante());
		modelMap.put("numeroMateriasAprobadasEstudiante", carreraEstudianteLogeado.getCantidadMateriasAprobadas());
		modelMap.put("materiasDisponiblesEstudiante", carreraEstudianteLogeado.getCantidadMateriasPosibles());
		modelMap.put("actividadesExtracurricularesEstudiante",
				carreraEstudianteLogeado.getCantidadActividadesExtracurriculares());
		return "mainPage.jsp";
	}else {
		estudianteLogeado = null;
		carreraEstudianteLogeado = null;
		estudianteExiste = false;
		return "inactivityLogin.jsp";
	}
	}

	// Para las materias habiles:
	@GetMapping("/availableSubjects")
	public String availableSubjects(ModelMap modelmap) {
		if(estudianteLogeado!=null) {
		// Separa las el id de las materias aprobadas que tiene el estudiante en la
		// tabla carrera
		// y busca las materias en la tabla Materia y las agrega a la lista materias
		// para mostrarlas
		List<Materia> materiasP = new ArrayList<Materia>();
		List<Materia> materiasA = new ArrayList<Materia>();
		List<Double> notaAprobada = new ArrayList<Double>();

		String[] split1 = carreraService.getCarreraById(estudianteLogeado.getIdEstudiante()).getMateriasPosibles()
				.split(",");
		String[] split2 = carreraService.getCarreraById(estudianteLogeado.getIdEstudiante()).getMateriasAprobadas()
				.split(",");
		String[] split3 = carreraService.getCarreraById(estudianteLogeado.getIdEstudiante()).getNotaAprobada()
				.split(",");

		// Agregando las materias posibles
		for (int i = 0; i < split1.length; i++) {
			materiasP.add(materiaService.getMateriaById(Integer.parseInt(split1[i])));
		}
		materiasP.remove(null);

		// Agregando las materias aprobadas y sus notas
		for (int i = 0; i < split2.length; i++) {
			materiasA.add(materiaService.getMateriaById(Integer.parseInt(split2[i])));
			notaAprobada.add(Double.valueOf(split3[i]));
		}
		materiasA.remove(null);
		notaAprobada.remove(null);

		// Obteniendo las materias recomendadas desde la clase Util
		List<Materia> materiasR = Util2.materiasRecomendadas(materiasP, materiasA, notaAprobada);

		if (materiasP.isEmpty()) {
			modelmap.addAttribute("errorSem3", "En este momento no tienes materias disponibles");
			modelmap.addAttribute("errorSem3", "En este momento no tienes materias recomendadas");
			return "availableSubjects.jsp";
		} else {

			if (materiasA.isEmpty()) {
				modelmap.addAttribute("materias", materiasP);
				modelmap.addAttribute("errorSem3", "En este momento no tienes materias recomendadas");
				return "availableSubjects.jsp";
			} else {
				modelmap.addAttribute("materias", materiasP);
				modelmap.addAttribute("materiasR", materiasR);
				return "availableSubjects.jsp";
			}

		}
		
		}else {
			estudianteLogeado = null;
			carreraEstudianteLogeado = null;
			estudianteExiste = false;
			return "inactivityLogin.jsp";
		}	

	}

	// para las actividades extracurriculares:
	@GetMapping("/activities")
	public String activities(ModelMap modelMap) {
		if(estudianteLogeado!=null) {
		// Lista de tabla Estudiante
		List<ActividadesExtra> actividades = new ArrayList<ActividadesExtra>();
		actividadesExtraService.getActividades().forEach(a -> actividades.add(a));

		// Lista para mostrar en la tabla de ActividadesExtra
		List<ActividadesExtra> actividadesEstudianteLogeado = new ArrayList<ActividadesExtra>();

		actividades.forEach(a -> {
			if (a.getIdEstudiante().equals(estudianteLogeado.getIdEstudiante())) {
				actividadesEstudianteLogeado.add(a);

				// a.getNombreActividadesExtra();
				// a.getActividadHecha();
			}
		});

		if (actividadesEstudianteLogeado.isEmpty()) {

			modelMap.addAttribute("errorAE", "No tiene actividades pendientes");
			return "activities.jsp";
		} else {
			modelMap.addAttribute("actividadesEstudianteLogeado", actividadesEstudianteLogeado);
			return "activities.jsp";
		}
		
		}else {
			estudianteLogeado = null;
			carreraEstudianteLogeado = null;
			estudianteExiste = false;
			return "inactivityLogin.jsp";
		}	

	}

	// Para las materias aprovadas:
	@GetMapping("/approvedSubjects")
	public String approvedSubjects(ModelMap modelmap) {
		if(estudianteLogeado!=null) {

		// Separa las el id de las materias aprobadas que tiene el estudiante en la
		// tabla carrera
		// y busca las materias en la tabla Materia y las agrega a la lista materias
		// para mostrarlas
		List<Materia> materiasMA = new ArrayList<Materia>();

		String materiasAprobadasEstudiante = carreraService.getCarreraById(estudianteLogeado.getIdEstudiante())
				.getMateriasAprobadas();
		String[] split = materiasAprobadasEstudiante.split(",");

		for (int i = 0; i < split.length; i++) {
			materiasMA.add(materiaService.getMateriaById(Integer.parseInt(split[i])));
		}
		
		List<MateriaAprobada> materiasAprobadas = new ArrayList<MateriaAprobada>();
		int sizeMA = materiasMA.size();
		
		String[] split2 = carreraService.getCarreraById(estudianteLogeado.getIdEstudiante()).getNotaAprobada().split(",");
		
		for(int i=0; i<sizeMA; i++) {
			
			MateriaAprobada ma = new MateriaAprobada();
			ma.setIdMateria(materiasMA.get(i).getIdMateria());
			ma.setNombreMateria(materiasMA.get(i).getNombreMateria());
			ma.setUv(materiasMA.get(i).getUv());
			ma.setPreRequisito(materiasMA.get(i).getPreRequisito());
			ma.setNota(split2[i]);
			
			materiasAprobadas.add(ma);
		}

		materiasMA.remove(null);
		materiasAprobadas.remove(null);

		if (materiasMA.isEmpty()) {
			modelmap.addAttribute("errorMA", "En este momento no tienes materias aprobadas");
			return "approvedSubjects.jsp";
		} else {
			modelmap.addAttribute("materiasMA", materiasAprobadas);
			return "approvedSubjects.jsp";
		}
		}else {
			estudianteLogeado = null;
			carreraEstudianteLogeado = null;
			estudianteExiste = false;
			return "inactivityLogin.jsp";
		}	

	}

	// Al volver al login o al deslogearse para que reinicie el estudiante logeado
	@GetMapping("/login")
	public String login(Model model) {

		MensajeMantenimiento m = mensajeService.getMensajeMantenimientoById(1);

		//Consultando si hay algun mensaje de mantenimiento activo
		if(m.getMensajeActivo()){

			// Agregar información de mantenimiento al modelo
        	model.addAttribute("maintenanceMessage", "Nuestra aplicación estará en mantenimiento desde el día "+m.getDiaInicio()+" a las "+m.getHoraInicio()+" hasta "+m.getDiaFin()+" a las "+m.getHoraFin());
 			// Controlar la visualización       
			model.addAttribute("showMaintenanceMessage", true);
		}
		

		carreraEstudianteLogeado = null;
		estudianteLogeado = null;
		estudianteExiste = false;

		return "login.jsp";
	}

	@GetMapping("/sugerencias")
	public String Sugerencias(ModelMap modelMap) {
		if(estudianteLogeado!=null) {
		modelMap.put("idEstudiante", estudianteLogeado.getIdEstudiante());
		return "sugerencias.jsp";
		}else {
			carreraEstudianteLogeado = null;
			estudianteLogeado = null;
			estudianteExiste = false;
			return "inactivityLogin.jsp";
		}
	}
	
	@GetMapping("/dataUpdate")
	public String dataUpdate() {
		return "dataUpdate.jsp";
	}

	@GetMapping("/semester")
	public String semester() {
		return "availableSubjects.jsp";
	}

	@GetMapping("/userUpdate")
	public String userUpdate() {
		return "userUpdate.jsp";
	}

	@GetMapping("/recoveryPasword")
	public String recoveryPasword() {
		return "passwordRecover.jsp";
	}

	@GetMapping("/register")
	public String register() {
		return "register.jsp";
	}

	@GetMapping("/closeSemester")
	public String closeSemester(ModelMap modelMap) {
		modelMap.put("nombreEstudianteCS", estudianteEjemplo.getNombreEstudiante());
		return "closeSemester.jsp";
	}

	@GetMapping("/socialUpdate")
	public String socialUpdate() {
		return "socialUpdate.jsp";
	}

	@GetMapping("/activitiesUpdate")
	public String activitiesUpdate() {
		return "activitiesUpdate.jsp";
	}
	
	@GetMapping("/inactivity")
	public String inactivity(ModelMap modelMap) {
		
		carreraEstudianteLogeado = null;
		estudianteLogeado = null;
		estudianteExiste = false;
			
		return "inactivityLogin.jsp";
	}


	//// ACTIONS PARA post mapping (para botones):
	// -------------------------------------------------------------------------------------------------------------------------

	// Agregar ActividadExtra para EstudianteLogeado
	@PostMapping("/activitiesUpSuccess")
	public String activitiesUpSuccess(@RequestParam("nameActivity") String nameActivity, ModelMap modelMap) {

		if (nameActivity.isEmpty()) {
			modelMap.put("errorU", "No deje espacios en blanco");
			return "activitiesUpdate.jsp";
		} else {

			// Lista de tabla Estudiante
			List<ActividadesExtra> actividades = new ArrayList<ActividadesExtra>();
			actividadesExtraService.getActividades().forEach(a -> actividades.add(a));

			int lastIdx = actividades.size() - 1;
			ActividadesExtra lastActividad = actividades.get(lastIdx);

			int idActividadExtra = lastActividad.getIdEstudiante() + 1;

			// Creando ActividadExtra
			ActividadesExtra newActividad = new ActividadesExtra();
			newActividad.setIdActividadesExtra(idActividadExtra);
			newActividad.setIdEstudiante(estudianteLogeado.getIdEstudiante());
			newActividad.setNombreActividadesExtra(nameActivity);
			actividadesExtraService.createActividadExtra(newActividad);

			modelMap.put("nombreEstudianteAUS", estudianteEjemplo.getNombreEstudiante());
			return "activitiesUpSuccess.jsp";
		}

	}

    //Eliminar ActividadExtra para EstudianteLogeado
	@PostMapping("/activitiesUpSuccess2")
	public String activitiesUpSuccess2(@RequestParam("nameActivity") String nameActivity, ModelMap modelMap) {

		if (nameActivity.isEmpty()) {
			modelMap.put("errorU", "No deje espacios en blanco");
			return "activitiesUpdate.jsp";
		} else {

			actividadesExtraService.getActividades().forEach(a -> {
				if (a.getNombreActividadesExtra().equals(nameActivity)) {
					actividadesExtraService.deleteActividadExtraById(a.getIdActividadesExtra());
				}
				;
			});

			modelMap.put("nombreEstudianteAUS", estudianteEjemplo.getNombreEstudiante());
			return "activitiesUpSuccess.jsp";
		}

	}

	// Actualizar nombre de usuario:
	@PostMapping("/userUpdateSuccess")
	public String userUpdateSuccess(@RequestParam("name") String name, @RequestParam("carnet") String carnet,
			ModelMap modelMap) {

		// Lista de tabla Estudiante
		List<Estudiante> estudiantes = new ArrayList<Estudiante>();
		estudianteService.getEstudiantes().forEach(e -> estudiantes.add(e));

		if (name.isEmpty() || carnet.isEmpty()) {
			modelMap.put("errorUU", "No deje espacios en blanco");
			return "userUpdate.jsp";
		}
		// Si el usuario que modificara no esta en la bdd
		else if (!carnet.equals(estudianteLogeado.getCarnetEstudiante().toString())) {
			modelMap.put("errorUU", "Carnet incorrecto");
			return "userUpdate.jsp";
		} else {

			estudiantes.forEach(e -> {
				if (e.getCarnetEstudiante().toString().equals(estudianteLogeado.getCarnetEstudiante().toString())) {

					estudianteService.updateEstudianteName(e, name);
				}
			});

			modelMap.put("nombreEstudianteUUS", estudianteEjemplo.getNombreEstudiante());
			return "userUpdateSuccess.jsp";
		}

	}

	// agregar o eliminar actividad:
	@PostMapping("/activitiesEdit")
	public String activitiesEdit(@RequestParam("idActivity") String idActivity,
			@RequestParam("nombreActividad") String nombreActividad, ModelMap modelMap) {

		if (idActivity.isEmpty() && nombreActividad.isEmpty()) {
			modelMap.put("errorAE", "Llene al menos un espacio");
			activities(modelMap);
			return "activities.jsp";
		} else {
			if (!nombreActividad.isEmpty() && idActivity.isEmpty()) {
				// Agregar una nueva actividad
				List<ActividadesExtra> actividades = new ArrayList<>();
				actividadesExtraService.getActividades().forEach(a -> actividades.add(a));

				int lastIdx = actividades.size() - 1;
				ActividadesExtra lastActividad = actividades.get(lastIdx);
				int idActividadExtra = lastActividad.getIdActividadesExtra() + 1;

				ActividadesExtra newActividadExtra = new ActividadesExtra();
				newActividadExtra.setIdActividadesExtra(idActividadExtra);
				newActividadExtra.setNombreActividadesExtra(nombreActividad);
				newActividadExtra.setIdEstudiante(estudianteLogeado.getIdEstudiante());
				actividadesExtraService.createActividadExtra(newActividadExtra);

				Carrera ca = carreraEstudianteLogeado;
				int cAEA = ca.getCantidadActividadesExtracurriculares();
				ca.setCantidadActividadesExtracurriculares(cAEA + 1);
				carreraService.updateCarrera(ca);

				modelMap.addAttribute("errorAE", "Se ha agregado la actividad");
			}

			if (!idActivity.isEmpty() && nombreActividad.isEmpty()) {
				// Eliminar una actividad
				actividadesExtraService.deleteActividadExtraById(Integer.parseInt(idActivity));

				Carrera ca = carreraEstudianteLogeado;
				int cAEA = ca.getCantidadActividadesExtracurriculares();
				ca.setCantidadActividadesExtracurriculares(cAEA - 1);
				carreraService.updateCarrera(ca);

				modelMap.addAttribute("errorAE", "Se ha eliminado la actividad");
			}

			activities(modelMap);
			return "activities.jsp";
		}
	}
	
	
	@PostMapping("/addComentario")
	public String addComentario(@RequestParam("mensaje") String mensaje, ModelMap modelMap){
		if (mensaje.isEmpty()) {
			modelMap.put("errorAE", "Favor, rellene el campo");
			return "sugerencias.jsp";
		} else {
			// Agregar un nuevo comentario
			Comentario newComentario = new Comentario();
			newComentario.setMensaje(mensaje);
			newComentario.setIdEstudiante(estudianteLogeado.getIdEstudiante());
				
			comentarioService.createComentario(newComentario);
			return "messegeCommentSuccess.jsp";
	    }
	}
	

	// Action para marcar una materia de "materias habiles" (por medio se su
	// correlativo) como aprobada
	// y removerla de las posibles y agregar las nuevas posibles en funcion de esa
	// aprobada
	int cantMateriasAprobadas = 0, cantMateriasPosibles = 0;
	List<String> prerrequisitos;

	@PostMapping("/subjectsUpdateSuccess2")
	public String subjectsUpdateSuccess2(@RequestParam("subject") String subject, ModelMap modelMap) {

		if (subject.isEmpty()) {
			modelMap.put("errorMA", "No deje espacios en blanco");

			approvedSubjects(modelMap);
			return "approvedSubjects.jsp";
		} else if (subject.equals("0")) {
			modelMap.put("errorMA", "No puede remover 'Bachillerato'");

			approvedSubjects(modelMap);
			return "approvedSubjects.jsp";
		} else {

			// POSIBLES MATERIAS DEL ESTUDIANTE LOGEADO:
			List<String> materias0 = new ArrayList<String>();

			String materiasPosiblesEstudianteLogeado = carreraService
					.getCarreraById(estudianteLogeado.getIdEstudiante()).getMateriasPosibles();
			String[] split = materiasPosiblesEstudianteLogeado.split(",");

			for (int i = 0; i < split.length; i++) {
				materias0.add(split[i]);
			}

			cantMateriasPosibles = (carreraService.getCarreraById(estudianteLogeado.getIdEstudiante())
					.getCantidadMateriasPosibles());

			// materias aprobadas del estudiante logueado:
			List<String> materias1 = new ArrayList<String>();

			String materiasAprobadasEstudianteLogeado = carreraService
					.getCarreraById(estudianteLogeado.getIdEstudiante()).getMateriasAprobadas();
			String[] split1 = materiasAprobadasEstudianteLogeado.split(",");

			for (int i = 0; i < split1.length; i++) {
				materias1.add(split1[i]);
			}

			cantMateriasAprobadas = (carreraService.getCarreraById(estudianteLogeado.getIdEstudiante())
					.getCantidadMateriasAprobadas());

			// verificamos si la materia que quiere remover en subject
			// la tiene disponible y la puede agregar
			if (!materias1.contains(subject)) {
				modelMap.put("errorMA", "No puede remover una materia que no tiene aprobada");

				approvedSubjects(modelMap);
				return "approvedSubjects.jsp";
			} else {
				// sino se elimina de la lista de ids de materias aprobadas y
				// se pasa al string de las materias posibles (eliminado de aqui todas aquellas
				// en las cuales
				// esta removida es prequisito)

				// Agregando las materias posibles en funcion de la que se esta removiendo:
				//
				//

				// Lista de tabla Materia
				List<Materia> materias = new ArrayList<Materia>();
				materiaService.getMaterias().forEach(m -> {
					materias.add(m);
				});

				// obteniendo las materias posibles a partir del id aprobado removido
				// y buscando las materias que tengan ese prerrequisito
				materias.forEach(m -> {

					// por cada materia existente, se iran guardando los prerrequisitos
					prerrequisitos = Arrays.asList(m.getPreRequisito().split(","));

					prerrequisitos.forEach(p -> {

						// para cada prerrequisito veremos si es el mismo id de la materia aprobada
						// removida
						if (subject.equals(p)) {

							// entonces si el prerrequisito es el mismo
							// seleccionaremos la materia
							// si esa materia esta en materias posibles ya la removeremos:
							if (materias0.contains(m.getIdMateria().toString())) {

								materias0.remove(m.getIdMateria().toString());
								cantMateriasPosibles--;

							}
						}
					});

				});

				// Sumandole la aprobada removida
				cantMateriasPosibles += 1;

				// Agregando la aprobada removida a las posibles
				materias0.add(subject);
				nuevasMateriasPosibles = String.join(",", materias0);

				// Removiendo la materia aprobada de las materias aprobadas:
				int indexNota = materias1.indexOf(subject);
				materias1.remove(subject);
				nuevasMateriasAprobadas = String.join(",", materias1);

				// eliminando la nota de la materia a remover (en su indice respectivo)
				String[] notasAprobadas = carreraService.getCarreraById(estudianteLogeado.getIdEstudiante())
						.getNotaAprobada().split(",");

				List<String> na = new ArrayList<>();

				for (int i = 0; i < notasAprobadas.length; i++) {
					if (i != indexNota) {
						na.add(notasAprobadas[i]);
					}
				}

				String nuevasNotasAprobadas = String.join(",", na);

				// cantidad de materia aprobadas
				cantMateriasAprobadas -= 1;

				// Actualizando materias posibles y materias aprobadas
				Carrera newCarrera = carreraService.getCarreraById(estudianteLogeado.getIdEstudiante());
				newCarrera.setMateriasPosibles(nuevasMateriasPosibles);
				newCarrera.setMateriasAprobadas(nuevasMateriasAprobadas);
				newCarrera.setNotaAprobada(nuevasNotasAprobadas);
				newCarrera.setCantidadMateriasPosibles(cantMateriasPosibles);
				newCarrera.setCantidadMateriasAprobadas(cantMateriasAprobadas);
				carreraService.updateCarreraG(newCarrera,
						carreraService.getCarreraById(estudianteLogeado.getIdEstudiante()));

				// Reiniciando variables:
				cantMateriasAprobadas = 0;
				cantMateriasPosibles = 0;
				prerrequisitos = new ArrayList<>();

			}

			// mostrar mensaje que la lista se ha actualizado correctamente
			modelMap.put("nombreEstudianteUS", estudianteEjemplo.getNombreEstudiante());

			return "subjectsUpdateSuccess.jsp";

		}

	}

	// Action para marcar una materia de "materias habiles" (por medio se su
	// correlativo) como aprobada
	// y removerla de las posibles y agregar las nuevas posibles en funcion de esa
	// aprobada
	List<String> prerrequisitosExcepto;

	@PostMapping("/subjectsUpdateSuccess")
	public String subjectsUpdateSuccess(@RequestParam("subject") String subject, @RequestParam("score") String score,
			ModelMap modelMap) {

		if (subject.isEmpty() || score.isEmpty()) {
			modelMap.put("errorSU", "No deje espacios en blanco");

			availableSubjects(modelMap);
			return "availableSubjects.jsp";
		} else {

			// PARA MOSTRAR LAS POSIBLES MATERIAS DEL ESTUDIANTE LOGEADO:
			List<String> materias0 = new ArrayList<String>();

			String materiasPosiblesEstudianteLogeado = carreraService
					.getCarreraById(estudianteLogeado.getIdEstudiante()).getMateriasPosibles();
			String[] split = materiasPosiblesEstudianteLogeado.split(",");

			for (int i = 0; i < split.length; i++) {
				materias0.add(split[i]);
			}

			// Para mostrar las materias aprobadas del estudiante logueado:
			List<String> materias1 = new ArrayList<String>();

			String materiasAprobadasEstudianteLogeado = carreraService
					.getCarreraById(estudianteLogeado.getIdEstudiante()).getMateriasAprobadas();
			String[] split1 = materiasAprobadasEstudianteLogeado.split(",");

			for (int i = 0; i < split1.length; i++) {
				materias1.add(split1[i]);
			}

			// verificamos si la materia que quiere agregar en subject (como aprobada)
			// la tiene disponible y la puede agregar
			if (!materias0.contains(subject)) {
				modelMap.put("errorSU", "No puede inscribir una materia que no tiene habilitada");

				availableSubjects(modelMap);
				return "availableSubjects.jsp";
			} else {
				// sino se elimina de la lista de ids de posibles materias y
				// se pasa al string de las materias aprobadas

				// Solo se esta actualizando (removiendo) las materias posibles:
				materias0.remove(subject);

				// Agregando las materias posibles en funcion de la que se esta aprobando:
				//
				//

				// Lista de tabla Materia
				List<Materia> materias = new ArrayList<Materia>();
				materiaService.getMaterias().forEach(m -> {
					materias.add(m);
				});

				// obteniendo las materias posibles a partir del los id aprobado
				// y buscando las materias que tengan esos prerrequisitos
				materias.forEach(m -> {

					// por cada materia existente, se iran guardando los prerrequisitos
					prerrequisitos = Arrays.asList(m.getPreRequisito().split(","));

					// lista exceptuando el id de la materia y poder comprobar si ya se aprobaron
					// las demas
					// materias (si los ids de las demas paterias prerrequisito estan en aprobadas)
					prerrequisitosExcepto = new ArrayList<>(prerrequisitos);
					prerrequisitosExcepto.remove(subject);

					prerrequisitos.forEach(p -> {

						// para cada prerrequisito veremos si es la materia aprobada
						if (subject.equals(p) && materias1.containsAll(prerrequisitosExcepto)) {

							// entonces si el prerrequisito es el mismo y los demas prerrequisito ya se
							// aprobaron
							// seleccionaremos la materia
							// si esa materia no esta en materias posibles ya:
							if (!materias0.contains(m.getIdMateria().toString())) {

								materias0.add(m.getIdMateria().toString());
								cantMateriasPosibles++;

							}
						}
					});

				});

				// Sumando las nuevas que se contaron, mas las que ya estan posibles y
				// restandole la aprobada
				cantMateriasPosibles += (carreraService.getCarreraById(estudianteLogeado.getIdEstudiante())
						.getCantidadMateriasPosibles()) - 1;

				nuevasMateriasPosibles = String.join(",", materias0);

				// Actualizando las materias aprobadas:
				materias1.add(subject);
				nuevasMateriasAprobadas = String.join(",", materias1);
				String nuevasNotasAprobadas = (carreraService.getCarreraById(estudianteLogeado.getIdEstudiante())
						.getNotaAprobada()) + "," + score;

				// cantidad de materia aprobadas
				cantMateriasAprobadas = (carreraService.getCarreraById(estudianteLogeado.getIdEstudiante())
						.getCantidadMateriasAprobadas()) + 1;

				// Actualizando materias posibles y materias aprobadas
				Carrera newCarrera = carreraService.getCarreraById(estudianteLogeado.getIdEstudiante());
				newCarrera.setMateriasPosibles(nuevasMateriasPosibles);
				newCarrera.setMateriasAprobadas(nuevasMateriasAprobadas);
				newCarrera.setNotaAprobada(nuevasNotasAprobadas);
				newCarrera.setCantidadMateriasPosibles(cantMateriasPosibles);
				newCarrera.setCantidadMateriasAprobadas(cantMateriasAprobadas);
				carreraService.updateCarreraG(newCarrera,
						carreraService.getCarreraById(estudianteLogeado.getIdEstudiante()));

				// Reiniciando variables:
				cantMateriasAprobadas = 0;
				cantMateriasPosibles = 0;
				prerrequisitos = new ArrayList<>();

			}

			// mostrar mensaje que la lista se ha actualizado correctamente
			modelMap.put("nombreEstudianteUS", estudianteEjemplo.getNombreEstudiante());

			return "subjectsUpdateSuccess.jsp";

		}

	}

	@PostMapping("/addSubject")
	public String addSubject(@RequestParam("materia") String materia, ModelMap modelMap) {

		if (materia.isEmpty()) {
			modelMap.put("errorASS", "No deje espacios en blanco");
			return "availableSubjects.jsp";
		} else {
			modelMap.put("nombreEstudianteASS", estudianteEjemplo.getNombreEstudiante());
			return "addSemesterSuccess.jsp";
		}

	}

	

}
