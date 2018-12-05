package flux.assoc.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import flux.assoc.exception.SyntaxeException;
import flux.assoc.metier.AccesBD;
import flux.assoc.metier.Administrateurs;
import flux.assoc.metier.Financiers;
import flux.assoc.metier.Utilisateurs;
import flux.assoc.ui.FenetreAdmin;
import flux.assoc.ui.FenetreUtilisateurs;

/**
 * 
 * @author king
 *
 */
public class ListenerUtilisateurs extends MouseAdapter {
	private FenetreUtilisateurs fenetreUser;

	public ListenerUtilisateurs(FenetreUtilisateurs fn) {
		this.fenetreUser = fn;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getSource().equals(fenetreUser.getBtnAjouterUtilisateur())) {
			fenetreUser.panelAddUser.setVisible(true);
			fenetreUser.panelDeleteUser.setVisible(false);
			fenetreUser.panelEditUser.setVisible(false);
		}

		if (e.getSource().equals(fenetreUser.getBtnDeleteUser())) {
			fenetreUser.panelAddUser.setVisible(false);
			fenetreUser.panelDeleteUser.setVisible(true);
			fenetreUser.panelEditUser.setVisible(false);
		}

		if (e.getSource().equals(fenetreUser.getBtnChangeRole())) {
			fenetreUser.panelAddUser.setVisible(false);
			fenetreUser.panelDeleteUser.setVisible(false);
			fenetreUser.panelEditUser.setVisible(true);
		}

		// ajout d'un utilisateur
		if (e.getSource().equals(fenetreUser.getBtnAddUser())) {
			String login = fenetreUser.getLogin().getText();
			String password = fenetreUser.getPassword().getText();
			try {
				if (isExist(login)) {
					JOptionPane.showMessageDialog(null,
							"Désolez, ce login existe deja.\n Veuillez choisir un autre SVP !", "Erreur Connexion",
							JOptionPane.WARNING_MESSAGE);
				} else {
					if (isCorrectLogin(login)) {

						if (isCorrectPassWord(password)) {
							int index = fenetreUser.getTypeUser().getSelectedIndex();
							switch (index) {
							case 0:
								Financiers financier = new Financiers(login, password);
								Financiers.ajouterFinanciers(financier);
								JOptionPane.showMessageDialog(null, "Financier ajouté avec Success",
										"Ajout d'un Financier", JOptionPane.INFORMATION_MESSAGE);
								fenetreUser.getLogin().setText("");
								fenetreUser.getPassword().setText("");
								fenetreUser.setVisible(false);
								new FenetreAdmin().setVisible(true);
								break;
							case 1:
								String sha1 = org.apache.commons.codec.digest.DigestUtils.sha256Hex(password);
								Administrateurs admin = new Administrateurs(login, sha1);
								admin.ajouterAdministrateurs();
								JOptionPane.showMessageDialog(null, "Administrateur ajouté avec Success",
										"Ajout d'un Administrateur", JOptionPane.INFORMATION_MESSAGE);
								fenetreUser.getLogin().getText();
								fenetreUser.getPassword().getText();
								fenetreUser.setVisible(false);
								new FenetreAdmin().setVisible(true);

								break;
							}
						} else {
							JOptionPane.showMessageDialog(null,
									"Ouups!! Désolez le mot de passe doit avoir au moins 6 caractéres ",
									"Erreur longueur Mot de Passe", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Ouups!! Désolez le login doit avoir au moins 6 caractéres ", "Erreur longueur Login",
								JOptionPane.ERROR);
					}
				}
			} catch (SQLException | SyntaxeException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}

		// supprimer un utilisateur
		if (e.getSource().equals(fenetreUser.getBtnSupprimer())) {
			Object[][] liste = fenetreUser.getListe();
			boolean fait = false;
			for (int i = 0; i < liste.length; i++) {
				if (liste[i][3].equals(true)) {
					int id = (int) liste[i][0];
					try {
						Utilisateurs.deleteUSer(id);
						fait = true;
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
			if (fait) {
				JOptionPane.showMessageDialog(null, "Utilisateur(s) supprime(s) avec Succes !!",
						"Suppression Utilisateur", JOptionPane.INFORMATION_MESSAGE);
				fenetreUser.setVisible(false);
				try {
					new FenetreAdmin().setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Veuillez cocher les Utilisateurs à supprimer",
						"Suppression Utilisatuers", JOptionPane.WARNING_MESSAGE);
			}
		}

		// modification role utilisateur
		if (e.getSource().equals(fenetreUser.getBtnModifier())) {
			Object[][] liste = fenetreUser.getListe();
			boolean fait = false;
			if (liste.length > 0) {
				for (int i = 0; i < liste.length; i++) {
					if (liste[i][3].equals(true)) {
						int id = (int) liste[i][0];

						if (liste[i][2].equals("Administrateur")) {
							try {
								Administrateurs.modifierRoleAdminFina(id);
								fait = true;
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
						} else {
							try {
								Financiers.modifierRoleFinaAdmin(id);
								fait = true;
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
						}
					}
				}
				if (fait) {
					try {
						JOptionPane.showMessageDialog(null, "L'utilisateur(s) ont changé de role ", "Modification Role",
								JOptionPane.INFORMATION_MESSAGE);
						fenetreUser.setVisible(false);
						new FenetreAdmin().setVisible(true);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Veuillez cocher les Utilisateurs dont  vous voulez changer leur role", "Modification Role",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	}

	// controle si le mot de passe est correct
	private boolean isCorrectPassWord(String password) throws SyntaxeException {
		if (password.length() < 6) {
			return false;
		} else {
			return true;
		}
	}

	// controle si le login est correct
	public boolean isCorrectLogin(String login) {
		if (login.length() < 6) {
			return false;
		} else {
			return true;
		}
	}

	// verifie si le login n'existe pas deja
	private boolean isExist(String login) throws SQLException {
		AccesBD connect = new AccesBD();
		String requete = "SELECT * FROM utilisateurs where login='" + login + "'";
		ResultSet response = connect.doQuery(requete);
		if (response.next()) {
			connect.deconnection();
			return true;
		} else {
			connect.deconnection();
			return false;
		}
	}
}
