import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;

class Nivel2 extends JFrame implements KeyListener {

	JPanel panel;

	BufferedImage imagenMoneda;
	BufferedImage subImagenMoneda;
	Moneda moneda;

	BufferedImage imagenEnemy;
	BufferedImage subImagenEnemy;
	EnemigoFig enemy;

	BufferedImage imagen;
	BufferedImage subImagen;
	Personaje personaje;

	boolean fin = false;
	boolean t = true;

	public Nivel2() {

		panel = new CambioDeFondo("./imagenes/FondoN2.png");
		panel.setLayout(null);

		// Moneda
		try {
			imagenMoneda = ImageIO.read(new File("./imagenes/Coin.png"));
		} catch (Exception e) {
			System.out.println("Error: al cargar la imagen.");
		}

		subImagenMoneda = imagenMoneda.getSubimage(0,0,500,500);
		moneda = new Moneda(subImagenMoneda);
		moneda.setBounds(325,205,50,50);

		//Personaje 1
		try {
			imagenEnemy = ImageIO.read(new File("./imagenes/BolaEnemy.png"));
		} catch (Exception e) {
			System.out.println("Error: al cargar la imagen.");
		}

		subImagenEnemy = imagenEnemy.getSubimage(0,0,500,500);
		enemy = new EnemigoFig(subImagenEnemy);
		enemy.setBounds(590,210,70,70);

		//Personaje2
		try {
			imagen = ImageIO.read(new File("./imagenes/BolaNegra.png"));
		} catch (Exception e) {
			System.out.println("Error: al cargar la imagen.");
		}

		subImagen = imagen.getSubimage(0,0,500,500);
		personaje = new Personaje(subImagen);
		personaje.setBounds(30,210,70,70);

		panel.add(personaje);
		panel.add(enemy);
		panel.add(moneda);

		this.add(panel);
		this.setTitle("NIVEL 2");
		this.setSize(700, 500);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);

		this.addKeyListener(this);
	}

	public void keyPressed(KeyEvent e) {

		int t = e.getKeyCode();

		Point posPer = personaje.getLocation();
		int xp = (int)posPer.getX();
		int yp = (int)posPer.getY();
		
		if (fin == false) {

			if(t==68) { // der

				xp = xp+10;
				personaje.imagen = imagen.getSubimage(500,0,500,500);
			}

			if(t==65) { // izq

				xp = xp-10;
				personaje.imagen = imagen.getSubimage(0,500,500,500);
			}

			if(t==87) { // arriba

				yp = yp-10;
				personaje.imagen = imagen.getSubimage(500,500,500,500);
			}

			if(t==83) { // abajo

				yp = yp+10;
				personaje.imagen = imagen.getSubimage(0,0,500,500);
			}

			personaje.setLocation(xp,yp);

			Point posEn = enemy.getLocation();
			int xe = (int)posEn.getX();
			int ye = (int)posEn.getY();

			if(t==39) { // der

				xe = xe+10;
				enemy.imagenEnemy = imagenEnemy.getSubimage(500,0,500,500);
			}

			if(t==37) { // izq

				xe = xe-10;
				enemy.imagenEnemy = imagenEnemy.getSubimage(0,500,500,500);
			}

			if(t==38) { // arriba

				ye = ye-10;
				enemy.imagenEnemy = imagenEnemy.getSubimage(500,500,500,500);
			}

			if(t==40) { // abajo

				ye = ye+10;
				enemy.imagenEnemy = imagenEnemy.getSubimage(0,0,500,500);
			}

			enemy.setLocation(xe,ye);
		}
	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent e) {

	}
}