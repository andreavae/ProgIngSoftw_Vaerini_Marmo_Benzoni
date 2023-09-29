package view;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class HomeIF extends JFrame {

	private JPanel HomeContentPane;
	private JButton NuovoOrdineButton;

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
		HomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		HomeLabel.setBounds(176, 11, 79, 39);
		HomeContentPane.add(HomeLabel);

		JLabel UserLabel = new JLabel("User: ");
		UserLabel.setBounds(10, 11, 41, 14);
		HomeContentPane.add(UserLabel);

		JLabel UserInLabel = new JLabel(utente);
		UserInLabel.setBounds(46, 11, 72, 14);
		HomeContentPane.add(UserInLabel);

		NuovoOrdineButton = new JButton("Nuovo Ordine");
		NuovoOrdineButton.setBounds(151, 72, 117, 23);
		HomeContentPane.add(NuovoOrdineButton);
	}

	public void openNuovoOrdineIF(ActionListener listener) {
		NuovoOrdineButton.addActionListener(listener);
	}
}