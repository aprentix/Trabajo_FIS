//
//  @ Project : @MyUPMClassroom
//  @ Author : @CITSIM_03
//

package etsisi.upm.myupmclassroom.controller;

import java.util.*;
import etsisi.upm.myupmclassroom.modelo.*;
import etsisi.upm.myupmclassroom.persistence.PersistenceManager;
import etsisi.upm.myupmclassroom.view.GUI_Usuario;
import servidor.Autenticacion;
import servidor.Correo;

public class CUsuario {
	//private Collection<IAlumno> alumnos = new LinkedList<IAlumno>();
	//private Collection<IPDI> pdis = new LinkedList<IPDI>();
	//private Collection<IPAS> pass = new LinkedList<IPAS>();
	private GUI_Usuario altaUsuario = new GUI_Usuario(this);
	private Correo correo;
	
	public CUsuario() {
		this.correo = new Correo();
	}
	
	public IAlumno agregarAlumno(String num_matricula, String dni, String nombre, String primer_apellido, String segundo_apellido, String email, String password) {
		Alumno alumno = null;
		
		if (correo.enviarEmail(email, nombre, password)) {
			alumno = new Alumno(num_matricula, dni, nombre, primer_apellido, segundo_apellido, email, password);
			//alumnos.add(alumno);
			PersistenceManager.getInstance().getPersistenceAlumno().insertAlumno(alumno);
		}
		return alumno;
	}
	
	public IPDI agregarPDI(String codigo_trabajador, String dni, String nombre, String primer_apellido, String segundo_apellido, String email, String password, TCategoria categoria) {
		PDI pdi = null;
		
		if (correo.enviarEmail(email, nombre, password)) {
			pdi = new PDI(codigo_trabajador, dni, nombre, primer_apellido, segundo_apellido, email, password, categoria);
			//pdis.add(pdi);
			PersistenceManager.getInstance().getPersistencePDI().insertPDI(pdi);
		}
		return pdi;
	}
	
	public IPAS agregarPAS(String codigo_persona, String dni, String nombre, String primer_apellido, String segundo_apellido, String email, String password, int anyo_incorporacion) {
		PAS pas = null;
		
		if (correo.enviarEmail(email, nombre, password)) {
			pas = new PAS(codigo_persona, dni, nombre, primer_apellido, segundo_apellido, email, password, anyo_incorporacion);
			//pass.add(pas);
			PersistenceManager.getInstance().getPersistencePAS().insertPAS(pas);
		}
		return pas;
	}

	public Collection<IAlumno> dameListaAlumnos(){
		return new LinkedList<IAlumno>(PersistenceManager.getInstance().getPersistenceAlumno().getAll());
		//return alumnos;
	}
	
	public Collection<IPDI> dameListaPDI(){
		return new LinkedList<IPDI>(PersistenceManager.getInstance().getPersistencePDI().getAll());
		//return pdis;
	}
	
	public Collection<IPAS> dameListaPAS(){
		return new LinkedList<IPAS>(PersistenceManager.getInstance().getPersistencePAS().getAll());
		//return pass;
	}
	
	public boolean existeUsuario(String dni) {
		return PersistenceManager.getInstance().getPersistenceUsuario().selectUsuario(dni) != null;
	}
	
	public boolean existeAlumno(String num_matricula, String dni) {
		return PersistenceManager.getInstance().getPersistenceAlumno().selectAlumno(num_matricula) != null || existeUsuario(dni);
	}
	
	public boolean existePDI(String codigo_trabajador, String dni) {
		return PersistenceManager.getInstance().getPersistencePDI().selectPDI(codigo_trabajador) != null || existeUsuario(dni);
	}
	
	public boolean existePAS(String codigo_personal, String dni) {
		return PersistenceManager.getInstance().getPersistencePAS().selectPAS(codigo_personal) != null || existeUsuario(dni);
	}
	
	public GUI_Usuario show() {
		return altaUsuario;
	}
}


