package flux.assoc.ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;

import flux.assoc.listener.ListenerUtilisateurs;
import flux.assoc.metier.ModelTableau;
import flux.assoc.metier.Utilisateurs;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import java.awt.Cursor;
import javax.swing.DefaultComboBoxModel;

public class FenetreUtilisateurs extends FenetrePrincipale {
	private JTextField login;
	private JTextField password;
	private JButton btnAddUser = new JButton("Ajouter");
	private JButton btnAjouterUtilisateur = new JButton("Ajouter Utilisateur");
	private JButton btnDeleteUser = new JButton("Supprimer Utilisateur(s)");
	private JButton btnSupprimer = new JButton("Supprimer");
	private JButton btnChangeRole = new JButton("Modifer R\u00F4le Utilisateur(s)");
	private JButton btnModifier = new JButton("Modifier");

	public JPanel panelAddUser = new JPanel();
	public JPanel panelDeleteUser = new JPanel();
	public JPanel panelEditUser = new JPanel();
	private Object[][] liste = null;

	@SuppressWarnings("rawtypes")
	private JComboBox typeUser = new JComboBox();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FenetreUtilisateurs() throws SQLException {
		iconHome.setVisible(true);
		lblAcceuil.setVisible(true);
		setUserRole(1);
		
				panelAddUser.setBackground(new Color(255, 255, 255));
				panelAddUser.setBounds(213, 74, 729, 507);
				panelAddUser.setLayout(null);
				getContentPane().add(panelAddUser);
				
						JPanel panelChamps = new JPanel();
						panelChamps.setBorder(new LineBorder(new Color(0, 0, 51), 2, true));
						panelChamps.setForeground(new Color(0, 0, 51));
						panelChamps.setBackground(new Color(255, 255, 255));
						panelChamps.setBounds(195, 92, 413, 365);
						panelAddUser.add(panelChamps);
						panelChamps.setLayout(null);
						
								JLabel lblAjoutUtilisateur = new JLabel("Ajout Utilisateur");
								lblAjoutUtilisateur.setForeground(new Color(0, 0, 51));
								lblAjoutUtilisateur.setFont(new Font("Tahoma", Font.BOLD, 17));
								lblAjoutUtilisateur.setBounds(133, 59, 149, 21);
								panelChamps.add(lblAjoutUtilisateur);
								
										JLabel lblLogin = new JLabel("New Login :");
										lblLogin.setForeground(new Color(0, 0, 51));
										lblLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
										lblLogin.setBounds(41, 148, 76, 21);
										panelChamps.add(lblLogin);
										
												login = new JTextField();
												login.setForeground(new Color(0, 0, 51));
												login.setBounds(157, 146, 172, 26);
												login.setBorder(new LineBorder(new Color(0, 0, 51)));
												panelChamps.add(login);
												login.setColumns(10);
												
														JLabel lblPassword = new JLabel("New Password :");
														lblPassword.setForeground(new Color(0, 0, 51));
														lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
														lblPassword.setBounds(41, 213, 106, 21);
														panelChamps.add(lblPassword);
														
																password = new JTextField();
																password.setColumns(10);
																password.setBorder(new LineBorder(new Color(0, 0, 51)));
																password.setBounds(157, 211, 172, 26);
																panelChamps.add(password);
																
																		JLabel lblType = new JLabel("Type :");
																		lblType.setForeground(new Color(0, 0, 51));
																		lblType.setFont(new Font("Tahoma", Font.BOLD, 13));
																		lblType.setBounds(41, 263, 46, 21);
																		panelChamps.add(lblType);
																		
																				typeUser.setModel(new DefaultComboBoxModel(new String[] { "Financier", "Administrateur" }));
																				typeUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																				typeUser.setFont(new Font("Tahoma", Font.BOLD, 12));
																				typeUser.setForeground(new Color(0, 0, 51));
																				
																				typeUser.setBackground(new Color(255, 255, 255));
																				typeUser.setBounds(157, 264, 172, 20);
																				panelChamps.add(typeUser);
																				btnAddUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
																				
																						btnAddUser.addMouseListener(new ListenerUtilisateurs(this));
																						btnAddUser.setBackground(new Color(0, 0, 51));
																						btnAddUser.setFont(new Font("Tahoma", Font.BOLD, 14));
																						btnAddUser.setForeground(new Color(255, 255, 255));
																						btnAddUser.setBounds(157, 318, 89, 23);
																						panelChamps.add(btnAddUser);
		JPanel panelOptions = new JPanel();
		panelOptions.setBackground(new Color(0, 25, 51));
		panelOptions.setForeground(new Color(0, 25, 51));
		panelOptions.setBounds(0, 74, 212, 569);
		getContentPane().add(panelOptions);
		panelOptions.setLayout(null);

		btnAjouterUtilisateur.addMouseListener(new ListenerUtilisateurs(this));
		btnAjouterUtilisateur.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAjouterUtilisateur.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAjouterUtilisateur.setForeground(new Color(255, 255, 255));
		btnAjouterUtilisateur.setBackground(new Color(0, 25, 51));
		btnAjouterUtilisateur.setBounds(16, 188, 186, 23);
		panelOptions.add(btnAjouterUtilisateur);

		btnDeleteUser.addMouseListener(new ListenerUtilisateurs(this));
		btnDeleteUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDeleteUser.setBackground(new Color(0, 25, 51));
		btnDeleteUser.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDeleteUser.setForeground(new Color(255, 255, 255));
		btnDeleteUser.setBounds(16, 228, 186, 23);
		panelOptions.add(btnDeleteUser);

		btnChangeRole.addMouseListener(new ListenerUtilisateurs(this));
		btnChangeRole.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnChangeRole.setBackground(new Color(0, 25, 51));
		btnChangeRole.setForeground(new Color(255, 255, 255));
		btnChangeRole.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnChangeRole.setBounds(16, 269, 186, 23);
		panelOptions.add(btnChangeRole);

		panelDeleteUser.setBackground(new Color(255, 255, 255));
		panelDeleteUser.setBounds(213, 73, 729, 508);
		panelDeleteUser.setVisible(false);
		panelDeleteUser.setLayout(null);

		panelEditUser.setLayout(null);
		panelEditUser.setVisible(false);
		panelEditUser.setForeground(new Color(0, 0, 51));
		panelEditUser.setBackground(new Color(255, 255, 255));
		panelEditUser.setBounds(213, 74, 729, 507);

		liste = Utilisateurs.listeUtilisateurs();
		JScrollPane scrollPane2 = new JScrollPane(listeUtilisateurs(liste, "Modifier(Admin/Financier)"));
		scrollPane2.setBorder(new LineBorder(new Color(0, 0, 51)));
		scrollPane2.setViewportBorder(new LineBorder(new Color(255, 102, 51), 1, true));
		scrollPane2.setForeground(new Color(0, 0, 51));
		scrollPane2.setBackground(new Color(255, 255, 255));
		scrollPane2.setBounds(32, 76, 682, 357);
		panelEditUser.add(scrollPane2);
		getContentPane().add(panelEditUser);

		JScrollPane scrollPane = new JScrollPane(listeUtilisateurs(liste, "Supprimer"));

		JLabel lblModifierRle = new JLabel("Modifier R\u00F4le");
		lblModifierRle.setForeground(new Color(0, 0, 51));
		lblModifierRle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblModifierRle.setBounds(327, 32, 155, 25);
		panelEditUser.add(lblModifierRle);

		btnModifier.addMouseListener(new ListenerUtilisateurs(this));
		btnModifier.setBackground(new Color(0, 25, 51));
		btnModifier.setForeground(new Color(255, 255, 255));
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnModifier.setBounds(327, 444, 89, 23);
		panelEditUser.add(btnModifier);
		scrollPane.setBorder(null);
		scrollPane.setViewportBorder(new LineBorder(new Color(255, 102, 51), 1, true));
		scrollPane.setForeground(new Color(0, 0, 51));
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(32, 76, 682, 357);
		panelDeleteUser.add(scrollPane);
		getContentPane().add(panelDeleteUser);

		JLabel lblSupprimerUtilisateurs = new JLabel("Supprimer Utilisateur(s)");
		lblSupprimerUtilisateurs.setForeground(new Color(0, 0, 51));
		lblSupprimerUtilisateurs.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSupprimerUtilisateurs.setBounds(272, 40, 261, 25);
		panelDeleteUser.add(lblSupprimerUtilisateurs);

		btnSupprimer.addMouseListener(new ListenerUtilisateurs(this));
		btnSupprimer.setBackground(new Color(0, 25, 51));
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSupprimer.setForeground(new Color(255, 255, 255));
		btnSupprimer.setBounds(318, 444, 114, 23);
		panelDeleteUser.add(btnSupprimer);

	}

	public JButton getBtnModifier() {
		return btnModifier;
	}

	public JButton getBtnChangeRole() {
		return btnChangeRole;
	}

	public Object[][] getListe() {
		return liste;
	}

	public JButton getBtnAddUser() {
		return btnAddUser;
	}

	public JTextField getLogin() {
		return login;
	}

	public JTextField getPassword() {
		return password;
	}

	public JComboBox getTypeUser() {
		return typeUser;
	}

	public JButton getBtnAjouterUtilisateur() {
		return btnAjouterUtilisateur;
	}

	public JButton getBtnDeleteUser() {
		return btnDeleteUser;
	}

	public JButton getBtnSupprimer() {
		return btnSupprimer;
	}

	private JTable listeUtilisateurs(Object[][] liste, String mot) {
		String title[] = { "Identifiant", "Login", "Role", mot };
		JTable table1 = new JTable(liste, title);
		table1.setRowHeight(20);
		ModelTableau zModel = new ModelTableau(liste, title);
		JTable table = new JTable(zModel);
		table.setSelectionForeground(new Color(255, 255, 255));
		table.setSelectionBackground(new Color(255, 102, 51));
		table.setForeground(new Color(0, 0, 51));
		table.setGridColor(new Color(255, 102, 51));

		return table;
	}
}
