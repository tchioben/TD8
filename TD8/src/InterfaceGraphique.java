import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public class InterfaceGraphique extends JPanel implements ActionListener, ListSelectionListener {

	


	JButton yes = new JButton("Valider");
	JButton no = new JButton("Annuler");
	
	public InterfaceGraphique(){
	    JPanel listPane = new JPanel();
	    listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));
	    add(listPane);
	    listPane.add(new JLabel("Hello World"));
	    listPane.add(yes);
	    listPane.add(no);
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
            //ajout d'un panel dans la frame
            getContentPane().add(new InterfaceGraphique());
            setLocationRelativeTo(null);
        }
    }

	
	
    public static void main(String [] args) {
        MyFrame frame = new MyFrame();
        frame.setVisible(true);
    }
	
	
}
