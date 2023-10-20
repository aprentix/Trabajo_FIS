package etsisi.upm.myupmclassroom.controller;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import etsisi.upm.myupmclassroom.modelo.Aula;
import etsisi.upm.myupmclassroom.modelo.TAula;
import etsisi.upm.myupmclassroom.persistence.PersistenceManager;

public class CAulaTest {
	
	CAula c;

	@Before
	public void setUp() throws Exception {
		c = new CAula();
	}

	//CAJA NEGRA**************
	//CP1  V1.V4.V2.V3 {nombre del centro="campus sur", superficie=50, aforo=20, tipo de aula="laboratorio"} 
	//CP2  V1.N6.V2.V3 {nombre del centro="campus sur", superficie=2, aforo=20, tipo de aula="laboratorio"} 
	//CP3  V1.N7.V2.V3 {nombre del centro="campus sur", superficie=300, aforo=20, tipo de aula="laboratorio"} 
	//CP4  V1.V6.V2.V4 {nombre del centro="campus sur", superficie=50, aforo=20, tipo de aula="mixta",} 
	//CP5  V1.V6.V2.V5 {nombre del centro="campus sur", superficie=50, aforo=20, tipo de aula="teoria"} 
	//CP6  V1.V6.V2.N5 {nombre del centro="campus sur", superficie=50, aforo=20, tipo de aula="actos"} 
	//CP7  V1.V6.N3.V5 {nombre del centro="campus sur", superficie=50, aforo=-3, tipo de aula="teoria"} 
	//CP8  V1.V6.N4.V5 {nombre del centro="campus sur", superficie=50, aforo=400, tipo de aula="teoria"} 
	//CP9  N1.V6.V2.V5 {nombre del centro="camp", superficie=50, aforo=20, tipo de aula="teoria",} 
	//CP10 N2.V6.V2.V5 {nombre del centro="aaaaaaaaaaaaaaaaaaaaaaaa[24]", superficie=50, aforo=20, tipo de aula="teoria",} 
	//CP11 V7.V6.V2.V3 {nombre del centro="campu", superficie=50, aforo=20, tipo de aula="laboratorio"} 
	//CP12 V8.V6.V2.V3 {nombre del centro="aaaaaaaaaaaaaaaaaaaa[20]", superficie=50, aforo=20, tipo de aula="laboratorio"} 
	//CP13 N8.V6.V2.V3 {nombre del centro="aaaaaaaaaaaaaaaaaaaaa[21]", superficie=50, aforo=20, tipo de aula="laboratorio"} 
	//CP14 V1.V6.N9.V3 {nombre del centro="campus sur", superficie=50}, aforo=0, tipo de aula="laboratorio", 
	//CP15 V1.V6.N10.V3 {nombre del centro="campus sur", superficie=50, aforo=81, tipo de aula="laboratorio"} 
	//CP16 V1.V6.V9.V3  {nombre del centro="campus sur", superficie=50, aforo=1, tipo de aula="laboratorio"} 
	//CP17 V1.V6.V10.V3 {nombre del centro="campus sur", superficie=50, aforo=80, tipo de aula="laboratorio"} 
	//CP18 V1.N11.V10.V3 {nombre del centro="campus sur", superficie=9, aforo=80, tipo de aula="laboratorio"} 
	//CP19 V1.N12.V10.V3 {nombre del centro="campus sur", superficie=101, aforo=80, tipo de aula="laboratorio"} 
	//CP20 V1.V11.V10.V3 {nombre del centro="campus sur", superficie=10, aforo=80, tipo de aula="laboratorio"} 
	//CP21 V1.V12.V10.V3 {nombre del centro="campus sur", superficie=100, aforo=80, tipo de aula="laboratorio"} 
	
	@Test
	public void test() {
		Aula aula = new Aula ("campus sur", 50, 20, TAula.valueOf("laboratorio".toUpperCase()));
		assertNotNull("el aula insertada es correcta", c.altaAula(aula.getNombre_centro(), aula.getSuperficie(), aula.getAforo(), aula.getTAula()));
		PersistenceManager.getInstance().getPersistenceAula().deleteAula(aula.getID());
		
		aula = new Aula ("campus sur", 2, 20, TAula.valueOf("laboratorio".toUpperCase()));
		assertNull("la superficie es muy pequeña deberia devolver nulo", c.altaAula(aula.getNombre_centro(), aula.getSuperficie(), aula.getAforo(), aula.getTAula()));
		PersistenceManager.getInstance().getPersistenceAula().deleteAula(aula.getID());
		
		aula = new Aula ("campus sur", 300, 20, TAula.valueOf("laboratorio".toUpperCase()));
		assertNull("la superficie es muy grande deberia devolver nulo", c.altaAula(aula.getNombre_centro(), aula.getSuperficie(), aula.getAforo(), aula.getTAula()));
		PersistenceManager.getInstance().getPersistenceAula().deleteAula(aula.getID());
		
		aula = new Aula ("campus sur", 50, 20, TAula.valueOf("mixta".toUpperCase()));
		assertNotNull("el aula insertada es correcta", c.altaAula(aula.getNombre_centro(), aula.getSuperficie(), aula.getAforo(), aula.getTAula()));
		PersistenceManager.getInstance().getPersistenceAula().deleteAula(aula.getID());
		
		aula = new Aula ("campus sur", 50, 20, TAula.valueOf("teoria".toUpperCase()));
		assertNotNull("el aula insertada es correcta", c.altaAula(aula.getNombre_centro(), aula.getSuperficie(), aula.getAforo(), aula.getTAula()));
		PersistenceManager.getInstance().getPersistenceAula().deleteAula(aula.getID());
		
		aula = new Aula ("campus sur", 50, 20, TAula.valueOf("actos".toUpperCase()));
		assertNull("el tipo de aula es incorrecto deberia devolver nulo", c.altaAula(aula.getNombre_centro(), aula.getSuperficie(), aula.getAforo(), aula.getTAula()));
		PersistenceManager.getInstance().getPersistenceAula().deleteAula(aula.getID());
		
		aula = new Aula ("campus sur", 50, -3, TAula.valueOf("teoria".toUpperCase()));
		assertNull("el aforo es negativo deberia devolver nulo", c.altaAula(aula.getNombre_centro(), aula.getSuperficie(), aula.getAforo(), aula.getTAula()));
		PersistenceManager.getInstance().getPersistenceAula().deleteAula(aula.getID());
		
		aula = new Aula ("campus sur", 50, 400, TAula.valueOf("teoria".toUpperCase()));
		assertNull("el aforo es muy grande deberia devolver nulo", c.altaAula(aula.getNombre_centro(), aula.getSuperficie(), aula.getAforo(), aula.getTAula()));
		PersistenceManager.getInstance().getPersistenceAula().deleteAula(aula.getID());
		
		aula = new Aula ("camp", 50, 20, TAula.valueOf("teoria".toUpperCase()));
		assertNull("el nombre del centro es muy pequeño y deberia devolver nulo", c.altaAula(aula.getNombre_centro(), aula.getSuperficie(), aula.getAforo(), aula.getTAula()));
		PersistenceManager.getInstance().getPersistenceAula().deleteAula(aula.getID());
		
		aula = new Aula ("aaaaaaaaaaaaaaaaaaaaaaaa", 50, 20, TAula.valueOf("teoria".toUpperCase()));
		assertNull("el nombre del centro es muy grande y deberia devolver nulo", c.altaAula(aula.getNombre_centro(), aula.getSuperficie(), aula.getAforo(), aula.getTAula()));
		PersistenceManager.getInstance().getPersistenceAula().deleteAula(aula.getID());
		
		aula = new Aula ("campu", 50, 20, TAula.valueOf("laboratorio".toUpperCase()));
		assertNotNull("el aula insertada es correcta", c.altaAula(aula.getNombre_centro(), aula.getSuperficie(), aula.getAforo(), aula.getTAula()));
		PersistenceManager.getInstance().getPersistenceAula().deleteAula(aula.getID());
		
		aula = new Aula ("aaaaaaaaaaaaaaaaaaaa", 50, 20, TAula.valueOf("laboratorio".toUpperCase()));
		assertNotNull("el aula insertada es correcta", c.altaAula(aula.getNombre_centro(), aula.getSuperficie(), aula.getAforo(), aula.getTAula()));
		PersistenceManager.getInstance().getPersistenceAula().deleteAula(aula.getID());
		
		aula = new Aula ("aaaaaaaaaaaaaaaaaaaaa", 50, 21, TAula.valueOf("laboratorio".toUpperCase()));
		assertNull("el nombre del centro es muy grande y deberia devolver nulo", c.altaAula(aula.getNombre_centro(), aula.getSuperficie(), aula.getAforo(), aula.getTAula()));
		PersistenceManager.getInstance().getPersistenceAula().deleteAula(aula.getID());
		
		aula = new Aula ("campus sur", 50, 0, TAula.valueOf("laboratorio".toUpperCase()));
		assertNull("el aforo es muy pequeño y deberia devolver nulo", c.altaAula(aula.getNombre_centro(), aula.getSuperficie(), aula.getAforo(), aula.getTAula()));
		PersistenceManager.getInstance().getPersistenceAula().deleteAula(aula.getID());
		
		aula = new Aula ("campus sur", 50, 81, TAula.valueOf("laboratorio".toUpperCase()));
		assertNull("el aforo es muy grande y deberia devolver nulo", c.altaAula(aula.getNombre_centro(), aula.getSuperficie(), aula.getAforo(), aula.getTAula()));
		PersistenceManager.getInstance().getPersistenceAula().deleteAula(aula.getID());
		
		aula = new Aula ("campus sur", 50, 1, TAula.valueOf("laboratorio".toUpperCase()));
		assertNotNull("el aula insertada es correcta", c.altaAula(aula.getNombre_centro(), aula.getSuperficie(), aula.getAforo(), aula.getTAula()));
		PersistenceManager.getInstance().getPersistenceAula().deleteAula(aula.getID());
		
		aula = new Aula ("campus sur", 50, 80, TAula.valueOf("laboratorio".toUpperCase()));
		assertNotNull("el aula insertada es correcta", c.altaAula(aula.getNombre_centro(), aula.getSuperficie(), aula.getAforo(), aula.getTAula()));
		PersistenceManager.getInstance().getPersistenceAula().deleteAula(aula.getID());
		
		aula = new Aula ("campus sur", 9, 80, TAula.valueOf("laboratorio".toUpperCase()));
		assertNull("la superficie es muy pequeña y deberia devolver nulo", c.altaAula(aula.getNombre_centro(), aula.getSuperficie(), aula.getAforo(), aula.getTAula()));
		PersistenceManager.getInstance().getPersistenceAula().deleteAula(aula.getID());
		
		aula = new Aula ("campus sur", 101, 80, TAula.valueOf("laboratorio".toUpperCase()));
		assertNull("la superficie es muy grande y deberia devolver nulo", c.altaAula(aula.getNombre_centro(), aula.getSuperficie(), aula.getAforo(), aula.getTAula()));
		PersistenceManager.getInstance().getPersistenceAula().deleteAula(aula.getID());
		
		aula = new Aula ("campus sur", 10, 80, TAula.valueOf("laboratorio".toUpperCase()));
		assertNotNull("el aula insertada es correcta", c.altaAula(aula.getNombre_centro(), aula.getSuperficie(), aula.getAforo(), aula.getTAula()));
		PersistenceManager.getInstance().getPersistenceAula().deleteAula(aula.getID());
		
		aula = new Aula ("campus sur", 100, 80, TAula.valueOf("laboratorio".toUpperCase()));
		assertNotNull("el aula insertada es correcta", c.altaAula(aula.getNombre_centro(), aula.getSuperficie(), aula.getAforo(), aula.getTAula()));
		PersistenceManager.getInstance().getPersistenceAula().deleteAula(aula.getID());
		
	}

}