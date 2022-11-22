package ar.edu.unlam.pb2;

public class UsuarioAdministrador extends Usuario{
	

	public UsuarioAdministrador(Integer dni, String nombre) {
		super(dni, nombre);
	}
	public Boolean agregarAlarma(Alarma nuevaAlarma, Central nuevaCentral) {
		nuevaCentral.agregarAlarma(nuevaAlarma);
		return true;
	}
	public Boolean agregarUsuario(Usuario usuario, Central nuevaCentral) {
		nuevaCentral.agregarUsuarioAUnaAlarma(usuario);
		return true;
	}

	public void agregarUsuarioAUnaAlarma(Integer iddniUsuarioAAgregar, Integer idAlarma, String codigoConfiguracionAlarma, Central nuevaCentral, Usuario usuario, Alarma alarma) throws CodigoInvalidoException {
		if(nuevaCentral.buscarAlarma(idAlarma).getCodConfiguracion().equals(codigoConfiguracionAlarma)) {
			nuevaCentral.agregarUsuarioAUnaAlarma(usuario);
		}else {
			throw new CodigoInvalidoException();
		}
	}
	public void agregarSensorALaAlarma(Integer idAlarma, String codigoConfiguracionAlarma, Sensor sensor, Central nuevaCentral, Alarma alarma) throws SensorDuplicadoException {
		if(!nuevaCentral.buscarAlarma(idAlarma).getCodConfiguracion().equals(codigoConfiguracionAlarma)) {
			alarma.agregarSensor(sensor);
		}
		
	}
	public Boolean activarDesactivarAlarma(Integer idAlarma, String codigoConfiguracionAlarma, Integer idSensor, Central nuevaCentral, Alarma alarma) throws SensorDesactivado {
		if(nuevaCentral.buscarAlarma(idAlarma).getCodConfiguracion().equals(codigoConfiguracionAlarma) && alarma.buscarSensor(idSensor).getEstado()==true) {
			alarma.setEstado(true);
		}else {
			alarma.setEstado(false);
			throw new SensorDesactivado();
		}return null;
	}
	

}
