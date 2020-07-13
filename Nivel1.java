import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;

class Nivel1 extends JFrame implements KeyListener {

	JPanel panel;

	BufferedImage imagenInsN1Per, imagenInsN1En;
	InstruccionN1 insN1Personaje, insN1Enemigo;

	BufferedImage imagenEnemy;
	BufferedImage subImagenEnemy;
	EnemigoFig enemy;

	BufferedImage imagen;
	BufferedImage subImagen;
	Personaje personaje;

	//para el final
	Rectangle areaFinal = new Rectangle(660,80,50,340);
	boolean fin = false;

	Reproductor rep = new Reproductor();

	public Nivel1() {

		panel = new CambioDeFondo("./imagenes/FondoN1.png");
		panel.setLayout(null);

		// Instruccion del Personaje
		try {
			imagenInsN1Per = ImageIO.read(new File("./imagenes/TeclasN1Personaje.png"));
		} catch (Exception e) {
			System.out.println("Error: al cargar la imagen.");
		}

		insN1Personaje = new InstruccionN1(imagenInsN1Per);
		insN1Personaje.setBounds(120,260,100,100); 

		// Instruccion del Enemigo
		try {
			imagenInsN1En = ImageIO.read(new File("./imagenes/TeclasN1Enemigo.png"));
		} catch (Exception e) {
			System.out.println("Error: al cargar la imagen.");
		}

		insN1Enemigo = new InstruccionN1(imagenInsN1En);
		insN1Enemigo.setBounds(120,100,100,100); 

		//Personaje 1
		try {
			imagenEnemy = ImageIO.read(new File("./imagenes/BolaEnemy.png"));
		} catch (Exception e) {
			System.out.println("Error: al cargar la imagen.");
		}

		subImagenEnemy = imagenEnemy.getSubimage(0,0,500,500);
		enemy = new EnemigoFig(subImagenEnemy);
		enemy.setBounds(0,100,100,100);

		//Personaje2
		try {
			imagen = ImageIO.read(new File("./imagenes/BolaNegra.png"));
		} catch (Exception e) {
			System.out.println("Error: al cargar la imagen.");
		}

		subImagen = imagen.getSubimage(0,0,500,500);
		personaje = new Personaje(subImagen);
		personaje.setBounds(0,260,100,100);

		panel.add(personaje);
		panel.add(enemy);
		panel.add(insN1Personaje);
		panel.add(insN1Enemigo);

		this.add(panel);
		this.setTitle("NIVEL 1");
		this.setSize(700, 500);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);

		this.addKeyListener(this);
	}

	public void keyPressed(KeyEvent e) {

		int t = e.getKeyCode();

		if (fin == false) {

			Point posPer = personaje.getLocation();
			int xp = (int)posPer.getX();
			int yp = (int)posPer.getY();

			if(t==68) {

				insN1Personaje.setVisible(false);

				xp = xp+10;
				personaje.imagen = imagen.getSubimage(500,0,500,500);
			}

			personaje.setLocation(xp,yp);

			Point posEn = enemy.getLocation();
			int xe = (int)posEn.getX();
			int ye = (int)posEn.getY();

			if(t==39) {

				insN1Enemigo.setVisible(false);

				xe = xe+10;
				enemy.imagenEnemy = imagenEnemy.getSubimage(500,0,500,500);
			}

			enemy.setLocation(xe,ye);
			colision();

			//Ventana de pausa

			if (t == 80) {
			
				Pausa n4 = new Pausa();
				this.setVisible(false);
			}
		}
	}

	public void keyReleased(KeyEvent e) {


	}

	public void keyTyped(KeyEvent e) {

	
	}

	public void colision() {

		if (enemy.getBounds().intersects(areaFinal.getBounds())) {
			
			leerNotasDeArchivoN1();

			this.fin = true;

			AvisoRojo avsR = new AvisoRojo();

			this.setVisible(false);

		} else if (personaje.getBounds().intersects(areaFinal.getBounds())) {

			leerNotasDeArchivoN1();

			this.fin = true;

			AvisoVerde avsV = new AvisoVerde();

			this.setVisible(false);
		}
	}

	public void leerNotasDeArchivoN1() {

		rep.inicializar();

		ArrayList<String> notasArchivo = new ArrayList<String>();
		notasArchivo = Reproductor.LeerNotas("notasA.txt");

		for (int i=0; i<notasArchivo.size(); i++) {

			int n = Integer.parseInt(notasArchivo.get(i));
			rep.reproducirNota(n, 1, 150);
		}

		rep.finalizar();
	}
}