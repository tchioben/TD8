package interfaceGraphique;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public class CopyOfInterfaceGraphique extends JPanel implements ActionListener, ListSelectionListener {

	
	
	
	public CopyOfInterfaceGraphique(){
		
		setLayout(new GridLayout(2,2));
		
// PANNEAU 1		
		
		JPanel p = new JPanel(); //le premier cadre
		

		
		
		
		
		
		
		
// PANNEAU 2		
		
		JPanel p2 = new JPanel();
		
		
		
		
		
		
		
		
	// PANNEAU 3	
		
		JPanel p3 = new JPanel();
		
		//SpringLayout layoutp3 = new SpringLayout();
		
		//GridLayout layoutp3 = new GridLayout(10,2);
		
		BorderLayout layoutp3 = new BorderLayout();
		
		p3.setLayout(layoutp3);
		
		
		JPanel p31= new JPanel();
		
		p31.setLayout(new GridLayout(2,1));
		
		
		JPanel p311 = new JPanel();
		p311.setLayout(new GridLayout(1,2));
		p311.add(new JLabel("Nom :"));
		p311.add(new JTextField());	
		
		
		JPanel p321 = new JPanel();
		p321.setLayout(new GridLayout(1,2));
		p321.add(new JLabel("Prénom :"));
		p321.add(new JTextField());
		
		
		p31.add(p311);
		p31.add(p321);
		//layoutp3.putConstraint(SpringLayout.WEST, p31, 5, SpringLayout.WEST, p3);
		
		
		JPanel p32= new JPanel();
		p32.add(new JButton("Ajouter"));
		p32.add(new JButton("Supprimer"));
		p32.add(new JButton("Clear"));
		
		
		
		p3.add(p31,BorderLayout.NORTH);
		p3.add(p32,BorderLayout.SOUTH);
		
		
		
		
		
		
	// PANNEAU 4	
		
		JPanel p4 = new JPanel();
		BorderLayout layoutp4 = new BorderLayout();
		
		p4.setLayout(layoutp4);
		
		
		JPanel p41= new JPanel();
		
		p41.setLayout(new GridLayout(2,1));
		
		
		JPanel p411 = new JPanel();
		p411.setLayout(new GridLayout(1,2));
		p411.add(new JLabel("Code :"));
		p411.add(new JTextField());	
		
		
		JPanel p421 = new JPanel();
		p421.setLayout(new GridLayout(1,2));
		p421.add(new JLabel("Valeur :"));
		p421.add(new JTextField());
		
		
		p41.add(p411);
		p41.add(p421);
		//layoutp3.putConstraint(SpringLayout.WEST, p31, 5, SpringLayout.WEST, p3);
		
		
		JPanel p42= new JPanel();
		p42.add(new JButton("Ajouter"));
		p42.add(new JButton("Supprimer"));
		p42.add(new JButton("Clear"));
		
		
		
		p4.add(p41,BorderLayout.NORTH);
		p4.add(p42,BorderLayout.SOUTH);
		
		
		
		
		
		
		p.setBackground(Color.BLUE);
		p2.setBackground(Color.RED);
		p3.setBackground(Color.GREEN);
		p4.setBackground(Color.YELLOW);
		
		
		
		
		
		
		add(p);  //ajoute du premier cadre dans al fenetre
		add(p2);
		add(p3);
		add(p4);
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
    }
	
	
}
