package sistema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;

import entidades.Agencia;
import entidades.FormularioDeBusqueda;
import entidades.Persona_EmpleadoPretenso;
import entidades.Persona_Empleador;
import patronState.ActivoState;

abstract class RondaDeEncuentrosLaborales {

protected static void iniciaRondaDeEncuentrosLaborales ()
	{
		Sistema.setInicioRondaEncuentrosLaborales(true);
		GregorianCalendar fecha = new GregorianCalendar();
		ArrayList <Persona_Empleador> empleadores = Agencia.getInstancia().getEmpleadores();
		ArrayList <Persona_EmpleadoPretenso> empleadosPretensos = Agencia.getInstancia().getEmpleadosPretensos();
		Persona_Empleador empleador = null;
		Persona_EmpleadoPretenso empleadoP=null;
		
		
		for (int i=0; i<empleadores.size(); i++)
		{
			
			empleador = empleadores.get(i);
			if(empleador.getTicket()!=null)
				empleador.getTicket().generaListaDeAsignacion(empleador,empleadoP,fecha,empleadosPretensos);	
		}
		for (int i=0;i<empleadosPretensos.size();i++)
		{
			if (empleadosPretensos.get(i).getListaDeAsignacion()!=null) 
			{
				Collections.sort(empleadosPretensos.get(i).getListaDeAsignacion().getLista());
				empleador = (Persona_Empleador) empleadosPretensos.get(i).getListaDeAsignacion().getLista().get(0).getPersona();
				Sistema.puntajePrimero(empleador);
			}
		}
	}
}
