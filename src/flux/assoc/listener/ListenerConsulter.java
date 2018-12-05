package flux.assoc.listener;

import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import flux.assoc.metier.Depenses;
import flux.assoc.metier.Recettes;
import flux.assoc.ui.FenetreConsulter;

public class ListenerConsulter extends MouseAdapter {

	private FenetreConsulter fenetreConsulter;

	public ListenerConsulter(FenetreConsulter fn) {
		// TODO Auto-generated constructor stub
		this.fenetreConsulter = fn;
	}

	public void mouseClicked(MouseEvent e) {
		// affichage du panel pour consulter les recettes principales
		if (e.getSource().equals(fenetreConsulter.btnConsulterRecettesPrincipale)) {
			fenetreConsulter.panelRecettesMembre.setVisible(false);
			fenetreConsulter.panelRecettesSecondaire.setVisible(false);
			fenetreConsulter.panelLesRecettes.setVisible(false);
			fenetreConsulter.panelRecettesPrincipale.setVisible(true);
			fenetreConsulter.panelDepenses.setVisible(false);
		}

		// affichage du panel pour consulter les recettes secondaires
		if (e.getSource().equals(fenetreConsulter.btnConsulterRecettesSecondaire)) {
			fenetreConsulter.panelRecettesPrincipale.setVisible(false);
			fenetreConsulter.panelRecettesMembre.setVisible(false);
			fenetreConsulter.panelLesRecettes.setVisible(false);
			fenetreConsulter.panelDepenses.setVisible(false);
			fenetreConsulter.panelRecettesSecondaire.setVisible(true);
		}

		// affichage du panel pour consulter les recettes secondaires
		if (e.getSource().equals(fenetreConsulter.btnConsulterRecettesMembre)) {
			fenetreConsulter.panelRecettesPrincipale.setVisible(false);
			fenetreConsulter.panelRecettesSecondaire.setVisible(false);
			fenetreConsulter.panelLesRecettes.setVisible(false);
			fenetreConsulter.panelDepenses.setVisible(false);
			fenetreConsulter.panelRecettesMembre.setVisible(true);
		}

		if (e.getSource().equals(fenetreConsulter.btnConsulterLesRecettes)) {
			fenetreConsulter.panelRecettesPrincipale.setVisible(false);
			fenetreConsulter.panelRecettesMembre.setVisible(false);
			fenetreConsulter.panelRecettesSecondaire.setVisible(false);
			fenetreConsulter.panelDepenses.setVisible(false);
			fenetreConsulter.panelLesRecettes.setVisible(true);
		}

		if (e.getSource().equals(fenetreConsulter.btnConsulterToutesLesDepenses)) {
			fenetreConsulter.panelRecettesPrincipale.setVisible(false);
			fenetreConsulter.panelRecettesMembre.setVisible(false);
			fenetreConsulter.panelRecettesSecondaire.setVisible(false);
			fenetreConsulter.panelLesRecettes.setVisible(false);
			fenetreConsulter.panelDepenses.setVisible(true);
		}

		// consulter recette principale
		if (e.getSource().equals(fenetreConsulter.btnConsulterRecettePrincipale)) {
			SimpleDateFormat dateD = new SimpleDateFormat("yyyy-MM-dd");
			try {
				String dateDebut = dateD.format(fenetreConsulter.calendarDebut1.getDate());
				String dateFin = dateD.format(fenetreConsulter.calendarFin1.getDate());
				try {
					fenetreConsulter.scrollPane = new JScrollPane(
							fenetreConsulter.listes(Recettes.listeRecettes(dateDebut, dateFin, "principale")));
					fenetreConsulter.totalRecPrincipale.setVisible(true);
					fenetreConsulter.scrollPane.setBounds(33, 127, 583, 274);
					fenetreConsulter.panelRecettesPrincipale.add(fenetreConsulter.scrollPane);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} catch (NullPointerException e2) {
				JOptionPane.showMessageDialog(null, "Veillez choisir une période SVP");
			}

		}

		// consulter recette secondaire
		if (e.getSource().equals(fenetreConsulter.btnConsulterRecetteSecondaire)) {
			SimpleDateFormat dateD = new SimpleDateFormat("yyyy-MM-dd");
			try {
				String dateDebut = dateD.format(fenetreConsulter.calendarDebut2.getDate());
				String dateFin = dateD.format(fenetreConsulter.calendarFin2.getDate());
				try {
					fenetreConsulter.lblTotalSecondaire.setVisible(true);
					fenetreConsulter.scrollPane_1 = new JScrollPane(
							fenetreConsulter.listes(Recettes.listeRecettes(dateDebut, dateFin, "secondaire")));
					fenetreConsulter.scrollPane_1.setBounds(33, 127, 583, 274);
					fenetreConsulter.panelRecettesSecondaire.add(fenetreConsulter.scrollPane_1);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} catch (NullPointerException e2) {
				JOptionPane.showMessageDialog(null, "Veillez choisir une période SVP", "Choix de Periode",
						JOptionPane.WARNING_MESSAGE);
			}
		}

		if (e.getSource().equals(fenetreConsulter.btnConsulter)) {
			SimpleDateFormat dateD = new SimpleDateFormat("yyyy-MM-dd");
			try {
				String dateDebut = dateD.format(fenetreConsulter.calendarDebut.getDate());
				String dateFin = dateD.format(fenetreConsulter.calendarFin.getDate());
				int montant = 0;
				Object[][] liste;
				try {
					if (fenetreConsulter.rdbtnPrincipale.isSelected()) {
						liste = Recettes.listeRecettes(dateDebut, dateFin, "principale");
						fenetreConsulter.scrollPane_4 = new JScrollPane(fenetreConsulter.listes(liste));
						int somme = somme(liste);
						fenetreConsulter.lblTotalDesDepenses.setVisible(true);
						fenetreConsulter.montantTotalDepenses.setText(somme + " FCFA");

					} else {
						liste = Recettes.listeRecettes(dateDebut, dateFin, "secondaire");
						fenetreConsulter.scrollPane_4 = new JScrollPane(fenetreConsulter.listes(liste));
						int somme = somme(liste);
						fenetreConsulter.lblTotalDesDepenses.setVisible(true);
						fenetreConsulter.montantTotalDepenses.setText(somme + " FCFA");
					}
					fenetreConsulter.scrollPane_4.setBounds(67, 193, 562, 286);
					fenetreConsulter.panelLesRecettes.add(fenetreConsulter.scrollPane_4);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} catch (NullPointerException e2) {
				JOptionPane.showMessageDialog(null, "Veillez choisir une période SVP", "Choix de Periode",
						JOptionPane.WARNING_MESSAGE);
			}

		}

		// consulter les depenses
		if (e.getSource().equals(fenetreConsulter.btnConsulterDepenses)) {
			SimpleDateFormat dateD = new SimpleDateFormat("yyyy-MM-dd");
			try {
				String dateDebut = dateD.format(fenetreConsulter.calendarDebut3.getDate());
				String dateFin = dateD.format(fenetreConsulter.calendarFin3.getDate());

				try {
					if (fenetreConsulter.rdbtnEspece.isSelected()) {
						fenetreConsulter.scrollPane_3 = new JScrollPane(
								fenetreConsulter.listes(Depenses.listeDepenses(dateDebut, dateFin, "espece")));
					} else {
						fenetreConsulter.scrollPane_3 = new JScrollPane(
								fenetreConsulter.listes(Depenses.listeDepenses(dateDebut, dateFin, "cheque")));
					}
					fenetreConsulter.scrollPane_3.setBounds(86, 207, 562, 286);
					fenetreConsulter.panelDepenses.add(fenetreConsulter.scrollPane_3);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} catch (NullPointerException e2) {
				JOptionPane.showMessageDialog(null, "Veillez choisir une période SVP", "Choix de Periode",
						JOptionPane.WARNING_MESSAGE);
			}

		}

		// consultation des recettes d'un client
		if (e.getSource().equals(fenetreConsulter.consulter)) {
			String nomMembre = fenetreConsulter.getNomRechercher().getText();
			SimpleDateFormat dateD = new SimpleDateFormat("yyyy-MM-dd");
			try {
				if (dateD.format(fenetreConsulter.calendarDebut4.getDate()) != null
						&& dateD.format(fenetreConsulter.calendarFin4.getDate()) != null) {

					String dateDebut = dateD.format(fenetreConsulter.calendarDebut4.getDate());
					String dateFin = dateD.format(fenetreConsulter.calendarFin4.getDate());
					try {
						Object[][] liste = Recettes.listeRecettesMem(dateDebut, dateFin, nomMembre);
						String title[] = { "Date Naissance", "dateVersement", "Type", "Montant" };
						if (liste != null) {
							JTable t = new JTable(liste, title);
							fenetreConsulter.scrollPane_5 = new JScrollPane(t);
							fenetreConsulter.scrollPane_5.setBounds(80, 239, 570, 208);
							fenetreConsulter.panelRecettesMembre.add(fenetreConsulter.scrollPane_5);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			} catch (NullPointerException e2) {
				JOptionPane.showMessageDialog(null, "Veillez choisir une date de Début et de Fin SVP","Choix de Periode", JOptionPane.WARNING_MESSAGE);
			}

		}
	}

	public int somme(Object[][] liste) {
		int somme = 0;
		for (int i = 0; i < liste.length; i++) {
			somme += (int) liste[i][1];
		}
		return somme;
	}
}
