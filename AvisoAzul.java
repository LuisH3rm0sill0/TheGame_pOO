import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

class AvisoAzul extends JFrame implements ActionListener {

	JPanel panelAzul;
	JButton btnRetry;

	public AvisoAzul() {

		panelAzul = new CambioDeFondo("./imagenes/WinBlue.png");
		panelAzul.setLayout(null);

		btnRetry = new JButton("BACK TO MENU");
		btnRetry.setBounds(275, 225, 150, 50);
		btnRetry.setBackground(Color.WHITE);

		panelAzul.add(btnRetry);

		this.add(panelAzul);
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
			VPrincipal vpBlue = new VPrincipal();
			this.setVisible(false);
		} 
	}
}