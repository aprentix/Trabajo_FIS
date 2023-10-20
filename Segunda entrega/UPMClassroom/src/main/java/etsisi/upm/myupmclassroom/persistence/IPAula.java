package etsisi.upm.myupmclassroom.persistence;

import java.util.*;
import etsisi.upm.myupmclassroom.modelo.*;

public interface IPAula {
	public void insertAula(Aula aula);
	
	public void deleteAula(int id);
	
	public Aula selectAula(int id);
	
	public void updateAula(Aula aula);
	
	public Collection<Aula> getAll();
	
	public Collection<Aula> getAulasSuscrito(String dni);
	
	public Collection<Aula> getAulasNoSuscrito(String dni);
	
	public void insertAulaSuscrita(int idAula, String dni);
		
}