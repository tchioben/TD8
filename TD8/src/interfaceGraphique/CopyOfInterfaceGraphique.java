package interfaceGraphique;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public class CopyOfInterfaceGraphique extends JPanel implements ActionListener, ListSelectionListener {

	
	
	
	public CopyOfInterfaceGraphique(){
		
		setLayout(new GridLayout(2,2));
		JPanel p = new JPanel(); //le premier cadre
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
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
