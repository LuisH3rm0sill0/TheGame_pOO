import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

class EnemigoFig extends JPanel {

	BufferedImage imagenEnemy;

	public EnemigoFig (BufferedImage imagenEnemy) {

		this.imagenEnemy = imagenEnemy;
	}

	@Override
	public void paintComponent (Graphics g) {

		super.paintComponent(g);
		g.drawImage(imagenEnemy, 0, 0, 70, 70, null);
		setOpaque(false);
	}
}