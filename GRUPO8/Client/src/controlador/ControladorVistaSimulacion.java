package controlador;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import entidades.Simulacion_EmpleadoPretenso;
import entidades.Simulacion_Empleador;
import simulacion.Simulacion;
import vista.IVentana;
import vista.IVistaSimulacion;

public class ControladorVistaSimulacion extends JFrame implements ActionListener, Observer {
	
	IVistaSimulacion vista = null;
	private IVentana ventana = null;
	private JPanel contentPane = null;
	private final String VOLVER = "Volver";
	private final String INICIAR = "Iniciar";
	private final String DETENER = "Detener";
	
	protected ArrayList<Simulacion_EmpleadoPretenso> empleadosObservados = new ArrayList<Simulacion_EmpleadoPretenso>();
	protected ArrayList<Simulacion_Empleador> empleadoresObservados = new ArrayList<Simulacion_Empleador>();
	
	public ControladorVistaSimulacion(IVentana ventana) {
		this.vista = ventana.getVistaSimulacion();
		this.ventana = ventana;
		this.vista.setActionListener(this);
		this.contentPane = ventana.getContentPane();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CardLayout cl = (CardLayout) (contentPane.getLayout());
		String comando = e.getActionCommand();
		
		switch(comando) {
		case VOLVER:
			cl.show(contentPane, ventana.getID_VistaInicial());
			break;
		case INICIAR:
			vista.setIniciarDisabled();
			this.vista.getTextArea_Consola().setText("");
			Simulacion.getInstancia().simulacion(this);
			this.vista.setTextArea_Empleadores(this.empleadoresObservados.toString());
			this.vista.setTextArea_EmpleadosPretensos(this.empleadosObservados.toString());
			break;
		case DETENER:
			vista.setDetenerDisabled();
			Simulacion.getInstancia().detener();
			break;
		}
	}
	
	

	public IVistaSimulacion getVista() {
		return vista;
	}

	public void agregarObservable(Simulacion_Empleador empleador) {
		empleador.addObserver(this);
		this.empleadoresObservados.add(empleador);
	}

	public void borrarObservable(Simulacion_Empleador empleador) {

		empleador.deleteObserver(this);
		this.empleadoresObservados.remove(empleador);
	}

	public void agregarObservable(Simulacion_EmpleadoPretenso empleado) {

		empleado.addObserver(this);
		this.empleadosObservados.add(empleado);
	}

	public void borrarObservable(Simulacion_EmpleadoPretenso empleado) {

		empleado.deleteObserver(this);
		this.empleadosObservados.remove(empleado);
	}

	@Override
	public void update(Observable o, Object arg) 
	{
		this.vista.setTextArea_Consola((String) arg+"\n");
	}
	
}
