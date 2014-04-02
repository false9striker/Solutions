import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Problem statement: Given a number n, convert the number to its binary
 * representation.
 * 
 * Input: First line of input will contain T = number of test case. Next T lines
 * will each have a number n. n will be between 0 and 1000000000 (10^9)
 * 
 * Output: For each number print its binary form on a single line. There should
 * be no leading zeroes in the result..
 * 
 * @author Venugopal Madathil
 * 
 */
public class DecimalToBinary {
	public static void main(String args[]) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int limit = Integer.parseInt(br.readLine());
		String inputArray[] = new String[limit];
		for (int i = 0; i < limit; i++) {
			inputArray[i] = br.readLine();
		}
		findBinary(inputArray);
	}

	private static void findBinary(String[] binaryStrArray) {
		String[] resultArray = new String[binaryStrArray.length];
		for (int j = 0; j < binaryStrArray.length; j++) {
			BigInteger decimal = new BigInteger(binaryStrArray[j]);
			String binary = "";
			BigInteger mod = BigInteger.valueOf(0);
			if (decimal.equals(new BigInteger("0"))) {
				binary += "0";
			} else {
				while (!decimal.equals(new BigInteger("0"))) {
					mod = decimal.mod(new BigInteger("2"));
					decimal = decimal.divide(new BigInteger("2"));
					binary += String.valueOf(mod);
				}
			}
			StringBuffer sb = new StringBuffer(binary);
			resultArray[j] = sb.reverse().toString();
		}
		for (int j = 0; j < resultArray.length; j++) {
			System.out.println(resultArray[j]);
		}
	}

}
