package etsisi.upm.myupmclassroom.modelo;
//
//  @ Project : @MyUPMClassroom
//  @ Author : @CITSIM_22_03
//
//

public interface IAula{
	public int getID();
	public String getNombre_centro();
	public int getSuperficie();
	public int getAforo();
	public TAula getTAula();
	public void setId(int id);
	
	public void setNombre_centro(String nombre_centro);
	public void setSuperficie(int superficie); 
	public void setAforo(int aforo);
	public void setTAula(TAula aula);
	
	public void gestionSuscripcion(Observador observador);

}
