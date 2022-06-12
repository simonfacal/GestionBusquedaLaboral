package entidades;

import tablas.ILocacion;
import tablas.Locacion_HomeOffice;
import tablas.Locacion_Indistinto;
import tablas.Locacion_Presencial;

public class Simulacion_Empleador extends Persona_Empleador implements Runnable {
	
	private BolsaDeTrabajo bolsaDeTrabajo;

	public Simulacion_Empleador( String razonSocial)
    {
		super(null, razonSocial, null, null, null);
		bolsaDeTrabajo = BolsaDeTrabajo.getInstancia();
	}

	@Override
	public  void run() {
		TicketSimplificado ticketSimplificado = null;
		ILocacion locacion = null;
		IRubro rubro = null;
		int opcion = 0;
		
		for(int i = 0; i < 3; i++) {
			opcion = (int)(Math.random()*3+1);
			
			switch(opcion) {
			case 1: locacion = new Locacion_Presencial();
				break;
			case 2: locacion = new Locacion_HomeOffice();
				break;
			case 3: locacion = new Locacion_Indistinto();
				break;
			}
			
			opcion = (int)(Math.random()*3+1);
			
			switch(opcion) {
			case 1: rubro = new Rubro_ComercioLocal();
				break;
			case 2: rubro = new Rubro_ComercioInternacional();
				break;
			case 3: rubro = new Rubro_Salud();
				break;
			}
			
			ticketSimplificado = new TicketSimplificado(locacion, rubro, this);
			
			bolsaDeTrabajo.poneTicketSimplificado(this,ticketSimplificado);
		}
	}
}
