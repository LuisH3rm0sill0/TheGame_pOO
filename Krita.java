import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

class Krita extends JPanel {

	BufferedImage imagen;

	public Krita (BufferedImage imagen) {

		this.imagen = imagen;
	}

	@Override
	public void paintComponent (Graphics g) {

		super.paintComponent(g);
		g.drawImage(imagen, 0, 0, 700, 500, null);
	}
}