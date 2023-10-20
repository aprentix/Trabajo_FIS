import java.util.*;
import etsisi.upm.myupmclassroom.modelo.*;
import etsisi.upm.myupmclassroom.persistence.*;

public class MySQL{
	public static void main(String[] args) {
		pruebasAula();
		System.out.println("-------------------------------");
		pruebasAlumno();
		System.out.println("-------------------------------");
		pruebasPDI();
		System.out.println("-------------------------------");
		pruebasPAS();
		System.out.println("-------------------------------");
		pruebasAulaSuscrita();
	}
	
	public static void pruebasAula() {
		Collection<Aula> aulas = PersistenceManager.getInstance().getPersistenceAula().getAll();
		
		Iterator<Aula> it = aulas.iterator();
		while (it.hasNext()) {
			IAula aux = it.next();
			System.out.println(aux.getID() + " - " + aux.getNombre_centro() + " - " + aux.getTAula());
		}
		
		Aula aula = PersistenceManager.getInstance().getPersistenceAula().selectAula(1);
		System.out.println(aula.getID() + " - " + aula.getNombre_centro() + " - " + aula.getTAula() + " - " + aula.getAforo());
		
		Aula nueva = new Aula("UPM", 20, 30, TAula.TEORIA);
		PersistenceManager.getInstance().getPersistenceAula().insertAula(nueva);
		aula = PersistenceManager.getInstance().getPersistenceAula().selectAula(5);
		System.out.println(aula.getID() + " - " + aula.getNombre_centro() + " - " + aula.getTAula() + " - " + aula.getAforo());
	}
	
	public static void pruebasAlumno() {
		Collection<Alumno> alumnos = PersistenceManager.getInstance().getPersistenceAlumno().getAll();
		
		Iterator<Alumno> it = alumnos.iterator();
		while (it.hasNext()) {
			Alumno aux = it.next();
			System.out.println(aux.getDNI() + " - " + aux.getNombre() + " - " + aux.getPrimer_apellido() + " - " + aux.getSegundo_apellido());
		}
		
		Alumno alumno = PersistenceManager.getInstance().getPersistenceAlumno().selectAlumno("BR0214");
		System.out.println(alumno.getDNI() + " - " + alumno.getNombre() + " - " + alumno.getPrimer_apellido() + " - " + alumno.getSegundo_apellido());
		
		Alumno nueva = new Alumno("br0231", "52190021T", "P", "A", "E", "p.a.e@mapa.es", "666");
		PersistenceManager.getInstance().getPersistenceAlumno().insertAlumno(nueva);
		alumno = PersistenceManager.getInstance().getPersistenceAlumno().selectAlumno("br0231");
		System.out.println(alumno.getDNI() + " - " + alumno.getNombre() + " - " + alumno.getPrimer_apellido() + " - " + alumno.getSegundo_apellido());
	}
	
	public static void pruebasPDI() {
		Collection<PDI> pdis = PersistenceManager.getInstance().getPersistencePDI().getAll();
		
		Iterator<PDI> it = pdis.iterator();
		while (it.hasNext()) {
			PDI aux = it.next();
			System.out.println(aux.getDNI() + " - " + aux.getNombre() + " - " + aux.getPrimer_apellido() + " - " + aux.getSegundo_apellido());
		}
		
		PDI alumno = PersistenceManager.getInstance().getPersistencePDI().selectPDI("12345");
		System.out.println(alumno.getDNI() + " - " + alumno.getNombre() + " - " + alumno.getPrimer_apellido() + " - " + alumno.getSegundo_apellido());
		
		PDI nueva = new PDI("JASD", "53201132T", "P", "A", "E", "p.a.e@mapa.es", "666", TCategoria.AYUDANTE);
		PersistenceManager.getInstance().getPersistencePDI().insertPDI(nueva);
		alumno = PersistenceManager.getInstance().getPersistencePDI().selectPDI("JASD");
		System.out.println(alumno.getDNI() + " - " + alumno.getNombre() + " - " + alumno.getPrimer_apellido() + " - " + alumno.getSegundo_apellido());
	}
	
	public static void pruebasPAS() {
		Collection<PAS> pass = PersistenceManager.getInstance().getPersistencePAS().getAll();
		
		Iterator<PAS> it = pass.iterator();
		while (it.hasNext()) {
			PAS aux = it.next();
			System.out.println(aux.getDNI() + " - " + aux.getNombre() + " - " + aux.getPrimer_apellido() + " - " + aux.getSegundo_apellido());
		}
		
		PAS alumno = PersistenceManager.getInstance().getPersistencePAS().selectPAS("02468");
		System.out.println(alumno.getDNI() + " - " + alumno.getNombre() + " - " + alumno.getPrimer_apellido() + " - " + alumno.getSegundo_apellido());
		
		PAS nueva = new PAS("Kakaka", "13141123K", "P", "A", "E", "p.a.e@mapa.es", "666", 2024);
		PersistenceManager.getInstance().getPersistencePAS().insertPAS(nueva);
		alumno = PersistenceManager.getInstance().getPersistencePAS().selectPAS("Kakaka");
		System.out.println(alumno.getDNI() + " - " + alumno.getNombre() + " - " + alumno.getPrimer_apellido() + " - " + alumno.getSegundo_apellido());
	}
	
	public static void pruebasAulaSuscrita() {
		System.out.println("Lista de Aulas suscritas por alumno " + "XXXXXXX");
		List<Aula> aulas = PersistenceManager.getInstance().getPersistenceAlumno().selectAulasSuscritas("XXXXXXX");
		
		for (Aula aula : aulas) {
			System.out.println(aula.getID() + " - " + aula.getNombre_centro() + " - " + aula.getTAula());
		}
		
		System.out.println("\nLista de Aulas suscritas por pdi " + "BBBBBBB");
		aulas = PersistenceManager.getInstance().getPersistenceAlumno().selectAulasSuscritas("BBBBBBB");
		
		for (Aula aula : aulas) {
			System.out.println(aula.getID() + " - " + aula.getNombre_centro() + " - " + aula.getTAula());
		}
		
		PersistenceManager.getInstance().getPersistenceAula().insertAulaSuscrita(1, "53201132T");
		PersistenceManager.getInstance().getPersistenceAula().insertAulaSuscrita(3, "53201132T");
		PersistenceManager.getInstance().getPersistenceAula().insertAulaSuscrita(5, "53201132T");
		
		System.out.println("\nLista de Aulas suscritas por pdi " + "53201132T");
		aulas = PersistenceManager.getInstance().getPersistenceAlumno().selectAulasSuscritas("53201132T");
		
		for (Aula aula : aulas) {
			System.out.println(aula.getID() + " - " + aula.getNombre_centro() + " - " + aula.getTAula());
		}
		
	}
}