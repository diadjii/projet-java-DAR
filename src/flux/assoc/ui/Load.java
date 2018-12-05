package flux.assoc.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Cursor;
import javax.swing.border.LineBorder;

public class Load extends JFrame {

	private JPanel contentPane;

	public Load() throws SQLException {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 699, 159);
		contentPane = new JPanel();
		setVisible(true);
		contentPane.setBackground(new Color(255, 204, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
//		setUndecorated(true);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 51));
		panel.setBounds(0, 0, 683, 120);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Demarrer");
		btnNewButton.setBounds(203, 73, 221, 36);
		panel.add(btnNewButton);
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 51), 1, true));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setForeground(new Color(255, 204, 51));
		btnNewButton.setBackground(new Color(0, 0, 51));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				try {
					new FenetreConexion().setVisible(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));

		JLabel lblB = new JLabel("BIENVENUE DANS Financial Management");
		lblB.setBackground(new Color(255, 204, 51));
		lblB.setBounds(34, 11, 617, 51);
		panel.add(lblB);
		lblB.setForeground(new Color(0, 0, 51));
		lblB.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));
		btnNewButton.setVisible(true);

	}
}
