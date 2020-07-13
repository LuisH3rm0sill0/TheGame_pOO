import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

class AvisoRojo extends JFrame implements ActionListener {

	JPanel panelRojo;
	JButton btnRetry;

	public AvisoRojo() {

		panelRojo = new CambioDeFondo("./imagenes/FAvisoRed.png");
		panelRojo.setLayout(null);

		btnRetry = new JButton("BACK TO MENU");
		btnRetry.setBounds(275, 225, 150, 50);
		btnRetry.setBackground(Color.WHITE);

		panelRojo.add(btnRetry);

		this.add(panelRojo);
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
			VPrincipal vpRed = new VPrincipal();
			this.setVisible(false);
		} 
	}
}