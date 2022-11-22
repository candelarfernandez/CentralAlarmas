package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.Set;

public class Central {
	private String nombre;
	private Set<Alarma> alarmas;
	private Set<Usuario> usuarios;

	public Central(String nombre) {
		super();
		this.nombre = nombre;
		this.alarmas= new HashSet<>();
		this.usuarios = new HashSet<>();
	}
	public Alarma obtenerAlarmasPorId(Integer idAlarma) {
		for (Alarma alarma : alarmas) {
			if(alarma.getIdAlarma().equals(idAlarma)) {
				return alarma;
			}
		}return null;
	}

	public Set<Alarma> getAlarmas() {
		return alarmas;
	}

	public void setAlarmas(Set<Alarma> alarmas) {
		this.alarmas = alarmas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void agregarAlarma(Alarma alarma) {
		this.alarmas.add(alarma);
	}

	public Integer obtenerCantidadDeAlarmas() {
		return this.alarmas.size();
	}

	public void agregarUsuarioAUnaAlarma(Usuario usuario) {
		this.usuarios.add(usuario);
		
	}

	public Integer obtenerCantidadDeUsuarios() {
		return this.usuarios.size();
	}
	public Alarma buscarAlarma(Integer idAlarma) {
		for (Alarma alarma : alarmas) {
         if(alarma.getIdAlarma().equals(idAlarma)) {
				return alarma;
			}
		}return null;
			
}
		
    public Usuario buscarUsuario(Integer idDni) {
	  for (Usuario usuario : usuarios) {
		if(usuario.getDni().equals(idDni)) {
			return usuario;
		}
		
	}return null;
    }
			
		
	}
	


