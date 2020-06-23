import javax.swing.*;
import java.awt.*;

class CambioFondo extends JPanel {

	public Image imagen;

	@Override
	public void paint(Graphics g)
	{
		imagen = new ImageIcon(getClass().getResource("C:/Users/luish/OneDrive/Escritorio/GAME/FondoN1.png")).getImage();

		g.drawImage(imagen,0,0,getWidth(),getHeight(),this);

		setOpaque(false);

		super.paint(g);
	}
}