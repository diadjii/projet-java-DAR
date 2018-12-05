package flux.assoc.metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class AccesBD {
	private Connection connexion = null;

	public AccesBD() {
		this.connection();
	}

	public AccesBD(String path, String dbName, String username, String password, String type) {
		this.connection(path, dbName, username, password, type);
	}

	public void doUpdate(String requete) throws SQLException {
		autoCommit(false);
		try {
			Statement req = null;
			req = connexion.createStatement();
			req.executeUpdate(requete);
			commit();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erreur enregistrement" + e.getMessage());
			rollBack();
		} finally {
			autoCommit(true);
		}
	}

	public ResultSet doQuery(String requete) throws SQLException {
		ResultSet res = null;

		autoCommit(false);
		try {
			Statement req = null;
			req = connexion.createStatement();
			req = connexion.createStatement();
			res = req.executeQuery(requete);
			commit();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erreur enregistrement" + e.getMessage());
			rollBack();
		} finally {
			autoCommit(true);
		}
		return res;
	}

	private void connection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://localhost/gestion_flux", "root", "");
		} catch (ClassNotFoundException e) {
			System.out.println("Connextion echouée");
		} catch (SQLException e) {
			System.out.println("Erreur de requete ");
		}
	}

	private void connection(String path, String dbName, String username, String password, String typeBD) {
		try {
			Class.forName("com." + typeBD + ".jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:" + typeBD + "://" + path + dbName, username, password + "");
		} catch (ClassNotFoundException e) {
			System.out.println("Connextion echouée");
		} catch (SQLException e) {
			System.out.println("Erreur de requete ");
		}
	}

	public void deconnection() {
		if (connexion != null) {
			try {
				connexion.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private void commit() {
		try {
			connexion.commit();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	private void autoCommit(boolean n) {
		try {
			connexion.setAutoCommit(n);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	private void rollBack() {
		try {
			connexion.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
