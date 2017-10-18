package CajaRegistradora1;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PanelIzquierdo extends JPanel implements ActionListener{
	
	
	
	private GridBagConstraints c;
	private Insets in;

	private JButton Jbt_AgregarPro;
	private JButton Jbt_VerListado;
	private JButton Jbt_AlertaInv;
	private JButton Jbt_RegistrarCliente;
	private JButton Jbt_ListadoClientes;
	private JButton Jbt_MejoresClientes;
	
	public PanelIzquierdo() {
		setLayout(new GridBagLayout());
		Border borde1 = BorderFactory.createTitledBorder("Formulario");
		setBorder (borde1);
		
		Jbt_AgregarPro = new JButton("Agregar Producto");
        Jbt_AgregarPro.addActionListener(this);
        Jbt_AgregarPro.setActionCommand("a");
        c=new GridBagConstraints();
        c.gridx=0;
        c.gridy=1;
        c.fill = GridBagConstraints.BOTH;
        in = new Insets( 5, 10, 5, 10 );
        c.insets = in;
        add(Jbt_AgregarPro,c);
        
        Jbt_VerListado = new JButton("Ver Listado");
        Jbt_VerListado.addActionListener(this);
        Jbt_VerListado.setActionCommand("a");
        c=new GridBagConstraints();
        c.gridx=0;
        c.gridy=2;
        c.fill = GridBagConstraints.BOTH;
        in = new Insets( 5, 10, 5, 10 );
        c.insets = in;
        add(Jbt_VerListado,c);
        
        Jbt_AlertaInv = new JButton("Alerta Stock");
        Jbt_AlertaInv.addActionListener(this);
        Jbt_AlertaInv.setActionCommand("a");
        c=new GridBagConstraints();
        c.gridx=0;
        c.gridy=3;
        c.fill = GridBagConstraints.BOTH;
        in = new Insets( 5, 10, 5, 10 );
        c.insets = in;
        add(Jbt_AlertaInv,c);
        
        Jbt_RegistrarCliente = new JButton("Registrar cliente");
        Jbt_RegistrarCliente.addActionListener(this);
        Jbt_AlertaInv.setActionCommand("a");
        c=new GridBagConstraints();
        c.gridx=0;
        c.gridy=4;
        c.fill = GridBagConstraints.BOTH;
        in = new Insets( 5, 10, 5, 10 );
        c.insets = in;
        add(Jbt_RegistrarCliente,c);
        
        Jbt_ListadoClientes = new JButton("Listado Cliente");
        Jbt_ListadoClientes.addActionListener(this);
        Jbt_AlertaInv.setActionCommand("a");
        c=new GridBagConstraints();
        c.gridx=0;
        c.gridy=5;
        c.fill = GridBagConstraints.BOTH;
        in = new Insets( 5, 10, 5, 10 );
        c.insets = in;
        add(Jbt_ListadoClientes,c);
        
        Jbt_MejoresClientes = new JButton("Mejores Clientes");
        Jbt_MejoresClientes.addActionListener(this);
        Jbt_AlertaInv.setActionCommand("a");
        c=new GridBagConstraints();
        c.gridx=0;
        c.gridy=6;
        c.fill = GridBagConstraints.BOTH;
        in = new Insets( 5, 10, 5, 10 );
        c.insets = in;
        add(Jbt_MejoresClientes,c);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
	}

}
