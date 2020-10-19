package calculatrice;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class ControleurChiffre extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	String[] tab_string = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "." };
	JButton[] tab_button = new JButton[tab_string.length];
	private Dimension dim = new Dimension(50, 40);
	private Controleur controleur;
	public ControleurChiffre(Controleur controleur){
		this.controleur=controleur;
		setPreferredSize(new Dimension(165, 225));
		for(int i = 0; i < tab_string.length; i++) {
			tab_button[i] = new JButton(tab_string[i]);
			tab_button[i].setPreferredSize(dim);
			add(tab_button[i]);
			tab_button[i].addActionListener(this);
		}
	}
	public void actionPerformed(ActionEvent e) {
		String str = ((JButton)e.getSource()).getText();
		controleur.setChiffre(str);
	}
}
