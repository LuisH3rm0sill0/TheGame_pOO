import java.util.*;
import java.io.*;
import javax.sound.midi.*;

class Reproductor{
	
	private Synthesizer synthe = null;
	private int intensity = 100;
	private MidiChannel [] channels;
	private MidiChannel channel;

	private Instrument[] instrumentos;

	public Reproductor(){
		try{
			synthe = MidiSystem.getSynthesizer();

		} catch(Exception e) {
			System.out.println("Error: al obtener synthe.");
		}
	}

	public void inicializar(){
		try{
			synthe.open();
			channels = synthe.getChannels();

			instrumentos = synthe.getLoadedInstruments();

		} catch(Exception e) {
			System.out.println("Error: al inizializar el synthe.");
		}
	}

	public void reproducirNota(int nota, int canal, int duracion){
		
		channel = channels[canal];
		channel.programChange(0,13);
		channel.noteOn(nota, intensity);

		try{
			Thread.sleep(duracion);

		} catch(Exception e) {
			System.out.println("ERROR: en sleep.");
		}

		channel.noteOff(nota);
	}

	public static ArrayList<String> LeerNotas(String nombreArchivo) {

		ArrayList<String> notasArchivo = new ArrayList<String>();
		String rdNota = new String();

		try(FileInputStream fis = new FileInputStream(nombreArchivo);
			DataInputStream din = new DataInputStream(fis);
			BufferedReader br = new BufferedReader(new InputStreamReader(din));) {

			rdNota = br.readLine();

			while(rdNota != null) {

				notasArchivo.add(rdNota);
				rdNota = br.readLine();
			}

		} catch(Exception e) {

			e.printStackTrace();
		}

		return notasArchivo;
	}

	public void finalizar(){
		try{
			synthe.close();

		} catch(Exception e) {
			System.out.println("Error: al finalizar el synthe.");
		}
	}
}