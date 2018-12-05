package flux.assoc.ui;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import flux.assoc.listener.ListenerMessage;

public class FenetreMessage extends FenetrePrincipale {
	private JTextField nomMembre;
	private JTextField prenomMembre;
	private JDateChooser dateEntreeMembre = new JDateChooser();
	private JTextField adresseMembre;
	public JButton btnEnvoyer = new JButton("Envoyer Message");
	private JDateChooser dateNaissMembre = new JDateChooser();

	/**
	 * Create the panel.
	 */
	public FenetreMessage() throws SQLException{
		iconHome.setVisible(true);
		lblAcceuil.setVisible(true);
		FenetrePrincipale.iconUser.setVisible(true);
		JLabel lblEnvoiDunMessage = new JLabel("Demande Cr\u00E9ation d'un Membre");
		lblEnvoiDunMessage.setForeground(new Color(0, 0, 51));
		lblEnvoiDunMessage.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEnvoiDunMessage.setBounds(288, 114, 355, 25);
		getContentPane().add(lblEnvoiDunMessage);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 51));
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 51)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(221, 162, 508, 400);
		getContentPane().add(panel);

		JLabel label_1 = new JLabel("Nom  :");
		label_1.setForeground(new Color(0, 0, 51));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(109, 135, 46, 17);
		panel.add(label_1);

		nomMembre = new JTextField();
		nomMembre.setSelectionColor(new Color(255, 102, 51));
		nomMembre.setColumns(10);
		nomMembre.setBorder(new LineBorder(new Color(0, 0, 51)));
		nomMembre.setBounds(238, 135, 164, 20);
		panel.add(nomMembre);

		JLabel label_2 = new JLabel("Pr\u00E9nom  :");
		label_2.setForeground(new Color(0, 0, 51));
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(109, 176, 73, 26);
		panel.add(label_2);

		prenomMembre = new JTextField();
		prenomMembre.setColumns(10);
		prenomMembre.setBorder(new LineBorder(new Color(0, 0, 51)));
		prenomMembre.setBounds(238, 181, 164, 20);
		panel.add(prenomMembre);

		JLabel label_3 = new JLabel("Date de Naissance :");
		label_3.setForeground(new Color(0, 0, 51));
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(109, 221, 129, 17);
		panel.add(label_3);

		dateNaissMembre.setBorder(new LineBorder(new Color(0, 0, 51)));
		dateNaissMembre.setBounds(238, 221, 164, 20);
		panel.add(dateNaissMembre);

		JLabel labelDateEntre = new JLabel("Date d' Entr\u00E9e :");
		labelDateEntre.setForeground(new Color(0, 0, 51));
		labelDateEntre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelDateEntre.setBounds(109, 267, 129, 17);
		panel.add(labelDateEntre);

		dateEntreeMembre.setBorder(new LineBorder(new Color(0, 0, 51)));
		dateEntreeMembre.setBounds(238, 267, 164, 20);
		panel.add(dateEntreeMembre);

		JLabel label_5 = new JLabel("Adr\u00E9sse  :");
		label_5.setForeground(new Color(0, 0, 51));
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(109, 308, 73, 17);
		panel.add(label_5);

		adresseMembre = new JTextField();
		adresseMembre.setColumns(10);
		adresseMembre.setBorder(new LineBorder(new Color(0, 0, 51)));
		adresseMembre.setBounds(238, 308, 164, 20);
		panel.add(adresseMembre);
		btnEnvoyer.addMouseListener(new ListenerMessage(this));

		btnEnvoyer.setForeground(Color.WHITE);
		btnEnvoyer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEnvoyer.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		btnEnvoyer.setBackground(new Color(0, 0, 51));
		btnEnvoyer.setBounds(208, 352, 143, 23);
		panel.add(btnEnvoyer);

		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(FenetreMessage.class.getResource("/images/icons8_Person_96px.png")));
		label_6.setBounds(208, 24, 100, 77);
		panel.add(label_6);

	}

	public JDateChooser getDateEntreeMembre() {
		return dateEntreeMembre;
	}

	public JTextField getNomMembre() {
		return nomMembre;
	}

	public JTextField getPrenomMembre() {
		return prenomMembre;
	}

	public JDateChooser getDateNaissMembre() {
		return dateNaissMembre;
	}

	public JTextField getAdresseMembre() {
		return adresseMembre;
	}
}
