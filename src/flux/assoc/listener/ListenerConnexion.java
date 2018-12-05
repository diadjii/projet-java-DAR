package flux.assoc.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import flux.assoc.metier.Utilisateurs;
import flux.assoc.ui.FenetreConexion;

public class ListenerConnexion extends MouseAdapter {
	private FenetreConexion FenetreConexion;

	public ListenerConnexion(FenetreConexion fn) {
		
		this.FenetreConexion=fn;
		
		}
	
	public void mouseClicked(MouseEvent e) {
		if(e.getSource().equals(FenetreConexion.getBtnNewButton())) {
			String login =FenetreConexion.getLogin().getText();
			String passwd=FenetreConexion.getPassword().getText();
//			System.out.println(login+" "+passwd);
			boolean ok=Utilisateurs.connecter(login,passwd);
			if(ok) {
				FenetreConexion.setVisible(false);
			}
			
		}
		
	}


}
