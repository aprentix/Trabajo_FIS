package etsisi.upm.myupmclassroom.controller;

//
//  @ Project : @MyUPMClassroom
//  @ Author : @CITSIM_03
//

import java.util.Collection;
import etsisi.upm.myupmclassroom.modelo.*;
import etsisi.upm.myupmclassroom.view.GUI_Aula;

public interface ICAula {
	
	public Aula altaAula(String nombre_centro, int superficie, int aforoAula, TAula aula);
	
	public Collection<IAula> obtenerLista();
	public Collection<IAula> obtenerListaSuscrito(String dni);
	public Collection<IAula> obtenerListaNoSuscrito(String dni);
	
	public void suscribirseAula(int idAula, String dni);

	public GUI_Aula show();
}
