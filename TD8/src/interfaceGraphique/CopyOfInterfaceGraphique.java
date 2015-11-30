package interfaceGraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;




import connectionBDD.BDDConnection;
import metier.GererEntree;
import metier.InitialisationAppli;
import domaine.Entree;
import domaine.Numero;


@SuppressWarnings("serial")
public class CopyOfInterfaceGraphique extends JPanel implements ActionListener,
		ListSelectionListener {

	private static CopyOfInterfaceGraphique INSTANCE = null;
	
	// PANNEAU 1
	@SuppressWarnings("rawtypes")
	private static DefaultListModel lm = new DefaultListModel();
	@SuppressWarnings("rawtypes")
	private JList l1 = new JList(lm);
	private JScrollPane p = new JScrollPane(l1);

	// PANNEAU 2

	@SuppressWarnings("rawtypes")
	private static DefaultListModel<Numero> lm2 = new DefaultListModel<Numero>();
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JList l2 = new JList(lm2);
	private JScrollPane p2 = new JScrollPane(l2);

	// PANNEAU 3
	private JPanel p3 = new JPanel();

	private JPanel p31 = new JPanel();
	private JPanel p311 = new JPanel();
	private JPanel p321 = new JPanel();
	private JPanel p32 = new JPanel();

	private JLabel labelNom = new JLabel("Nom :");
	private JTextField textFieldNom = new JTextField();

	private JLabel labelPrenom = new JLabel("Prenom :");
	private JTextField textFieldPrenom = new JTextField();

	private JButton button1 = new JButton("Ajouter");
	private JButton button2 = new JButton("Supprimer");
	private JButton button3 = new JButton("Clear");
	
	private boolean nomEtPrenomPeutEtreSupprimer = true; // permet d'empecher l'écouteur d'essayer de changer la valeur el temps de l'utiliser
	private boolean codeEtValeurPeutEtreSupprimer = true; // permet d'empecher l'écouteur d'essayer de changer la valeur el temps de l'utiliser

	// PANNEAU 4
	private JPanel p4 = new JPanel();

	private JPanel p41 = new JPanel();
	private JPanel p411 = new JPanel();
	private JPanel p421 = new JPanel();
	private JPanel p42 = new JPanel();

	private JLabel labelCode = new JLabel("Code :");
	private JTextField textFieldCode = new JTextField();

	private JLabel labelValeur = new JLabel("Valeur :");
	private JTextField textFieldValeur = new JTextField();

	private JButton button4 = new JButton("Ajouter");
	private JButton button5 = new JButton("Supprimer");
	private JButton button6 = new JButton("Clear");

	/**
	 * instance d'une interface graphique
	 */
	public static CopyOfInterfaceGraphique getInstance(){
		if (INSTANCE == null){
			INSTANCE = new CopyOfInterfaceGraphique();
		}
		return INSTANCE;
	}
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public CopyOfInterfaceGraphique() {

		setLayout(new GridLayout(2, 2));

		// PANNEAU 1


		// p.add(test);
		l1.addListSelectionListener(this); // liste ecran de gauche

		// PANNEAU 2

		// Recuperer la liste et l'afficher

		l2.addListSelectionListener(this); // liste ecran droite

		// PANNEAU 3

		// SpringLayout layoutp3 = new SpringLayout();

		// GridLayout layoutp3 = new GridLayout(10,2);

		BorderLayout layoutp3 = new BorderLayout();

		p3.setLayout(layoutp3);

		p31.setLayout(new GridLayout(2, 1));

		p311.setLayout(new GridLayout(1, 2));

		p311.add(labelNom);
		p311.add(textFieldNom);

		p321.setLayout(new GridLayout(1, 2));

		p321.add(labelPrenom);
		p321.add(textFieldPrenom);

		p31.add(p311);
		p31.add(p321);

		p32.add(button1);
		p32.add(button2);
		p32.add(button3);

		p3.add(p31, BorderLayout.NORTH);
		p3.add(p32, BorderLayout.SOUTH);

		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);

		// PANNEAU 4

		BorderLayout layoutp4 = new BorderLayout();

		p4.setLayout(layoutp4);

		p41.setLayout(new GridLayout(2, 1));

		p411.setLayout(new GridLayout(1, 2));
		p411.add(labelCode);
		p411.add(textFieldCode);

		p421.setLayout(new GridLayout(1, 2));
		p421.add(labelValeur);
		p421.add(textFieldValeur);

		p41.add(p411);
		p41.add(p421);

		p42.add(button4);
		p42.add(button5);
		p42.add(button6);

		p4.add(p41, BorderLayout.NORTH);
		p4.add(p42, BorderLayout.SOUTH);

		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);

		// FIN PANNEAU 4

		p.setBackground(Color.BLUE);
		p2.setBackground(Color.RED);
		p3.setBackground(Color.GREEN);
		p4.setBackground(Color.YELLOW);

		add(p); // ajoute du premier cadre dans al fenetre
		add(p2);
		add(p3);
		add(p4);
	}

	

	public void valueChanged(ListSelectionEvent e) {
		 // Panneau entree
		if (e.getSource()== l1 && nomEtPrenomPeutEtreSupprimer){
			 if (e.getValueIsAdjusting()){
			 return ;
			 }
			 nomEtPrenomPeutEtreSupprimer=false;
			 Entree entree = (Entree) l1.getSelectedValue();
			 
			 InitialisationAppli.initialisationNumero(lm2,entree.getNom(),entree.getPrenom());
			 textFieldNom.setText(entree.getNom());
			 textFieldPrenom.setText(entree.getPrenom());		 
		 }
		 
		 //Panneau valeur+ code
		 if (e.getSource()== l2 ){
			 if (e.getValueIsAdjusting()){
			 return ;
			 }
			 Entree entree = (Entree) l1.getSelectedValue();
			 String mot = entree.getNom();
			 textFieldNom.setText(mot);
			 textFieldPrenom.setText(entree.getPrenom());		 
		 }
	}

	public void actionPerformed(ActionEvent act) {
		// TODO Auto-generated method stub

		// AJOUTER BAS GAUCHE
		if (act.getSource() == button1) {
			String nom = textFieldNom.getText();
			String prenom = textFieldPrenom.getText();
			Entree entree= GererEntree.addEntree(nom,prenom);
			lm.addElement(entree);
			InitialisationAppli.initialisationNumero(lm2,nom, prenom);
			clearNom();

		}
		if (act.getSource() == button2) {
			String nom = textFieldNom.getText();
			String prenom = textFieldPrenom.getText();
			Entree entree= GererEntree.getEntree(nom,prenom); 
			lm.removeElement(entree);
			l1.clearSelection();
			clearNom();
			nomEtPrenomPeutEtreSupprimer=true;
			GererEntree.supprimeEntreeDeLaBDD(entree);
		}
		
		if (act.getSource() == button3) {
			clearNom();
		}
		if (act.getSource() == button4) {
			String nom = textFieldNom.getText();
			String prenom = textFieldPrenom.getText();
			String code = textFieldCode.getText();
			String valeur = textFieldValeur.getText();
			if (nom !="" || prenom != "") {
				InitialisationAppli.ajouterNumero(nom, prenom,code,valeur);
				Numero num =new Numero(BDDConnection.getNumeroPersonne(nom, prenom),code,valeur);
				lm2.addElement(num);
				System.out.println(num.toString()+"bis");
			}
			clearCode();
		}
		if (act.getSource() == button5) {
			String nom = textFieldCode.getText();
			String prenom = textFieldValeur.getText();
			
			clearCode();
		}
		if (act.getSource() == button6) {
			clearCode();
		}

	}

	//vide les champs nom et prenom
	private void clearNom() {
		textFieldNom.setText("");
		textFieldPrenom.setText("");
	}
	
	//vide les champs code et valeur
	private void clearCode() {
		textFieldCode.setText("");
		textFieldValeur.setText("");
	}

	public static class MyFrame extends JFrame {

		@SuppressWarnings("unused")
		public MyFrame() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(640, 400);
			GridLayout grid = new GridLayout(2, 2);
			// ajout d'un panel dans la frame
			getContentPane().add(CopyOfInterfaceGraphique.getInstance());
			setLocationRelativeTo(null);
		}
	}

	
		
	public static void main(String[] args) {
		lm = InitialisationAppli.initialisationEntree();	
		MyFrame frame = new MyFrame();
		frame.setBackground(Color.BLUE);
		frame.setVisible(true);
	}

}
