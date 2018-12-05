
package flux.assoc.metier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import flux.assoc.ui.FenetreMembres;

/**
 * @author diadji
 *
 */
public class Membres extends Contributeurs {
	private String prenom;
	private String dateNaiss;
	private String dateEntree;

	/**
	 * 
	 */
	public Membres(String nomM, String prenomM, String dateNaissM, String dateEntreeM, String adresseM) {
		super(nomM, adresseM);
		setPrenom(prenomM);
		setDateNaiss(dateNaissM);
		setDateEntree(dateEntreeM);
		// if (info != null) {
		// FenetreMembres.info.setText(info);
		// }
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
		info += "Un nom ne doit contenir que des lettres de l'Alphabet .\n";
	}

	public String getDateNaiss() {
		return dateNaiss;
	}

	public void setDateNaiss(String dateNaiss) {
		this.dateNaiss = dateNaiss;
	}

	public String getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(String dateEntree) {

		this.dateEntree = dateEntree;
	}


	public static void addMembre(Membres membre) throws SQLException {
		AccesBD connect = new AccesBD();
		System.out.println(membre.getDateNaiss());
		String requete = "INSERT INTO membres (nom,prenom,adresse,dateNaiss,dateEntree) values('" + membre.getNom()
				+ "','" + membre.getPrenom() + "','" + membre.getAdresse() + "','" + membre.getDateNaiss() + "','"
				+ membre.getDateEntree() + "')";
		connect.doUpdate(requete);
		JOptionPane.showMessageDialog(null, "Membre ajouter avec succes");
		connect.deconnection();

	}

	public static void addMembre(int[] ids) throws SQLException {
		AccesBD connect = new AccesBD();
		for (int i = 0; i < ids.length; i++) {
			String requete = "update membres set etat=1 where id_membre=" + ids[i] + "";
			connect.doUpdate(requete);
		}
		System.out.println("Les membres ont ete ajouter avec succes");
	}

	public static void addMembreAttente(Membres membre) throws SQLException {
		AccesBD connect = new AccesBD();
		String requete = "INSERT INTO membres (nom,prenom,adresse,dateEntree,dateNaiss,etat) values('" + membre.getNom()
				+ "','" + membre.getPrenom() + "','" + membre.getAdresse() + "','" + membre.getDateEntree() + "','"
				+ membre.getDateNaiss() + "',3)";
		connect.doUpdate(requete);
		JOptionPane.showMessageDialog(null, "Envoi Message reussit");
		connect.deconnection();

	}

	public static void desactiveMembre(Membres membre) {

	}

	public static Object[][] listeMembres(String type) throws SQLException {
		String requete = "";
		int nbreLignes = 0;
		int i = 0;
		AccesBD connect = new AccesBD();
		ResultSet resultat;
		Object[][] listeMembres = null;
		switch (type) {
		case "Désactiver":

			requete = "SELECT * FROM membres where etat=1";
			resultat = connect.doQuery(requete);
			while (resultat.next()) {
				nbreLignes++;
			}
			resultat.beforeFirst();
			listeMembres = new Object[nbreLignes][5];

			while (resultat.next()) {
				listeMembres[i][0] = resultat.getInt("id_membre");
				listeMembres[i][1] = resultat.getString("nom");
				listeMembres[i][2] = resultat.getString("prenom");
				listeMembres[i][3] = "Activer";
				listeMembres[i][4] = new Boolean(false);
				i++;
			}
			break;
		case "Réactiver":
			requete = "SELECT * FROM membres where etat=0";
			resultat = connect.doQuery(requete);
			while (resultat.next()) {
				nbreLignes++;
			}
			resultat.beforeFirst();
			listeMembres = new Object[nbreLignes][5];
			while (resultat.next()) {
				listeMembres[i][0] = resultat.getInt("id_membre");
				listeMembres[i][1] = resultat.getString("nom");
				listeMembres[i][2] = resultat.getString("prenom");
				listeMembres[i][3] = "Désactiver";
				listeMembres[i][4] = new Boolean(false);
				i++;
			}
			break;
		case "liste":
			requete = "SELECT * FROM membres where etat=1";
			resultat = connect.doQuery(requete);
			while (resultat.next()) {
				nbreLignes++;
			}
			resultat.beforeFirst();
			listeMembres = new Object[nbreLignes][4];
			while (resultat.next()) {
				listeMembres[i][0] = resultat.getInt("id_membre");
				listeMembres[i][1] = resultat.getString("nom");
				listeMembres[i][2] = resultat.getString("prenom");
				i++;
			}
			break;
		}
		return listeMembres;
	}

}
