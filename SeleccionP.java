import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
class SeleccionP extends JFrame implements ActionListener
{
	JPanel panel;
	BufferedImage mngFondo;
	JButton btnAzAm;
	JButton btnNaCa;
	JButton btnRoVe;

	BufferedImage imgAA;
	AzulvsAmarillo ayA;

	BufferedImage imgNC;
	AzulvsAmarillo nyC;

	BufferedImage imgRV;
	AzulvsAmarillo ryV;

	public SeleccionP(){

		panel = new CambioDeFondo("./imagenes/seleccion.png");
		panel.setLayout(null);
		panel.setFocusable(true);
		panel.requestFocusInWindow();

		btnAzAm = new JButton("Azul vs Amarillo");
		btnAzAm.setBounds(150, 100, 150, 30);
		btnAzAm.setBackground(Color.WHITE);
		btnNaCa = new JButton("Naranja vs Cafe");
		btnNaCa.setBounds(150, 250, 150, 30);
		btnNaCa.setBackground(Color.WHITE);
		btnRoVe = new JButton("Verde vs Rojo");
		btnRoVe.setBounds(150, 400, 150, 30);
		btnRoVe.setBackground(Color.WHITE);

		//Azul y amarillo
		try {
			imgAA = ImageIO.read(new File("./imagenes/azul y amarillo.png"));
		} catch (Exception e) {
			System.out.println("Error: al cargar la imagen.");
		}
		ayA = new AzulvsAmarillo(imgAA);
		ayA.setBounds(75,135,300,90);

		//Naranja y cafe
		try {
			imgNC = ImageIO.read(new File("./imagenes/naranja vs cafe.png"));
		} catch (Exception e) {
			System.out.println("Error: al cargar la imagen.");
		}
		nyC = new AzulvsAmarillo(imgNC);
		nyC.setBounds(75, 285, 300, 90);

		//Rojo y verde
		try {
			imgRV = ImageIO.read(new File("./imagenes/rojo y verde.png"));
		} catch (Exception e) {
			System.out.println("Error: al cargar la imagen.");
		}
		ryV = new AzulvsAmarillo(imgRV);
		ryV.setBounds(75, 435, 300, 90);

		panel.add(btnAzAm);
		panel.add(btnNaCa);
		panel.add(btnRoVe);
		panel.add(ayA);
		panel.add(nyC);
		panel.add(ryV);

		this.add(panel);
		this.setTitle("Seleccion de personajes");
		this.setBounds(600, 250, 450, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);

		btnRoVe.addActionListener(this);
		btnAzAm.addActionListener(this);
		btnNaCa.addActionListener(this);
	}
	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == this.btnRoVe) {

			//Hacia Nivel2
			Nivel2 niv2 = new Nivel2();
			this.setVisible(false);

		}else if(event.getSource() == this.btnAzAm){
			Nivel2AA niv2AA = new Nivel2AA();
			this.setVisible(false);
		} 
		else if(event.getSource() == this.btnNaCa){
			Nivel2NC niv2NC = new Nivel2NC();
			this.setVisible(false);
		} 


		/*else if (event.getSource() == this.btnExit) {

			//Cerrar programa
			System.exit(ABORT);
		}*/
	}


}