import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

class EnemigoFig extends JPanel {

	BufferedImage imagenEnemy;

	public EnemigoFig (BufferedImage imagen) {

		this.imagenEnemy = imagenEnemy;
	}

	@Override
	public void paintComponent (Graphics g) {

		super.paintComponent(g);
		g.drawImage(imagenEnemy, 10, 300, 64, 64, null);
		setOpaque(false);
	}
}