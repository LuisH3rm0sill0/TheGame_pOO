import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;

class Nivel1 extends JFrame implements KeyListener {

	BufferedImage imagenFondoN1;
	Krita fondoN1;

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

		try {
			imagen = ImageIO.read(new File("C:/Users/luish/OneDrive/Escritorio/GAME/BolaNegra.png"));
		} catch (Exception e) {
			System.out.println("Error: al cargar la imagen.");
		}

		subImagen = imagen.getSubimage(0,0,500,500);
		personaje = new Personaje(subImagen);

		this.add(personaje);

		this.setTitle("NIVEL 1");
		this.setBounds(0, 0, 700, 500);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		this.addKeyListener(this);

		this.add(fondoN1);
	}

	public void keyPressed(KeyEvent e) {

		int t = e.getKeyCode();

		Point pos = personaje.getLocation();
		int x = (int)pos.getX();
		int y = (int)pos.getY();

		if(t==68)
		{
			x = x+5;
			personaje.imagen = imagen.getSubimage(500,0,500,500);
		}

		else if(t==65)
		{
			x = x-5;
			personaje.imagen = imagen.getSubimage(0,500,500,500);
		}

		else if(t==83)
		{
			y = y+5;
			personaje.imagen = imagen.getSubimage(0,0,500,500);
		}
		else if(t==87)
		{
			y = y-5;
			personaje.imagen = imagen.getSubimage(500,500,500,500);
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