package flux.assoc.metier;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import flux.assoc.ui.FenetreConsulter;

public class RecettesSecondaires extends Recettes {
	private String libelle;

	public RecettesSecondaires(double montant, String date, String libelle, int identite) {
		super(montant, date);
		setLibelle(libelle);
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public boolean verifierLibelle(String libelle) {
		if (libelle == null) {
			JOptionPane.showMessageDialog(null, "Veuillez renseigner le champ libelle");
			return false;
		} else {
			return true;
		}
	}

	public static void addRecetteSecondaire(RecettesSecondaires recette, int identite, int idtypeRecette)
			throws SQLException {
		String requete = " insert into recettes (identite,libelle,montant,id_typeRec,dateVersement) values (" + identite
				+ ",'" + recette.getLibelle() + "'," + recette.getMontant() + ",2,'" + recette.getDate() + "' )";
		AccesBD connect = new AccesBD();
		connect.doUpdate(requete);
		connect.deconnection();
	}

	public static Object[][] listeRecettesSecondaires() throws SQLException {
		Object[][] listes;
		String requete = "SELECT * FROM recettes where id_typeRec=2";
		int nl = 0, montant = 0;
		AccesBD connect = new AccesBD();
		ResultSet res = connect.doQuery(requete);
		while (res.next()) {
			nl++;
		}
		res.beforeFirst();
		listes = new Object[nl][4];
		int i = 0;
		while (res.next()) {
			listes[i][0] = res.getInt("id_recette");
			listes[i][1] = res.getInt("montant");
			montant += res.getInt("montant");
			listes[i][2] = res.getDate("dateVersement");
			i++;
		}
		FenetreConsulter.montantSecondaire.setText(String.valueOf(montant) + " FCFA");
		return listes;
	}

	public static Object[][] listeRecettesSecondaire(String type) throws SQLException {
		String date = new Date(System.currentTimeMillis()).toString().substring(0, 10);
		String[] dateFormate = date.split("-");
		int montant = 0, nbreLignes = 0, i = 0;
		Object[][] recettes = null;
		AccesBD connect = new AccesBD();
		String requete = "select * from  recettes where id_typeRec=2";

		switch (type) {
		case "cemois":
			String moisPresent = dateFormate[0] + "-" + dateFormate[1];
			try {
				ResultSet res = connect.doQuery(requete);
				while (res.next()) {
					String dateVersement = res.getString("DateVersement");
					String day = dateVersement.toString().substring(0, 7);
					if (day.equals(moisPresent)) {
						nbreLignes++;
					}
				}
				res.beforeFirst();
				recettes = new Object[nbreLignes][4];
				while (res.next()) {
					String dateVersement = res.getString("DateVersement");
					String day = dateVersement.toString().substring(0, 7);
					if (day.equals(moisPresent)) {
						recettes[i][0] = res.getInt("id_recette");
						recettes[i][1] = res.getInt("montant");
						montant += res.getInt("montant");
						recettes[i][2] = res.getDate("dateVersement");
						i++;
					}
				}
				FenetreConsulter.montantSecondaire.setText(String.valueOf(montant) + " FCFA");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			break;
		case "3mois":
			String mois2 = null;
			String mois1 = null;
			String mois3 = null;
			if (Integer.parseInt(dateFormate[1]) == 1) {
				mois1 = Integer.parseInt(dateFormate[0]) - 1 + "-12";
				mois2 = Integer.parseInt(dateFormate[0]) - 1 + "-11";
				mois3 = Integer.parseInt(dateFormate[0]) - 1 + "-10";
			} else {
				mois1 = dateFormate[0] + "-0" + (Integer.parseInt(dateFormate[1]) - 1);
				mois2 = dateFormate[0] + "-0" + (Integer.parseInt(dateFormate[1]) - 2);
				mois3 = dateFormate[0] + "-0" + (Integer.parseInt(dateFormate[1]) - 3);
			}
			try {
				ResultSet res = connect.doQuery(requete);
				while (res.next()) {
					String dateVersement = res.getString("DateVersement");
					String day = dateVersement.toString().substring(0, 7);
					if (day.equals(mois1) || day.equals(mois2) || day.equals(mois3)) {
						nbreLignes++;
					}
				}
				recettes = new Object[nbreLignes][4];
				res.beforeFirst();
				while (res.next()) {
					String dateVersement = res.getString("DateVersement");
					String day = dateVersement.toString().substring(0, 7);
					if (day.equals(mois1) || day.equals(mois2) || day.equals(mois3)) {
						recettes[i][0] = res.getInt("id_recette");
						recettes[i][1] = res.getInt("montant");
						montant += res.getInt("montant");
						recettes[i][2] = res.getDate("dateVersement");
						i++;
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			FenetreConsulter.montantSecondaire.setText(String.valueOf(montant) + " FCFA");
			break;
		}
		// if (recettes.length == 0) {
		// FenetreConsulter.infoRecetteSecondaire
		// .setText("Info :Aucune recette principale n'a été enregistré ces 3 derniers
		// mois.");
		// FenetreConsulter.infoRecetteSecondaire.setVisible(true);
		// } else {
		// FenetreConsulter.infoRecetteSecondaire.setVisible(false);
		// }
		return recettes;
	}
}
