package flux.assoc.metier;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import flux.assoc.ui.FenetreConsulter;

public abstract class Depenses {
	protected String motif;
	protected int montant;
	protected String dateDepense;

	public Depenses(String motif, int mntant, String depen) {
		setMotif(motif);
		setMontant(mntant);
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	public String getDateDepense() {
		return dateDepense;
	}

	public void setDateDepense(String dateDepense) {
		this.dateDepense = dateDepense;
	}

	public static Object[][] listeDepenses(String dateDebut, String dateFin, String type) throws SQLException {
		Object[][] listeDepenses = null;
		AccesBD connect = new AccesBD();
		int nbLignes = 0;
		int i = 0, montant = 0;
		switch (type) {
		case "espece":
			String requete1 = " select * from depenses where dateDepense between '" + dateDebut + "' and '" + dateFin
					+ "' and id_typeDep =1";
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
				listeDepenses[i][2] = response.getDate("dateDepense");
				i++;
			}
			FenetreConsulter.lblTotalDepenses.setVisible(true);
			FenetreConsulter.sommeDepenses.setText(montant + " FCFA");
			break;
		case "cheque":
			String requete2 = " select * from depenses where dateDepense between '" + dateDebut + "' and '" + dateFin
					+ "' and id_typeDep =2";
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
				listeDepenses[i][2] = response1.getDate("dateDepense");
				i++;
			}
			FenetreConsulter.lblTotalDepenses.setVisible(true);
			FenetreConsulter.sommeDepenses.setText(montant + " FCFA");
			break;
		}
		if (listeDepenses.length == 0) {
			JOptionPane.showMessageDialog(null, "Aucune depense n'a ete enregistre durant cette periode");
		}
		return listeDepenses;
	}

}
