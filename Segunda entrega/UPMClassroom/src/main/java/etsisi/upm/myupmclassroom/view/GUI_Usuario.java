package etsisi.upm.myupmclassroom.view;
//
//@ Project : @MyUPMClassroom
//@ Author : @CITSIM_03
//

import java.util.*;
import etsisi.upm.myupmclassroom.controller.*;
import etsisi.upm.myupmclassroom.modelo.*;
import spark.*;

public class GUI_Usuario {
	private CUsuario cUsuario;

	public GUI_Usuario(CUsuario usercontrolerIN) {
		cUsuario = usercontrolerIN;
	}

	public TemplateViewRoute creaUsuario() {
		return new TemplateViewRoute() {
			
			@Override
			public ModelAndView handle(Request request, Response response) throws Exception {
				 
		         return new ModelAndView(new HashMap<>(), "creaUsuarioForm.vm");
			}
		};
	}

	public ModelAndView pantallaError(String nameError){
		HashMap<String,Object> variable = new HashMap<>();
		variable.put("error", nameError);
		return new ModelAndView(variable, "creaUsuarioForm.vm");
	}

	public TemplateViewRoute creaUsuarioPost() {
		return new TemplateViewRoute() {

			@Override
			public ModelAndView handle(Request request, Response response) throws Exception {
				
				// Usuario
				String nombre = request.queryParams("nombre");
				String primer_apellido = request.queryParams("primer_apellido");	
				String segundo_apellido = request.queryParams("segundo_apellido");	
				String dni = request.queryParams("dni");
				String email = request.queryParams("email");
				String password = request.queryParams("password");
				// Alumno
				String num_matricula = request.queryParams("num_matricula");
				// PDI
				String codigo_trabajador = request.queryParams("cod_trabajador");
				String rol = request.queryParams("catPDI");
				// PAS
				String codigo_personal = request.queryParams("codigo_personal");
				String anioINC = request.queryParams("anioINC");
				int anioICO = -1;
				
				if (nombre.isEmpty() || primer_apellido.isEmpty() || email.isEmpty() || dni.isEmpty() || password.isEmpty()) {
					return pantallaError("Rellene todos los valores indicados antes de continuar");
				}
				else if (num_matricula.isEmpty() && (rol.isEmpty() || codigo_trabajador.isEmpty()) && (codigo_personal.isEmpty() || anioINC.isEmpty())) {
					return pantallaError("Rellene los valores del tipo de Usuario");
				}
				
				if (!num_matricula.isEmpty()) {
					if (cUsuario.existeAlumno(num_matricula, dni))
						return pantallaError("El Usuario ya existe en la base de datos");
					
					if (cUsuario.agregarAlumno(num_matricula, dni, nombre, primer_apellido, segundo_apellido, email, password) == null)
						return pantallaError("Se ha introducido incorrectamente el email");
					
				} else if (!codigo_trabajador.isEmpty() && !rol.isEmpty()) {
					if (cUsuario.existePDI(codigo_trabajador, dni))
						return pantallaError("El Usuario ya existe en la base de datos");
					
					TCategoria categoria = TCategoria.AYUDANTE;
					
					if(rol.equalsIgnoreCase("PROFESOR_AYUDANTE")) {
						categoria = TCategoria.PROFESOR_AYUDANTE;
					} else if(rol.equalsIgnoreCase("PROFESOR_CONTRATADO_DOCTOR")) {
						categoria = TCategoria.PROFESOR_CONTRATADO_DOCTOR;
					} else if(rol.equalsIgnoreCase("PROFESOR_TITULAR")) {
						categoria = TCategoria.PROFESOR_TITULAR;
					} else if(rol.equalsIgnoreCase("CATEDRATICO")) {
						categoria = TCategoria.CATEDRATICO;
					}
					
					if (cUsuario.agregarPDI(codigo_trabajador, dni, nombre, primer_apellido, segundo_apellido, email, password, categoria) == null)
						return pantallaError("Se ha introducido incorrectamente el email");
					
				} else if (!codigo_personal.isEmpty() && !anioINC.isEmpty()) {
					if (cUsuario.existePAS(codigo_personal, dni))
						return pantallaError("El Usuario ya existe en la base de datos");
					
					anioICO = Integer.parseInt(anioINC);
					if(anioICO > 2022)
						return pantallaError("La fecha de inscripción no puede ser mayor que la actual");
					
					if (cUsuario.agregarPAS(codigo_personal, dni, nombre, primer_apellido, segundo_apellido, email, password, anioICO) == null)
						return pantallaError("Se ha introducido incorrectamente el email");
				}
				
				Collection<IAlumno> listaAlumno = cUsuario.dameListaAlumnos();
				Collection<IPDI> listaPDI = cUsuario.dameListaPDI();
				Collection<IPAS> listaPAS = cUsuario.dameListaPAS();
				
				HashMap<String,Object> model = new HashMap<>();
				model.put("lista_alumno", listaAlumno);
				model.put("lista_pdi", listaPDI);
				model.put("lista_pas", listaPAS);
				
				return new ModelAndView(model, "listaUsuario.vm");
			}
		};
	}

	
	public TemplateViewRoute listaUsuario() {
		return new TemplateViewRoute() {
			
			@Override
			public ModelAndView handle(Request request, Response response) throws Exception {
				Collection<IAlumno> listaAlumnos = cUsuario.dameListaAlumnos();
				Collection<IPDI> listaPDI = cUsuario.dameListaPDI();
				Collection<IPAS> listaPAS = cUsuario.dameListaPAS();
				
				HashMap<String,Object> model = new HashMap<>();
				model.put("lista_alumno", listaAlumnos);
				model.put("lista_pdi", listaPDI);
				model.put("lista_pas", listaPAS);
				
		        return new ModelAndView(model, "listaUsuario.vm");
			}
		};
	}

}



