package patronState;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import entidades.FormularioDeBusqueda;
import entidades.ListaDeAsignacion;
import entidades.Persona;
import entidades.PersonaElegida;
import entidades.Persona_EmpleadoPretenso;
import entidades.Persona_Empleador;
import entidades.Ticket;
import entidades.Ticket_EmpleadoPretenso;
import entidades.Usuario;
import excepciones.ModificacionTicketInvalidaException;
import sistema.Sistema;

public class ActivoState implements IState
{
	private Ticket ticket;
	
	
	
	public ActivoState(Ticket ticket)
	{
		super();
		this.ticket = ticket;
	}

	
	@Override
	public void suspender()
	{
		this.ticket.setEstado(new SuspendidoState(this.ticket));
		
	}

	@Override
	public void cancelar()
	{
		this.ticket.setEstado(new CanceladoState(this.ticket));
		
	}

	@Override
	public void finalizar()
	{
		this.ticket.setEstado(new FinalizadoState(this.ticket));
		
	}


	@Override
	public void modificarTicket_Formulario( FormularioDeBusqueda form) throws ModificacionTicketInvalidaException
	{
		if (!Sistema.isInicioRondaEncuentrosLaborales())
			this.ticket.setFormularioDeBusqueda(form);
		else
			throw new ModificacionTicketInvalidaException("no se puede modificar el ticket una vez iniciada la ronda de encuentros laborales");
		
	}


	@Override
	public void comparaFormularioEmpleador(Persona_Empleador empleador,Persona_EmpleadoPretenso empleadoP,GregorianCalendar fecha,ArrayList<Persona_EmpleadoPretenso>empleadosPretensos)
	{
		
		
		empleador.setListaDeAsignacion(new ListaDeAsignacion());
		empleador.getListaDeAsignacion().setLista(new ArrayList<PersonaElegida>());
		empleador.getListaDeAsignacion().setFechaDeCreacion(fecha); 
		for (int j=0; j < empleadosPretensos.size(); j++)
		{
			
			empleadoP = (Persona_EmpleadoPretenso) empleadosPretensos.get(j);	
			if(empleadoP.getListaDeAsignacion() == null) {
				empleadoP.setListaDeAsignacion(new ListaDeAsignacion());
				empleadoP.getListaDeAsignacion().setLista(new ArrayList<PersonaElegida>());
				empleadoP.getListaDeAsignacion().setFechaDeCreacion(fecha);
			}
			empleadoP.getTicket().comparaFormularioEmpleadoPretenso(empleadoP,empleador);
			
		}
	}


	@Override
	public void comparaFormularioEmpleadoPretenso(Persona_EmpleadoPretenso empleadoP,Persona_Empleador empleador)
	{
		FormularioDeBusqueda formularioEmpleadoP;
		FormularioDeBusqueda formularioEmpleador;
		formularioEmpleadoP=empleadoP.getTicket().getFormularioDeBusqueda();
		formularioEmpleador = empleador.getTicket().getFormularioDeBusqueda();
		double puntajeDeContratacion=0;
		puntajeDeContratacion+=empleador.getPuntajeAspectos()[0]*formularioEmpleador.getLocacion().comparaCon(formularioEmpleadoP.getLocacion())
					+empleador.getPuntajeAspectos()[1]*formularioEmpleador.getRemuneracion().comparaCon(formularioEmpleadoP.getRemuneracion())
					+empleador.getPuntajeAspectos()[2]*formularioEmpleador.getCargaHoraria().comparaCon(formularioEmpleadoP.getCargaHoraria())
					+empleador.getPuntajeAspectos()[3]*formularioEmpleador.getTipoDePuesto().comparaCon(formularioEmpleadoP.getTipoDePuesto())
					+empleador.getPuntajeAspectos()[4]*formularioEmpleador.getRangoEtario().comparaCon(formularioEmpleadoP.getRangoEtario())
					+empleador.getPuntajeAspectos()[5]*formularioEmpleador.getExperienciaPrevia().comparaCon(formularioEmpleadoP.getExperienciaPrevia())
					+empleador.getPuntajeAspectos()[6]*formularioEmpleador.getEstudiosCursados().comparaCon(formularioEmpleadoP.getEstudiosCursados());
		
		empleador.getListaDeAsignacion().getLista().add(new PersonaElegida(empleadoP,puntajeDeContratacion));
		empleadoP.getListaDeAsignacion().getLista().add(new PersonaElegida(empleador,puntajeDeContratacion));
	
		
	}


	@Override
	public String visualizaResultado(Usuario usuario)
	{
		
		return "lo sentimos "+((Persona_EmpleadoPretenso) usuario).getNya()+", no fuiste contratado/a por ninguna empresa";
	}


	@Override
	public void seteaResultado(Persona_EmpleadoPretenso empleadoPretenso)
	{
		Ticket_EmpleadoPretenso ticket = (Ticket_EmpleadoPretenso) empleadoPretenso.getTicket();
		ticket.setResultado("fracaso");
		
	}


	@Override
	public void activar()
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	public String visualizarCostoServicio(Persona usuario)
	{
		
		return "ticket no finalizado";
	}


	

	

}