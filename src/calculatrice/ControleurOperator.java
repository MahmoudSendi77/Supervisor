package calculatrice;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class ControleurOperator extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	String[] tab_string = {"=", "C", "+", "-", "*", "/"};
	JButton[] tab_button = new JButton[tab_string.length];
	private Dimension dim = new Dimension(50, 40);
	private Dimension dim2 = new Dimension(50, 31);
	private Controleur controleur;
	public ControleurOperator(Controleur controleur){
		this.controleur=controleur;
		setPreferredSize(new Dimension(55, 225));
		for(int i = 0; i < tab_string.length; i++)
		{
			tab_button[i] = new JButton(tab_string[i]);
			tab_button[i].addActionListener(this);
			tab_button[i].setPreferredSize(dim2);
			add(tab_button[i]);
			switch(i){
			case 0 :
				tab_button[i].setPreferredSize(dim);
				controleur.jcchiffre.add(tab_button[i]);
				break;
			case 1 :
				tab_button[i].setForeground(Color.red);
				break;
			}
		}
	}
	public void actionPerformed(ActionEvent arg0) {
		String str = ((JButton)arg0.getSource()).getText();
		if (str.equals(tab_string[0])){
			controleur.egal();
		} else 
			if (str.equals(tab_string[1])){
				controleur.raz();
			} else 
				if (str.equals(tab_string[2])){
					controleur.plus();
				} else 
					if (str.equals(tab_string[3])){
						controleur.moins();
					} else 
						if (str.equals(tab_string[4])){
							controleur.multiplier();
						} else 
							if (str.equals(tab_string[5])){
								controleur.diviser();
							}
	}
}
