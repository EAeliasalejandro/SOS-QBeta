import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Font;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	JDesktopPane principal;
	static JMenu mnVerArticulos;
	static JMenu mnArticulos;
	static JMenu mnRegistrarcliente;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Principal() {

		setTitle("Mesa de Regalos ITZ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		principal = new JDesktopPane();
		principal.setBackground(Color.LIGHT_GRAY);
		setContentPane(principal);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnIngresar = new JMenu("Ingresar");
		menuBar.add(mnIngresar);

		JMenuItem mntmLogin = new JMenuItem("Login");

		mnIngresar.add(mntmLogin);

		mnRegistrarcliente = new JMenu("Cliente");
		mnRegistrarcliente.setEnabled(false);
		menuBar.add(mnRegistrarcliente);

		JMenuItem mntmRegistrarCliente = new JMenuItem("Registrar");
		mnRegistrarcliente.add(mntmRegistrarCliente);

		mnArticulos = new JMenu("Articulos");
		mnArticulos.setEnabled(false);
		menuBar.add(mnArticulos);

		JMenuItem mntmRegistrarArticulo = new JMenuItem("Registrar");
		mnArticulos.add(mntmRegistrarArticulo);

		mnVerArticulos = new JMenu("Ver Articulos");
		mnVerArticulos.setEnabled(false);
		menuBar.add(mnVerArticulos);

		JMenuItem mntmVerLista = new JMenuItem("Ver lista");
		mnVerArticulos.add(mntmVerLista);

		Principal h = this;
		

		// *******************************************Eventos***************************************************************

		mntmLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login registrar = new Login("Ingresar los datos", true, true, true, h);
				principal.add(registrar);
			}
		});
	}// Fin constructor
//////////////////////////////////////////////////Metodos/////////////////////////////////////////////
	public static void cambioUsuario(int x){
		if(x == 1){
			mnVerArticulos.setEnabled(true);
			mnArticulos.setEnabled(true);
			mnRegistrarcliente.setEnabled(true);
		}else if (x==0){
			mnVerArticulos.setEnabled(true);
			mnArticulos.setEnabled(false);
			mnRegistrarcliente.setEnabled(false);
		}
	}
}
