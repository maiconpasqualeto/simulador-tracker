/**
 * 
 */
package br.com.sixinf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author maicon
 *
 */
public class Simulador {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*String stringNMEA = "$GPGSA,A,3,15,18,21,22,25,29,31,,,,,,2.0,1.0,1.6*36";
		boolean checksumok = SimuladorHelper.ChecksumNMEAVerify(stringNMEA);
		System.out.println("Checksum ok? " + checksumok);*/
		
		while (true) {
			BufferedReader br = null;
			try {
				
				File f = new File("/home/maicon/six/pettracker/coordenadas_log.txt");
				br = new BufferedReader(new FileReader(f));
				String str = null;
				while ((str = br.readLine()) != null) {
					
					System.out.println(str);
					
					// enviar via socket
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
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
