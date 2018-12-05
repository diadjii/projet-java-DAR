package flux.assoc.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import flux.assoc.metier.AccesBD;
import flux.assoc.metier.Membres;
import flux.assoc.metier.ModelTableau;

@SuppressWarnings("serial")
public class FenetreViewMessage extends FenetrePrincipale {
	String title[] = { "Identifiant", "Prénom", "Nom" };
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public FenetreViewMessage(Object[][] listeMembre) throws SQLException, NullPointerException {
		iconHome.setVisible(true);
		lblAcceuil.setVisible(true);
		iconSMS.setVisible(false);
		if (listeMembre.length == 0) {
			JOptionPane.showMessageDialog(null, "Aucun Message Reçu");
		} else {
			scrollPane = new JScrollPane(listes(listeMembre));
		}
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(141, 221, 720, 365);
		getContentPane().add(scrollPane);

		JLabel lblListeDesMembres = new JLabel("Liste des Membres \u00E0 Cr\u00E9er");
		lblListeDesMembres.setBackground(new Color(255, 255, 255));
		lblListeDesMembres.setForeground(new Color(0, 0, 51));
		lblListeDesMembres.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblListeDesMembres.setBounds(319, 133, 319, 25);
		getContentPane().add(lblListeDesMembres);

		JButton btnNewButton = new JButton("Creer Membre(s)");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int id[] = new int[listeMembre.length];
				for (int i = 0; i < listeMembre.length; i++) {
					id[i] = (int) listeMembre[i][0];

				}
				try {
					Membres.addMembre(id);
					AccesBD connect = new AccesBD();
					String requete = "Update messages set etat=1 where id_dest=0";
					String envoi = "select * from messages where etat=0";
					connect.doUpdate(requete);
					ResultSet res = connect.doQuery(envoi);
					while (res.next()) {
						String req = "insert into messages (id_sc,id_dest,contenu,etat) values(0,1,'',0)";
						connect.doUpdate(req);
					}
					System.out.println("ok");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(new Color(0, 25, 51));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(400, 602, 158, 23);
		getContentPane().add(btnNewButton);
	}

	public void addMembres() {

	}

	public JTable listes(Object[][] liste) {
		JTable table1 = new JTable(liste, title);
		table1.setRowHeight(20);
		ModelTableau zModel = new ModelTableau(liste, title);
		table = new JTable(zModel);
		table.setForeground(new Color(0, 0, 51));
		table.setGridColor(new Color(255, 102, 51));

		return table;
	}
}