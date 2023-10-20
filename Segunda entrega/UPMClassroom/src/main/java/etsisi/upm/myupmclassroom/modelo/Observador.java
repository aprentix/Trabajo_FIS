package etsisi.upm.myupmclassroom.modelo;
//
//
//
//  @ Project : @MyUPMClassroom
//  @ Author : @CITSIM22_03
//
//

public class Observador extends Usuario implements IObservador, ISuscripcion {
	// Lista de booleans cuyos indices representan el id de las aulas de la lista de aulas de un usuario	
	
	public Observador(String nombre, String primer_apellido, String segundo_apellido, String password, String nie,String email) {
		super(nombre, primer_apellido, segundo_apellido, password, nie, email);
	}
	
	public Observador(Usuario usuario) {
		super(usuario);
	}
	
	public void destroy() {
	
	}

	/// Pulsan el tick de las aulas a las que deseen suscribirse y se suscriben
	@Override
	public void suscripcionAula(int id) {
		
	}
}
