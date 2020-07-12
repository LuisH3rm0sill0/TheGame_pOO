import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;
import java.util.Random;
class Nivel2AA extends JFrame implements KeyListener
{
	JPanel panel;

	JLabel lblAmarillo, lblAzul;

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

	public Nivel2AA() {

		panel = new CambioDeFondo("./imagenes/FondoN2.png");
		panel.setLayout(null);

		lblAzul = new JLabel ("TEAM BLUE:");
		lblAzul.setBounds(30, 10, 150, 30);
		lblAzul.setForeground(Color.WHITE);

		lblAmarillo = new JLabel ("TEAM YELLOW:");
		lblAmarillo.setBounds(190, 10, 150, 30);
		lblAmarillo.setForeground(Color.WHITE);

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
			imagenEnemy = ImageIO.read(new File("./imagenes/OjosAmarillos.png"));
		} catch (Exception e) {
			System.out.println("Error: al cargar la imagen.");
		}

		subImagenEnemy = imagenEnemy.getSubimage(0,0,500,500);
		enemy = new EnemigoFig2(subImagenEnemy);
		enemy.setBounds(590,210,70,70);

		//Personaje2
		try {
			imagen = ImageIO.read(new File("./imagenes/OjosAzules.png"));
		} catch (Exception e) {
			System.out.println("Error: al cargar la imagen.");
		}

		subImagen = imagen.getSubimage(0,0,500,500);
		personaje = new Personaje2(subImagen);
		personaje.setBounds(30,210,70,70);

		panel.add(lblAmarillo);
		panel.add(lblAzul);
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
			lblAzul.setText("TEAM BLUE: " +puntajeVerdeString);

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

				AvisoAzul avsVerde = new AvisoAzul();
				this.setVisible(false);
			}
		}

		if (enemy.getBounds().intersects(moneda.getBounds())) {

			puntajeRojo = puntajeRojo + 10;
			puntajeRojoString = Integer.toString(puntajeRojo);
			lblAmarillo.setText("TEAM YELLOW: " +puntajeRojoString);

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

				AvisoAmarillo avsRojo = new AvisoAmarillo();
				this.setVisible(false);
			}
		}
	}

	public void cambiarTextoLblVerde (String cadena) {

		this.lblAzul.setText(cadena);
	}

	public void cambiarTextoLblRojo (String cadena) {

		this.lblAmarillo.setText(cadena);
	}

}
