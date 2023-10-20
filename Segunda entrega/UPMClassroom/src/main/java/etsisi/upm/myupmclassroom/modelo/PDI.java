package etsisi.upm.myupmclassroom.modelo;

//
//
//  @ Project : @MyUPMClassroom
//  @ Author : @CITSIM_22_03
//
//

public class PDI extends Observador implements IPDI {
	private String codigo_trabajador;
	private TCategoria categoria;
	
	public PDI(String codigo_trabajador, String dni, String nombre, String primer_apellido, String segundo_apellido, String email, String password, TCategoria categoria) {
			super(dni, nombre, primer_apellido, segundo_apellido, email, password);
			this.codigo_trabajador = codigo_trabajador;
			this.categoria = categoria;
	}
	
	public PDI(String codigo_trabajador, TCategoria categoria, Usuario usuario) {
		super(usuario);
		this.codigo_trabajador = codigo_trabajador;
		this.categoria = categoria;
	}

	public String getCodigo_trabajador() {
		return codigo_trabajador;
	}

	public TCategoria getCategoria() {
		return categoria;
	}

	public void setCodigo_trabajador(String codigo_trabajador) {
		this.codigo_trabajador = codigo_trabajador;
	}

	public void setCategoria(TCategoria categoria) {
		this.categoria = categoria;
	}
}
