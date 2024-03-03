package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ButtonClickListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
        String buttonText = ((JButton) e.getSource()).getText();

        if (buttonText.equals("Imprimir as cidades que o sistema abarca")) {

        } else if (buttonText.equals("Imprimir a distância de cada a partir da matriz")) {


        } else if (buttonText.equals("Escolher o percurso")) {


        } else if (buttonText.equals("Sair")) {

        }


	}

}
