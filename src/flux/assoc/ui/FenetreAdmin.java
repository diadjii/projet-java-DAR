package flux.assoc.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Cursor;

public class FenetreAdmin extends FenetrePrincipale {
	/**
	 * Create the panel.
	 * 
	 * @throws SQLException
	 */
	public FenetreAdmin() throws SQLException {
		setUserRole(1);
		FenetrePrincipale.iconUser.setVisible(true);
		JLabel lblNewLabel = new JLabel(" Membres");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				try {
					new FenetreMembres().setVisible(true);
					FenetrePrincipale.iconUser.setVisible(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		iconHome.setVisible(true);
		lblAcceuil.setVisible(true);
		
		lblNewLabel.setForeground(new Color(51, 0, 102));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(87, 336, 80, 52);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(" Utilisateurs");
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				try {
					new FenetreUtilisateurs().setVisible(true);
					FenetrePrincipale.iconUser.setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		if (existeMessage()) {
			if (getUserRole() == 1) {
				iconSMS.setVisible(true);
				iconSMS.setEnabled(true);
			}
		} else {
			iconSMS.setVisible(true);
			iconSMS.setEnabled(false);
		}
		lblNewLabel_1.setForeground(new Color(51, 0, 102));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(267, 346, 99, 44);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Nouvelles Recettes/Depenses");
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				try {
					new FenetreRecettes(getUserRole()).setVisible(true);
					FenetrePrincipale.iconUser.setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		if (existeMessage()) {
			iconSMS.setVisible(true);
			iconSMS.setEnabled(true);
		} else {
			iconSMS.setVisible(true);
			iconSMS.setEnabled(false);
		}
		lblNewLabel_2.setForeground(new Color(51, 0, 102));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(425, 341, 230, 52);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Consulter Recettes/Depenses");
		lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				try {
					new FenetreConsulter(getUserRole()).setVisible(true);
					FenetrePrincipale.iconUser.setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		lblNewLabel_3.setForeground(new Color(51, 0, 102));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(703, 346, 239, 39);
		getContentPane().add(lblNewLabel_3);

		JLabel label = new JLabel("");
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.setIcon(new ImageIcon(FenetreAdmin.class.getResource("/images/icons8_User_Groups_96px.png")));
		label.setBounds(77, 256, 131, 110);
		getContentPane().add(label);

		JLabel label_1 = new JLabel("");
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.setIcon(new ImageIcon(FenetreAdmin.class.getResource("/images/icons8_Person_96px.png")));
		label_1.setBounds(263, 243, 114, 132);
		getContentPane().add(label_1);

		JLabel label_2 = new JLabel("");
		label_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_2.setIcon(new ImageIcon(FenetreAdmin.class.getResource("/images/icons8_Money_Bag_100px_2.png")));
		label_2.setBounds(456, 243, 164, 110);
		getContentPane().add(label_2);

		JLabel label_3 = new JLabel("");
		label_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_3.setIcon(new ImageIcon(FenetreAdmin.class.getResource("/images/icons8_Combo_Chart_100px_2.png")));
		label_3.setBounds(733, 230, 136, 132);
		getContentPane().add(label_3);

		JLabel lblNewLabel_4 = new JLabel("Administrateur");
		lblNewLabel_4.setForeground(new Color(51, 0, 102));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel_4.setBounds(316, 131, 323, 89);
		getContentPane().add(lblNewLabel_4);
		this.setVisible(true);

	}

}
