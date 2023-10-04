package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PagamentoIF extends JFrame {

	private JPanel PagamentoContentPane;
	private JTextField NumeroCartaField;
	private JTextField DataScadenzaField;
	private JButton PagamentoButton;

	/**
	 * Create the frame.
	 */
	public PagamentoIF() {
		setBounds(100, 100, 386, 300);
		PagamentoContentPane = new JPanel();
		PagamentoContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(PagamentoContentPane);
		PagamentoContentPane.setBackground(new Color(255, 180, 180));
		PagamentoContentPane.setLayout(null);

		JLabel PagamentoLabel = new JLabel("PAGAMENTO"); // etichetta pagamento
		PagamentoLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		PagamentoLabel.setBounds(118, 0, 198, 58);
		PagamentoContentPane.add(PagamentoLabel);

		JLabel NumeroCartaLabel = new JLabel("Numero Carta"); // etichetta numero carta
		NumeroCartaLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		NumeroCartaLabel.setBounds(10, 84, 110, 24);
		PagamentoContentPane.add(NumeroCartaLabel);

		NumeroCartaField = new JTextField(); // campo di testo
		NumeroCartaField.setBounds(118, 86, 215, 20);
		PagamentoContentPane.add(NumeroCartaField);
		NumeroCartaField.setColumns(10);

		JLabel DataScadenzaLabel = new JLabel("Data Scadenza"); // etichetta scadenza
		DataScadenzaLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		DataScadenzaLabel.setBounds(10, 133, 110, 14);
		PagamentoContentPane.add(DataScadenzaLabel);

		DataScadenzaField = new JTextField(); // campo di testo
		DataScadenzaField.setBounds(120, 130, 86, 20);
		PagamentoContentPane.add(DataScadenzaField);
		DataScadenzaField.setColumns(10);

		PagamentoButton = new JButton("Conferma"); // bottone conferma
		PagamentoButton.setForeground(new Color(255, 255, 255));
		PagamentoButton.setBackground(new Color(255, 80, 120));
		PagamentoButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		PagamentoButton.setBounds(118, 181, 89, 23);
		PagamentoContentPane.add(PagamentoButton);
	}

	// ritorno dati inseriti dall'utente

	public JTextField getNumeroCartaField() {
		return NumeroCartaField;
	}

	public JTextField getDataScadenzaField() {
		return DataScadenzaField;
	}

	public void pagamento(ActionListener listener) {
		PagamentoButton.addActionListener(listener);
	}

}
