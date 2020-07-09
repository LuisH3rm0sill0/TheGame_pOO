import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;

class Nivel1 extends JFrame implements KeyListener {

	JPanel panel;
	JLabel lblBarra;
	JLabel lblTexto1;

	BufferedImage imagenEnemy;
	BufferedImage subImagenEnemy;
	//JPanel enemy;
	EnemigoFig enemy;
	BufferedImage imagen;
	BufferedImage subImagen;
	Personaje personaje;

	//para la monedita
	
	BufferedImage imagenMonedita;
	Moneda monedita;


	//para el final
	Rectangle areaFinal = new Rectangle(640,80,60,340);
	boolean fin = false;

	public Nivel1() {
		
		panel = new CambioDeFondo("Mapa.png");
		panel.setLayout(null);

		lblBarra = new JLabel();
		lblBarra.setBounds(320, 80, 50 , 30);

		lblTexto1 = new JLabel("Puntos Rojo:");
		lblTexto1.setBounds(240,80,90,30);
		
		//Personaje 1

		try {
			imagenEnemy = ImageIO.read(new File("OjosRojos.png"));
		} catch (Exception e) {
			System.out.println("Error: al cargar la imagen.");
		}
		subImagenEnemy = imagenEnemy.getSubimage(0,0,500,500);
		enemy = new EnemigoFig(subImagenEnemy);
		enemy.setBounds(0,100,100,100);
		//Personaje2
		try {
			imagen = ImageIO.read(new File("OjosVerdes.png"));
		} catch (Exception e) {
			System.out.println("Error: al cargar la imagen.");
		}
		subImagen = imagen.getSubimage(0,0,500,500);
		personaje = new Personaje(subImagen);
		personaje.setBounds(0,260,100,100);

		//Moneda calis
		
		try{
			imagenMonedita = ImageIO.read(new File("monedaF.png"));
		}catch(Exception e){
			System.out.println("Error al cargar la imagen.");
		}
		monedita = new Moneda(imagenMonedita);
		monedita.setBounds(90, 30, 50, 50);







		panel.add(personaje);
		panel.add(enemy);
		panel.add(monedita);
		panel.add(lblBarra);
		panel.add(lblTexto1);

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

		Point posPer = personaje.getLocation();
		int xp = (int)posPer.getX();
		int yp = (int)posPer.getY();
		
		if (fin == false) {

			if(t==68) {

				xp = xp+10;
				personaje.imagen = imagen.getSubimage(500,0,500,500);
			}

			personaje.setLocation(xp,yp);

			Point posEn = enemy.getLocation();
			int xe = (int)posEn.getX();
			int ye = (int)posEn.getY();

			if(t==39) {

				xe = xe+10;
				enemy.imagenEnemy = imagenEnemy.getSubimage(500,0,500,500);
			}

			enemy.setLocation(xe,ye);
			colision();
		}
	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent e) {

	}

	public void colision() {

		Reproductor rep = new Reproductor();

		if (enemy.getBounds().intersects(areaFinal.getBounds())) {

			//Puntuacion
			this.lblBarra.setText(this.lblBarra.getText()+"55");
			//
			
			rep.inicializar();  

			for (int i=1; i<3; i++) {

				rep.reproducirNota(64, 1, 150);
				rep.reproducirNota(60, 1, 150);
				rep.reproducirNota(60, 1, 150);
				rep.reproducirNota(68, 1, 800);
			}
			
			rep.finalizar();

			this.fin = true;

			AvisoRojo avsR = new AvisoRojo();

			//this.setVisible(false);

		} else if (personaje.getBounds().intersects(areaFinal.getBounds())) {

			rep.inicializar();

			for (int i=1; i<3; i++) {

				rep.reproducirNota(64, 1, 150);
				rep.reproducirNota(60, 1, 150);
				rep.reproducirNota(60, 1, 150);
				rep.reproducirNota(68, 1, 800);
			}
			
			rep.finalizar();

			this.fin = true;

			AvisoVerde avsV = new AvisoVerde();

			this.setVisible(false);
		}
	}
}