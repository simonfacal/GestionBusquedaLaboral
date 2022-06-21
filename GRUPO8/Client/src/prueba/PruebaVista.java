package prueba;

import javax.swing.JPanel;

import controlador.ControladorVistaFormularioDeBusquedaEmpleadoPretenso;
import controlador.ControladorVistaFormularioDeBusquedaEmpleador;
import controlador.ControladorVistaFuncionalidadesAdministrador;
import controlador.ControladorVistaFuncionalidadesPersona;
import controlador.ControladorVistaGestionTicketPersona;
import controlador.ControladorVistaInicial;
import controlador.ControladorVistaRegistrarAdministrador;
import controlador.ControladorVistaRegistrarEmpleadoPretenso;
import controlador.ControladorVistaRegistrarEmpleador;
import controlador.ControladorVistaSimulacion;
import entidades.Agencia;
import sistema.Sistema;
import vista.Ventana;
import vista.VistaFormularioDeBusquedaEmpleadoPretenso;
import vista.VistaFormularioDeBusquedaEmpleador;
import vista.VistaFuncionalidadesAdministrador;
import vista.VistaFuncionalidadesPersona;
import vista.VistaGestionTicketPersona;
import vista.VistaInicial;
import vista.VistaRegistrarAdministrador;
import vista.VistaRegistrarEmpleadoPretenso;
import vista.VistaRegistrarEmpleador;
import vista.VistaSimulacion;

public class PruebaVista {

	public static void main(String[] args) {
		VistaInicial vistaInicial = new VistaInicial();
		VistaRegistrarAdministrador vistaRegistrarAdministrador = new VistaRegistrarAdministrador();
		VistaRegistrarEmpleadoPretenso vistaRegistrarEmpleadoPretenso = new VistaRegistrarEmpleadoPretenso();
		VistaRegistrarEmpleador vistaRegistrarEmpleador = new VistaRegistrarEmpleador();
		VistaFuncionalidadesAdministrador vistaFuncionalidadesAdministrador = new VistaFuncionalidadesAdministrador();
		VistaFuncionalidadesPersona vistaFuncionalidadesPersona = new VistaFuncionalidadesPersona();
		VistaFormularioDeBusquedaEmpleadoPretenso vistaFormularioDeBusquedaEmpleadoPretenso = new VistaFormularioDeBusquedaEmpleadoPretenso();
		VistaFormularioDeBusquedaEmpleador vistaFormularioDeBusquedaEmpleador = new VistaFormularioDeBusquedaEmpleador();
		VistaGestionTicketPersona vistaGestionTicketPersona = new VistaGestionTicketPersona();
		VistaSimulacion vistaSimulacion = new VistaSimulacion();
		
		Ventana ventana = new Ventana(vistaInicial,
				vistaRegistrarAdministrador,
				vistaRegistrarEmpleadoPretenso,
				vistaRegistrarEmpleador,
				vistaFuncionalidadesAdministrador,
				vistaFuncionalidadesPersona,
				vistaFormularioDeBusquedaEmpleadoPretenso,
				vistaFormularioDeBusquedaEmpleador,
				vistaGestionTicketPersona,
				vistaSimulacion);
		
		
		
		
		ControladorVistaInicial controladorVistaInicial = new ControladorVistaInicial(ventana,vistaInicial);
		ControladorVistaRegistrarAdministrador controladorVistaRegistrarAdministrador = new ControladorVistaRegistrarAdministrador(ventana,vistaRegistrarAdministrador);
		ControladorVistaRegistrarEmpleadoPretenso controladorVistaRegistrarEmpleadoPretenso = new ControladorVistaRegistrarEmpleadoPretenso(ventana,vistaRegistrarEmpleadoPretenso);
		ControladorVistaRegistrarEmpleador controladorVistaRegistrarEmpleador = new ControladorVistaRegistrarEmpleador(ventana,vistaRegistrarEmpleador);
		ControladorVistaSimulacion controladorVistaSimulacion = new ControladorVistaSimulacion(ventana,vistaSimulacion);
		ControladorVistaFuncionalidadesAdministrador controladorVistaFuncionalidadesAdministrador = new ControladorVistaFuncionalidadesAdministrador(ventana,vistaFuncionalidadesAdministrador);
		ControladorVistaFuncionalidadesPersona controladorVistaFuncionalidadesPersona = new ControladorVistaFuncionalidadesPersona(ventana,vistaFuncionalidadesPersona);
		ControladorVistaFormularioDeBusquedaEmpleador controladorVistaFormularioDeBusquedaEmpleador = new ControladorVistaFormularioDeBusquedaEmpleador(ventana,vistaFormularioDeBusquedaEmpleador);
		ControladorVistaFormularioDeBusquedaEmpleadoPretenso controladorVistaFormularioDeBusquedaEmpleadoPretenso = new ControladorVistaFormularioDeBusquedaEmpleadoPretenso(ventana,vistaFormularioDeBusquedaEmpleadoPretenso);
		ControladorVistaGestionTicketPersona controladoVistaGestionTicketPersona = new ControladorVistaGestionTicketPersona(ventana,vistaGestionTicketPersona);
	}

}
