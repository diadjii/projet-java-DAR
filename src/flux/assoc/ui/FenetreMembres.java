package flux.assoc.ui;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import flux.assoc.listener.ListenerMembre;
import flux.assoc.metier.Membres;
import flux.assoc.metier.ModelTableau;
import java.awt.Cursor;

public class FenetreMembres extends FenetrePrincipale {

	private JLabel reactiverMembre = new JLabel("R\u00E9activer Membre");
	public JPanel panelAjouter = new JPanel();
	public JPanel panelReactiver = new JPanel();
	public JPanel panelAjoutMembre = new JPanel();
	private JPanel panelChamps = new JPanel();
	private JLabel labelAjoutMembre = new JLabel("Ajouter un Membre");
	private JLabel lblNewLabel = new JLabel("Nom  :");
	private JTextField nom;
	private JLabel lblPrnom = new JLabel("Pr\u00E9nom  :");
	private JTextField prenom = new JTextField();
	private JLabel lblNewLabel_2 = new JLabel("Date de Naissance :");
	private JDateChooser dateNaiss = new JDateChooser();
	private JLabel lblDateDEntre = new JLabel("Date d' Entr\u00E9e :");
	private JDateChooser dateEntree = new JDateChooser();

	private JLabel lblAdrsse = new JLabel("Adr\u00E9sse  :");
	private JTextField adresse = new JTextField();
	private JButton btnAnnuler = new JButton("Annuler");
	private JLabel label = new JLabel("");
	public JButton btnAjouter = new JButton("Ajouter");
	private JPanel options = new JPanel();
	private Object[][] listeMembresDesactiver;
	private Object[][] listeMembresReactiver;
	public JPanel panelDesactiver = new JPanel();
	private JLabel titreDesactiverMembre = new JLabel("D\u00E9sactiver Membre(s)");
	private JLabel titreReactiverMembre = new JLabel("R\u00E9activer Membre(s)");
	private JButton btnReactiver = new JButton("R\u00E9activer");
	private JButton btnDesactiver = new JButton("D\u00E9sactiver");
	public JButton btnAddMembre = new JButton("Ajouter Membre");
	String title[] = { "Identifiant", "Nom", "Prénom", "Etat", "Activer/Désactiver" };
	public JButton btnDsactiverMembre = new JButton("D\u00E9sactiver Membre");
	private final JLabel lblTableauDeBord = new JLabel("Tableau de Bord");

	public FenetreMembres() throws SQLException {
		iconHome.setVisible(true);
		lblAcceuil.setVisible(true);
		setUserRole(1);
		options.setBackground(new Color(0, 25, 51));
		options.setBounds(0, 73, 207, 610);
		options.setVisible(true);

		panelAjoutMembre.setBackground(new Color(255, 255, 255));
		panelAjoutMembre.setBounds(217, 73, 725, 508);
		panelAjoutMembre.setLayout(null);
		panelAjoutMembre.setVisible(true);
		getContentPane().add(panelAjoutMembre);
		label.setIcon(new ImageIcon(FenetreMembres.class.getResource("/images/icons8_Person_96px.png")));
		label.setBounds(274, 28, 89, 77);

		prenom.setBounds(238, 181, 164, 20);
		prenom.setColumns(10);
		prenom.setBorder(new LineBorder(new Color(0, 0, 51)));
		panelChamps.setBounds(127, 86, 508, 400);
		panelAjoutMembre.add(panelChamps);

		panelChamps.setBorder(new LineBorder(new Color(0, 0, 51)));
		panelChamps.setBackground(new Color(255, 255, 255));
		panelChamps.setLayout(null);

		lblNewLabel.setForeground(new Color(0, 0, 51));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(109, 135, 46, 17);

		panelChamps.add(lblNewLabel);

		nom = new JTextField();
		nom.setSelectionColor(new Color(0, 0, 51));
		nom.setBorder(new LineBorder(new Color(0, 0, 51)));
		nom.setBounds(238, 135, 164, 20);
		nom.setColumns(10);
		panelChamps.add(nom);

		lblPrnom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrnom.setForeground(new Color(0, 0, 51));
		lblPrnom.setBounds(109, 176, 73, 26);
		panelChamps.add(lblPrnom);

		panelChamps.add(prenom);
		lblNewLabel_2.setForeground(new Color(0, 0, 51));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(109, 221, 129, 17);

		panelChamps.add(lblNewLabel_2);
		dateNaiss.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateNaiss.setBorder(new LineBorder(new Color(0, 0, 51)));
		dateNaiss.setBounds(238, 221, 164, 20);

		panelChamps.add(dateNaiss);
		lblDateDEntre.setForeground(new Color(0, 0, 51));
		lblDateDEntre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDateDEntre.setBounds(109, 267, 129, 17);

		panelChamps.add(lblDateDEntre);
		dateEntree.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateEntree.setDateFormatString("yyyy MMM d");
		dateEntree.setBorder(new LineBorder(new Color(0, 0, 51)));
		dateEntree.setBounds(238, 267, 164, 20);

		panelChamps.add(dateEntree);
		lblAdrsse.setForeground(new Color(0, 0, 51));
		lblAdrsse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAdrsse.setBounds(109, 308, 73, 17);

		panelChamps.add(lblAdrsse);
		adresse.setColumns(10);
		adresse.setBorder(new LineBorder(new Color(0, 0, 51)));
		adresse.setBounds(238, 308, 164, 20);

		panelChamps.add(adresse);

		btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAjouter.setBackground(new Color(0, 0, 51));
		btnAjouter.setForeground(new Color(255, 255, 255));
		btnAjouter.setBounds(124, 351, 89, 23);
		btnAjouter.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		btnAjouter.addMouseListener(new ListenerMembre(this));
		panelChamps.add(btnAjouter);

		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAnnuler.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		btnAnnuler.setBackground(new Color(0, 0, 51));
		btnAnnuler.setBounds(255, 351, 89, 23);
		panelChamps.add(btnAnnuler);
		panelChamps.add(label);
				labelAjoutMembre.setBounds(242, 36, 237, 26);
				panelAjoutMembre.add(labelAjoutMembre);
		
				labelAjoutMembre.setFont(new Font("Tahoma", Font.BOLD, 20));
				labelAjoutMembre.setForeground(new Color(0, 0, 51));
		options.setLayout(null);
		getContentPane().add(options);
		reactiverMembre.setBorder(new LineBorder(new Color(255, 255, 255)));

		reactiverMembre.addMouseListener(new ListenerMembre(this));
		reactiverMembre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		reactiverMembre.setForeground(new Color(255, 255, 255));
		reactiverMembre.setBounds(20, 300, 161, 21);
		options.add(reactiverMembre);
		btnAddMembre.setForeground(new Color(255, 255, 255));
		btnAddMembre.setBackground(new Color(0, 25, 51));

		btnAddMembre.addMouseListener(new ListenerMembre(this));
		btnAddMembre.setBounds(20, 219, 161, 23);
		options.add(btnAddMembre);
		btnDsactiverMembre.setForeground(new Color(255, 255, 255));
		btnDsactiverMembre.setBackground(new Color(0, 25, 51));
		btnDsactiverMembre.addMouseListener(new ListenerMembre(this));
		btnDsactiverMembre.setBounds(20, 265, 161, 23);

		options.add(btnDsactiverMembre);
		lblTableauDeBord.setForeground(new Color(255, 255, 255));
		lblTableauDeBord.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTableauDeBord.setBounds(20, 116, 160, 21);
		
		options.add(lblTableauDeBord);
		/**
		 * fin panel Options
		 */

		panelReactiver.setBackground(new Color(255, 255, 255));
		panelReactiver.setBounds(211, 73, 731, 508);
		panelReactiver.setVisible(false);
		getContentPane().add(panelReactiver);

		panelReactiver.setLayout(null);
		titreReactiverMembre.setForeground(new Color(0, 0, 51));
		titreReactiverMembre.setFont(new Font("Tahoma", Font.BOLD, 17));
		titreReactiverMembre.setBounds(274, 37, 179, 21);

		listeMembresReactiver = Membres.listeMembres("Réactiver");
		JScrollPane scrollPane2 = new JScrollPane(listes(listeMembresReactiver));
		scrollPane2.setViewportBorder(new LineBorder(new Color(255, 102, 51), 1, true));
		scrollPane2.setForeground(new Color(0, 0, 51));
		scrollPane2.setBackground(new Color(255, 255, 255));
		scrollPane2.setBounds(37, 97, 667, 366);
		panelReactiver.add(scrollPane2);

		panelReactiver.add(titreReactiverMembre);
		btnReactiver.addMouseListener(new ListenerMembre(this));
		btnReactiver.setBackground(new Color(0, 0, 51));
		btnReactiver.setForeground(new Color(255, 255, 255));
		btnReactiver.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReactiver.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 1));
		btnReactiver.setBounds(313, 474, 89, 23);
		panelReactiver.add(btnReactiver);

		panelDesactiver.setBounds(211, 73, 731, 508);
		getContentPane().add(panelDesactiver);
		panelDesactiver.setBorder(new EmptyBorder(28, 0, 0, 0));
		panelDesactiver.setLayout(null);
		panelDesactiver.setVisible(false);

		listeMembresDesactiver = Membres.listeMembres("Désactiver");
		JScrollPane scrollPane = new JScrollPane(listes(listeMembresDesactiver));
		scrollPane.setViewportBorder(new LineBorder(new Color(255, 102, 51), 1, true));
		scrollPane.setForeground(new Color(0, 0, 51));
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(40, 96, 662, 366);
		panelDesactiver.add(scrollPane);

		panelDesactiver.setBackground(new Color(255, 255, 255));
		titreDesactiverMembre.setBounds(227, 39, 284, 32);
		titreDesactiverMembre.setVerticalAlignment(SwingConstants.TOP);
		titreDesactiverMembre.setHorizontalAlignment(SwingConstants.CENTER);
		titreDesactiverMembre.setForeground(new Color(0, 0, 51));
		titreDesactiverMembre.setFont(new Font("Tahoma", Font.BOLD, 17));

		panelDesactiver.add(titreDesactiverMembre);

		btnDesactiver.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDesactiver.setBackground(new Color(0, 0, 51));
		btnDesactiver.setForeground(new Color(255, 255, 255));
		btnDesactiver.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 1));
		btnDesactiver.addMouseListener(new ListenerMembre(this));
		btnDesactiver.setBounds(319, 473, 106, 24);
		panelDesactiver.add(btnDesactiver);

	}

	public JTextField getNom() {
		return nom;
	}

	public JTextField getPrenom() {
		return prenom;
	}

	public Date getDateNaiss() {
		return dateNaiss.getDate();
	}

	public JTextField getAdresse() {
		return adresse;
	}

	public Object[][] getListeMembresDesactiver() {
		return listeMembresDesactiver;
	}

	public JLabel getReactiverMembre() {
		return reactiverMembre;
	}

	public JButton getBtnReactiver() {
		return btnReactiver;
	}

	public JButton getBtnDesactiver() {
		return btnDesactiver;
	}

	public Date getDateEntree() {
		return dateEntree.getDate();
	}

	public Object[][] getListeMembresReactiver() {
		return listeMembresReactiver;
	}

	public JTable listes(Object[][] liste) {
		JTable table1 = new JTable(liste, title);
		table1.setRowHeight(20);
		ModelTableau zModel = new ModelTableau(liste, title);
		JTable table = new JTable(zModel);
		table.setForeground(new Color(0, 0, 51));
		table.setGridColor(new Color(255, 102, 51));

		return table;
	}
}
