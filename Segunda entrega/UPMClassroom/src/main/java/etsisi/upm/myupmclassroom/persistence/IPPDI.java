package etsisi.upm.myupmclassroom.persistence;

import java.util.Collection;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : @MyUPMClassroom
//  @ Author : @CITSIM_22_03
//
//

import java.util.List;
import etsisi.upm.myupmclassroom.modelo.*;

public interface IPPDI {
	public void insertPDI(PDI pdi);
	
	public void deletePDI(String codigo_trabajador);
	
	public PDI selectPDI(String codigo_trabajador);
	
	public void updatePDI(PDI pdi);
	
	public List<Aula> selectAulasSuscritas(String codigo_trabajador);

	public Collection<PDI> getAll();
}
