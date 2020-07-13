import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

class MovimientoMoneda implements Runnable {

	BufferedImage imagenMoneda;
	BufferedImage subImagenMoneda;
	Moneda moneda;

	public MovimientoMoneda(BufferedImage imagenMoneda, BufferedImage subImagenMoneda, Moneda moneda) {

		this.imagenMoneda = imagenMoneda;
		this.subImagenMoneda = subImagenMoneda;
		this.moneda = moneda;
	}

	@Override
	public void run() {

		int w = 0;

		while (true) {

			for (int x=0; x<3; x++) {

				w = w + 500;
				this.moneda.imagenMoneda = imagenMoneda.getSubimage(w, 0, 500, 500);
			} 

			retardo(10);
		}
	}

	public void retardo(int ms) {

		try {

			Thread.sleep(ms);
		} catch(Exception e) {

			System.out.println("Error: al ejecutar el sleep.");
		}
	}
}