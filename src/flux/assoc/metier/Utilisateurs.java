package flux.assoc.metier;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import flux.assoc.exception.SyntaxeException;
import flux.assoc.ui.FenetreAdmin;
import flux.assoc.ui.FenetreFinancier;
import flux.assoc.ui.FenetrePrincipale;

public abstract class Utilisateurs {
	protected String login;
	protected String password;

	public Utilisateurs(String login, String password) throws SyntaxeException {
		setLogin(login);
		setPassword(password);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) throws SyntaxeException {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws SyntaxeException {
		this.password = password;
	}

	public static void deleteUSer(int admin) throws SQLException {
		AccesBD connect = new AccesBD();
		String requete = "DELETE from utilisateurs where id_user =" + admin;
		connect.doUpdate(requete);
		connect.deconnection();
	}

	public static Object[][] listeUtilisateurs() throws SQLException {
		String requete = "";
		int nbreLignes = 0;
		int i = 0;
		AccesBD connect = new AccesBD();
		ResultSet resultat;
		Object[][] listeMembres = null;
		requete = "SELECT * FROM utilisateurs";
		resultat = connect.doQuery(requete);
		while (resultat.next()) {
			nbreLignes++;
		}
		resultat.beforeFirst();
		listeMembres = new Object[nbreLignes][4];

		while (resultat.next()) {
			listeMembres[i][0] = resultat.getInt("id_user");
			listeMembres[i][1] = resultat.getString("Login");
			if (resultat.getInt("role") == 1) {
				listeMembres[i][2] = "Administrateur";
			} else {
				listeMembres[i][2] = "Financier";
			}
			listeMembres[i][3] = new Boolean(false);
			i++;
		}
		return listeMembres;
	}

	public static Boolean connecter(String login, String mdp) {
		AccesBD connect = new AccesBD();
		String requete = "Select * from utilisateurs where login='" + login + "'";
		boolean ok = false;

		try {
			ResultSet resultat = connect.doQuery(requete);
			if (resultat.next()) {
				String sha1 = org.apache.commons.codec.digest.DigestUtils.sha256Hex(mdp);
				if (resultat.getString("password").equals(sha1)) {
					String userLogin = resultat.getString("login");
					if (resultat.getInt("role") == 1) {
						FenetrePrincipale.userLogin.setText(userLogin);
						FenetrePrincipale.userRole = 1;
						FenetreAdmin f = new FenetreAdmin();
						f.setVisible(true);
						ok = true;
					} else {
						FenetrePrincipale.userLogin.setText(userLogin);
						FenetreFinancier f = new FenetreFinancier();
						f.setVisible(true);
						ok = true;
					}
				} else {
					JOptionPane.showMessageDialog(null, "Veillez Verifier votre Mot de passe");
					ok = false;
				}
			} else {
				JOptionPane.showMessageDialog(null, "Veillez verifier votre Login");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connect.deconnection();
		}
		return ok;
	}
}
