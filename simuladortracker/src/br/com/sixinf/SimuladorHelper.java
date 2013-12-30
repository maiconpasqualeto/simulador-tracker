/**
 * 
 */
package br.com.sixinf;

/**
 * @author maicon
 *
 */
public class SimuladorHelper {
	
	public static boolean ChecksumNMEAVerify(String stringNMEA) {
		boolean retorno = false; 
		if (!stringNMEA.startsWith("$")) 
	        throw new UnsupportedOperationException("String NMEA inválida: " + stringNMEA);
		
		int finalString = stringNMEA.indexOf('*');
		
		String checksumString = stringNMEA.substring(finalString + 1, stringNMEA.length());
		
		stringNMEA = stringNMEA.substring(1, finalString);		
		
		byte[] bytes = stringNMEA.getBytes();
		int i = 0;
		for (byte b : bytes) {
			i ^= b;
		}
		
		String checksumCalculado = Integer.toHexString(i).toUpperCase();
		
		System.out.println("Checksum string: " + checksumString);
		System.out.println("Checksum calculado: " + checksumCalculado);
		
		if (checksumString.equals(checksumCalculado))
			retorno = true;
		
		return retorno;
	}

}
