import javax.swing.*;
import java.awt.image.*;
import java.awt.*;

class Moneda extends JPanel
{
	BufferedImage imagenMoneda;

	public Moneda(BufferedImage imagenMoneda)
	{
		this.imagenMoneda = imagenMoneda;
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(imagenMoneda, 0, 0, 50, 50, null);
		setOpaque(false);
	}
}
