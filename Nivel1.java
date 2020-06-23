import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;

class Nivel1 extends JFrame implements KeyListener {

	BufferedImage imagenFondoN1;
	Krita fondoN1;

	// JPanel panel;

	BufferedImage imagenEnemy;
	BufferedImage subImagenEnemy;
	EnemigoFig enemy;

	BufferedImage imagen;
	BufferedImage subImagen;
	Personaje personaje;

	public Nivel1() {

		try {
			imagenFondoN1 = ImageIO.read(new File("C:/Users/luish/OneDrive/Escritorio/GAME/FondoN1.png"));
		} catch (Exception e) {
			System.out.println("Error: al cargar la imagen.");
		}

		fondoN1 = new Krita(imagenFondoN1);

		/* panel = new CambioFondo();
		panel.setLayout(null);
		panel.setFocusable(true);
		panel.requestFocusInWindow(); */

		try {
			imagenEnemy = ImageIO.read(new File("C:/Users/luish/OneDrive/Escritorio/GAME/BolaEnemy.png"));
		} catch (Exception e) {
			System.out.println("Error: al cargar la imagen.");
		}

		subImagenEnemy = imagenEnemy.getSubimage(0,0,500,500);
		enemy = new EnemigoFig(subImagenEnemy);
		
		try {
			imagen = ImageIO.read(new File("C:/Users/luish/OneDrive/Escritorio/GAME/BolaNegra.png"));
		} catch (Exception e) {
			System.out.println("Error: al cargar la imagen.");
		}

		subImagen = imagen.getSubimage(0,0,500,500);
		personaje = new Personaje(subImagen);

		// panel.add(personaje);
		// panel.add(enemy);

		// panel.addKeyListener(this);
		// this.add(panel);

		this.add(fondoN1);
		this.add(enemy);
		
		this.setTitle("NIVEL 1");
		this.setBounds(0, 0, 700, 500);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.addKeyListener(this);

		this.add(personaje);
	}

	public void keyPressed(KeyEvent e) {

		int t = e.getKeyCode();

		Point posPer = personaje.getLocation();
		int xp = (int)posPer.getX();
		int yp = (int)posPer.getY();

		if(t==68)
		{
			xp = xp+5;
			personaje.imagen = imagen.getSubimage(500,0,500,500);
		}

		personaje.setLocation(xp,yp);

		Point posEn = enemy.getLocation();
		int xe = (int)posEn.getX();
		int ye = (int)posEn.getY();

		if(t==39)
		{
			xe = xe+5;
			enemy.imagenEnemy = imagenEnemy.getSubimage(500,0,500,500);
		}

		enemy.setLocation(xe,ye);
	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent e) {

	}
}