package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import model.Carrello;
import model.Prodotto;

public class VisualizzaOrdineIF extends JFrame {

	private JPanel VisualizzaOrdineContentPane;

	/**
	 * Create the frame.
	 */
	public VisualizzaOrdineIF(Carrello carrello) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(450, 300)); // Imposta le dimensioni minime
		setLocationRelativeTo(null);
		VisualizzaOrdineContentPane = new JPanel();
		VisualizzaOrdineContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(VisualizzaOrdineContentPane);
		VisualizzaOrdineContentPane.setLayout(new BorderLayout()); // Usa BorderLayout

		JLabel VisualizzaOrdineLabel = new JLabel("ORDINE");
		VisualizzaOrdineLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		VisualizzaOrdineLabel.setHorizontalAlignment(JLabel.CENTER); // Centra il testo

		VisualizzaOrdineContentPane.add(VisualizzaOrdineLabel, BorderLayout.NORTH);

		DefaultListModel<Prodotto> listModel = new DefaultListModel<>();
		for (Prodotto prodotto : carrello.getCarrello()) {
			listModel.addElement(prodotto);
		}
		JList<Prodotto> lista = new JList<>(listModel);

		JScrollPane scrollPane = new JScrollPane(lista);
		VisualizzaOrdineContentPane.add(scrollPane, BorderLayout.CENTER);

		setVisible(true);
	}

}
