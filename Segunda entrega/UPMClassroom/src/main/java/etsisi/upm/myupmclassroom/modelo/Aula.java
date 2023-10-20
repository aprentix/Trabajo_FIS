package etsisi.upm.myupmclassroom.modelo;

import java.util.Collection;
import java.util.LinkedList;

//
//
//  @ Project : @MyUPMClassroom
//  @ Author : @CITSIM_22_03
//
//

public class Aula implements IAula {
	private int id;
	private String nombre_centro;
	private int superficie;
	private int aforoAula;
	private TAula taula;
	public PAS esDadoDeAltaPor;
	public Collection<Observador> tiene = new LinkedList<Observador>();
	public PDI daClase;
	
	// Constructor
	public Aula (String nombre_centro, int superficie, int aforoAula, TAula taula) {
		this.id = -1;
		this.nombre_centro = nombre_centro;
		this.superficie = superficie;
		this.aforoAula = aforoAula;
		this.taula = taula;
	}

	@Override
	public int getID() {
		return this.id;
	}

	@Override
	public String getNombre_centro() {
		return this.nombre_centro;
	}

	@Override
	public int getSuperficie() {
		return superficie;
	}

	@Override
	public int getAforo() {
		return this.aforoAula;
	}

	@Override
	public TAula getTAula() {
		return taula;
	}
	
	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void setNombre_centro(String nombre_centro) {
		this.nombre_centro = nombre_centro;
	}

	@Override
	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	@Override
	public void setAforo(int aforo) {
		this.aforoAula = aforo;
	}

	@Override	
	public void setTAula(TAula taula) {
		this.taula=taula;
	}
	
	@Override
	public void gestionSuscripcion(Observador observador) {
		tiene.add(observador);
	}

}
