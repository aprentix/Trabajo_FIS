package etsisi.upm.myupmclassroom.modelo;


public class Usuario implements IUsuario{
	private String dni;
	private String nombre;
	private String primer_apellido;
	private String segundo_apellido;
	private String email;
	private String password;
	
	// constructor
	public Usuario(String dni, String nombre, String primer_apellido, String segundo_apellido, String email, String password) {
		this.dni = dni;
		this.nombre = nombre;
		this.primer_apellido = primer_apellido;
		this.segundo_apellido = segundo_apellido;
		this.email = email;
		this.password = password;
	}
	
	public Usuario(Usuario usuario) {
		this.dni = usuario.getDNI();
		this.nombre = usuario.nombre;
		this.primer_apellido = usuario.getPrimer_apellido();
		this.segundo_apellido = usuario.getSegundo_apellido();
		this.email = usuario.getEmail();
		this.password = usuario.getPassword();
	}
	
	// getters y setters
	public String getDNI() {
		return dni;
	}
	public String getNombre() {
		return nombre;
	}
	public String getPrimer_apellido() {
		return primer_apellido;
	}
	public String getSegundo_apellido() {
		return segundo_apellido;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	
	public void setDNI(String dni) {
		this.dni = dni;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPrimer_apellido(String primer_apellido) {
		this.primer_apellido = primer_apellido;
	}
	public void setSegundo_apellido(String segundo_apellido) {
		this.segundo_apellido = segundo_apellido;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

