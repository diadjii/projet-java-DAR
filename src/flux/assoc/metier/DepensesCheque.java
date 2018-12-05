package flux.assoc.metier;

import java.sql.SQLException;

public class DepensesCheque extends Depenses {
	private int numCheque;
	private String beneficiaire;

	public DepensesCheque(String motif, int montant, String date, int numCheque, String beneficiaire) {
		super(motif, montant, date);
		setNumCheque(numCheque);
		setBeneficiaire(beneficiaire);
	}

	public int getNumCheque() {
		return numCheque;
	}

	public void setNumCheque(int numCheque) {
		this.numCheque = numCheque;
	}

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

	public static void enregistrerDepenseCheque(DepensesCheque dep) throws SQLException {
		AccesBD connect = new AccesBD();
		String requete = "INSERT INTO depenses (motif,montant,beneficiare,numCheque,id_typeDep) values('"
				+ dep.getMotif() + "'," + dep.getMontant() + ",'" + dep.getBeneficiaire() + "'," + dep.getNumCheque()
				+ ",2)";
		connect.doUpdate(requete);
		connect.deconnection();

	}
}
