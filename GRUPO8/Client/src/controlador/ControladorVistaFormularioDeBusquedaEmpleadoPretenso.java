package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import vista.IVistaFormularioDeBusquedaEmpleadoPretenso;
import vista.Ventana;

public class ControladorVistaFormularioDeBusquedaEmpleadoPretenso implements ActionListener 
{
	private IVistaFormularioDeBusquedaEmpleadoPretenso vista=null;
	private JPanel contentPane = null;
	private final String ACEPTAR = "Aceptar";
	private final String CANCELAR = "Cancelar";
	
	
	
	public ControladorVistaFormularioDeBusquedaEmpleadoPretenso(IVistaFormularioDeBusquedaEmpleadoPretenso vista,
			JPanel contentPane)
	{
		super();
		this.vista = vista;
		this.contentPane = contentPane;
		this.vista.setActionListener(this);
	}




	@Override
	public void actionPerformed(ActionEvent e)
	{
		CardLayout cl = (CardLayout)(contentPane.getLayout());
		String comando = e.getActionCommand();
		
		if(comando.equals(ACEPTAR)) 
		{
			cl.show(contentPane, Ventana.VISTA_GESTION_TICKET_PERSONA);
		}
		else
			if(comando.equals(CANCELAR)) 
			{
				cl.show(contentPane, Ventana.VISTA_GESTION_TICKET_PERSONA);
			}
		
		this.vista.actualizarComboBox();
		
	}

}
