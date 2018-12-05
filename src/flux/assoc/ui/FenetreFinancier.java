package flux.assoc.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Cursor;

public class FenetreFinancier extends FenetrePrincipale {

	/**
	 * Create the panel.
	 */
	public FenetreFinancier() throws SQLException {
		iconHome.setVisible(true);
		lblAcceuil.setVisible(true);
		setUserRole(2);
		FenetrePrincipale.iconUser.setVisible(true);
		JLabel lblNewLabel_2 = new JLabel("Nouvelles Rec\u00E9ttes/D\u00E9penses");
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				try {
					new FenetreRecettes(getUserRole()).setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		lblNewLabel_2.setForeground(new Color(51, 0, 102));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(182, 383, 230, 45);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Consulter Recettes/D\u00E9penses");
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
		lblNewLabel_3.setBounds(530, 383, 239, 43);
		getContentPane().add(lblNewLabel_3);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(FenetreFinancier.class.getResource("/images/icons8_Money_Bag_100px_2.png")));
		label_2.setBounds(245, 277, 114, 114);
		getContentPane().add(label_2);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(FenetreFinancier.class.getResource("/images/icons8_Combo_Chart_100px_2.png")));
		label_3.setBounds(592, 280, 124, 114);
		getContentPane().add(label_3);

		JLabel lblNewLabel_4 = new JLabel("Financier");
		lblNewLabel_4.setForeground(new Color(51, 0, 102));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel_4.setBounds(412, 131, 224, 89);

		if (existeMessageFinancier(userLogin.getText())) {
			iconSMS.setVisible(true);
			iconSMS.setEnabled(true);
		} else {
			iconSMS.setVisible(true);
			iconSMS.setEnabled(false);
		}
		getContentPane().add(lblNewLabel_4);
		this.setVisible(true);

	}
}
