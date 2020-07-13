import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;
import java.util.Random;

class Nivel2 extends JFrame implements KeyListener {

	JPanel panel;

	JLabel lblRojo, lblVerde;

	BufferedImage imagenInsPer, imagenInsEn;
	Instruccion insPersonaje, insEnemigo;

	BufferedImage imagenMoneda;
	BufferedImage subImagenMoneda;
	Moneda moneda;

	BufferedImage imagenEnemy;
	BufferedImage subImagenEnemy;
	EnemigoFig enemy;

	BufferedImage imagen;
	BufferedImage subImagen;
	Personaje personaje;

	Rectangle colisionArriba = new Rectangle(0,0,700,50);
	Rectangle colisionAbajo = new Rectangle(0,450,700,50);
	Rectangle colisionIzquierda = new Rectangle(0,50,25,430);
	Rectangle colisionDerecha = new Rectangle(670,50,25,430);

	boolean fin = false;
	boolean t = true;

	int puntajeRojo = 0;
	int puntajeVerde = 0;

	Reproductor rep = new Reproductor();

	public Nivel2() {

		panel = new CambioDeFondo("./imagenes/FondoN2.png");
		panel.setLayout(null);

		lblVerde = new JLabel ("TEAM GREEN:");
		lblVerde.setBounds(30, 10, 150, 30);
		lblVerde.setForeground(Color.WHITE);

		lblRojo = new JLabel ("TEAM RED:");
		lblRojo.setBounds(190, 10, 150, 30);
		lblRojo.setForeground(Color.WHITE);

		// Instruccion del Personaje
		try {
			imagenInsPer = ImageIO.read(new File("./imagenes/TeclasPersonaje.png"));
		} catch (Exception e) {
			System.out.println("Error: al cargar la imagen.");
		}

		insPersonaje = new Instruccion(imagenInsPer);
		insPersonaje.setBounds(25,145,80,60); 

		// Instruccion del Enemigo
		try {
			imagenInsEn = ImageIO.read(new File("./imagenes/TeclasEnemigo.png"));
		} catch (Exception e) {
			System.out.println("Error: al cargar la imagen.");
		}

		insEnemigo = new Instruccion(imagenInsEn);
		insEnemigo.setBounds(585,145,80,60); 

		//Moneda
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

		panel.add(lblRojo);
		panel.add(lblVerde);
		panel.add(personaje);
		panel.add(enemy);
		panel.add(moneda);
		panel.add(insEnemigo);
		panel.add(insPersonaje);

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

				insPersonaje.setVisible(false);

				xp = xp+10;
				personaje.imagen = imagen.getSubimage(500,0,500,500);

				if (personaje.getBounds().intersects(colisionDerecha.getBounds())) {

					xp = xp-10;
				}
			}

			if(t==65) { // izq

				xp = xp-10;
				personaje.imagen = imagen.getSubimage(0,500,500,500);

				if (personaje.getBounds().intersects(colisionIzquierda.getBounds())) {

					xp = xp+10;
				}
			}

			if(t==87) { // arriba

				yp = yp-10;
				personaje.imagen = imagen.getSubimage(500,500,500,500);

				if (personaje.getBounds().intersects(colisionArriba.getBounds())) {

					yp = yp+10;
				}
			}

			if(t==83) { // abajo

				yp = yp+10;
				personaje.imagen = imagen.getSubimage(0,0,500,500);

				if (personaje.getBounds().intersects(colisionAbajo.getBounds())) {

					yp = yp-10;
				}
			}

			personaje.setLocation(xp,yp);

			Point posEn = enemy.getLocation();
			int xe = (int)posEn.getX();
			int ye = (int)posEn.getY();

			if(t==39) { // der

				xe = xe+10;
				enemy.imagenEnemy = imagenEnemy.getSubimage(500,0,500,500);

				if (enemy.getBounds().intersects(colisionDerecha.getBounds())) {

					xe = xe-10;
				}
			}

			if(t==37) { // izq

				insEnemigo.setVisible(false);

				xe = xe-10;
				enemy.imagenEnemy = imagenEnemy.getSubimage(0,500,500,500);

				if (enemy.getBounds().intersects(colisionIzquierda.getBounds())) {

					xe = xe+10;
				}
			}

			if(t==38) { // arriba

				ye = ye-10;
				enemy.imagenEnemy = imagenEnemy.getSubimage(500,500,500,500);

				if (enemy.getBounds().intersects(colisionArriba.getBounds())) {

					ye = ye+10;
				}
			}

			if(t==40) { // abajo

				ye = ye+10;
				enemy.imagenEnemy = imagenEnemy.getSubimage(0,0,500,500);

				if (enemy.getBounds().intersects(colisionAbajo.getBounds())) {

					ye = ye-10;
				}
			}

			enemy.setLocation(xe,ye);

			movimientoMoneda();

			//Ventana de pausa

			if (t == 80) {
			
				Pausa n1 = new Pausa();
				this.setVisible(false);
			}
		}
	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent e) {

	}

	public void movimientoMoneda() {

		Random numA = new Random();
		int nx = numA.nextInt(500);
		int ny = numA.nextInt(400);

		String puntajeVerdeString, puntajeRojoString;

		if (personaje.getBounds().intersects(moneda.getBounds())) {

			puntajeVerde = puntajeVerde + 10;
			puntajeVerdeString = Integer.toString(puntajeVerde);
			lblVerde.setText("TEAM GREEN: " +puntajeVerdeString);

			moneda.setLocation(nx,ny);

			if (puntajeVerde == 100) {

				leerNotasDeArchivoN2();

				AvisoVerde avsVerde = new AvisoVerde();
				this.setVisible(false);
			}
		}

		if (enemy.getBounds().intersects(moneda.getBounds())) {

			puntajeRojo = puntajeRojo + 10;
			puntajeRojoString = Integer.toString(puntajeRojo);
			lblRojo.setText("TEAM RED: " +puntajeRojoString);

			moneda.setLocation(nx,ny);

			if (puntajeRojo == 100) {

				leerNotasDeArchivoN2();

				AvisoRojo avsRojo = new AvisoRojo();
				this.setVisible(false);
			}
		}
	}

	public void leerNotasDeArchivoN2() {

		rep.inicializar();

		ArrayList<String> notasArchivo = new ArrayList<String>();
		notasArchivo = Reproductor.LeerNotas("notasA.txt");

		for (int i=0; i<notasArchivo.size(); i++) {

			int n = Integer.parseInt(notasArchivo.get(i));
			rep.reproducirNota(n, 1, 150);
		}

		rep.finalizar();
	}

	public void cambiarTextoLblVerde (String cadena) {

		this.lblVerde.setText(cadena);
	}

	public void cambiarTextoLblRojo (String cadena) {

		this.lblRojo.setText(cadena);
	}
}