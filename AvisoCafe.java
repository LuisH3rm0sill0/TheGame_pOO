import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

class AvisoCafe extends JFrame implements ActionListener {

	JPanel panelCafe;
	JButton btnRetry;

	public AvisoCafe() {

		panelCafe = new CambioDeFondo("./imagenes/WinBrown.png");
		panelCafe.setLayout(null);

		btnRetry = new JButton("BACK TO MENU");
		btnRetry.setBounds(275, 225, 150, 50);
		btnRetry.setBackground(Color.WHITE);

		panelCafe.add(btnRetry);

		this.add(panelCafe);
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
			VPrincipal vpBrown = new VPrincipal();
			this.setVisible(false);
		} 
	}
}