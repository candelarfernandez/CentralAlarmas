package ar.edu.unlam.pb2;

import java.util.Objects;

public class Sensor {
	private Integer idSensor;
	private Boolean estado;
	public Sensor(Integer idSensor, Boolean estado) {
		super();
		this.idSensor = idSensor;
		this.estado = estado;
	}
	public Integer getIdSensor() {
		return idSensor;
	}
	public void setIdSensor(Integer idSensor) {
		this.idSensor = idSensor;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	@Override
	public int hashCode() {
		return Objects.hash(estado, idSensor);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sensor other = (Sensor) obj;
		return Objects.equals(estado, other.estado) && Objects.equals(idSensor, other.idSensor);
	}
	

}
