package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Alarma {
	private Integer idAlarma;
	private String codActivacion;
	private String codConfiguracion;
	private String nombre;
	private Set<Usuario> usuariosValidos;
	private Set<Accion> accionesRealizadas;
	private Set<Sensor> sensores;
	private Boolean estado;
	
	public Alarma(Integer idAlarma, String codActivacion, String codConfiguracion, String nombre) {
		super();
		this.idAlarma = idAlarma;
		this.codActivacion = codActivacion;
		this.codConfiguracion = codConfiguracion;
		this.nombre = nombre;
		this.accionesRealizadas= new TreeSet<>();
		this.usuariosValidos= new HashSet<>();
		this.sensores= new HashSet<>();
		this.estado=true;
	}

	public Integer getIdAlarma() {
		return idAlarma;
	}

	public void setIdAlarma(Integer idAlarma) {
		this.idAlarma = idAlarma;
	}

	public String getCodActivacion() {
		return codActivacion;
	}

	public void setCodActivacion(String codActivacion) {
		this.codActivacion = codActivacion;
	}

	public String getCodConfiguracion() {
		return codConfiguracion;
	}

	public void setCodConfiguracion(String codConfiguracion) {
		this.codConfiguracion = codConfiguracion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Usuario> getUsuariosValidos() {
		return usuariosValidos;
	}

	public void setUsuariosValidos(Set<Usuario> usuariosValidos) {
		this.usuariosValidos = usuariosValidos;
	}

	public Set<Accion> getAccionesRealizadas() {
		return accionesRealizadas;
	}

	public void setAccionesRealizadas(Set<Accion> accionesRealizadas) {
		this.accionesRealizadas = accionesRealizadas;
	}

	public Set<Sensor> getSensores() {
		return sensores;
	}

	public void setSensores(Set<Sensor> sensores) {
		this.sensores = sensores;
	}
	
	
	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Boolean agregarSensor(Sensor sensor) throws SensorDuplicadoException {
		for (Sensor sensor1 : sensores) {
			if(sensor1.getIdSensor().equals(sensor.getIdSensor())) {
				throw new SensorDuplicadoException();
				
			}
		}return this.sensores.add(sensor);
		
	}
	public Sensor buscarSensor (Integer idSensor) {
		for (Sensor sensor1 : sensores) {
			if(sensor1.getIdSensor().equals(idSensor)) {
				return sensor1;
			}
			
		}return null;
	}

	public Sensor activarSensor(Integer idSensor) {
		for (Sensor sensor : sensores) {
			if(sensor.getIdSensor().equals(idSensor))
			sensor.setEstado(true);
		}return null;
	}

	public void agregarAccion(Accion accion) {
		this.accionesRealizadas.add(accion);
	}


	
}
