package interfaceGraphique;

/**
 * 
 */

import javax.swing.JFrame;

/**
 * @author Tchioben
 *
 */
public class MyFrame extends JFrame {

	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 400);
		System.out.println("t'es con ou quoi?");
		// ajout d'un panel dans la frame
		// getContentPane().add(new InterfaceGraphique());
		setLocationRelativeTo(null);
	}
}
