import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

class AvisoVerde extends JFrame implements ActionListener {

	JPanel panelVerde;
	JButton btnRetry, btnExit;

	public AvisoVerde() {

		panelVerde = new CambioDeFondo("./imagenes/FAvisoGreen.png");
		panelVerde.setLayout(null);

		btnRetry = new JButton("RETRY");
		btnRetry.setBounds(300, 215, 100, 30);
		btnRetry.setBackground(Color.WHITE);

		btnExit = new JButton("EXIT");
		btnExit.setBounds(300, 255, 100, 30);
		btnExit.setBackground(Color.WHITE);

		panelVerde.add(btnRetry);
		panelVerde.add(btnExit);

		this.add(panelVerde);
		this.setTitle("");
		this.setSize(700, 500);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);

		btnRetry.addActionListener(this);
		btnExit.addActionListener(this);
	}

	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == this.btnRetry) {

			//Reiniciar partida
			Nivel1 nivel1Green = new Nivel1();
			this.setVisible(false);

		} else if (event.getSource() == this.btnExit) {

			//Cerrar programa
			System.exit(ABORT);
		}
	}
}