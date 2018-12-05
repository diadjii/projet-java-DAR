package flux.assoc.metier;

import java.sql.ResultSet;
import java.sql.SQLException;

import flux.assoc.exception.SyntaxeException;

public class Administrateurs extends Financiers {
	private static int id_user;

	public Administrateurs(String login, String passWord) throws SyntaxeException {
		super(login, passWord);
	}

	@SuppressWarnings("unused")
	public void ajouterAdministrateurs() throws SQLException {
		String login = this.getLogin();
		String password = this.getPassword();
		String requete = "INSERT INTO utilisateurs (login,password,role) values('" + login + "','" + password + "',1)";
		AccesBD connect = new AccesBD();
		connect.doUpdate(requete);
		connect.deconnection();
	}

	public static void modifierRoleAdminFina(int id_administrateur) throws SQLException {
		AccesBD connect = new AccesBD();
		String requete = "UPDATE utilisateurs SET role = 2 where id_user=" + id_administrateur;
		connect.doUpdate(requete);
		connect.deconnection();
	}

	/**
	 * @return the id_user
	 */

}
