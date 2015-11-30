package interfaceGraphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class InterfaceGraphique extends JPanel implements ActionListener,
		ListSelectionListener {

	public InterfaceGraphique() {
		JPanel premierCadre = new JPanel(); // le premier cadre
		premierCadre.setPreferredSize(new Dimension(300, 50)); // dim du premier
																// cadre
		setLayout(new SpringLayout());

		// premierCadre.setLayout(new BorderLayout());

		premierCadre.setBackground(Color.RED);

		JLabel nomS = new JLabel("Nom :"); // ajout du mot nom
		premierCadre.add(nomS);

		JTextField nom = new JTextField(5); // ajout case de remplissage nom
		premierCadre.add(nom);
		//

		JLabel prenomS = new JLabel("Prenom :"); // ajout du mot nom
		premierCadre.add(prenomS, SpringLayout.SOUTH);

		JTextField prenom = new JTextField(5); // ajout case de remplissage nom
		premierCadre.add(prenom, SpringLayout.SOUTH);

		JLabel valeurS = new JLabel("Valeur :"); // ajout du mot nom
		premierCadre.add(valeurS);

		JTextField valeur = new JTextField(5); // ajout case de remplissage nom
		premierCadre.add(valeur);
		//

		JLabel codeS = new JLabel("Code :"); // ajout du mot nom
		premierCadre.add(codeS, SpringLayout.SOUTH);

		JTextField code = new JTextField(5); // ajout case de remplissage nom
		premierCadre.add(code, SpringLayout.SOUTH);

		setBackground(Color.BLUE);

		add(premierCadre); // ajoute du premier cadre dans al fenetre
	}

	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	public static class MyFrame extends JFrame {

		public MyFrame() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(640, 400);

			// ajout d'un panel dans la frame
			getContentPane().add(new InterfaceGraphique());
			setLocationRelativeTo(null);
		}
	}

	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.setBackground(Color.BLUE);
		frame.setVisible(true);
	}

}
