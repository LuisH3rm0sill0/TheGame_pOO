import javax.swing.*;
import java.awt.*;

class CambioDeFondo extends JPanel {

	public Image imagen;
	String ruta;

	public CambioDeFondo(String ruta) {

		this.ruta = ruta;
	}

	@Override
	public void paint(Graphics g)
	{
		imagen = new ImageIcon(getClass().getResource(ruta)).getImage();

		g.drawImage(imagen,0,0,getWidth(),getHeight(),this);

		setOpaque(false);

		super.paint(g);
	}
}