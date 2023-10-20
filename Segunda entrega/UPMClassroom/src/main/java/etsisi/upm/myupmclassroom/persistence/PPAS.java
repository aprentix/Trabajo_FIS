package etsisi.upm.myupmclassroom.persistence;

//
//
//  @ Project : @MyUPMClassroom
//  @ Author : @CITSIM_22_03
//
//

import java.util.*;
import java.sql.*;
import etsisi.upm.myupmclassroom.modelo.*;

public class PPAS implements IPPAS {
	public void insertPAS(PAS pas) {
		Statement stmt;
		try {
			PersistenceManager.getInstance().getPersistenceUsuario().insertUsuario(pas);
			
			stmt = PersistenceManager.getInstance().getconnection().createStatement();
			
			stmt.executeUpdate("INSERT INTO PAS (dni, codigo_persona, anyo_incorporacion) VALUES (" + 
					"'" + pas.getDNI() + "'," +
					"'" + pas.getCodigo_persona() + "'," +
					"'" + pas.getAnyo_incorporacion() + "'" +
					")");
			
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletePAS(String codigo_persona) {
		Statement stmt;
		
		try {
			stmt = PersistenceManager.getInstance().getconnection().createStatement();
			
			stmt.executeUpdate("DELETE FROM PAS WHERE codigo_persona = '" + codigo_persona + "'");
			
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public PAS selectPAS(String codigo_persona) {

		PAS pas = null;
		Statement stmt;
		
		try {
			stmt = PersistenceManager.getInstance().getconnection().createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from PAS where codigo_persona = '" + codigo_persona + "'");
			
			while (rs.next())
			{
				Usuario usuario = PersistenceManager.getInstance().getPersistenceUsuario().selectUsuario(rs.getString("dni"));
				
				pas = new PAS (
						codigo_persona,
						rs.getInt("anyo_incorporacion"),
						usuario
						);
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pas;
	}
	
	public void updatePAS(PAS pas) {
		Statement stmt;
		
		try {
			stmt = PersistenceManager.getInstance().getconnection().createStatement();
			
			stmt.executeUpdate("UPDATE PAS SET " +
					"anyo_incorporacion = '" + pas.getAnyo_incorporacion() + "'," +
					" WHERE codigo_persona = '" + pas.getCodigo_persona() + "' AND dni = '" + pas.getDNI() + "'"
					);
			
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public Collection<PAS> getAll() {

		LinkedList<PAS> paslistout = new LinkedList<>();
		Statement stmt;
		
		try {
			stmt = PersistenceManager.getInstance().getconnection().createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from PAS");
			
			while (rs.next())
			{
				Usuario usuario = PersistenceManager.getInstance().getPersistenceUsuario().selectUsuario(rs.getString("dni"));
				paslistout.add(new PAS (
						rs.getString("codigo_persona"),
						rs.getInt("anyo_incorporacion"),
						usuario
						));
			}
			
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return paslistout;
	}
}