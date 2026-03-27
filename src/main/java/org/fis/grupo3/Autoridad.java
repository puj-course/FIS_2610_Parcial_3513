package org.fis.grupo3;
import java.util.ArrayList;

<<<<<<< HEAD:src/main/java/org/fis/grupo3/Autoridades.java
public class Autoridades {
	private int idAutoridad;
	private String nombre;
	private String apellido;
	private String cargo;
	private int numeroVotos;
	private boolean electo;
=======
public class Autoridad {
>>>>>>> 900b34736952a456218513a053c7d29d612fd36e:src/main/java/org/fis/grupo3/Autoridad.java
}
public Autoridades(){
}
public int getIdAutoridad(){
	return idAutoridad;
}
public String getNombre(){
	return nombre;
}

public String getApellido(){
	return apellido;
}
public String getCargo(){
	return cargo;
}
public int getNumeroVotos(){
	return numeroVotos;
}
public boolean isElecto(){
	return electo;
}
public boid setIdAutoridad(int idAutoridad){
	this.idAutoridad = idAutoridad;
}
public void setNombre(String nombre){
	this.nombre=nombre;
}
public void setApellido(String apelliudo){
	this.apellido = apellido;
}
public void setCargo (String cargo){
	this.cargo= cargo;
}
public void setNumeroVotos (int numeroVotos){
	this.numeroVotos = numeroVotos;
}
public void setElecto (boolean electo){
	this.electo = electo;
}

private ArrayList <String> historialSituaciones = new ArrayList <>();

public void registrarSituacionAnormal (String situacion) {
	historialSituaciones.add(situacion);
}
public ArrayList <String> getHistorialSituaciones(){
	return historialSituaciones;
}
}

