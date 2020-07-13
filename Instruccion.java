import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

class Instruccion extends JPanel {

	BufferedImage imagenIns;

	public Instruccion (BufferedImage imagenIns) {

		this.imagenIns = imagenIns;
	}

	@Override
	public void paintComponent (Graphics g) {

		super.paintComponent(g);
		g.drawImage(imagenIns, 0, 0, 80, 60, null);
		setOpaque(false);
	}
}