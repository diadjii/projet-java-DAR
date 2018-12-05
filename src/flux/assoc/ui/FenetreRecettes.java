package flux.assoc.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import flux.assoc.listener.ListenerRecettes;
import flux.assoc.metier.Membres;
import flux.assoc.metier.ModelTableau;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class FenetreRecettes extends FenetrePrincipale {
	private Object[][] listeMembres;
	private String title[] = { "Identifiant", "Nom", "Prénom" };
	private JTextField nomMembre;
	private JTextField montant;
	private JDateChooser dateVersement;
	private JComboBox categorie = new JComboBox();
	private JTextField indentifiantMembre;
	private JTable table;
	private JLabel lblCategorie = new JLabel("Categorie :");
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private JTextField libelle;
	private JLabel lblLibell = new JLabel("Libell\u00E9  :");
	private JTextField montantDepense;
	private JTextField motif;
	private JDateChooser dateDepense;
	private JTextField numeroCheque;
	private JTextField nomBeneficiaire;
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	private JLabel lblConcern = new JLabel("Concern\u00E9 :");
	public JLabel lblListeDesMembres;
	public JButton btnEnregistrer = new JButton("Enregistrer");
	public JRadioButton btnMembre = new JRadioButton("Membre");
	public JRadioButton rdbtnSecondaire = new JRadioButton("Secondaire");
	public JRadioButton rdbtnRecettePrincipale = new JRadioButton("Principale");
	public JScrollPane scrollPane2;
	public JRadioButton btnTiers = new JRadioButton("Tiers");
	public JPanel panelAddRecette = new JPanel();
	public JButton btnEnregistrerDepenses = new JButton("Enregistrer D\u00E9penses");
	public JPanel panelAddDepenses = new JPanel();
	public JButton btnEnregistrerRecette = new JButton("Enregistrer Recette ");
	public JScrollPane scrollPane;
	public JRadioButton rdbtnParChque = new JRadioButton("Par Ch\u00E9que");
	public JRadioButton rdbtnEspeces = new JRadioButton("Par Esp\u00E9ce");
	public JButton btnAddDepense = new JButton("Enregistrer");
	public JLabel lblNchque = new JLabel("N\u00B0 Ch\u00E9que : ");
	public JLabel lblNomBnficiaire = new JLabel("Nom B\u00E9n\u00E9ficiaire :");
	public JLabel lblMembre = new JLabel("Membre :");

	public FenetreRecettes(int role) throws SQLException {
		iconHome.setVisible(true);
		lblAcceuil.setVisible(true);
		setUserRole(role);
		listeMembres = Membres.listeMembres("liste");
		scrollPane2 = new JScrollPane(listes(listeMembres));
		scrollPane2.setViewportBorder(new LineBorder(new Color(255, 102, 51), 1, true));
		scrollPane2.setForeground(new Color(0, 0, 51));
		scrollPane2.setBackground(new Color(255, 255, 255));
		scrollPane2.setBounds(99, 387, 555, 136);
		panelAddRecette.add(scrollPane2);

		panelAddRecette.setBackground(new Color(255, 255, 255));
		panelAddRecette.setBounds(235, 74, 707, 523);
		getContentPane().add(panelAddRecette);
		panelAddRecette.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 51), 2, true));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(82, 36, 572, 325);
		panelAddRecette.add(panel);
		panel.setLayout(null);

		JLabel lblAjouterUneNouvelle = new JLabel("Ajouter une Nouvelle Recette ");
		lblAjouterUneNouvelle.setForeground(new Color(0, 0, 51));
		lblAjouterUneNouvelle.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAjouterUneNouvelle.setBounds(191, 11, 270, 20);
		panel.add(lblAjouterUneNouvelle);

		lblMembre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMembre.setForeground(new Color(0, 0, 51));
		lblMembre.setBounds(291, 126, 72, 14);
		panel.add(lblMembre);

		nomMembre = new JTextField();
		nomMembre.setColumns(10);
		nomMembre.setBorder(new LineBorder(new Color(0, 0, 51)));
		nomMembre.setBounds(409, 123, 130, 20);
		panel.add(nomMembre);

		JLabel lblMontant = new JLabel("Montant :");
		lblMontant.setForeground(new Color(0, 0, 51));
		lblMontant.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMontant.setBounds(33, 168, 72, 14);
		panel.add(lblMontant);

		montant = new JTextField();
		montant.setColumns(10);
		montant.setBorder(new LineBorder(new Color(0, 0, 51)));
		montant.setBounds(115, 165, 130, 20);
		panel.add(montant);

		JLabel lblDateVersement = new JLabel("Date  Versement :");
		lblDateVersement.setForeground(new Color(0, 0, 51));
		lblDateVersement.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDateVersement.setBounds(291, 168, 108, 14);
		panel.add(lblDateVersement);

		dateVersement = new JDateChooser();
		dateVersement.setBorder(new LineBorder(new Color(0, 0, 51)));
		dateVersement.setBounds(409, 165, 130, 20);
		panel.add(dateVersement);

		JLabel labelNote = new JLabel(
				"Note : Si un membre n'est pas dans la liste.Envoyer un message \u00E0 l'Adminitrateur  pour qu'il l'ajoute.");
		labelNote.setForeground(new Color(0, 102, 255));
		labelNote.setFont(new Font("Tahoma", Font.PLAIN, 9));
		labelNote.setBounds(76, 42, 430, 36);
		panel.add(labelNote);

		btnEnregistrer.addMouseListener(new ListenerRecettes(this));
		btnEnregistrer.setBackground(new Color(0, 25, 51));
		btnEnregistrer.setForeground(new Color(255, 255, 255));
		btnEnregistrer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEnregistrer.setBounds(158, 291, 118, 23);
		panel.add(btnEnregistrer);

		JLabel lblIdentifiant = new JLabel("Identit\u00E9 :");
		lblIdentifiant.setForeground(new Color(0, 0, 51));
		lblIdentifiant.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdentifiant.setBounds(33, 126, 72, 14);
		panel.add(lblIdentifiant);

		indentifiantMembre = new JTextField();
		indentifiantMembre.setForeground(new Color(0, 0, 51));
		indentifiantMembre.setColumns(10);
		indentifiantMembre.setBorder(new LineBorder(new Color(0, 0, 51)));
		indentifiantMembre.setBounds(117, 123, 130, 20);
		panel.add(indentifiantMembre);

		lblCategorie.setForeground(new Color(0, 0, 51));
		lblCategorie.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCategorie.setBounds(33, 208, 85, 14);
		panel.add(lblCategorie);

		categorie.setModel(new DefaultComboBoxModel(
				new String[] { "Recette Mensuelle", "Recette Annuelle", "Recette Spontan\u00E9e" }));
		categorie.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		categorie.setBounds(115, 205, 130, 20);
		panel.add(categorie);

		btnMembre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scrollPane2.setVisible(true);
				lblListeDesMembres.setVisible(true);
				lblMembre.setEnabled(true);
				getNomMembre().setEnabled(true);

			}
		});
		btnMembre.setBorder(new LineBorder(new Color(255, 102, 51)));
		btnMembre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMembre.setForeground(new Color(0, 0, 51));
		btnMembre.setVisible(false);
		btnMembre.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMembre.setBackground(new Color(255, 255, 255));
		buttonGroup.add(btnMembre);
		btnMembre.setBounds(191, 244, 85, 23);
		panel.add(btnMembre);

		btnTiers.setContentAreaFilled(false);
		btnTiers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scrollPane2.setVisible(false);
				lblListeDesMembres.setVisible(false);
				lblMembre.setEnabled(false);
				getNomMembre().setEnabled(false);
			}
		});
		btnTiers.setBorder(new LineBorder(new Color(255, 102, 51)));
		btnTiers.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTiers.setSelected(true);
		btnTiers.setVisible(false);
		btnTiers.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTiers.setForeground(new Color(0, 0, 51));
		btnTiers.setBackground(new Color(255, 255, 255));
		buttonGroup.add(btnTiers);
		btnTiers.setBounds(113, 244, 72, 23);
		panel.add(btnTiers);

		getLblConcern().setFont(new Font("Tahoma", Font.BOLD, 12));
		getLblConcern().setVisible(false);
		getLblConcern().setForeground(new Color(0, 0, 51));
		getLblConcern().setBounds(33, 247, 79, 14);
		panel.add(getLblConcern());

		JLabel lblTypeDeRecette = new JLabel("Type de Recette :");
		lblTypeDeRecette.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTypeDeRecette.setForeground(new Color(0, 0, 51));
		lblTypeDeRecette.setBounds(33, 89, 108, 14);
		panel.add(lblTypeDeRecette);

		rdbtnRecettePrincipale.addMouseListener(new ListenerRecettes(this));
		rdbtnRecettePrincipale.setSelected(true);
		buttonGroup_1.add(rdbtnRecettePrincipale);
		rdbtnRecettePrincipale.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnRecettePrincipale.setBackground(new Color(255, 255, 255));
		rdbtnRecettePrincipale.setForeground(new Color(0, 0, 51));
		rdbtnRecettePrincipale.setBounds(158, 85, 93, 23);
		panel.add(rdbtnRecettePrincipale);

		rdbtnSecondaire.addMouseListener(new ListenerRecettes(this));
		buttonGroup_1.add(rdbtnSecondaire);
		rdbtnSecondaire.setForeground(new Color(0, 0, 51));
		rdbtnSecondaire.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnSecondaire.setBackground(Color.WHITE);
		rdbtnSecondaire.setBounds(270, 85, 93, 23);
		panel.add(rdbtnSecondaire);

		getLblLibell().setFont(new Font("Tahoma", Font.BOLD, 11));
		getLblLibell().setVisible(false);
		getLblLibell().setForeground(new Color(0, 0, 51));
		getLblLibell().setBounds(291, 208, 46, 14);
		panel.add(getLblLibell());

		libelle = new JTextField();
		libelle.setForeground(new Color(0, 0, 51));
		libelle.setVisible(false);
		libelle.setColumns(10);
		libelle.setBorder(new LineBorder(new Color(0, 0, 51)));
		libelle.setBounds(409, 205, 130, 20);
		panel.add(libelle);

		JButton btnEnvoyerMessage = new JButton("Envoyer Message");
		btnEnvoyerMessage.setIcon(new ImageIcon(FenetreRecettes.class.getResource("/images/icons8_Paper_Plane_30px_1.png")));

		if (userRole == 1) {
			btnEnvoyerMessage.setVisible(false);
		}
		btnEnvoyerMessage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				try {
					new FenetreMessage().setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnEnvoyerMessage.setForeground(Color.WHITE);
		btnEnvoyerMessage.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEnvoyerMessage.setBackground(new Color(0, 25, 51));
		btnEnvoyerMessage.setBounds(327, 293, 212, 23);
		panel.add(btnEnvoyerMessage);

		lblListeDesMembres = new JLabel("Liste des Membres ");
		lblListeDesMembres.setForeground(new Color(0, 0, 51));
		lblListeDesMembres.setVisible(false);
		lblListeDesMembres.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblListeDesMembres.setBounds(300, 361, 140, 25);
		panelAddRecette.add(lblListeDesMembres);

		panelAddDepenses.setBackground(new Color(255, 255, 255));
		panelAddDepenses.setVisible(false);
		panelAddDepenses.setBounds(245, 75, 707, 526);
		getContentPane().add(panelAddDepenses);
		panelAddDepenses.setLayout(null);

		JPanel panelChamps = new JPanel();
		panelChamps.setBorder(new LineBorder(new Color(255, 102, 51), 2, true));
		panelChamps.setBackground(new Color(255, 255, 255));
		panelChamps.setBounds(120, 104, 531, 392);
		panelAddDepenses.add(panelChamps);
		panelChamps.setLayout(null);

		JLabel labelMotif = new JLabel("Motif :");
		labelMotif.setForeground(new Color(255, 102, 51));
		labelMotif.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelMotif.setBounds(53, 158, 46, 14);
		panelChamps.add(labelMotif);

		motif = new JTextField();
		motif.setBorder(new LineBorder(new Color(255, 102, 51), 1, true));
		motif.setFont(new Font("Tahoma", Font.PLAIN, 12));
		motif.setBounds(174, 155, 176, 22);
		panelChamps.add(motif);
		motif.setColumns(10);

		montantDepense = new JTextField();
		montantDepense.setFont(new Font("Tahoma", Font.PLAIN, 12));
		montantDepense.setColumns(10);
		montantDepense.setBorder(new LineBorder(new Color(255, 102, 51), 1, true));
		montantDepense.setBounds(174, 192, 176, 21);
		panelChamps.add(montantDepense);

		JLabel lblMontant_1 = new JLabel("Montant :");
		lblMontant_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMontant_1.setForeground(new Color(255, 102, 51));
		lblMontant_1.setBounds(53, 199, 79, 14);
		panelChamps.add(lblMontant_1);

		dateDepense = new JDateChooser();
		dateDepense.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dateDepense.setBorder(new LineBorder(new Color(255, 102, 51), 1, true));
		dateDepense.setBounds(174, 229, 176, 21);
		panelChamps.add(dateDepense);

		JLabel lblDateDpense = new JLabel("Date D\u00E9pense :");
		lblDateDpense.setForeground(new Color(255, 102, 51));
		lblDateDpense.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDateDpense.setBounds(53, 232, 112, 14);
		panelChamps.add(lblDateDpense);

		rdbtnEspeces.addMouseListener(new ListenerRecettes(this));
		rdbtnEspeces.setSelected(true);
		buttonGroup_3.add(rdbtnEspeces);
		rdbtnEspeces.setBounds(118, 78, 109, 23);

		panelChamps.add(rdbtnEspeces);

		buttonGroup_3.add(rdbtnParChque);
		rdbtnParChque.addMouseListener(new ListenerRecettes(this));
		rdbtnParChque.setBounds(274, 78, 109, 23);
		panelChamps.add(rdbtnParChque);

		lblNchque.setForeground(new Color(255, 102, 51));
		lblNchque.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNchque.setBounds(53, 277, 85, 14);
		panelChamps.add(lblNchque);

		numeroCheque = new JTextField();
		numeroCheque.setFont(new Font("Tahoma", Font.PLAIN, 12));
		numeroCheque.setColumns(10);
		numeroCheque.setBorder(new LineBorder(new Color(255, 102, 51), 1, true));
		numeroCheque.setBounds(174, 275, 176, 21);
		panelChamps.add(numeroCheque);

		lblNomBnficiaire.setForeground(new Color(255, 102, 51));
		lblNomBnficiaire.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNomBnficiaire.setBounds(53, 307, 121, 22);
		panelChamps.add(lblNomBnficiaire);

		nomBeneficiaire = new JTextField();
		nomBeneficiaire.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nomBeneficiaire.setColumns(10);
		nomBeneficiaire.setBorder(new LineBorder(new Color(255, 102, 51), 1, true));
		nomBeneficiaire.setBounds(174, 309, 176, 21);
		panelChamps.add(nomBeneficiaire);
		btnAddDepense.addMouseListener(new ListenerRecettes(this));
		btnAddDepense.setBounds(222, 355, 102, 23);
		panelChamps.add(btnAddDepense);

		JLabel lblEnregistrerNouvellesDpenses = new JLabel("Enregistrer Nouvelles D\u00E9penses");
		lblEnregistrerNouvellesDpenses.setBounds(114, 28, 313, 22);
		panelChamps.add(lblEnregistrerNouvellesDpenses);
		lblEnregistrerNouvellesDpenses.setForeground(new Color(0, 0, 51));
		lblEnregistrerNouvellesDpenses.setFont(new Font("Tahoma", Font.BOLD, 18));

		JPanel panelOptions = new JPanel();
		panelOptions.setBackground(new Color(0, 25, 51));
		panelOptions.setBounds(0, 74, 231, 569);
		getContentPane().add(panelOptions);
		panelOptions.setLayout(null);

		btnEnregistrerRecette.addMouseListener(new ListenerRecettes(this));
		btnEnregistrerRecette.setForeground(new Color(255, 255, 255));
		btnEnregistrerRecette.setBackground(new Color(0, 25, 51));
		btnEnregistrerRecette.setBounds(10, 196, 203, 23);
		panelOptions.add(btnEnregistrerRecette);

		btnEnregistrerDepenses.addMouseListener(new ListenerRecettes(this));
		btnEnregistrerDepenses.setForeground(Color.WHITE);
		btnEnregistrerDepenses.setBackground(new Color(0, 25, 51));
		btnEnregistrerDepenses.setBounds(10, 254, 203, 23);
		panelOptions.add(btnEnregistrerDepenses);

	}

	public JTextField getMotif() {
		return motif;
	}

	public JTextField getMontantDepense() {
		return montantDepense;
	}

	public Date getDateDepense() {
		return dateDepense.getDate();
	}

	public JTextField getNumeroCheque() {
		return numeroCheque;
	}

	public JTextField getNomBeneficiaire() {
		return nomBeneficiaire;
	}

	public JTextField getNomMembre() {
		return nomMembre;
	}

	public Date getDateVersement() {
		return dateVersement.getDate();
	}

	public JTextField getMontant() {
		return montant;
	}

	public JComboBox getCategorie() {
		return categorie;
	}

	public JTextField getIndentifiantMembre() {
		return indentifiantMembre;
	}

	public JTable getTable() {
		return table;
	}

	public JButton getBtnEnregistrer() {
		return btnEnregistrer;
	}

	public JLabel getLblConcern() {
		return lblConcern;
	}

	public void setLblConcern(JLabel lblConcern) {
		this.lblConcern = lblConcern;
	}

	public JLabel getLblLibell() {
		return lblLibell;
	}

	public void setLblLibell(JLabel lblLibell) {
		this.lblLibell = lblLibell;
	}

	public JTextField getLibelle() {
		return libelle;
	}

	public void setLibelle(JTextField libelle) {
		this.libelle = libelle;
	}

	public JTable listes(Object[][] liste) {
		JTable table1 = new JTable(liste, title);
		table1.setRowHeight(20);
		ModelTableau zModel = new ModelTableau(liste, title);
		table = new JTable(zModel);
		table.addMouseListener(new ListenerRecettes(this));
		table.setForeground(new Color(0, 0, 51));
		table.setGridColor(new Color(255, 102, 51));
		return table;
	}
}
