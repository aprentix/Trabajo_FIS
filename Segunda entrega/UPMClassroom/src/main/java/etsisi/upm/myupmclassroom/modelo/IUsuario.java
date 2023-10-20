package etsisi.upm.myupmclassroom.modelo;
//
//  @ Project : @MyUPMClassroom
//  @ Author : @CITSIM_03
//


public interface IUsuario {
	public String getDNI();
	public String getNombre();
	public String getPrimer_apellido();
	public String getSegundo_apellido();
	public String getEmail();
	public String getPassword();
	
	public void setDNI(String dni);
	public void setNombre(String nombre);
	public void setPrimer_apellido(String primer_apellido);
	public void setSegundo_apellido(String segundo_apellido);
	public void setEmail(String email);
	public void setPassword(String password);
}
