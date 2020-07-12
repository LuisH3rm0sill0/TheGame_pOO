import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

class AzulvsAmarillo extends JPanel {

	BufferedImage imagenAA;

	public AzulvsAmarillo (BufferedImage imagenAA) {

		this.imagenAA = imagenAA;
	}

	@Override
	public void paintComponent (Graphics g) {

		super.paintComponent(g);
		g.drawImage(imagenAA, 0, 0, 300, 90, null);
		setOpaque(false);
	}
}