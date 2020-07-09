import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

class VPrincipal extends JFrame implements KeyListener {

	JPanel panel;
	BufferedImage imagenFondo;
	

	public VPrincipal() {

		panel = new CambioDeFondo("FondoP.png");
		panel.setLayout(null);
		panel.setFocusable(true);
		panel.requestFocusInWindow();

		panel.addKeyListener(this);

		this.add(panel);
		this.setTitle("GAME");
		this.setBounds(0, 0, 1450, 850);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
	}

	public void keyPressed(KeyEvent e) {

		int nTecla = e.getKeyCode();

		if (nTecla == 10) {
			
			Nivel1 n1 = new Nivel1();
			this.setVisible(false);
		}
	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent e) {

	}
}