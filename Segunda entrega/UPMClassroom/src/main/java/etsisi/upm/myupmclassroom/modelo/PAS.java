package etsisi.upm.myupmclassroom.modelo;

//
//
//  @ Project : @MyUPMClassroom
//  @ Author : @CITSIM_22_03
//
//

public class PAS extends Usuario implements IPAS {
	private String codigo_persona;
	private int anyo_incorporacion;
	
	public PAS(String codigo_persona, String dni, String nombre, String primer_apellido, String segundo_apellido, String email, String password, int anyo_incorporacion) {
			super(dni, nombre, primer_apellido, segundo_apellido, email, password);
			this.codigo_persona = codigo_persona;
			this.anyo_incorporacion = anyo_incorporacion;
	}
	
	public PAS(String codigo_persona, int anyo_incorporacion, Usuario usuario) {
		super(usuario);
		this.codigo_persona = codigo_persona;
		this.anyo_incorporacion = anyo_incorporacion;
	}

	public String getCodigo_persona() {
		return codigo_persona;
	}

	public void setCodigo_persona(String codigo_persona) {
		this.codigo_persona = codigo_persona;
	}

	public int getAnyo_incorporacion() {
		return anyo_incorporacion;
	}

	public void setAnyo_incorporacion(int anyo_incorporacion) {
		this.anyo_incorporacion = anyo_incorporacion;
	}

}
