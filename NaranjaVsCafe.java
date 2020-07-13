import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

class NaranjaVsCafe extends JPanel {

	BufferedImage imagenNC;

	public NaranjaVsCafe (BufferedImage imagenNC) {

		this.imagenNC = imagenNC;
	}

	@Override
	public void paintComponent (Graphics g) {

		super.paintComponent(g);
		g.drawImage(imagenNC, 0, 0, 300, 90, null);
		setOpaque(false);
	}
}