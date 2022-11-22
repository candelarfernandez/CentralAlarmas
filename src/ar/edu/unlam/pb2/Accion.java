package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.Set;

public class Accion implements Comparable<Accion> {
	private Integer idAccion;
	private Set<Alarma> alarmas;
	private Set<Usuario> usuarios;
	private String fecha;
	private TipoOperacion tipo;
	
	public Accion(Integer idAccion, String fecha, TipoOperacion tipo) {
		super();
		this.idAccion = idAccion;
		this.fecha = fecha;
		this.tipo = tipo;
		this.alarmas= new HashSet<>();
		this.usuarios= new HashSet<>();
	}

	public Integer getIdAccion() {
		return idAccion;
	}

	public void setIdAccion(Integer idAccion) {
		this.idAccion = idAccion;
	}

	public Set<Alarma> getAlarmas() {
		return alarmas;
	}

	public void setAlarmas(Set<Alarma> alarmas) {
		this.alarmas = alarmas;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public TipoOperacion getTipo() {
		return tipo;
	}

	public void setTipo(TipoOperacion tipo) {
		this.tipo = tipo;
	}

	@Override
	public int compareTo(Accion o) {
		return this.idAccion.compareTo(o.getIdAccion());
	}
	
	

}
