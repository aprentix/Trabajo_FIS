package etsisi.upm.myupmclassroom.controller;

//
//  @ Project : @MyUPMClassroom
//  @ Author : @CITSIM_03
//

import etsisi.upm.myupmclassroom.modelo.*;

public interface ICUsuario {
	public void agregarUsuario(String nombre, String primer_apellido, String segundo_apellido, String DNI, String correo, String contrasenya);
	public IUsuario obtenerUsuario(String dni);
	public void listaUsuario();
}
