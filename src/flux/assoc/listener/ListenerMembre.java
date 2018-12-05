/**
 * 
 */
package flux.assoc.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import flux.assoc.metier.AccesBD;
import flux.assoc.metier.Membres;
import flux.assoc.ui.FenetreAdmin;
import flux.assoc.ui.FenetreMembres;

public class ListenerMembre extends MouseAdapter {
	private FenetreMembres fenetreMembres;

	/**
	 * 
	 * @param membre2
	 */
	public ListenerMembre(FenetreMembres membre2) throws NullPointerException {
		this.fenetreMembres = membre2;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(fenetreMembres.btnAddMembre)) {
			fenetreMembres.panelAjoutMembre.setVisible(true);
			fenetreMembres.panelDesactiver.setVisible(false);
			fenetreMembres.panelReactiver.setVisible(false);
		}

		if (e.getSource().equals(fenetreMembres.btnDsactiverMembre)) {
			fenetreMembres.panelAjoutMembre.setVisible(false);
			fenetreMembres.panelDesactiver.setVisible(true);
			fenetreMembres.panelReactiver.setVisible(false);
		}

		if (e.getSource().equals(fenetreMembres.getReactiverMembre())) {
			fenetreMembres.panelAjoutMembre.setVisible(false);
			fenetreMembres.panelDesactiver.setVisible(false);
			fenetreMembres.panelReactiver.setVisible(true);
		}

		// enregistrement d'un membre
		if (e.getSource().equals(fenetreMembres.btnAjouter)) {
			String nom = fenetreMembres.getNom().getText();
			String prenom = fenetreMembres.getPrenom().getText();
			SimpleDateFormat dateD = new SimpleDateFormat("yyyy-MM-dd");
			String dateEntree = null;
			String dateNaiss = null;
			String adresse = fenetreMembres.getAdresse().getText();
			try {
				dateNaiss = dateD.format(fenetreMembres.getDateNaiss());
				dateEntree = dateD.format(fenetreMembres.getDateEntree());
				if (controle(nom) && controle(prenom) && adresse != null) {
					Membres membre = new Membres(nom, prenom, dateNaiss, dateEntree, adresse);
					try {
						Membres.addMembre(membre);
						fenetreMembres.setVisible(false);
						new FenetreAdmin().setVisible(true);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Veillez renseigner tous les champs",
							"Renseignement des Champs", JOptionPane.WARNING_MESSAGE);
				}
			} catch (NullPointerException e2) {
				JOptionPane.showMessageDialog(null, "Veillez renseigner tous les champs ", "Renseignement des Champs",
						JOptionPane.WARNING_MESSAGE);
			}

		}

		// desactiver un membre
		if (e.getSource().equals(fenetreMembres.getBtnDesactiver())) {
			Object[][] listes = fenetreMembres.getListeMembresDesactiver();
			boolean fait = false;
			for (int i = 0; i < listes.length; i++) {
				if (listes[i][4].equals(true)) {
					String requete = "Update membres set etat=0 where id_membre=" + listes[i][0] + "";
					AccesBD connect = new AccesBD();
					try {
						connect.doUpdate(requete);

						fait = true;
					} catch (SQLException e1) {
						e1.printStackTrace();
					} finally {
						connect.deconnection();
					}
				}
			}
			if (fait) {
				JOptionPane.showMessageDialog(null, "Le(s) membre(s) ont été désactivé ! ", "Desactivation Membre(s)",
						JOptionPane.INFORMATION_MESSAGE);
				fenetreMembres.setVisible(false);
				try {
					new FenetreAdmin().setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}

		// reactiver un membre
		if (e.getSource().equals(fenetreMembres.getBtnReactiver())) {
			Object[][] listes = fenetreMembres.getListeMembresReactiver();
			boolean fait = false;
			for (int i = 0; i < listes.length; i++) {
				if (listes[i][4].equals(true)) {
					String requete = "Update membres set etat=1 where id_membre=" + listes[i][0] + "";
					AccesBD connect = new AccesBD();
					try {
						connect.doUpdate(requete);
						fait = true;
					} catch (SQLException e1) {
						e1.printStackTrace();
					} finally {
						connect.deconnection();
					}
				}
			}
			if (fait) {
				JOptionPane.showMessageDialog(null, "Le(s)  membre(s) ont été réactivé ! ", "Reactivation Membre(s)",
						JOptionPane.INFORMATION_MESSAGE);
				fenetreMembres.setVisible(false);
				try {
					new FenetreAdmin().setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	private boolean controle(String name) {
		String regex = "^[a-zA-Z]+$";
		Pattern regPat = Pattern.compile(regex);
		Matcher matcher = regPat.matcher(name);
		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}
}
