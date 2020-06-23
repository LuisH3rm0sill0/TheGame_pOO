import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

class Personaje extends JPanel {

	BufferedImage imagen;

	public Personaje (BufferedImage imagen) {

		this.imagen = imagen;
	}

	@Override
	public void paintComponent (Graphics g) {

		super.paintComponent(g);
		g.drawImage(imagen, 10, 150, 64, 64, null);
		setOpaque(false);
	}
}