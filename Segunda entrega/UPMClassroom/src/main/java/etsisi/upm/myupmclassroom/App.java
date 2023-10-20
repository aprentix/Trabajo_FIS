package etsisi.upm.myupmclassroom;

import static spark.Spark.*;
import org.apache.log4j.BasicConfigurator;
import etsisi.upm.myupmclassroom.controller.*;
import etsisi.upm.myupmclassroom.view.AppView;
import spark.template.velocity.VelocityTemplateEngine;

public class App {
	private AppView appview = new AppView(this);
	
	private AppView getView() {
		return appview;
	}
	
    public static void main( String[] args )
    {
    	CUsuario userController = new CUsuario();
    	CAula aulaController = new CAula();
    	App appController = new App();
    	BasicConfigurator.configure();
      	
    	get("/", appController.getView().show(), new VelocityTemplateEngine());
    	//Form para crear aula
    	get("/creaAula", aulaController.show().creaAula(),new VelocityTemplateEngine());
    	post("/creaAula", aulaController.show().creaAulaPost(),new VelocityTemplateEngine());
    	//Form para crear usuario
    	get("/creaUsuario", userController.show().creaUsuario(),new VelocityTemplateEngine());
    	post("/creaUsuario", userController.show().creaUsuarioPost(),new VelocityTemplateEngine());
    	//lista de todos los usuarios
    	get("/listaUsuario", userController.show().listaUsuario(),new VelocityTemplateEngine());
    	//lista de todas las aulas
    	get("/listaAula", aulaController.show().listaAula(),new VelocityTemplateEngine());
    	//lista de aulas a las que el usuario no esta suscrito
    	get("/listaAulaSuscripcion", aulaController.show().listaAulaSuscripcion(),new VelocityTemplateEngine());
    	post("/listaAulaSuscripcion", aulaController.show().listaAulaSuscripcionPost(),new VelocityTemplateEngine());
    	//lista de aulas a las que el usuario esta suscrito
    	get("/listaAulaSuscritas", aulaController.show().listaAulaSuscritas(),new VelocityTemplateEngine());
    	post("/listaAulaSuscritas", aulaController.show().listaAulaSuscritasPost(),new VelocityTemplateEngine());
    	//suscribirse
    	post("/suscripcion", aulaController.show().suscripcionPost(),new VelocityTemplateEngine());
    }
}