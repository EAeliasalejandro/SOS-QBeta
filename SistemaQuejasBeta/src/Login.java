import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Login extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private Principal menuIngreso;
	private JPanel contentPane;
	private JPanel contentPane_1;
	private JTextField txtUsuario;
	private JButton btnAcceder;
	private JPasswordField txtPass;
	
	public Login(String titulo, boolean tamaño, boolean cerrar, boolean maximizar, Principal padre) {

		super(titulo, tamaño, cerrar, maximizar);
		menuIngreso = padre;

		setBounds(100, 100, 450, 300);
		contentPane_1 = (JPanel) this.getContentPane();
		contentPane_1.setLayout(null);
		setVisible(true);

		setTitle("Ingresar");
		setBounds(100, 100, 450, 300);
		contentPane_1 = new JPanel();
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_1);
		contentPane_1.setLayout(null);

		JLabel lblMesaDeRegalos = new JLabel("Mesa De Regalos ITZ");
		lblMesaDeRegalos.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		lblMesaDeRegalos.setBounds(124, 11, 178, 24);
		contentPane_1.add(lblMesaDeRegalos);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLogin.setBounds(193, 36, 46, 24);
		contentPane_1.add(lblLogin);

		JLabel lblNombreDeUsuario = new JLabel("Nombre de Usuario:");
		lblNombreDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombreDeUsuario.setBounds(10, 83, 115, 14);
		contentPane_1.add(lblNombreDeUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblContrasea.setBounds(10, 127, 86, 14);
		contentPane_1.add(lblContrasea);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(145, 78, 178, 24);
		contentPane_1.add(txtUsuario);
		txtUsuario.setColumns(10);

		btnAcceder = new JButton("Aceptar");
		btnAcceder.setBounds(186, 161, 89, 23);
		contentPane_1.add(btnAcceder);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(145, 122, 178, 24);
		contentPane_1.add(txtPass);
		
//////////////////// Acciones///////////////////////////////////////
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String contraseña= new String(txtPass.getPassword());
				String UserRoot = "adminMesaRegalos";
				String PassRoot = "Mesa.2018";

				String UserClie = "clieMesaRegalos";
				String PassClie = "MesaCliente";
				
				if (txtUsuario.getText().equals(UserRoot) && contraseña.equals(PassRoot)) {
					JOptionPane.showMessageDialog(null, "Ingresaste como super usuario y/O administrador");
					// realizar conexion con el super usuario y poner
					// visible todas las pestañas
					/*
					 * try { try { Connection cn;
					 * Class.forName("com.mysql.jdbc.Driver"); cn =
					 * DriverManager.getConnection(
					 * "jdbc:mysql://localhost/mesaregalosproyectofinal?user=" +
					 * usuario + "&password=" + password); Statement st =
					 * cn.createStatement();
					 * 
					 * } catch (SQLException ex) { ex.printStackTrace();
					 * JOptionPane.showMessageDialog(null,
					 * "Error en el ingreso"); } } catch (ClassNotFoundException
					 * e1) { // TODO Auto-generated catch block
					 * e1.printStackTrace(); }
					 */
					Principal.cambioUsuario(1);
					dispose();
				} else if  (txtUsuario.getText().equals(UserClie) & contraseña.equals(PassClie)) {
					// iniciar la conexion como cliente y poner visible las
					// pestañas
					// solo para agregar regalos
					JOptionPane.showMessageDialog(null, "Ingresaste como un cliente");
					/*
					 * try { try { Connection cn;
					 * Class.forName("com.mysql.jdbc.Driver"); cn =
					 * DriverManager.getConnection(
					 * "jdbc:mysql://localhost/mesaregalosproyectofinal?user=" +
					 * usuario + "&password=" + password); Statement st =
					 * cn.createStatement();
					 * 
					 * } catch (SQLException ex) { ex.printStackTrace();
					 * JOptionPane.showMessageDialog(null,
					 * "Error en el ingreso"); } } catch (ClassNotFoundException
					 * e1) { // TODO Auto-generated catch block
					 * e1.printStackTrace(); }
					 */
					Principal.cambioUsuario(0);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrecta");
					dispose();
				}
			}
		});
	}// fin del constructor
}// fin programa
