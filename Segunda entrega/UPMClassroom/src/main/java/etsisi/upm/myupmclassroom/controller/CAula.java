package etsisi.upm.myupmclassroom.controller;

//
//@ Project : @MyUPMClassroom
//@ Author : @CITSIM_03
//

import java.util.Collection;
import java.util.LinkedList;

import etsisi.upm.myupmclassroom.modelo.*;
import etsisi.upm.myupmclassroom.persistence.*;
import etsisi.upm.myupmclassroom.view.*;

public class CAula implements ICAula {
	//private Collection<IAula> gestiona=new LinkedList<IAula>();
	private GUI_Aula altaAula = new GUI_Aula(this);
	
	public Aula altaAula(String nombre_centro, int superficie, int aforoAula, TAula tipo_aula) {
		
		Aula aula = null;
		
		aula = new Aula(nombre_centro, superficie, aforoAula, tipo_aula);
		//gestiona.add(aula);		
		PersistenceManager.getInstance().getPersistenceAula().insertAula(aula);
		
		return aula;
	}

	// Retorna todas las aulas
	public Collection<IAula> obtenerLista() {
		return new LinkedList<IAula> (PersistenceManager.getInstance().getPersistenceAula().getAll());
		//return gestiona;
	}

	// Retorna las aulas a las que el usuario está suscrito
	public Collection<IAula> obtenerListaSuscrito(String dni) {
		return new LinkedList<IAula> (PersistenceManager.getInstance().getPersistenceAula().getAulasSuscrito(dni));
		//return gestiona;
	}
	
	// Retorna las aulas a las que el usuario no está suscrito
	public Collection<IAula> obtenerListaNoSuscrito(String dni) {
		return new LinkedList<IAula> (PersistenceManager.getInstance().getPersistenceAula().getAulasNoSuscrito(dni));
		//return gestiona;
	}
	
	public void suscribirseAula(int idAula, String dni) {
		PersistenceManager.getInstance().getPersistenceAula().insertAulaSuscrita(idAula, dni);
	}
	
	public GUI_Aula show() {
		return altaAula;
	}
}