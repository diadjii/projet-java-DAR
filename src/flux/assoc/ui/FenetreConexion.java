package flux.assoc.ui;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import flux.assoc.listener.ListenerConnexion;
import javax.swing.border.LineBorder;

public class FenetreConexion extends FenetrePrincipale {
	private JTextField login;
	private JPasswordField password;
	private JButton btnNewButton;
	
	

	public JTextField getLogin() {
		return login;
	}


	public void setLogin(JTextField login) {
		this.login = login;
	}


	public JPasswordField getPassword() {
		return password;
	}


	public void setPassword(JPasswordField password) {
		this.password = password;
	}


	public JButton getBtnNewButton() {
		return btnNewButton;
	}


	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}


	/**
	 * Create the panel.
	 */
	public FenetreConexion() throws SQLException {
		
		JPanel panelConnexion = new JPanel();
		panelConnexion.setForeground(Color.WHITE);
		panelConnexion.setBackground(new Color(0, 30, 51));
		panelConnexion.setBounds(528, 71, 430, 563);
		getContentPane().add(panelConnexion);
		panelConnexion.setLayout(null);
		
		JLabel labelLogin = new JLabel("Login :");
		labelLogin.setForeground(Color.WHITE);
		labelLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelLogin.setBounds(31, 266, 60, 22);
		panelConnexion.add(labelLogin);
		
		login = new JTextField();
		login.setBounds(129, 265, 205, 28);
		panelConnexion.add(login);
		login.setColumns(10);
		
		JLabel labelPassword = new JLabel("Password :");
		labelPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelPassword.setForeground(Color.WHITE);
		labelPassword.setBounds(31, 329, 88, 23);
		panelConnexion.add(labelPassword);
		
		password = new JPasswordField();
		password.setBounds(129, 329, 205, 27);
		panelConnexion.add(password);
		
		btnNewButton = new JButton("Connexion");
		btnNewButton.setBackground(new Color(255, 204, 51));
		btnNewButton.setForeground(new Color(0, 0, 51));
		btnNewButton.setBorder(new LineBorder(new Color(255, 204, 51), 5));
		btnNewButton.setBounds(172, 404, 89, 23);
		btnNewButton.addMouseListener(new ListenerConnexion(this));
		panelConnexion.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Se Connecter");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(153, 180, 165, 33);
		panelConnexion.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(FenetreConexion.class.getResource("/images/icons8_User_Groups_96px.png")));
		label.setBounds(170, 75, 114, 80);
		panelConnexion.add(label);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 74, 528, 558);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(FenetreConexion.class.getResource("/images/Sans titre-1.png")));
		label_1.setBounds(0, 0, 528, 558);
		panel.add(label_1);
		setVisible(true);
		iconSMS.setVisible(false);
	
	}
}
