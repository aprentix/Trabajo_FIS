package etsisi.upm.myupmclassroom.modelo;

//
//  @ Project : @MyUPMClassroom
//  @ Author : @CITSIM_03
//


public class Alumno extends Observador implements IAlumno{
	private String num_matricula;
	
	/// constructor
	public Alumno(String num_matricula, String dni, String nombre, String primer_apellido, String segundo_apellido, String email, String password) {
		super(dni, nombre, primer_apellido, segundo_apellido, email, password);
		this.num_matricula = num_matricula;
	}
	
	public Alumno(String num_matricula, Usuario usuario) {
		super(usuario);
		this.num_matricula = num_matricula;
	}

	/// getters y setters
	public String getNum_matricula() {
		return num_matricula;
	}
	public void setNum_matricula(String num_matricula) {
		this.num_matricula = num_matricula;
	}
}
