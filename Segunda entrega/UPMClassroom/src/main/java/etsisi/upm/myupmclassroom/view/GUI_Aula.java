package etsisi.upm.myupmclassroom.view;

//
//@ Project : @MyUPMClassroom
//@ Author : @CITSIM_03
//

import java.util.*;
import etsisi.upm.myupmclassroom.controller.*;
import etsisi.upm.myupmclassroom.modelo.*;
import spark.*;

public class GUI_Aula {
	private CAula cAula;

	public GUI_Aula(CAula cAula) {
		this.cAula = cAula;
	}

	public TemplateViewRoute creaAula() {
		return new TemplateViewRoute() {
			
			@Override
			public ModelAndView handle(Request request, Response response) throws Exception {
				 
		         return new ModelAndView(new HashMap<>(), "creaAulaForm.vm");
			}
		};
	}
	
	public ModelAndView pantallaErrorAula(String nameError, String html) {
		HashMap<String,Object> variable = new HashMap<>();
		variable.put("error", nameError);
		return new ModelAndView(variable, html);
	}
	
	public ModelAndView pantallaErrorAula(String nameError, int postURL, String html) {
		HashMap<String,Object> variable = new HashMap<>();
		variable.put("error", nameError);
		variable.put("postURL", postURL);
		return new ModelAndView(variable, html);
	}

	public TemplateViewRoute creaAulaPost() {
		return new TemplateViewRoute() {
			
			@Override
			public ModelAndView handle(Request request, Response response) throws Exception {
				
				String nombre_centro = request.queryParams("nombre_centro");
				String sup = request.queryParams("superficie");
				int superficie = -1;
				String numPeople = request.queryParams("aforo");
				int aforo = -1;
				String tipoClase = request.queryParams("aulaT");
				TAula aulaT = TAula.LABORATORIO; // Valor por defecto

				if (nombre_centro.isEmpty() || sup.isEmpty() || numPeople.isEmpty()) {
					return pantallaErrorAula("Rellene todos los valores indicados antes de continuar", "creaAulaForm.vm");
				} else {
					aforo = Integer.parseInt(numPeople);
					superficie = Integer.parseInt(sup);					
				}
				
				/// El usuario unicamente puede elegir entre los tipos de clase que tiene disponibles (TEORIA, LABORATORIO, MIXTA)
				if (tipoClase.equalsIgnoreCase("TEORIA")) {
					aulaT = TAula.TEORIA;
				} else if (tipoClase.equalsIgnoreCase("LABORATORIO")) {
					aulaT = TAula.LABORATORIO;
				} else if (tipoClase.equalsIgnoreCase("MIXTA")) {
					aulaT = TAula.MIXTA;
				} else {
					return pantallaErrorAula("La categoria no esta en las categorias posibles", "creaAulaForm.vm");
				}
				
				cAula.altaAula(nombre_centro, superficie, aforo, aulaT);

				Collection<IAula> listame = cAula.obtenerLista();
				
				HashMap<String,Object> model = new HashMap<>();
				model.put("lista", listame);
				
		        return new ModelAndView(model, "listaAula.vm");
			}
		};
	}
	
	public TemplateViewRoute listaAula() {
		return new TemplateViewRoute() {		
			@Override
			public ModelAndView handle(Request request, Response response) throws Exception {

				Collection<IAula> listame = cAula.obtenerLista();
				
				HashMap<String,Object> model = new HashMap<>();
				model.put("lista", listame);
				
		        return new ModelAndView(model, "listaAula.vm");
			}
		};
	}
	
	public TemplateViewRoute listaAulaSuscripcion() {
		return new TemplateViewRoute() {		
			@Override
			public ModelAndView handle(Request request, Response response) throws Exception {
				
				HashMap<String,Object> model = new HashMap<>();
				model.put("postURL", 0);
				
				return new ModelAndView(model, "formDNI.vm");
			}
		};
	}
	
	public TemplateViewRoute listaAulaSuscripcionPost() {
		return new TemplateViewRoute() {
			
			@Override
			public ModelAndView handle(Request request, Response response) throws Exception {
				
				String dni = request.queryParams("dni");
				CUsuario cUsuario = new CUsuario();

				if (dni.isEmpty())
					return pantallaErrorAula("Rellene todos los valores indicados antes de continuar", 0, "formDNI.vm");
				else if (!cUsuario.existeUsuario(dni))
					return pantallaErrorAula("El usuario no se encuentra en la Base de Datos", 0, "formDNI.vm");
				
				/// Obtener lista de aulas a las que el usuario esta suscrito
				Collection<IAula> listame = cAula.obtenerListaNoSuscrito(dni);
				
				if (listame.isEmpty())
					return pantallaErrorAula("Este Usuario esta suscrito a todas las Aulas", 0, "formDNI.vm");
				
				HashMap<String,Object> model = new HashMap<>();
				model.put("lista", listame);
				model.put("dni", dni);
				
		        return new ModelAndView(model, "listaAulaSuscripcion.vm");
			}
		};
	}
	
	public TemplateViewRoute listaAulaSuscritas() {
		return new TemplateViewRoute() {
			
			@Override
			public ModelAndView handle(Request request, Response response) throws Exception {
				
				HashMap<String,Object> model = new HashMap<>();
				model.put("postURL", 1);
				
				return new ModelAndView(model, "formDNI.vm");
			}
		};
	}
	
	public TemplateViewRoute listaAulaSuscritasPost() {
		return new TemplateViewRoute() {
			
			@Override
			public ModelAndView handle(Request request, Response response) throws Exception {
				
				String dni = request.queryParams("dni");
				CUsuario cUsuario = new CUsuario();

				if (dni.isEmpty())
					return pantallaErrorAula("Rellene todos los valores indicados antes de continuar", 1, "formDNI.vm");
				else if (!cUsuario.existeUsuario(dni))
					return pantallaErrorAula("El usuario no se encuentra en la Base de Datos", 1, "formDNI.vm");
				
				/// Obtener lista de aulas a las que el usuario esta suscrito
				Collection<IAula> listame = cAula.obtenerListaSuscrito(dni);
				
				if (listame.isEmpty())
					return pantallaErrorAula("Este Usuario no esta suscrito a ningun Aula", 1, "formDNI.vm");
				
				HashMap<String,Object> model = new HashMap<>();
				model.put("lista", listame);
				
		        return new ModelAndView(model, "listaAulaSuscritas.vm");
			}
		};
	}
	
	public TemplateViewRoute suscripcionPost() {
		return new TemplateViewRoute() {
			
			@Override
			public ModelAndView handle(Request request, Response response) throws Exception {
				
				String[] seleccionados = request.queryParamsValues("seleccionados");
				String dni = null;
				
				if (seleccionados == null)
					return pantallaErrorAula("No se ha seleccionado ningun Aula", 0, "formDNI.vm");
				else
					dni = seleccionados[0].split("-")[1];
				
				for (int i = 0; i < seleccionados.length; i++) {
					int idAula = Integer.parseInt(seleccionados[i].split("-")[0]);
					
					cAula.suscribirseAula(idAula, dni);
				}

				/// Obtener lista de aulas a las que el usuario esta suscrito
				Collection<IAula> listame = cAula.obtenerListaSuscrito(dni);
				
				HashMap<String,Object> model = new HashMap<>();
				model.put("lista", listame);
				
				
		        return new ModelAndView(model, "listaAulaSuscritas.vm");
			}
		};
	}
}
