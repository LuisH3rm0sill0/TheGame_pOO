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
	Krita fondo;

	public VPrincipal() {

		try {
			imagenFondo = ImageIO.read(new File("Fondo.png"));
		} catch (Exception e) {
			System.out.println("Error: al cargar la imagen.");
		}

		fondo = new Krita(imagenFondo);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setFocusable(true);
		panel.requestFocusInWindow();

		panel.addKeyListener(this);

		this.add(panel);
		this.add(fondo);
		this.setTitle("GAME");
		this.setBounds(0, 0, 700, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
	}

	public void keyPressed(KeyEvent e) {

		int nTecla = e.getKeyCode();

		if (nTecla == 10) {
			
			Nivel1 n1 = new Nivel1();
		}
	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent e) {

	}
}