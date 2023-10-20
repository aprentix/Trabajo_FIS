package etsisi.upm.myupmclassroom.persistence;

import etsisi.upm.myupmclassroom.modelo.*;

public interface IPUsuario {
	public void insertUsuario(Usuario usuario);
	
	public void deleteUsuario(String nie);
	
	public Usuario selectUsuario(String nie);
	
	public void updateUsuario(Usuario usuario);

}
