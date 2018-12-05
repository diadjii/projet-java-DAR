package flux.assoc.metier;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import flux.assoc.ui.FenetreConsulter;
import flux.assoc.ui.FenetreRecettes;

public abstract class Recettes {
	private double montant;
	private String date;

	public Recettes(double montant, String date) {
		setMontant(montant);
		setDate(date);
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {

		this.montant = montant;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean verifierDonnees(String donnees) {
		if (Integer.parseInt(donnees) == 0) {
			JOptionPane.showMessageDialog(null, "veuillez renseigner le montant");
			return false;
		} else if (Integer.parseInt(donnees) < 0) {
			JOptionPane.showMessageDialog(null, "le montant ne peut étre negatif");
			return false;
		} else
			return true;
	}

	public boolean isCorrectMontant(String montant) {
		String regex = "^[0-9]+$";
		Pattern pregex = Pattern.compile(regex);
		Matcher mregex = pregex.matcher(montant);
		if (mregex.find()) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Le montant doit étre un nombre");
			return false;
		}

	}

	public static Object[][] listeRecettesMem(String dateDebut, String dateFin, String nomMembre) throws SQLException {
		int montant = 0;
		String info = "";
		Object[][] listeRecette = null;
		AccesBD connect = new AccesBD();
		String requete = "select * from membres inner join recettes on id_membre=identite where membres.prenom='"
				+ nomMembre + "' and dateVersement between '" + dateDebut + "' and  '" + dateFin + "'";
		ResultSet response = connect.doQuery(requete);

		if (!response.next()) {
			JOptionPane.showMessageDialog(null,
					"Aucune recette n'a ete versée par " + nomMembre + " durant cette prériode. ");
		} else {
			int i = 0;
			response.beforeFirst();
			while (response.next()) {
				i++;
			}
			response.beforeFirst();
			listeRecette = new Object[i][6];
			i = 0;
			String nom = null;
			String prenom = null;
			while (response.next()) {
				nom = response.getString("nom");
				prenom = response.getString("prenom");
				listeRecette[i][0] = response.getString("dateNaiss");
				listeRecette[i][1] = response.getString("dateVersement");
				if (response.getInt("id_typeRec") == 1) {
					listeRecette[i][2] = "Recette Principale";
				} else {
					listeRecette[i][2] = "Recette Secondaire";
				}
				listeRecette[i][3] = response.getInt("montant");
				montant += response.getInt("montant");
				i++;
			}
			FenetreConsulter.titre.setVisible(true);
			FenetreConsulter.titre.setText("Liste recette(s) versee(s) par " + prenom + " " + nom);
			FenetreConsulter.lblTotalRecettesMembre.setVisible(true);

			FenetreConsulter.sommeRecettesMembres.setVisible(true);
			FenetreConsulter.sommeRecettesMembres.setText(montant + " FCFA");
			// JOptionPane.showMessageDialog(null, info + "\n TOTAL = " + montant + "
			// FCFA");
		}
		return listeRecette;
	}

	public static Object[][] listeRecettes(String dateDebut, String dateFin, String type) throws SQLException {
		Object[][] listeDepenses = null;
		AccesBD connect = new AccesBD();
		int nbLignes = 0, i = 0, montant = 0;
		switch (type) {
		case "principale":
			String requete1 = " select * from recettes where dateVersement between '" + dateDebut + "' and '" + dateFin
					+ "' and id_typeRec =1";
			ResultSet response = connect.doQuery(requete1);
			while (response.next()) {
				nbLignes++;
			}
			listeDepenses = new Object[nbLignes][4];
			response.beforeFirst();

			while (response.next()) {
				listeDepenses[i][0] = i + 1;
				listeDepenses[i][1] = response.getInt("montant");
				montant += response.getInt("montant");
				listeDepenses[i][2] = response.getDate("dateVersement");
				i++;
			}
			FenetreConsulter.montantPrincipale.setText(montant + " FCFA");
			break;
		case "secondaire":
			String requete2 = " select * from recettes where dateVersement between '" + dateDebut + "' and '" + dateFin
					+ "' and id_typeRec =2";
			ResultSet response1 = connect.doQuery(requete2);
			while (response1.next()) {
				nbLignes++;
			}
			listeDepenses = new Object[nbLignes][4];
			response1.beforeFirst();
			while (response1.next()) {
				listeDepenses[i][0] = i + 1;
				listeDepenses[i][1] = response1.getInt("montant");
				montant += response1.getInt("montant");
				listeDepenses[i][2] = response1.getDate("dateVersement");
				i++;
			}
			FenetreConsulter.montantSecondaire.setText(montant + " FCFA");
			break;
		default:
			String requete3 = " select * from recettes where dateVersement between '" + dateDebut + "' and '" + dateFin
					+ "'";
			ResultSet response3 = connect.doQuery(requete3);
			while (response3.next()) {
				nbLignes++;
			}
			listeDepenses = new Object[nbLignes][4];
			response3.beforeFirst();
			while (response3.next()) {
				listeDepenses[i][0] = i + 1;
				listeDepenses[i][1] = response3.getInt("montant");
				listeDepenses[i][2] = response3.getDate("dateVersement");
				i++;
			}
			break;
		}
		if (listeDepenses.length == 0) {
			JOptionPane.showMessageDialog(null, "Aucune recette n ' a ete verse durant cette periode");
		}
		return listeDepenses;
	}

}