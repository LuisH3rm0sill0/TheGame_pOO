import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

class AvisoNaranja extends JFrame implements ActionListener {

	JPanel panelNaranja;
	JButton btnRetry;

	public AvisoNaranja() {

		panelNaranja = new CambioDeFondo("./imagenes/WinOrange.png");
		panelNaranja.setLayout(null);

		btnRetry = new JButton("BACK TO MENU");
		btnRetry.setBounds(275, 225, 150, 50);
		btnRetry.setBackground(Color.WHITE);

		panelNaranja.add(btnRetry);

		this.add(panelNaranja);
		this.setTitle("");
		this.setSize(700, 500);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);

		btnRetry.addActionListener(this);
	}

	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == this.btnRetry) {

			//Reiniciar partida
			VPrincipal vpOrange = new VPrincipal();
			this.setVisible(false);
		} 
	}
}