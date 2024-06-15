package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class SaidaFrame extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextArea texto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SaidaFrame dialog = new SaidaFrame();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SaidaFrame() {
		// Defina as dimensões da janela (exemplo)
		setBounds(100, 100, 450, 300);
		setModal(false);
		// Crie o JTextArea e adicione-o à janela
		texto = new JTextArea();
		add(texto);

	}

}
