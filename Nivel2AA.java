import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;
import java.util.Random;

class Nivel2AA extends JFrame implements KeyListener {

	JPanel panel;

	JLabel lblAmarillo, lblAzul;

	BufferedImage imagenInsPer, imagenInsEn;
	Instruccion insPersonajeAzul, insEnemigoAmarillo;

	BufferedImage imagenMoneda;
	BufferedImage subImagenMoneda;
	Moneda moneda;

	BufferedImage imagenEnemy;
	BufferedImage subImagenEnemy;
	EnemigoFig enemigoAmarillo;

	BufferedImage imagen;
	BufferedImage subImagen;
	Personaje personajeAzul;

	Rectangle colisionArriba = new Rectangle(0,0,700,50);
	Rectangle colisionAbajo = new Rectangle(0,450,700,50);
	Rectangle colisionIzquierda = new Rectangle(0,50,25,430);
	Rectangle colisionDerecha = new Rectangle(670,50,25,430);

	boolean fin = false;
	boolean t = true;

	int puntajeAmarillo = 0;
	int puntajeAzul = 0;

	Reproductor rep = new Reproductor();

	public Nivel2AA() {

		panel = new CambioDeFondo("./imagenes/FondoN2.png");
		panel.setLayout(null);

		lblAmarillo = new JLabel ("TEAM YELLOW:");
		lblAmarillo.setBounds(30, 10, 150, 30);
		lblAmarillo.setForeground(Color.WHITE);

		lblAzul = new JLabel ("TEAM BLUE:");
		lblAzul.setBounds(190, 10, 150, 30);
		lblAzul.setForeground(Color.WHITE);

		// Instruccion del Personaje
		try {
			imagenInsPer = ImageIO.read(new File("./imagenes/TeclasPersonaje.png"));
		} catch (Exception e) {
			System.out.println("Error: al cargar la imagen.");
		}

		insPersonajeAzul = new Instruccion(imagenInsPer);
		insPersonajeAzul.setBounds(25,145,80,60); 

		// Instruccion del Enemigo
		try {
			imagenInsEn = ImageIO.read(new File("./imagenes/TeclasEnemigo.png"));
		} catch (Exception e) {
			System.out.println("Error: al cargar la imagen.");
		}

		insEnemigoAmarillo = new Instruccion(imagenInsEn);
		insEnemigoAmarillo.setBounds(585,145,80,60); 

		//Moneda
		try {
			imagenMoneda = ImageIO.read(new File("./imagenes/Coin.png"));
		} catch (Exception e) {
			System.out.println("Error: al cargar la imagen.");
		}

		subImagenMoneda = imagenMoneda.getSubimage(0,0,500,500);
		moneda = new Moneda(subImagenMoneda);
		moneda.setBounds(325,205,50,50); 

		//Personaje Amarillo
		try {
			imagenEnemy = ImageIO.read(new File("./imagenes/OjosAmarillos.png"));
		} catch (Exception e) {
			System.out.println("Error: al cargar la imagen.");
		}

		subImagenEnemy = imagenEnemy.getSubimage(0,0,500,500);
		enemigoAmarillo = new EnemigoFig(subImagenEnemy);
		enemigoAmarillo.setBounds(590,210,70,70);

		//Personaje Azul
		try {
			imagen = ImageIO.read(new File("./imagenes/OjosAzules.png"));
		} catch (Exception e) {
			System.out.println("Error: al cargar la imagen.");
		}

		subImagen = imagen.getSubimage(0,0,500,500);
		personajeAzul = new Personaje(subImagen);
		personajeAzul.setBounds(30,210,70,70);

		panel.add(lblAmarillo);
		panel.add(lblAzul);
		panel.add(personajeAzul);
		panel.add(enemigoAmarillo);
		panel.add(moneda);
		panel.add(insPersonajeAzul);
		panel.add(insEnemigoAmarillo);

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

		Point posPer = personajeAzul.getLocation();
		int xp = (int)posPer.getX();
		int yp = (int)posPer.getY();
		
		if (fin == false) {

			if(t==68) { // der

				insPersonajeAzul.setVisible(false);

				xp = xp+10;
				personajeAzul.imagen = imagen.getSubimage(500,0,500,500);

				if (personajeAzul.getBounds().intersects(colisionDerecha.getBounds())) {

					xp = xp-10;
				}
			}

			if(t==65) { // izq

				xp = xp-10;
				personajeAzul.imagen = imagen.getSubimage(0,500,500,500);

				if (personajeAzul.getBounds().intersects(colisionIzquierda.getBounds())) {

					xp = xp+10;
				}
			}

			if(t==87) { // arriba

				yp = yp-10;
				personajeAzul.imagen = imagen.getSubimage(500,500,500,500);

				if (personajeAzul.getBounds().intersects(colisionArriba.getBounds())) {

					yp = yp+10;
				}
			}

			if(t==83) { // abajo

				yp = yp+10;
				personajeAzul.imagen = imagen.getSubimage(0,0,500,500);

				if (personajeAzul.getBounds().intersects(colisionAbajo.getBounds())) {

					yp = yp-10;
				}
			}

			personajeAzul.setLocation(xp,yp);

			Point posEn = enemigoAmarillo.getLocation();
			int xe = (int)posEn.getX();
			int ye = (int)posEn.getY();

			if(t==39) { // der

				xe = xe+10;
				enemigoAmarillo.imagenEnemy = imagenEnemy.getSubimage(500,0,500,500);

				if (enemigoAmarillo.getBounds().intersects(colisionDerecha.getBounds())) {

					xe = xe-10;
				}
			}

			if(t==37) { // izq

				insEnemigoAmarillo.setVisible(false);

				xe = xe-10;
				enemigoAmarillo.imagenEnemy = imagenEnemy.getSubimage(0,500,500,500);

				if (enemigoAmarillo.getBounds().intersects(colisionIzquierda.getBounds())) {

					xe = xe+10;
				}
			}

			if(t==38) { // arriba

				ye = ye-10;
				enemigoAmarillo.imagenEnemy = imagenEnemy.getSubimage(500,500,500,500);

				if (enemigoAmarillo.getBounds().intersects(colisionArriba.getBounds())) {

					ye = ye+10;
				}
			}

			if(t==40) { // abajo

				ye = ye+10;
				enemigoAmarillo.imagenEnemy = imagenEnemy.getSubimage(0,0,500,500);

				if (enemigoAmarillo.getBounds().intersects(colisionAbajo.getBounds())) {

					ye = ye-10;
				}
			}

			enemigoAmarillo.setLocation(xe,ye);

			movimientoMonedaAA();

			//Ventana de pausa

			if (t == 80) {
			
				Pausa n2 = new Pausa();
				this.setVisible(false);
			}
		}
	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent e) {

	}

	public void movimientoMonedaAA() {

		Reproductor rep = new Reproductor();

		Random numA = new Random();
		int nx = numA.nextInt(500);
		int ny = numA.nextInt(400);

		String puntajeAzulString, puntajeAmarilloString;

		if (personajeAzul.getBounds().intersects(moneda.getBounds())) {

			puntajeAzul = puntajeAzul + 10;
			puntajeAzulString = Integer.toString(puntajeAzul);
			lblAzul.setText("TEAM BLUE: " +puntajeAzulString);

			moneda.setLocation(nx,ny);

			if (puntajeAzul == 100) {

				leerNotasDeArchivoN2AA();

				AvisoAzul avsAzul = new AvisoAzul();
				this.setVisible(false);
			}
		}

		if (enemigoAmarillo.getBounds().intersects(moneda.getBounds())) {

			puntajeAmarillo = puntajeAmarillo + 10;
			puntajeAmarilloString = Integer.toString(puntajeAmarillo);
			lblAmarillo.setText("TEAM YEALLOW: " +puntajeAmarilloString);

			moneda.setLocation(nx,ny);

			if (puntajeAmarillo == 100) {

				leerNotasDeArchivoN2AA();

				AvisoAmarillo avsAmarillo = new AvisoAmarillo();
				this.setVisible(false);
			}
		}
	}

	public void leerNotasDeArchivoN2AA() {

		rep.inicializar();

		ArrayList<String> notasArchivo = new ArrayList<String>();
		notasArchivo = Reproductor.LeerNotas("notasA.txt");

		for (int i=0; i<notasArchivo.size(); i++) {

			int n = Integer.parseInt(notasArchivo.get(i));
			rep.reproducirNota(n, 1, 150);
		}

		rep.finalizar();
	}

	public void cambiarTextoLblAzul (String cadena) {

		this.lblAzul.setText(cadena);
	}

	public void cambiarTextoLblAmarillo (String cadena) {

		this.lblAmarillo.setText(cadena);
	}
}