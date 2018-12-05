package flux.assoc.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import flux.assoc.metier.DepensesCheque;
import flux.assoc.metier.DepensesEspece;
import flux.assoc.metier.RecettesPrincipales;
import flux.assoc.metier.RecettesSecondaires;
import flux.assoc.ui.FenetreAdmin;
import flux.assoc.ui.FenetreFinancier;
import flux.assoc.ui.FenetreMessage;
import flux.assoc.ui.FenetreRecettes;

public class ListenerRecettes extends MouseAdapter {
	private FenetreRecettes fenetreRecette;

	public ListenerRecettes(FenetreRecettes fn) {
		this.fenetreRecette = fn;
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(fenetreRecette.getTable())) {
			int row = fenetreRecette.getTable().getSelectedRow();
			int id = (int) fenetreRecette.getTable().getValueAt(row, 0);
			String nomMembre = (String) fenetreRecette.getTable().getValueAt(row, 2);
			fenetreRecette.getNomMembre().setText(nomMembre);
			fenetreRecette.getIndentifiantMembre().setText("" + id);
		}

		// affichage du panel pour ajouter des recettes
		if (e.getSource().equals(fenetreRecette.btnEnregistrerRecette)) {
			fenetreRecette.panelAddRecette.setVisible(true);
			fenetreRecette.panelAddDepenses.setVisible(false);
		}
		// affichage du panel pour enregistrer une dépense
		if (e.getSource().equals(fenetreRecette.btnEnregistrerDepenses)) {
			fenetreRecette.panelAddDepenses.setVisible(true);
			fenetreRecette.panelAddRecette.setVisible(false);
		}

		if (e.getSource().equals(fenetreRecette.getBtnEnregistrer())) {
			SimpleDateFormat dateD = new SimpleDateFormat("yyyy-MM-dd");
			String dateVersement = null;
			try {
				// enregistrement recette principale
				dateVersement = dateD.format(fenetreRecette.getDateVersement());
				String id = fenetreRecette.getIndentifiantMembre().getText();
				String mn = fenetreRecette.getMontant().getText();
				int categorie = fenetreRecette.getCategorie().getSelectedIndex() + 1;

				if (id.length() > 0 && mn.length() > 0) {
					if (fenetreRecette.rdbtnRecettePrincipale.isSelected()) {
						int identite = Integer.parseInt(id);
						double montant = Double.parseDouble(mn);
						RecettesPrincipales recette = new RecettesPrincipales(montant, dateVersement, categorie);
						try {
							RecettesPrincipales.addRecettePrincipale(recette, identite, 1);
							JOptionPane.showMessageDialog(null, "L'enregistrement de le recétte a reussi");
							fenetreRecette.setVisible(false);
							if (fenetreRecette.getUserRole() == 2) {
								new FenetreFinancier().setVisible(true);
							} else {
								new FenetreAdmin().setVisible(true);
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					} else {
						// enregistrement recette secondaire
						int identite = Integer.parseInt(fenetreRecette.getIndentifiantMembre().getText());
						double montant = Double.parseDouble(fenetreRecette.getMontant().getText());
						String libelle = fenetreRecette.getLibelle().getText();
						RecettesSecondaires recette = new RecettesSecondaires(montant, dateVersement, libelle,
								identite);
						try {
							RecettesSecondaires.addRecetteSecondaire(recette, identite, 2);
							JOptionPane.showMessageDialog(null, "L'enregistrement de la recette a reussi");
							fenetreRecette.setVisible(false);
							if (fenetreRecette.getUserRole() == 2) {
								new FenetreFinancier().setVisible(true);
							} else {
								new FenetreAdmin().setVisible(true);
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}

				} else {
					JOptionPane.showMessageDialog(null, "Veillez renseigner les champs Vides");
				}
			} catch (NullPointerException e2) {
				JOptionPane.showMessageDialog(null, "Veillez choisir la Date de Versement ");
			}
		}
		// champs visibles pour enregistrer une recette principale
		if (fenetreRecette.rdbtnRecettePrincipale.isSelected()) {
			fenetreRecette.btnTiers.setVisible(false);
			fenetreRecette.btnMembre.setVisible(false);
			fenetreRecette.getLblConcern().setVisible(false);
			fenetreRecette.getLibelle().setVisible(false);
			fenetreRecette.getLblLibell().setVisible(false);
			fenetreRecette.getCategorie().setEnabled(true);
			fenetreRecette.lblListeDesMembres.setVisible(true);
			fenetreRecette.lblMembre.setEnabled(true);
			fenetreRecette.scrollPane2.setVisible(true);
		}

		// champs visibles pour enregistrer une recette secondaire
		if (fenetreRecette.rdbtnSecondaire.isSelected()) {
			fenetreRecette.btnTiers.setVisible(true);
			fenetreRecette.btnMembre.setVisible(true);
			fenetreRecette.lblMembre.setEnabled(false);
			fenetreRecette.getNomMembre().setEnabled(false);
			fenetreRecette.getLblConcern().setVisible(true);
			fenetreRecette.getLblLibell().setVisible(true);
			fenetreRecette.getLibelle().setVisible(true);
			fenetreRecette.getCategorie().setEnabled(false);
			fenetreRecette.getNomMembre().setEnabled(false);
			fenetreRecette.getLblLibell().setVisible(true);
			fenetreRecette.scrollPane2.setVisible(false);
			fenetreRecette.lblListeDesMembres.setVisible(false);
		}

		if (fenetreRecette.rdbtnEspeces.isSelected()) {
			fenetreRecette.lblNchque.setVisible(false);
			fenetreRecette.getNumeroCheque().setVisible(false);
			fenetreRecette.lblNomBnficiaire.setVisible(false);
			fenetreRecette.getNomBeneficiaire().setVisible(false);

		}
		if (fenetreRecette.rdbtnParChque.isSelected()) {
			fenetreRecette.lblNchque.setVisible(true);
			fenetreRecette.getNumeroCheque().setVisible(true);
			fenetreRecette.lblNomBnficiaire.setVisible(true);
			fenetreRecette.getNomBeneficiaire().setVisible(true);
		}
		// enregistrement de depense espece ou cheque
		if (e.getSource().equals(fenetreRecette.btnAddDepense)) {
			SimpleDateFormat dateD = new SimpleDateFormat("yyyy-MM-dd");
			String dateDepense = dateD.format(fenetreRecette.getDateDepense());

			if (fenetreRecette.rdbtnEspeces.isSelected()) {
				String motif = fenetreRecette.getMotif().getText();
				String mont = fenetreRecette.getMontantDepense().getText();

				if (motif.length() == 0 || mont.length() == 0 || dateDepense.length() == 0) {
					JOptionPane.showMessageDialog(null, "Veillez renseigner tous les Champs SVP.");
				} else {
					int montantDepense = Integer.parseInt(mont);
					DepensesEspece depense = new DepensesEspece(motif, montantDepense, dateDepense);
					try {
						DepensesEspece.enregistrerDepenseEspece(depense);
						JOptionPane.showMessageDialog(null, "Dépense enregistrée avec succes");
						fenetreRecette.setVisible(false);
						if (fenetreRecette.getUserRole() == 2) {
							new FenetreFinancier().setVisible(true);
						} else {
							new FenetreAdmin().setVisible(true);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			} else {
				if (fenetreRecette.rdbtnParChque.isSelected()) {
					String motif = fenetreRecette.getMotif().getText();
					String mont = fenetreRecette.getMontantDepense().getText();
					String ch = fenetreRecette.getNumeroCheque().getText();
					String beneficiaire = fenetreRecette.getNomBeneficiaire().getText();

					if (motif.length() == 0 || dateDepense.length() == 0 || beneficiaire.length() == 0
							|| ch.length() == 0) {
						JOptionPane.showMessageDialog(null, "Veillez renseigner tous les Champs SVP.",
								"Renseignement des Champs", JOptionPane.ERROR_MESSAGE);
					} else {
						int numCheque = Integer.parseInt(ch);
						int montantDepense = Integer.parseInt(mont);
						DepensesCheque depense = new DepensesCheque(motif, montantDepense, dateDepense, numCheque,
								beneficiaire);
						fenetreRecette.setVisible(false);
						try {
							new FenetreAdmin().setVisible(true);
						} catch (SQLException e2) {
							e2.printStackTrace();
						}
						try {
							DepensesCheque.enregistrerDepenseCheque(depense);
							JOptionPane.showMessageDialog(null, "Dépense enregistrée avec Succes",
									"Eneregistrement Recette Reussi", JOptionPane.INFORMATION_MESSAGE);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		}

	}

}
