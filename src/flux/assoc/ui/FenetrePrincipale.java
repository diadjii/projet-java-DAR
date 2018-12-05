package flux.assoc.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import flux.assoc.listener.LisetenerFenetre;
import flux.assoc.metier.AccesBD;
import javax.swing.border.LineBorder;

public class FenetrePrincipale extends JFrame {

	private JPanel contentPane;
	public static JLabel iconUser = new JLabel("");
	public static JLabel userLogin = new JLabel("");
	public static JLabel iconSMS = new JLabel("");
	private boolean connected = false;
	public static int userRole;
	private Object[][] toAdd;
	public final JLabel iconHome = new JLabel("");
	public final JLabel lblAcceuil = new JLabel("Acceuil");
	private final JLabel label = new JLabel("");
	private final JPanel panel_1 = new JPanel();
	private final JLabel lblTousDroitsReservs = new JLabel("Tous droits  reserv\u00E9s   @DAF 2017");

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public FenetrePrincipale() throws SQLException {
		setPreferredSize(new Dimension(800, 500));
		setLocationByPlatform(true);
		setLocation(new Point(100, 5));
		setFocusable(false);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 958, 672);
		setUndecorated(true);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 51));
		panel.setBounds(0, 0, 958, 74);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Financial Management");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setForeground(new Color(0, 0, 51));
		lblNewLabel.setBounds(367, 19, 306, 36);
		panel.add(lblNewLabel);

		iconUser.setIcon(new ImageIcon(FenetrePrincipale.class.getResource("/images/icons8_Male_User_25px.png")));
		iconUser.setBackground(new Color(255, 102, 51));
		iconUser.setVisible(false);
		iconUser.setBounds(37, 38, 30, 33);
		panel.add(iconUser);

		userLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		userLogin.setForeground(new Color(255, 255, 255));
		userLogin.setBackground(new Color(255, 102, 51));
		userLogin.setBounds(67, 46, 164, 25);
		panel.add(userLogin);
		iconHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				if (userRole == 1) {
					try {
						new FenetreAdmin().setVisible(true);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					try {
						new FenetreFinancier().setVisible(true);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		iconHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		iconHome.setIcon(new ImageIcon(FenetrePrincipale.class.getResource("/images/icons8_Home_30px_2.png")));
		iconHome.setBounds(882, 19, 46, 52);

		panel.add(iconHome);
		lblAcceuil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAcceuil.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAcceuil.setForeground(new Color(0, 0, 51));
		lblAcceuil.setBounds(882, 57, 46, 14);
		if (userRole == 1) {

			iconHome.setVisible(true);
			lblAcceuil.setVisible(true);
		} else {
			if (userRole == 2) {
				iconHome.setVisible(true);
				lblAcceuil.setVisible(true);
			} else {
				iconHome.setVisible(false);
				lblAcceuil.setVisible(false);
			}

		}
		iconHome.setVisible(false);
		lblAcceuil.setVisible(false);
		panel.add(lblAcceuil);
		label.setIcon(new ImageIcon(FenetrePrincipale.class.getResource("/images/icons8_Receive_Cash_50px_1.png")));
		label.setBounds(307, 11, 61, 55);
		
		panel.add(label);
		
				JButton btnFermer = new JButton("Fermer");
				btnFermer.setBorder(null);
				btnFermer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnFermer.setForeground(new Color(0, 0, 51));
				btnFermer.setBackground(new Color(255, 204, 51));
				btnFermer.setBounds(869, 0, 89, 23);
				panel.add(btnFermer);
				btnFermer.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						System.exit(-1);
					}
				});
		iconSMS.setEnabled(false);
		iconSMS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				viewMessage();
			}
		});

		iconSMS.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		iconSMS.setIcon(new ImageIcon(FenetrePrincipale.class.getResource("/images/icons8_Envelope_30px.png")));
		iconSMS.setVisible(false);
		iconSMS.setBounds(902, 602, 40, 30);
		contentPane.add(iconSMS);
		panel_1.setBackground(new Color(255, 204, 51));
		panel_1.setBounds(0, 632, 958, 52);
		
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		lblTousDroitsReservs.setForeground(new Color(0, 0, 51));
		lblTousDroitsReservs.setBounds(421, 11, 251, 14);
		
		panel_1.add(lblTousDroitsReservs);

		this.setVisible(true);

		LisetenerFenetre fn = new LisetenerFenetre(this);
		this.addMouseListener(fn);
		this.addMouseMotionListener(fn);
		setLocationRelativeTo(null);
	}

	public String getUserLogin() {
		return userLogin.getText();
	}

	public void setUserLogin(String userLogin) {
		this.userLogin.setText(userLogin);
	}

	public void viewMessage() {
		if (getUserRole() == 1) {
			try {
				if (existeMessage()) {
					setVisible(false);
					new FenetreViewMessage(toAdd);
				} else {
					JOptionPane.showMessageDialog(null, "Aucun Message reçu pour le moment");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			if (getUserRole() == 2) {
				try {
					if (existeMessageFinancier(userLogin.getText())) {
						JOptionPane.showMessageDialog(null,
								"Le(s) nouveau(x) membre(s) ont ete ajoutés avec dans la liste");
						AccesBD connect = new AccesBD();
						String req = "delete from messages where id_dest=1";
						connect.doUpdate(req);
						iconSMS.setEnabled(false);
						connect.deconnection();
					} else {
						JOptionPane.showMessageDialog(null, "Aucun message reçu pour le moment F");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	protected boolean existeMessage() throws SQLException {
		boolean vrai = false;
		AccesBD connect = new AccesBD();
		String requete = "select * from messages where id_dest=0 and etat=0";
		ResultSet response1 = connect.doQuery(requete);
		int nbLignes = 0;
		if (response1.next()) {
			vrai = true;
			String requete2 = "select * from membres where etat=3";
			ResultSet response2 = connect.doQuery(requete2);
			while (response2.next()) {
				nbLignes++;
			}

			response2.beforeFirst();
			toAdd = new Object[nbLignes][3];
			int i = 0;
			while (response2.next()) {
				toAdd[i][0] = response2.getInt("id_membre");
				toAdd[i][1] = response2.getString("prenom");
				toAdd[i][2] = response2.getString("nom");
				i++;
			}
		}
		return vrai;
	}

	protected boolean existeMessageFinancier(String string) throws SQLException {
		boolean vrai = false;
		AccesBD connect = new AccesBD();
		String requete = "select * from messages where id_dest= 1";
		ResultSet res1 = connect.doQuery(requete);
		if (res1.next()) {
			vrai = true;
		} else {
			vrai = false;
		}
		return vrai;
	}

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

	public JLabel getIconSMS() {
		return iconSMS;
	}

	public void setIconSMS(JLabel iconSMS) {
		this.iconSMS = iconSMS;
	}

	public JLabel getUserlogin() {
		return userLogin;
	}

	public void setUserlogin(String userlogin) {
		userLogin.setText(userlogin);
	}

	public int getUserRole() {
		return userRole;
	}

	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}
}
