package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class HomeIF extends JFrame {

	private JPanel HomeContentPane;
	private JButton OrdineStandardButton;
	private JButton OrdinePersonalizzatoButton;

	/**
	 * Create the frame.
	 */
	public HomeIF(String utente) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		HomeContentPane = new JPanel();
		HomeContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(HomeContentPane);
		HomeContentPane.setLayout(null);

		JLabel HomeLabel = new JLabel("HOME");
		HomeLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		HomeLabel.setBounds(176, 11, 79, 39);
		HomeContentPane.add(HomeLabel);

		JLabel UserLabel = new JLabel("User: ");
		UserLabel.setBounds(10, 11, 41, 14);
		HomeContentPane.add(UserLabel);

		JLabel UserInLabel = new JLabel(utente);
		UserInLabel.setBounds(46, 11, 72, 14);
		HomeContentPane.add(UserInLabel);

		OrdineStandardButton = new JButton("Ordine Standard");
		OrdineStandardButton.setForeground(new Color(255, 255, 255));
		OrdineStandardButton.setBackground(new Color(0, 128, 255));
		OrdineStandardButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		OrdineStandardButton.setBounds(126, 72, 159, 23);
		HomeContentPane.add(OrdineStandardButton);

		OrdinePersonalizzatoButton = new JButton("Ordine Personalizzato");
		OrdinePersonalizzatoButton.setForeground(new Color(255, 255, 255));
		OrdinePersonalizzatoButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		OrdinePersonalizzatoButton.setBackground(new Color(0, 128, 255));
		OrdinePersonalizzatoButton.setBounds(126, 114, 159, 23);
		HomeContentPane.add(OrdinePersonalizzatoButton);
	}

	public void openNuovoOrdineIF(ActionListener listener) {
		OrdineStandardButton.addActionListener(listener);
	}

	public void openOrdinePersonalizzato(ActionListener listener) {
		OrdinePersonalizzatoButton.addActionListener(listener);
	}
}