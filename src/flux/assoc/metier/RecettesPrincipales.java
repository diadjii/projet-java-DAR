package flux.assoc.metier;

import java.sql.SQLException;

public class RecettesPrincipales extends Recettes {

	private int categorie;

	public int getCategorie() {
		return categorie;
	}

	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}

	public RecettesPrincipales(double montant, String date, int categorie) {
		super(montant, date);
		this.categorie = categorie;
	}

	public static void addRecettePrincipale(RecettesPrincipales recette, int idMembre, int idTypeRecette)
			throws SQLException {
		String requete = " insert into recettes (identite,montant,dateVersement,categorie,id_typeRec) values ("
				+ idMembre + "," + recette.getMontant() + ",'" + recette.getDate() + "'," + recette.getCategorie() + ","
				+ idTypeRecette + ")";
		AccesBD connect = new AccesBD();
		connect.doUpdate(requete);
		connect.deconnection();

	}

}
