import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

class Pausa extends JFrame implements ActionListener {

	JPanel panel;
	JButton btnMenu;

	public Pausa() {

		panel = new CambioDeFondo("./imagenes/menBandera.gif");
		panel.setLayout(null);

		btnMenu = new JButton("Back to menu");
		btnMenu.setBounds(290, 25, 120, 30);
		btnMenu.setBackground(Color.WHITE);

		panel.add(btnMenu);
		
		this.add(panel);
		this.setTitle("Pause");
		this.setSize(700, 500);
		this.setLocation(0,0);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);

		btnMenu.addActionListener(this);
	}

	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == this.btnMenu) {

			//Hacia Nivel2
			VPrincipal niv2 = new VPrincipal();
			this.setVisible(false);
		}
	}
}