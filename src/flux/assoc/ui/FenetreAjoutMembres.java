package flux.assoc.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class FenetreAjoutMembres extends JPanel {
	private JPanel panelChamps = new JPanel();
	private JLabel labelNom = new JLabel("Nom :");
	private JTextField nom = new JTextField();
	private JLabel labelPrenom = new JLabel("Pr\u00E9nom :");
	private JTextField prenom = new JTextField();
	private JLabel lblNewLabel = new JLabel("Date Naissance :");
	private JTextField dateNaiss = new JTextField();
	private JLabel labelDateEntre = new JLabel("Date Entr\u00E9e :");
	private JTextField dateEntree = new JTextField();
	private JLabel lblAdresse = new JLabel("Adresse :");
	private JTextField adresse = new JTextField();
	private JButton btnAddMembre = new JButton("Ajouter");
	private JButton btnAnnuler = new JButton("Annuler");

	/**
	 * Create the panel.
	 */
	public FenetreAjoutMembres() {
		
		adresse.setBounds(227, 276, 139, 20);
		adresse.setColumns(10);
		adresse.setBorder(BorderFactory.createLineBorder(new Color(255, 99, 71), 1));

		dateEntree.setBounds(228, 237, 138, 20);
		dateEntree.setColumns(10);
		dateEntree.setBorder(BorderFactory.createLineBorder(new Color(255, 99, 71), 1));
		dateEntree.setText("        jj/mm/yy");

		dateNaiss.setFont(new Font("Tahoma", Font.PLAIN, 13));
		dateNaiss.setText("        jj/mm/yy");
		dateNaiss.setBorder(BorderFactory.createLineBorder(new Color(255, 99, 71), 1));

		dateNaiss.setBounds(228, 189, 139, 20);
		dateNaiss.setColumns(10);
		dateNaiss.setBorder(BorderFactory.createLineBorder(new Color(255, 99, 71), 1));

		prenom.setBounds(227, 146, 139, 20);
		prenom.setColumns(10);
		prenom.setBorder(BorderFactory.createLineBorder(new Color(255, 99, 71), 1));

		nom.setBounds(227, 103, 139, 20);
		nom.setColumns(10);
		nom.setBorder(BorderFactory.createLineBorder(new Color(255, 99, 71), 1));

		panelChamps.setBackground(new Color(255, 255, 255));
		panelChamps.setBorder(new LineBorder(new Color(255, 102, 51), 2, true));
		panelChamps.setBounds(106, 66, 422, 361);
		panelChamps.setVisible(true);

		panelChamps.setLayout(null);
		labelNom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelNom.setBounds(102, 104, 57, 14);

		panelChamps.add(labelNom);

		panelChamps.add(nom);
		labelPrenom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelPrenom.setBounds(102, 144, 68, 20);

		panelChamps.add(labelPrenom);
		panelChamps.add(prenom);

		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(102, 190, 125, 20);

		panelChamps.add(lblNewLabel);
		panelChamps.add(dateNaiss);

		labelDateEntre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelDateEntre.setBounds(102, 238, 101, 14);

		panelChamps.add(labelDateEntre);
		panelChamps.add(dateEntree);
		lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdresse.setBounds(102, 277, 78, 14);

		panelChamps.add(lblAdresse);

		panelChamps.add(adresse);
		btnAddMembre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAddMembre.setBackground(new Color(0, 25, 51));
		btnAddMembre.setForeground(new Color(255, 255, 255));
		btnAddMembre.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		btnAddMembre.setBounds(81, 325, 125, 25);

		panelChamps.add(btnAddMembre);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\king\\Desktop\\TPJAVA\\Projet Java\\images\\icons8_User_45px.png"));
		label.setBounds(196, 42, 50, 50);
		panelChamps.add(label);

		JLabel lblAjouterMembre = new JLabel("Ajouter Membre");
		lblAjouterMembre.setForeground(new Color(0, 0, 51));
		lblAjouterMembre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAjouterMembre.setBounds(144, 22, 180, 20);
		panelChamps.add(lblAjouterMembre);
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAnnuler.setForeground(new Color(255, 255, 255));
		btnAnnuler.setBackground(new Color(0, 25, 51));
		btnAnnuler.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		btnAnnuler.setBounds(245, 327, 121, 23);

		panelChamps.setVisible(true);
		this.setVisible(true);
		this.setBounds(106, 66, 422, 361);
		

	}

}
