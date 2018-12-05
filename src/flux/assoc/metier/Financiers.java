package flux.assoc.metier;

import java.sql.ResultSet;
import java.sql.SQLException;

import flux.assoc.exception.SyntaxeException;

public class Financiers extends Utilisateurs {

	public Financiers(String login, String passWord) throws SyntaxeException {
		super(login, passWord);
	}

	public static void ajouterFinanciers(Financiers fin) throws SQLException {
		String login = fin.getLogin();
		String password = fin.getPassword();
		String requete = "INSERT INTO utilisateurs (login,password,role) values('" + login + "','" + password + "',2)";
		AccesBD connect = new AccesBD();
		connect.doUpdate(requete);
		connect.deconnection();
	}

	public static void modifierRoleFinaAdmin(int id_financier) throws SQLException {
		AccesBD connect = new AccesBD();
		String requete = "UPDATE utilisateurs SET role = 1 where id_user=" + id_financier;
		connect.doUpdate(requete);
		connect.deconnection();
	}

	public static void envoieMessage(String login, int idDest, String message) throws SQLException {
		AccesBD connect = new AccesBD();
		String req = "select id_user from utilisateurs where login='" + login + "'";
		ResultSet res = connect.doQuery(req);
		int idSource = 0;
		if (res.next()) {
			idSource = res.getInt("id_user");
		}
		String requete = "INSERT INTO messages (id_sc,id_dest,contenu,etat) value(" + idSource + "," + idDest + ",'"
				+ message + "',0)";
		connect.doUpdate(requete);
		connect.deconnection();
	}

}