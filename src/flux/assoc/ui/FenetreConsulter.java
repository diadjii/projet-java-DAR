package flux.assoc.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import flux.assoc.listener.ListenerConsulter;
import flux.assoc.metier.ModelTableau;
import flux.assoc.metier.Recettes;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.Cursor;

public class FenetreConsulter extends FenetrePrincipale {
	public JRadioButton rdbtnRecettesSecondaires = new JRadioButton("Recettes Secondaires");
	JTable table;
	public static JLabel montantSecondaire = new JLabel("");
	public static JLabel montantPrincipale = new JLabel("");
	String title[] = { "Identifiant", "Montant", "Date Versement" };
	private JTextField nomRechercher;
	public JButton consulter = new JButton("Consulter");
	public JPanel panelRecettesSecondaire = new JPanel();
	public JPanel panelRecettesPrincipale = new JPanel();
	public JPanel panelRecettesMembre = new JPanel();
	public JButton btnConsulterRecettesPrincipale = new JButton("Consulter Recettes Principales");
	public JButton btnConsulterRecettesSecondaire = new JButton("Consulter Recettes Secondaires");
	public JButton btnConsulterRecettesMembre = new JButton("Consulter Recettes d'un Membre");
	private Object[][] tableListe;
	public JLabel totalRecPrincipale = new JLabel("TOTAL :");
	public JScrollPane scrollPane_1;
	public JButton btnConsulterLesRecettes = new JButton("Consulter Toutes les Recettes ");
	public JScrollPane scrollPane;
	public JScrollPane scrollPane_2;
	public JPanel panelLesRecettes = new JPanel();
	public JDateChooser calendarDebut = new JDateChooser();
	public JDateChooser calendarFin = new JDateChooser();
	public JDateChooser calendarDebut1 = new JDateChooser();
	public JDateChooser calendarFin1 = new JDateChooser();
	public JDateChooser calendarDebut2 = new JDateChooser();
	public JDateChooser calendarFin2 = new JDateChooser();
	public JDateChooser calendarDebut3 = new JDateChooser();
	public JDateChooser calendarFin3 = new JDateChooser();
	public JDateChooser calendarDebut4 = new JDateChooser();
	public JDateChooser calendarFin4 = new JDateChooser();

	public JPanel panelDepenses = new JPanel();
	public JButton btnConsulter = new JButton("Consulter");
	public JButton btnConsulterRecettePrincipale = new JButton("Consulter");
	public JButton btnConsulterRecetteSecondaire = new JButton("Consulter");
	public JButton btnConsulterToutesLesDepenses = new JButton("Consulter Toutes les D\u00E9penses");
	public JScrollPane scrollPane_3;
	public JButton btnConsulterDepenses = new JButton("Consulter");
	public JScrollPane scrollPane_4 = new JScrollPane();
	private JTable listeRecettesMembres;
	public JScrollPane scrollPane_5;
	public static JLabel lblTotalRecettesMembre = new JLabel("TOTAL  :");
	public static JLabel sommeRecettesMembres = new JLabel("");
	public static JLabel titre = new JLabel("");
	private final JLabel lblDateDeDebut_1 = new JLabel("Date de debut");
	private final JLabel lblDateDeFin_1 = new JLabel("Date de Fin");
	public static JLabel lblTotalSecondaire = new JLabel("TOTAL :");
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public JRadioButton rdbtnCheque = new JRadioButton("Cheque");
	public JRadioButton rdbtnEspece = new JRadioButton("Espece");
	public static JLabel lblTotalDepenses = new JLabel("TOTAL  :");
	public static JLabel sommeDepenses = new JLabel("");
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	public JRadioButton rdbtnPrincipale = new JRadioButton("Principale");
	public JRadioButton rdbtnSecondaire = new JRadioButton("Secondaire");
	public final JLabel lblTotalDesDepenses = new JLabel("TOTAL  :");
	public final JLabel montantTotalDepenses = new JLabel("");
	private final JLabel lblDateDeDebut_2 = new JLabel("Date de Debut");
	private final JLabel lblDateDeFin_2 = new JLabel("Date  de Fin");
	private final JLabel lblDateDeDebut_3 = new JLabel("Date  de Debut");
	private final JLabel lblDateDeFin_3 = new JLabel("Date de Fin");

	public FenetreConsulter(int role) throws SQLException {
		iconHome.setVisible(true);
		lblAcceuil.setVisible(true);
		setUserRole(role);

		calendarDebut.setBounds(59, 89, 117, 23);
		panelLesRecettes.add(calendarDebut);
		panelLesRecettes.setVisible(false);

		panelDepenses.setBackground(new Color(255, 255, 255));
		panelDepenses.setBounds(267, 95, 681, 537);
		panelDepenses.setVisible(false);
		calendarDebut2.setBounds(67, 95, 106, 25);
		panelRecettesSecondaire.add(calendarDebut2);
		calendarFin2.setBounds(298, 84, 95, 25);

		panelRecettesSecondaire.add(calendarFin2);
		panelRecettesSecondaire.setBackground(new Color(255, 255, 255));
		panelRecettesSecondaire.setVisible(false);
		calendarDebut4.setBounds(120, 87, 104, 20);
		panelRecettesMembre.add(calendarDebut4);
		calendarFin4.setBounds(328, 87, 114, 20);
		panelRecettesMembre.add(calendarFin4);
		panelRecettesMembre.setBounds(267, 97, 675, 510);
		panelRecettesMembre.setVisible(false);
		panelRecettesMembre.setLayout(null);
		panelRecettesMembre.setBackground(Color.WHITE);
		getContentPane().add(panelRecettesMembre);

		nomRechercher = new JTextField();
		nomRechercher.setColumns(10);
		nomRechercher.setBorder(new LineBorder(new Color(255, 204, 51), 1, true));
		nomRechercher.setBounds(99, 126, 325, 28);
		panelRecettesMembre.add(nomRechercher);

		consulter.addMouseListener(new ListenerConsulter(this));
		consulter.setFont(new Font("Tahoma", Font.BOLD, 13));
		consulter.setForeground(new Color(0, 0, 51));
		consulter.setBackground(new Color(255, 204, 51));
		consulter.setBorder(new LineBorder(new Color(255, 102, 51), 0));
		consulter.setBounds(423, 125, 104, 28);
		panelRecettesMembre.add(consulter);

		JLabel lblConsulterLesRecettes_1 = new JLabel("Consulter Les recettes vers\u00E9es par un Membre");
		lblConsulterLesRecettes_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConsulterLesRecettes_1.setBounds(119, 11, 491, 28);
		panelRecettesMembre.add(lblConsulterLesRecettes_1);

		JLabel lblDateDeDebut = new JLabel("Date de Debut");
		lblDateDeDebut.setForeground(new Color(0, 0, 51));
		lblDateDeDebut.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDateDeDebut.setBounds(120, 50, 104, 26);
		panelRecettesMembre.add(lblDateDeDebut);

		JLabel lblNewLabel = new JLabel("Date de Fin");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(0, 0, 51));
		lblNewLabel.setBounds(330, 57, 112, 19);
		panelRecettesMembre.add(lblNewLabel);
		lblTotalRecettesMembre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotalRecettesMembre.setBounds(79, 457, 66, 20);
		lblTotalRecettesMembre.setVisible(false);
		sommeRecettesMembres.setVisible(false);
		panelRecettesMembre.add(lblTotalRecettesMembre);
		sommeRecettesMembres.setBounds(140, 457, 189, 20);

		panelRecettesMembre.add(sommeRecettesMembres);
		titre.setForeground(new Color(255, 102, 51));
		titre.setBackground(new Color(255, 255, 255));
		titre.setFont(new Font("Tahoma", Font.BOLD, 13));
		titre.setBounds(99, 191, 530, 28);

		panelRecettesMembre.add(titre);
		calendarDebut1.setBounds(62, 87, 106, 22);

		panelRecettesPrincipale.add(calendarDebut1);
		calendarFin1.setBounds(293, 88, 116, 22);
		panelRecettesPrincipale.add(calendarFin1);
		panelRecettesPrincipale.setBackground(new Color(255, 255, 255));
		panelRecettesPrincipale.setBounds(273, 95, 665, 513);
		panelRecettesPrincipale.setLayout(null);
		getContentPane().add(panelRecettesPrincipale);

		JLabel lblConsulterRecettes = new JLabel("Consulter Recettes Principales");
		lblConsulterRecettes.setFont(new Font("Dialog", Font.BOLD, 20));
		lblConsulterRecettes.setForeground(new Color(0, 0, 51));
		lblConsulterRecettes.setBounds(192, 28, 298, 19);
		panelRecettesPrincipale.add(lblConsulterRecettes);

		totalRecPrincipale.setFont(new Font("Tahoma", Font.BOLD, 14));
		totalRecPrincipale.setVisible(false);
		totalRecPrincipale.setBounds(65, 460, 56, 19);
		panelRecettesPrincipale.add(totalRecPrincipale);
		montantPrincipale.setFont(new Font("Tahoma", Font.BOLD, 12));

		montantPrincipale.setBounds(126, 460, 168, 19);
		panelRecettesPrincipale.add(montantPrincipale);
		btnConsulterRecettePrincipale.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnConsulterRecettePrincipale.addMouseListener(new ListenerConsulter(this));
		btnConsulterRecettePrincipale.setBounds(527, 87, 89, 23);
		panelRecettesPrincipale.add(btnConsulterRecettePrincipale);
		lblDateDeDebut_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDateDeDebut_3.setBounds(62, 65, 106, 14);

		panelRecettesPrincipale.add(lblDateDeDebut_3);
		lblDateDeFin_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDateDeFin_3.setBounds(292, 63, 117, 22);

		panelRecettesPrincipale.add(lblDateDeFin_3);
		panelRecettesSecondaire.setBounds(267, 95, 671, 513);
		getContentPane().add(panelRecettesSecondaire);
		panelRecettesSecondaire.setLayout(null);

		JLabel lblConsulterRecettesSecondaire = new JLabel("Consulter Recettes Secondaire");
		lblConsulterRecettesSecondaire.setForeground(new Color(0, 0, 51));
		lblConsulterRecettesSecondaire.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConsulterRecettesSecondaire.setBounds(169, 25, 319, 25);
		panelRecettesSecondaire.add(lblConsulterRecettesSecondaire);

		lblTotalSecondaire.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalSecondaire.setVisible(false);
		lblTotalSecondaire.setBounds(47, 456, 67, 17);
		panelRecettesSecondaire.add(lblTotalSecondaire);
		montantSecondaire.setFont(new Font("Tahoma", Font.BOLD, 12));

		montantSecondaire.setBounds(113, 456, 180, 17);
		panelRecettesSecondaire.add(montantSecondaire);
		btnConsulterRecetteSecondaire.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsulterRecetteSecondaire.addMouseListener(new ListenerConsulter(this));
		btnConsulterRecetteSecondaire.setBounds(496, 86, 89, 23);

		panelRecettesSecondaire.add(btnConsulterRecetteSecondaire);
		lblDateDeDebut_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDateDeDebut_2.setBounds(70, 61, 121, 23);

		panelRecettesSecondaire.add(lblDateDeDebut_2);
		lblDateDeFin_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDateDeFin_2.setBounds(298, 59, 121, 19);

		panelRecettesSecondaire.add(lblDateDeFin_2);
		panelDepenses.add(calendarDebut3);
		calendarDebut3.setBounds(100, 102, 105, 22);
		calendarFin3.setBounds(301, 102, 113, 22);
		panelDepenses.add(calendarFin3);
		getContentPane().add(panelDepenses);
		panelDepenses.setLayout(null);

		JLabel lblConsulterLesDpenses = new JLabel("Consulter Les D\u00E9penses");
		lblConsulterLesDpenses.setFont(new Font("Dialog", Font.BOLD, 20));
		lblConsulterLesDpenses.setForeground(new Color(0, 0, 51));
		lblConsulterLesDpenses.setBounds(232, 22, 268, 22);
		panelDepenses.add(lblConsulterLesDpenses);
		btnConsulterDepenses.setForeground(new Color(255, 255, 255));
		btnConsulterDepenses.setBackground(new Color(0, 0, 51));

		btnConsulterDepenses.addMouseListener(new ListenerConsulter(this));
		btnConsulterDepenses.setBounds(490, 102, 89, 23);
		panelDepenses.add(btnConsulterDepenses);
		lblDateDeDebut_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDateDeDebut_1.setBounds(100, 83, 105, 16);

		panelDepenses.add(lblDateDeDebut_1);
		lblDateDeFin_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDateDeFin_1.setBounds(301, 84, 113, 14);

		panelDepenses.add(lblDateDeFin_1);

		buttonGroup.add(rdbtnCheque);
		rdbtnCheque.setBackground(new Color(255, 255, 255));
		rdbtnCheque.setSelected(true);
		rdbtnCheque.setBounds(171, 152, 99, 23);
		panelDepenses.add(rdbtnCheque);

		buttonGroup.add(rdbtnEspece);
		rdbtnEspece.setBackground(new Color(255, 255, 255));
		rdbtnEspece.setBounds(312, 152, 99, 23);
		panelDepenses.add(rdbtnEspece);

		JLabel lblType = new JLabel("Type  :");
		lblType.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblType.setBounds(100, 151, 67, 22);
		panelDepenses.add(lblType);
		lblTotalDepenses.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotalDepenses.setVisible(false);
		lblTotalDepenses.setBounds(86, 496, 67, 22);

		panelDepenses.add(lblTotalDepenses);
		sommeDepenses.setBounds(147, 496, 180, 22);

		panelDepenses.add(sommeDepenses);
		panelLesRecettes.setBackground(Color.WHITE);
		panelLesRecettes.setBounds(273, 95, 665, 537);
		getContentPane().add(panelLesRecettes);
		panelLesRecettes.setLayout(null);

		JLabel lblConsulterLesRecettes = new JLabel("Consulter Les Recettes Enregistr\u00E9es");
		lblConsulterLesRecettes.setForeground(new Color(0, 0, 51));
		lblConsulterLesRecettes.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConsulterLesRecettes.setBounds(168, 24, 356, 30);
		panelLesRecettes.add(lblConsulterLesRecettes);
		btnConsulter.setForeground(new Color(0, 0, 51));
		btnConsulter.setBackground(new Color(255, 204, 51));

		btnConsulter.addMouseListener(new ListenerConsulter(this));
		btnConsulter.setBounds(540, 89, 89, 23);
		panelLesRecettes.add(btnConsulter);

		calendarFin.setBounds(289, 87, 117, 25);
		panelLesRecettes.add(calendarFin);

		JLabel lblDateDeDbut = new JLabel("Date de D\u00E9but");
		lblDateDeDbut.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDateDeDbut.setBounds(59, 59, 107, 23);
		panelLesRecettes.add(lblDateDeDbut);

		JLabel lblDateDeFin = new JLabel("Date de Fin");
		lblDateDeFin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDateDeFin.setBounds(289, 62, 107, 23);
		panelLesRecettes.add(lblDateDeFin);
		rdbtnPrincipale.setBackground(new Color(255, 255, 255));

		rdbtnPrincipale.setSelected(true);
		buttonGroup_1.add(rdbtnPrincipale);
		rdbtnPrincipale.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnPrincipale.setBounds(141, 142, 109, 23);
		panelLesRecettes.add(rdbtnPrincipale);

		buttonGroup_1.add(rdbtnSecondaire);
		rdbtnSecondaire.setBackground(new Color(255, 255, 255));
		rdbtnSecondaire.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnSecondaire.setBounds(311, 142, 109, 23);
		panelLesRecettes.add(rdbtnSecondaire);

		// scrollPane_4 = new JScrollPane(listeRecettesMembres);
		// scrollPane_4.setBounds(67, 193, 562, 286);
		// panelLesRecettes.add(scrollPane_4);

		panelLesRecettes.add(scrollPane_4);

		JLabel lblType_1 = new JLabel("Type  :");
		lblType_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblType_1.setBounds(67, 144, 54, 18);
		panelLesRecettes.add(lblType_1);
		lblTotalDesDepenses.setVisible(false);
		lblTotalDesDepenses.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotalDesDepenses.setBounds(87, 504, 60, 14);

		panelLesRecettes.add(lblTotalDesDepenses);
		montantTotalDepenses.setBounds(143, 496, 234, 22);

		panelLesRecettes.add(montantTotalDepenses);

		listeRecettesMembres = new JTable();
		listeRecettesMembres.setMinimumSize(new Dimension(0, 35));
		listeRecettesMembres.setBounds(0, 0, 1, 1);

		JPanel panelOptions = new JPanel();
		panelOptions.setBackground(new Color(0, 25, 51));
		panelOptions.setBounds(0, 74, 249, 598);
		panelOptions.setLayout(null);
		getContentPane().add(panelOptions);
		btnConsulterRecettesPrincipale.addMouseListener(new ListenerConsulter(this));

		btnConsulterRecettesPrincipale.setForeground(Color.WHITE);
		btnConsulterRecettesPrincipale.setBackground(new Color(0, 0, 51));
		btnConsulterRecettesPrincipale.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnConsulterRecettesPrincipale.setBounds(10, 210, 229, 23);
		panelOptions.add(btnConsulterRecettesPrincipale);
		btnConsulterRecettesSecondaire.addMouseListener(new ListenerConsulter(this));

		btnConsulterRecettesSecondaire.setForeground(Color.WHITE);
		btnConsulterRecettesSecondaire.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnConsulterRecettesSecondaire.setBackground(new Color(0, 0, 51));
		btnConsulterRecettesSecondaire.setBounds(10, 253, 229, 23);
		panelOptions.add(btnConsulterRecettesSecondaire);

		btnConsulterRecettesMembre.addMouseListener(new ListenerConsulter(this));
		btnConsulterRecettesMembre.setForeground(Color.WHITE);
		btnConsulterRecettesMembre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnConsulterRecettesMembre.setBackground(new Color(0, 0, 51));
		btnConsulterRecettesMembre.setBounds(10, 302, 229, 23);

		panelOptions.add(btnConsulterRecettesMembre);
		btnConsulterLesRecettes.addMouseListener(new ListenerConsulter(this));
		btnConsulterLesRecettes.setForeground(Color.WHITE);
		btnConsulterLesRecettes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnConsulterLesRecettes.setBackground(new Color(0, 0, 51));
		btnConsulterLesRecettes.setBounds(10, 347, 229, 23);
		panelOptions.add(btnConsulterLesRecettes);

		btnConsulterToutesLesDepenses.addMouseListener(new ListenerConsulter(this));
		btnConsulterToutesLesDepenses.setForeground(Color.WHITE);
		btnConsulterToutesLesDepenses.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnConsulterToutesLesDepenses.setBackground(new Color(0, 0, 51));
		btnConsulterToutesLesDepenses.setBounds(10, 393, 229, 23);

		panelOptions.add(btnConsulterToutesLesDepenses);

	}

	public void setTableListe(Object[][] tableListe) {
		this.tableListe = tableListe;
	}

	public JTable listes(Object[][] liste) {
		JTable table1 = new JTable(liste, title);
		table1.setRowHeight(20);
		ModelTableau zModel = new ModelTableau(liste, title);
		table = new JTable(zModel);
		table.setForeground(new Color(0, 0, 51));
		table.setGridColor(new Color(255, 102, 51));

		return table;
	}

	public JTextField getNomRechercher() {
		return nomRechercher;
	}
}
