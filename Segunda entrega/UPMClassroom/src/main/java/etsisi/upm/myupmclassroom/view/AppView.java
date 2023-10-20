package etsisi.upm.myupmclassroom.view;

import java.util.HashMap;

import etsisi.upm.myupmclassroom.App;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

public class AppView {

	@SuppressWarnings("unused")
	private App app;
	
	public AppView(App appIn) {
		app=appIn;
	}

	public TemplateViewRoute show() {
		return new TemplateViewRoute() {
			
			@Override
			public ModelAndView handle(Request request, Response response) throws Exception {
				 
		         return new ModelAndView(new HashMap<>(), "index.vm");
			}
		};
	}

}
