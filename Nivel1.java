import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;

class Nivel1 extends JFrame implements KeyListener {

	//JPanel panel;
	BufferedImage imagenFondo;
	Krita fondo;

	BufferedImage imagen;
	BufferedImage subImagen;
	Personaje personaje;
	int indiceX = 0;

	public Nivel1() {

		try {
			imagenFondo = ImageIO.read(new File("NivelPink.png"));
		} catch (Exception e) {
			System.out.println("Error: al cargar la imagen.");
		}
		fondo = new Krita(imagenFondo);

		//panel = new JPanel();
		//panel.setLayout(null);
		//panel.setFocusable(true);
		//panel.requestFocusInWindow();


		try {
			imagen = ImageIO.read(new File("professor_walk.png"));
		} catch (Exception e) {
			System.out.println("Error: al cargar la imagen.");
		}

		subImagen = imagen.getSubimage(0,64*3,64,64);
		personaje = new Personaje(subImagen);


		
		this.add(personaje);


		this.setTitle("NIVEL 1");
		this.setBounds(0, 0, 700, 500);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.addKeyListener(this);
		//this.add(panel);
		this.add(fondo);
	}

	public void keyPressed(KeyEvent e) {

		int t = e.getKeyCode();

		Point pos = personaje.getLocation();
		int x = (int)pos.getX();
		int y = (int)pos.getY();

		if(t==68)
		{
			x = x+5;
			indiceX = ((indiceX + 1) % 9) * 64;
			personaje.imagen = imagen.getSubimage(indiceX,64*3,64,64);
		}

		else if(t==65)
		{
			x = x-5;
			indiceX = ((indiceX + 1) % 9) * 64;
			personaje.imagen = imagen.getSubimage(indiceX,64*1,64,64);
		}

		else if(t==83)
		{
			y = y+5;
			indiceX = ((indiceX + 1) % 9) * 64;
			personaje.imagen = imagen.getSubimage(indiceX,64*2,64,64);
		}
		else if(t==87)
		{
			y = y-5;
			indiceX = ((indiceX + 1) % 9) * 64;
			personaje.imagen = imagen.getSubimage(indiceX,64*0,64,64);
		}

		personaje.setLocation(x,y);
	}

	public void keyReleased(KeyEvent e) {

		/* System.out.println("Tecla liberada."); */
	}

	public void keyTyped(KeyEvent e) {

		/* System.out.println("Tecla en el Buffer."); */
	}

}