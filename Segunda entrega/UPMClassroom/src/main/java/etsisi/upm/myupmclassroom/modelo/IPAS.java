package etsisi.upm.myupmclassroom.modelo;

public interface IPAS extends IUsuario{
	public String getCodigo_persona();
	public int getAnyo_incorporacion();
	
	public void setCodigo_persona(String codigo_persona);
	public void setAnyo_incorporacion(int anyo_incorporacion);
}
