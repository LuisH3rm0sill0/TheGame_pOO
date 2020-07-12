import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;
import java.util.Random;
class Nivel2NC extends JFrame implements KeyListener
{
	JPanel panel;

	JLabel lblCafe, lblNaranja;

	BufferedImage imagenMoneda;
	BufferedImage subImagenMoneda;
	Moneda moneda;

	BufferedImage imagenEnemy;
	BufferedImage subImagenEnemy;
	EnemigoFig2 enemy;

	BufferedImage imagen;
	BufferedImage subImagen;
	Personaje2 personaje;

	Rectangle colisionArriba = new Rectangle(0,0,700,50);
	Rectangle colisionAbajo = new Rectangle(0,450,700,50);
	Rectangle colisionIzquierda = new Rectangle(0,50,25,430);
	Rectangle colisionDerecha = new Rectangle(670,50,25,430);

	boolean fin = false;
	boolean t = true;

	int puntajeRojo = 0;
	int puntajeVerde = 0;

	public Nivel2NC() {

		panel = new CambioDeFondo("./imagenes/FondoN2.png");
		panel.setLayout(null);

		lblNaranja = new JLabel ("TEAM ORANGE:");
		lblNaranja.setBounds(30, 10, 150, 30);
		lblNaranja.setForeground(Color.WHITE);

		lblCafe = new JLabel ("TEAM BROWN:");
		lblCafe.setBounds(190, 10, 150, 30);
		lblCafe.setForeground(Color.WHITE);

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
			imagenEnemy = ImageIO.read(new File("./imagenes/OjosCafes.png"));
		} catch (Exception e) {
			System.out.println("Error: al cargar la imagen.");
		}

		subImagenEnemy = imagenEnemy.getSubimage(0,0,500,500);
		enemy = new EnemigoFig2(subImagenEnemy);
		enemy.setBounds(590,210,70,70);

		//Personaje2
		try {
			imagen = ImageIO.read(new File("./imagenes/OjosNaranjas.png"));
		} catch (Exception e) {
			System.out.println("Error: al cargar la imagen.");
		}

		subImagen = imagen.getSubimage(0,0,500,500);
		personaje = new Personaje2(subImagen);
		personaje.setBounds(30,210,70,70);

		panel.add(lblCafe);
		panel.add(lblNaranja);
		panel.add(personaje);
		panel.add(enemy);
		panel.add(moneda);

		this.add(panel);
		this.setTitle("NIVEL 2");
		this.setSize(700, 500);
		this.setLocation(600,250);
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
				personaje.imagen2 = imagen.getSubimage(500,0,500,500);
				if(personaje.getBounds().intersects(colisionDerecha.getBounds())){
					xp = xp - 10;
				}
			}

			if(t==65) { // izq

				xp = xp-10;
				personaje.imagen2 = imagen.getSubimage(0,500,500,500);
				if(personaje.getBounds().intersects(colisionIzquierda.getBounds())){
					xp = xp + 10;
				}
			}

			if(t==87) { // arriba

				yp = yp-10;
				personaje.imagen2 = imagen.getSubimage(500,500,500,500);
				if(personaje.getBounds().intersects(colisionArriba.getBounds())){
					yp = yp + 10;
				}
			}

			if(t==83) { // abajo

				yp = yp+10;
				personaje.imagen2 = imagen.getSubimage(0,0,500,500);
				if(personaje.getBounds().intersects(colisionAbajo.getBounds())){
					yp = yp - 10;
				}
			}
			personaje.setLocation(xp,yp);


			Point posEn = enemy.getLocation();
			int xe = (int)posEn.getX();
			int ye = (int)posEn.getY();


			if(t==39) { // der

				xe = xe+10;
				enemy.imagenEnemy2 = imagenEnemy.getSubimage(500,0,500,500);
				if(enemy.getBounds().intersects(colisionDerecha.getBounds())){
					xe = xe - 10;
				}
			}

			if(t==37) { // izq

				xe = xe-10;
				enemy.imagenEnemy2 = imagenEnemy.getSubimage(0,500,500,500);
				if(enemy.getBounds().intersects(colisionIzquierda.getBounds())){
					xe = xe + 10;
				}
			}

			if(t==38) { // arriba

				ye = ye-10;
				enemy.imagenEnemy2 = imagenEnemy.getSubimage(500,500,500,500);
				if(enemy.getBounds().intersects(colisionArriba.getBounds())){
					ye = ye + 10;
				}
			}

			if(t==40) { // abajo

				ye = ye+10;
				enemy.imagenEnemy2 = imagenEnemy.getSubimage(0,0,500,500);
				if(enemy.getBounds().intersects(colisionAbajo.getBounds())){
					ye = ye - 10;
				}
			}

			enemy.setLocation(xe,ye);

			movimientoMoneda();

			//Ventana de pausa
			int nTecla = e.getKeyCode();

			if (nTecla == 80) {
			
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

		Reproductor rep = new Reproductor();

		Random numA = new Random();
		int nx = numA.nextInt(600);
		int ny = numA.nextInt(400);

		String puntajeVerdeString, puntajeRojoString;

		if (personaje.getBounds().intersects(moneda.getBounds())) {

			puntajeVerde = puntajeVerde + 10;
			puntajeVerdeString = Integer.toString(puntajeVerde);
			lblNaranja.setText("TEAM ORANGE: " +puntajeVerdeString);

			moneda.setLocation(nx,ny);

			if (puntajeVerde == 100) {

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

		if (enemy.getBounds().intersects(moneda.getBounds())) {

			puntajeRojo = puntajeRojo + 10;
			puntajeRojoString = Integer.toString(puntajeRojo);
			lblCafe.setText("TEAM BROWN: " +puntajeRojoString);

			moneda.setLocation(nx,ny);

			if (puntajeRojo == 100) {

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
	}

	public void cambiarTextoLblVerde (String cadena) {

		this.lblNaranja.setText(cadena);
	}

	public void cambiarTextoLblRojo (String cadena) {

		this.lblCafe.setText(cadena);
	}

}
