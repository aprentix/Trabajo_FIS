package etsisi.upm.myupmclassroom.modelo;

public interface IPDI extends IUsuario{
	public String getCodigo_trabajador();
	public TCategoria getCategoria();
	
	public void setCodigo_trabajador(String codigo_trabajador);
	public void setCategoria(TCategoria categoria);
}
