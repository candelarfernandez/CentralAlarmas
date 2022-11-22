package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

public class TestCases {

	@Test
	public void queSePuedaRegistrarUnaAlarmaEnLaCentral() {
		Central nuevaCentral = new Central("nuevaCentral");
		Alarma alarma = new Alarma(1, "a-22", "a-34", "primerAlarma");
		Usuario admin = new UsuarioAdministrador(44424896, "candela");
		((UsuarioAdministrador) admin).agregarAlarma(alarma, nuevaCentral);
		assertEquals((Integer)1, nuevaCentral.obtenerCantidadDeAlarmas());
	}
	@Test
	public void queSePuedaAgregarUnUsuarioConfiguradorAUnaAlarma() {
		Central nuevaCentral = new Central("nuevaCentral");
		Alarma alarma = new Alarma(1, "a-22", "a-34", "primerAlarma");
		Usuario configurador = new UsuarioConfigurador(44424896, "candela");
		Usuario admin = new UsuarioAdministrador(44424896, "candela");
		((UsuarioAdministrador) admin).agregarAlarma(alarma, nuevaCentral);
		((UsuarioAdministrador) admin).agregarUsuario(configurador, nuevaCentral);
		assertEquals((Integer)1, nuevaCentral.obtenerCantidadDeUsuarios());
	}
	@Test (expected = CodigoInvalidoException.class)
	public void alAgregarUnUsuarioAUnaAlarmaConCodigoDeConfiguracionDeAlarmaInvalidoSeLanceCodigoAlarmaIncorrectoException() throws CodigoInvalidoException {
		Central nuevaCentral = new Central("nuevaCentral");
		Alarma alarma = new Alarma(1, "invalido", "a-34", "primerAlarma");
		Usuario configurador = new UsuarioConfigurador(44424896, "candela");
		Usuario admin = new UsuarioAdministrador(44424896, "candela");
		((UsuarioAdministrador) admin).agregarAlarma(alarma, nuevaCentral);
		((UsuarioAdministrador) admin).agregarUsuario(configurador, nuevaCentral);
		((UsuarioAdministrador) admin).agregarUsuarioAUnaAlarma(1, 1, "hola", nuevaCentral, admin, alarma);
	}
	
	@Test (expected = SensorDuplicadoException.class)
	public void alAgregarUnSensorDuplicadoEnUnaAlarmaSeLanceUnaExcepcion() throws SensorDuplicadoException {
		Central nuevaCentral = new Central("nuevaCentral");
		Alarma alarma = new Alarma(1, "invalido", "a-34", "primerAlarma");
		Usuario configurador = new UsuarioConfigurador(44424896, "candela");
		Usuario admin = new UsuarioAdministrador(44424896, "candela");
		Sensor sensor = new Sensor(1, true);
		Sensor sensor1 = new Sensor(1, true);
		((UsuarioAdministrador) admin).agregarAlarma(alarma, nuevaCentral);
		((UsuarioAdministrador) admin).agregarSensorALaAlarma(1, "invalido", sensor, nuevaCentral, alarma);
		((UsuarioAdministrador) admin).agregarSensorALaAlarma(1, "invalido", sensor1, nuevaCentral, alarma);
	}
	@Test (expected = SensorDesactivado.class)
	public void queNoSePuedaActivarUnaAlarmaSiHayAlMenosUnSensorDesactivado() throws SensorDuplicadoException, SensorDesactivado {
		Central nuevaCentral = new Central("nuevaCentral");
		Alarma alarma = new Alarma(1, "invalido", "a-34", "primerAlarma");
		Usuario admin = new UsuarioAdministrador(44424896, "candela");
		Sensor sensor = new Sensor(1, false);
		((UsuarioAdministrador) admin).agregarAlarma(alarma, nuevaCentral);
		((UsuarioAdministrador) admin).agregarSensorALaAlarma(1, "invalido", sensor, nuevaCentral, alarma);
		((UsuarioAdministrador) admin).activarDesactivarAlarma(1, "invalido", 1, nuevaCentral, alarma);
	}
	
	@Test
	public void queParaUnaAlarmaDeterminadaSEPuedaObtenerUnaColeccionOrdenaadaDeAccionEsDeTipoConfiguracionOrdenadasPorIdDeAccion() {
		Central nuevaCentral = new Central("nuevaCentral");
		Alarma alarma = new Alarma(1, "invalido", "a-34", "primerAlarma");
		Usuario admin = new UsuarioAdministrador(44424896, "candela");
		Accion accion = new Accion(4, "20220531", TipoOperacion.CONFIGURACION);
		Accion accion1 = new Accion(3, "20220531", TipoOperacion.CONFIGURACION);
		Accion accion2 = new Accion(1, "20220531", TipoOperacion.CONFIGURACION);
		Accion accion3 = new Accion(2, "20220531", TipoOperacion.CONFIGURACION);
		alarma.agregarAccion(accion);
		alarma.agregarAccion(accion2);
		alarma.agregarAccion(accion3);
		alarma.agregarAccion(accion1);
		Set<Accion> accionesOrdenadas = alarma.getAccionesRealizadas();
		for (Accion accion4 : accionesOrdenadas) {
			assertEquals((Integer)1, accion4.getIdAccion());
			break;
		}
	
	}

}
