import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;
import java.util.Random;

class Nivel2NC extends JFrame implements KeyListener {

	JPanel panel;

	JLabel lblNaranja, lblCafe;

	BufferedImage imagenInsPer, imagenInsEn;
	Instruccion insPersonajeCafe, insEnemigoNaranja;

	BufferedImage imagenMoneda;
	BufferedImage subImagenMoneda;
	Moneda moneda;

	BufferedImage imagenEnemy;
	BufferedImage subImagenEnemy;
	EnemigoFig enemigoNaranja;

	BufferedImage imagen;
	BufferedImage subImagen;
	Personaje personajeCafe;

	Rectangle colisionArriba = new Rectangle(0,0,700,50);
	Rectangle colisionAbajo = new Rectangle(0,450,700,50);
	Rectangle colisionIzquierda = new Rectangle(0,50,25,430);
	Rectangle colisionDerecha = new Rectangle(670,50,25,430);

	boolean fin = false;
	boolean t = true;

	int puntajeNaranja = 0;
	int puntajeCafe = 0;

	public Nivel2NC() {

		panel = new CambioDeFondo("./imagenes/FondoN2.png");
		panel.setLayout(null);

		lblNaranja = new JLabel ("TEAM ORANGE:");
		lblNaranja.setBounds(30, 10, 150, 30);
		lblNaranja.setForeground(Color.WHITE);

		lblCafe = new JLabel ("TEAM BROWN:");
		lblCafe.setBounds(190, 10, 150, 30);
		lblCafe.setForeground(Color.WHITE);

		// Instruccion del Personaje
		try {
			imagenInsPer = ImageIO.read(new File("./imagenes/TeclasPersonaje.png"));
		} catch (Exception e) {
			System.out.println("Error: al cargar la imagen.");
		}

		insPersonajeCafe = new Instruccion(imagenInsPer);
		insPersonajeCafe.setBounds(25,145,80,60); 

		// Instruccion del Enemigo
		try {
			imagenInsEn = ImageIO.read(new File("./imagenes/TeclasEnemigo.png"));
		} catch (Exception e) {
			System.out.println("Error: al cargar la imagen.");
		}

		insEnemigoNaranja = new Instruccion(imagenInsEn);
		insEnemigoNaranja.setBounds(585,145,80,60); 

		//Moneda
		try {
			imagenMoneda = ImageIO.read(new File("./imagenes/Coin.png"));
		} catch (Exception e) {
			System.out.println("Error: al cargar la imagen.");
		}

		subImagenMoneda = imagenMoneda.getSubimage(0,0,500,500);
		moneda = new Moneda(subImagenMoneda);
		moneda.setBounds(325,205,50,50); 

		//Personaje Naranja
		try {
			imagenEnemy = ImageIO.read(new File("./imagenes/OjosNaranjas.png"));
		} catch (Exception e) {
			System.out.println("Error: al cargar la imagen.");
		}

		subImagenEnemy = imagenEnemy.getSubimage(0,0,500,500);
		enemigoNaranja = new EnemigoFig(subImagenEnemy);
		enemigoNaranja.setBounds(590,210,70,70);

		//Personaje Cafe
		try {
			imagen = ImageIO.read(new File("./imagenes/OjosCafes.png"));
		} catch (Exception e) {
			System.out.println("Error: al cargar la imagen.");
		}

		subImagen = imagen.getSubimage(0,0,500,500);
		personajeCafe = new Personaje(subImagen);
		personajeCafe.setBounds(30,210,70,70);

		panel.add(lblNaranja);
		panel.add(lblCafe);
		panel.add(personajeCafe);
		panel.add(enemigoNaranja);
		panel.add(moneda);
		panel.add(insPersonajeCafe);
		panel.add(insEnemigoNaranja);
		
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

		Point posPer = personajeCafe.getLocation();
		int xp = (int)posPer.getX();
		int yp = (int)posPer.getY();
		
		if (fin == false) {

			if(t==68) { // der

				insPersonajeCafe.setVisible(false);

				xp = xp+10;
				personajeCafe.imagen = imagen.getSubimage(500,0,500,500);

				if (personajeCafe.getBounds().intersects(colisionDerecha.getBounds())) {

					xp = xp-10;
				}
			}

			if(t==65) { // izq

				xp = xp-10;
				personajeCafe.imagen = imagen.getSubimage(0,500,500,500);

				if (personajeCafe.getBounds().intersects(colisionIzquierda.getBounds())) {

					xp = xp+10;
				}
			}

			if(t==87) { // arriba

				yp = yp-10;
				personajeCafe.imagen = imagen.getSubimage(500,500,500,500);

				if (personajeCafe.getBounds().intersects(colisionArriba.getBounds())) {

					yp = yp+10;
				}
			}

			if(t==83) { // abajo

				yp = yp+10;
				personajeCafe.imagen = imagen.getSubimage(0,0,500,500);

				if (personajeCafe.getBounds().intersects(colisionAbajo.getBounds())) {

					yp = yp-10;
				}
			}

			personajeCafe.setLocation(xp,yp);

			Point posEn = enemigoNaranja.getLocation();
			int xe = (int)posEn.getX();
			int ye = (int)posEn.getY();

			if(t==39) { // der

				xe = xe+10;
				enemigoNaranja.imagenEnemy = imagenEnemy.getSubimage(500,0,500,500);

				if (enemigoNaranja.getBounds().intersects(colisionDerecha.getBounds())) {

					xe = xe-10;
				}
			}

			if(t==37) { // izq

				insEnemigoNaranja.setVisible(false);

				xe = xe-10;
				enemigoNaranja.imagenEnemy = imagenEnemy.getSubimage(0,500,500,500);

				if (enemigoNaranja.getBounds().intersects(colisionIzquierda.getBounds())) {

					xe = xe+10;
				}
			}

			if(t==38) { // arriba

				ye = ye-10;
				enemigoNaranja.imagenEnemy = imagenEnemy.getSubimage(500,500,500,500);

				if (enemigoNaranja.getBounds().intersects(colisionArriba.getBounds())) {

					ye = ye+10;
				}
			}

			if(t==40) { // abajo

				ye = ye+10;
				enemigoNaranja.imagenEnemy = imagenEnemy.getSubimage(0,0,500,500);

				if (enemigoNaranja.getBounds().intersects(colisionAbajo.getBounds())) {

					ye = ye-10;
				}
			}

			enemigoNaranja.setLocation(xe,ye);

			movimientoMonedaNC();

			//Ventana de pausa

			if (t == 80) {
			
				Pausa n3 = new Pausa();
				this.setVisible(false);
			}
		}
	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent e) {

	}

	public void movimientoMonedaNC() {

		Reproductor rep = new Reproductor();

		Random numA = new Random();
		int nx = numA.nextInt(500);
		int ny = numA.nextInt(400);

		String puntajeCafeString, puntajeNaranjaString;

		if (personajeCafe.getBounds().intersects(moneda.getBounds())) {

			puntajeCafe = puntajeCafe + 10;
			puntajeCafeString = Integer.toString(puntajeCafe);
			lblCafe.setText("TEAM BROWN: " +puntajeCafeString);

			moneda.setLocation(nx,ny);

			if (puntajeCafe == 100) {

				rep.inicializar();  

				for (int i=1; i<3; i++) {

					rep.reproducirNota(64, 1, 150);
					rep.reproducirNota(60, 1, 150);
					rep.reproducirNota(60, 1, 150);
					rep.reproducirNota(68, 1, 800);
				}
			
				rep.finalizar();

				AvisoCafe avsCafe = new AvisoCafe();
				this.setVisible(false);
			}
		}

		if (enemigoNaranja.getBounds().intersects(moneda.getBounds())) {

			puntajeNaranja = puntajeNaranja + 10;
			puntajeNaranjaString = Integer.toString(puntajeNaranja);
			lblNaranja.setText("TEAM ORANGE: " +puntajeNaranjaString);

			moneda.setLocation(nx,ny);

			if (puntajeNaranja == 100) {

				rep.inicializar(); 

				for (int i=1; i<3; i++) {

					rep.reproducirNota(64, 1, 150);
					rep.reproducirNota(60, 1, 150);
					rep.reproducirNota(60, 1, 150);
					rep.reproducirNota(68, 1, 800);
				}
			
				rep.finalizar();

				AvisoNaranja avsNaranja = new AvisoNaranja();
				this.setVisible(false);
			}
		}
	}

	public void cambiarTextoLblCafe (String cadena) {

		this.lblCafe.setText(cadena);
	}

	public void cambiarTextoLblNaranja (String cadena) {

		this.lblNaranja.setText(cadena);
	}
}