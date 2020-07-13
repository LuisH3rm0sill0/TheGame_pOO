import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

class InstruccionN1 extends JPanel {

	BufferedImage imagenInsN1;

	public InstruccionN1 (BufferedImage imagenInsN1) {

		this.imagenInsN1 = imagenInsN1;
	}

	@Override
	public void paintComponent (Graphics g) {

		super.paintComponent(g);
		g.drawImage(imagenInsN1, 0, 0, 100, 100, null);
		setOpaque(false);
	}
}