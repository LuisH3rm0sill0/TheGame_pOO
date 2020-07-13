import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

class AvisoAmarillo extends JFrame implements ActionListener {

	JPanel panelAmarillo;
	JButton btnRetry;

	public AvisoAmarillo() {

		panelAmarillo = new CambioDeFondo("./imagenes/WinYellow.png");
		panelAmarillo.setLayout(null);

		btnRetry = new JButton("BACK TO MENU");
		btnRetry.setBounds(275, 225, 150, 50);
		btnRetry.setBackground(Color.WHITE);

		panelAmarillo.add(btnRetry);

		this.add(panelAmarillo);
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
			VPrincipal vpYellow = new VPrincipal();
			this.setVisible(false);
		} 
	}
}