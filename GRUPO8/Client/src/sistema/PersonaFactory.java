package sistema;

import entidades.Agencia;
import entidades.Cuenta;
import entidades.IRubro;
import entidades.Persona;
import entidades.Persona_EmpleadoPretenso;
import entidades.Persona_Empleador;
/**
 * Clase para la creacion de personas tanto empleados pretensos como empleadores.
 * @author Grupo 8
 * <br>Patron aplicado: Factory.
 */

public abstract class PersonaFactory {

	/**
	 *  <b>Pre: </b> usuario,contrasena,razonSocial,tipoPersona,rubro deben ser distintos de null.
	 * @param usuario Parametro de tipo String que representa el nombre del usuario.
	 * @param contrasena Parametro de tipo String que representa la contraseña del usuario.
	 * @param razonSocial Parametro de tipo String que representa el nombre, o la razon social del empleador.
	 * @param tipoPersona Parametro de tipo String que representa el tipo de persona del empleador (fisica o juridica).
	 * @param rubro Parametro de tipo IRubro que representa el rubro del empleador, en base al cual se le cobraran comisiones.
	 * @return Retorna una instancia de un objeto de clase Persona.
	 */
	public static Persona getEmpleador(String usuario, String contrasena, String razonSocial, String tipoPersona, IRubro rubro,double[] puntajeAspectos) {
		Persona persona = null;
		Cuenta cuenta = null;
		
		cuenta = new Cuenta(usuario, contrasena, Agencia.EMPLEADOR);
		persona = new Persona_Empleador(cuenta,razonSocial,tipoPersona,rubro,puntajeAspectos);
		
		return persona;
	}
	
	/**
	 * <b>Pre: </b> usuario,contrasena,nya,telefono,edad deben ser distintos de null.
	 * @param usuario Parametro de tipo String que representa el nombre del usuario.
	 * @param contrasena Parametro de tipo String que representa la contraseña del usuario.
	 * @param nya Parametro de tipo String que representa el nombre y apellido de la persona empleado pretenso.
	 * @param telefono Parametro de tipo String que representa el numero de telefono del empleado.
	 * @param edad Parametro de tipo int que representa la edad del empleado.
	 * @return Retorna una instancia de un objeto de clase Persona.
	 */
	public static Persona getEmpleadoPretenso(String usuario, String contrasena, String nya, String telefono, int edad) {
		Persona persona = null;
		Cuenta cuenta = null;
		
		cuenta = new Cuenta(usuario, contrasena, Agencia.EMPLEADO_PRETENSO);
		persona = new Persona_EmpleadoPretenso(cuenta,nya,telefono,edad);
		
		return persona;
	}
}
