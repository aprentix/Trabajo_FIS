package etsisi.upm.myupmclassroom.persistence;

//
//
//
//  @ Project : @MyUPMClassroom
//  @ Author : @CITSIM_22_03
//
//

import java.sql.*;

public class PersistenceManager {

	private final String connStr = "jdbc:mysql://localhost:3306/?serverTimezone=UTC";
	private final String user = "CITSIM22_03";
	private final String pass = "12345";
	
	private Connection conn;
	private PAula paula;
	private PUsuario pusuario;
	private PAlumno palumno;
	private PPDI ppdi;
	private PPAS ppas;
	private static PersistenceManager instance;

	private PersistenceManager() {	
		
		paula = new PAula();
		pusuario = new PUsuario();
		palumno = new PAlumno();
		ppdi = new PPDI();
		ppas = new PPAS();
		
		try {
			conn = DriverManager.getConnection(connStr, user, pass);
			Statement stmt = conn.createStatement();
			stmt.execute("use upmClassroom");
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Destroy en el que cerramos la conexion
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		conn.close();
	}

	public static PersistenceManager getInstance() {
		if (instance==null)
			instance=new PersistenceManager();
		return instance;
	}

	public IPAula getPersistenceAula() {
		return paula;
	}

	public IPUsuario getPersistenceUsuario() {		
		return pusuario;
	}

	public IPAlumno getPersistenceAlumno() {		
		return palumno;
	}

	public IPPDI getPersistencePDI() {		
		return ppdi;
	}

	public IPPAS getPersistencePAS() {		
		return ppas;
	}

	public Connection getconnection() {
		return conn;
	}
}
