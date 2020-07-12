import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

class AvisoCafe extends JFrame implements ActionListener {

	JPanel panelCafe;
	JButton btnRetry, btnExit;

	public AvisoCafe() {

		panelCafe = new CambioDeFondo("./imagenes/WinBrown.png");
		panelCafe.setLayout(null);

		btnRetry = new JButton("RETURN");
		btnRetry.setBounds(300, 215, 100, 30);
		btnRetry.setBackground(Color.WHITE);

		btnExit = new JButton("EXIT");
		btnExit.setBounds(300, 255, 100, 30);
		btnExit.setBackground(Color.WHITE);

		panelCafe.add(btnRetry);
		//panelVerde.add(btnExit);

		this.add(panelCafe);
		this.setTitle("");
		this.setSize(700, 500);
		this.setLocation(600,250);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);

		btnRetry.addActionListener(this);
		btnExit.addActionListener(this);
	}

	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == this.btnRetry) {

			//Reiniciar partida
			VPrincipal vpBlue = new VPrincipal();
			this.setVisible(false);

		} else if (event.getSource() == this.btnExit) {

			//Cerrar programa
			System.exit(ABORT);
		}
	}
}