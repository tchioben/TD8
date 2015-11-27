
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
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



@SuppressWarnings("serial")
public class CopyOfInterfaceGraphique extends JPanel implements ActionListener, ListSelectionListener {

	// PANNEAU 1
	@SuppressWarnings("rawtypes")
	private static DefaultListModel lm = new DefaultListModel();
	@SuppressWarnings("rawtypes")
	private JList l1 = new JList(lm);
	private JScrollPane p = new JScrollPane(l1);
	
	
	
	
	// PANNEAU 2
	
	@SuppressWarnings("rawtypes")
	private DefaultListModel lm2 = new DefaultListModel();
	@SuppressWarnings("rawtypes")
	private JList l2 = new JList(lm2);
	private JScrollPane p2 = new JScrollPane(l2);
	
	
	
	// PANNEAU 3
	private JPanel p3 = new JPanel();

	private JPanel p31= new JPanel();
	private JPanel p311 = new JPanel();
	private JPanel p321 = new JPanel();
	private JPanel p32= new JPanel();
	
	private JLabel labelNom= new JLabel("Nom :");
	private JTextField textFieldNom = new JTextField();
	
	private JLabel labelPrenom = new JLabel("Prenom :");
	private JTextField textFieldPrenom = new JTextField();
	
	private JButton button1 = new JButton("Ajouter");
	private JButton button2 = new JButton("Supprimer");
	private JButton button3 = new JButton("Clear");
	
	// PANNEAU 4
	private JPanel p4 = new JPanel();
	
	private JPanel p41= new JPanel();
	private JPanel p411 = new JPanel();
	private JPanel p421 = new JPanel();
	private JPanel p42= new JPanel();
	
	private JLabel labelCode= new JLabel("Code :");
	private JTextField textFieldCode = new JTextField();
	
	private JLabel labelValeur = new JLabel("Valeur :");
	private JTextField textFieldValeur = new JTextField();
	
	private JButton button4 = new JButton("Ajouter");
	private JButton button5 = new JButton("Supprimer");
	private JButton button6 = new JButton("Clear");
	
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public CopyOfInterfaceGraphique(){
		
		setLayout(new GridLayout(2,2));
		
		
		
// PANNEAU 1		
		
		
		// Recuperer la liste et l'afficher
		
		lm.addElement("benoit");
		lm.addElement("maryse");
	
		//p.add(test);
		l1.addListSelectionListener(this);   // liste ecran de gauche
					
	
		
// PANNEAU 2		

		// Recuperer la liste et l'afficher
		
		
		
		l2.addListSelectionListener(this);   // liste ecran droite
		
		
// PANNEAU 3	
		
		//SpringLayout layoutp3 = new SpringLayout();
		
		//GridLayout layoutp3 = new GridLayout(10,2);
		
		BorderLayout layoutp3 = new BorderLayout();
		
		p3.setLayout(layoutp3);
			
		p31.setLayout(new GridLayout(2,1));
			
		p311.setLayout(new GridLayout(1,2));
	
		p311.add(labelNom);
		p311.add(textFieldNom);	
		
		p321.setLayout(new GridLayout(1,2));
		
		p321.add(labelPrenom);
		p321.add(textFieldPrenom);
		
		p31.add(p311);
		p31.add(p321);
		
		p32.add(button1);
		p32.add(button2);
		p32.add(button3);
			
		p3.add(p31,BorderLayout.NORTH);
		p3.add(p32,BorderLayout.SOUTH);
			
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		
		
// PANNEAU 4	
		
		BorderLayout layoutp4 = new BorderLayout();
		
		p4.setLayout(layoutp4);
		
		p41.setLayout(new GridLayout(2,1));

		p411.setLayout(new GridLayout(1,2));
		p411.add(labelCode);
		p411.add(textFieldCode);	
		
		p421.setLayout(new GridLayout(1,2));
		p421.add(labelValeur);
		p421.add(textFieldValeur);
				
		p41.add(p411);
		p41.add(p421);		
		
		p42.add(button4);
		p42.add(button5);
		p42.add(button6);
		
		p4.add(p41,BorderLayout.NORTH);
		p4.add(p42,BorderLayout.SOUTH);
		
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		
		
// FIN PANNEAU 4		
		
			
		p.setBackground(Color.BLUE);
		p2.setBackground(Color.RED);
		p3.setBackground(Color.GREEN);
		p4.setBackground(Color.YELLOW);
		
				
		
		add(p);  //ajoute du premier cadre dans al fenetre
		add(p2);
		add(p3);
		add(p4);
		
	}
	
	
	
	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource()== l1 ){
			if (e.getValueIsAdjusting()){
				return ;
			}
			
		}
		 if ( e.getSource()==p32){
			if (e.getValueIsAdjusting()){
				return ;
			}
			
		}
		
		
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent act) {
		// TODO Auto-generated method stub
		
		// AJOUTER BAS GAUCHE
		if (act.getSource() == button1){
			String nom = textFieldNom.getText();
			String prenom = textFieldPrenom.getText();
			AjouteEntree.addEntree(nom,prenom);
			lm.addElement(nom+" "+prenom);
			clear();
			
		}
		if (act.getSource() == button2){
			String nom = textFieldNom.getText();
			String prenom = textFieldPrenom.getText();
			// supprimer l'entree
			clear();
		}
		if (act.getSource() == button3){
			clear();
			// ajouter l'entree
		}
		if (act.getSource() == button4){
			String nom = textFieldCode.getText();
			String prenom = textFieldValeur.getText();
			// ajouter le numero
		}
		if (act.getSource() == button5){
			String nom = textFieldCode.getText();
			String prenom = textFieldValeur.getText();
			// supprimer le numero
		}
		if (act.getSource() == button6){
			textFieldCode.setText("");
			textFieldValeur.setText("");
			// ajouter l'entree
		}
		
		
	}

	
    private void clear() {
		// TODO Auto-generated method stub
		textFieldNom.setText("");
		textFieldPrenom.setText("");
	}


	public static class MyFrame extends JFrame {

        @SuppressWarnings("unused")
		public MyFrame() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            setSize(640,400);
            GridLayout grid= new GridLayout(2, 2);
            //ajout d'un panel dans la frame
            getContentPane().add(new CopyOfInterfaceGraphique());
            setLocationRelativeTo(null);
        }
    }

	
	
    public static void main(String [] args) {
        MyFrame frame = new MyFrame();
        frame.setBackground(Color.BLUE);
        frame.setVisible(true);
        lm = Initialisation.initialisationPersonne();
    }
	
	
}
