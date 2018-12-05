package flux.assoc.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import flux.assoc.metier.Financiers;
import flux.assoc.metier.Membres;
import flux.assoc.ui.FenetreFinancier;
import flux.assoc.ui.FenetreMessage;
import flux.assoc.ui.FenetrePrincipale;

public class ListenerMessage extends MouseAdapter {
	private FenetreMessage fenetreMessage;

	public ListenerMessage(FenetreMessage fn) {
		this.fenetreMessage = fn;
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(fenetreMessage.btnEnvoyer)) {
			String nom = fenetreMessage.getNomMembre().getText();
			String prenom = fenetreMessage.getPrenomMembre().getText();
			SimpleDateFormat dateD = new SimpleDateFormat("yyyy-MM-dd");
			String dateNaiss = dateD.format(fenetreMessage.getDateNaissMembre().getDate());
			String dateEntree = dateD.format(fenetreMessage.getDateEntreeMembre().getDate());
			String adresse = fenetreMessage.getAdresseMembre().getText();
			Membres membre = new Membres(nom, prenom, dateNaiss, dateEntree, adresse);
			try {
				Membres.addMembreAttente(membre);
				Financiers.envoieMessage(FenetrePrincipale.userLogin.getText(), 0, "Ajout d un Membre");
				fenetreMessage.setVisible(false);
				new FenetreFinancier().setVisible(true);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

}
