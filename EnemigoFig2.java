import javax.swing.*;
import java.awt.image.*;
import java.awt.*;
class EnemigoFig2 extends JPanel
{
	BufferedImage imagenEnemy2;

	public EnemigoFig2 (BufferedImage imagenEnemy2) {

		this.imagenEnemy2 = imagenEnemy2;
	}

	@Override
	public void paintComponent (Graphics g) {

		super.paintComponent(g);
		g.drawImage(imagenEnemy2, 0, 0, 70, 70, null);
		setOpaque(false);
	}
}