import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

class AvisoVerde extends JFrame implements ActionListener {

	JPanel panelVerde;
	JButton btnRetry;

	public AvisoVerde() {

		panelVerde = new CambioDeFondo("./imagenes/FAvisoGreen.png");
		panelVerde.setLayout(null);

		btnRetry = new JButton("BACK TO MENU");
		btnRetry.setBounds(275, 225, 150, 50);
		btnRetry.setBackground(Color.WHITE);

		panelVerde.add(btnRetry);

		this.add(panelVerde);
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
			VPrincipal vpGreen = new VPrincipal();
			this.setVisible(false);
		} 
	}
}