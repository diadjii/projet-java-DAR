package flux.assoc.metier;

import java.sql.SQLException;

public class DepensesEspece extends Depenses {

	public DepensesEspece(String motif, int montant, String dateDepense) {
		super(motif, montant, dateDepense);
	}

	public static void enregistrerDepenseEspece(DepensesEspece dep) throws SQLException {
		AccesBD connect = new AccesBD();
		String requete = "INSERT INTO depenses (motif,montant,id_typeDep) values('" + dep.getMotif() + "',"
				+ dep.getMontant() + "," + "1)";
		connect.doUpdate(requete);
		connect.deconnection();

	}

	public static void consulterDepenseEspece(String requete) throws SQLException {
		AccesBD connect = new AccesBD();
		connect.doQuery(requete);
		connect.deconnection();
	}
}
