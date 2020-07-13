import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

class RojoVsVerde extends JPanel {

	BufferedImage imagenRV;

	public RojoVsVerde (BufferedImage imagenRV) {

		this.imagenRV = imagenRV;
	}

	@Override
	public void paintComponent (Graphics g) {

		super.paintComponent(g);
		g.drawImage(imagenRV, 0, 0, 300, 90, null);
		setOpaque(false);
	}
}