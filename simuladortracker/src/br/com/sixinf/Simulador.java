/**
 * 
 */
package br.com.sixinf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author maicon
 *
 */
public class Simulador {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*String stringNMEA = "$GPRMC,232029.000,A,2028.746172,S,05435.774688,W,0.7,170.4,291213,,,A*6A";
		boolean checksumok = SimuladorHelper.ChecksumNMEAVerify(stringNMEA);
		System.out.println("Checksum ok? " + checksumok);*/
		
		while (true) {
			BufferedReader br = null;
			try {
				
				File f = new File("/home/maicon/six/pettracker/coordenadas_log.txt");
				br = new BufferedReader(new FileReader(f));
				String str = null;
				while ((str = br.readLine()) != null) {
					/* número de série e a string completa da coordenada são simulados, verificar como o aparelho irá enviar e mudar
					* Nossa string simulada será:
					* [série] + mensagem
					*/
					String serie = "1234";
					
					str = serie+str;
					
					System.out.println(str);
					
					OutputStream os = null;
					
					try {
						
						// enviar via socket
						Socket s = new Socket("localhost", 2828);
						os = s.getOutputStream();
						os.write(str.getBytes());
						s.close();
						
						// pausa por 1 segundo
						Thread.sleep(1000);
					
					} catch (IOException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						try {
						if (os != null)
							os.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (br != null)
						br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
