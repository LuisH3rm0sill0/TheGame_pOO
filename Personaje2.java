import javax.swing.*;
import java.awt.image.*;
import java.awt.*;
class Personaje2 extends JPanel
{
	BufferedImage imagen2;

	public Personaje2 (BufferedImage imagen2) {

		this.imagen2 = imagen2;
	}

	@Override
	public void paintComponent (Graphics g) {

		super.paintComponent(g);
		g.drawImage(imagen2, 0, 0, 70, 70, null);
		setOpaque(false);
	}
}