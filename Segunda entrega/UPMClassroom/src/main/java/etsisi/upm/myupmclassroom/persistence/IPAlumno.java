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

public interface IPAlumno {
	public void insertAlumno(Alumno alumno);
	
	public void deleteAlumno(String num_matricula);
	
	public Alumno selectAlumno(String num_matricula);
	
	public void updateAlumno(Alumno alumno);
	
	public List<Aula> selectAulasSuscritas(String num_matricula);

	public Collection<Alumno> getAll();
}
