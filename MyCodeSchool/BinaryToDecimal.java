import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Given the binary representation of a number, convert it to its decimal form.
 * Input: The first line will contain an integer T = number of test case. Next T
 * lines will contain a string of size 1 to 30 characters representing the
 * binary form of a number.
 * 
 * Output: For each string (binary form), print on a single line, the number in
 * decimal number system.
 * 
 * @author Venugopal Madathil
 * 
 */
public class BinaryToDecimal {
	public static void main(String args[]) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int limit = Integer.parseInt(br.readLine());
		String inputArray[] = new String[limit];
		for (int i = 0; i < limit; i++) {
			inputArray[i] = br.readLine();
		}
		findDecimal(inputArray);
	}

	private static void findDecimal(String[] binaryStrArray) {
		String[] resultArray = new String[binaryStrArray.length];
		for (int j = 0; j < binaryStrArray.length; j++) {
			BigInteger binary = new BigInteger(binaryStrArray[j]);
			BigInteger decimal = BigInteger.valueOf(0);
			BigInteger mod = BigInteger.valueOf(0);
			for (int i = 0; i < binaryStrArray[j].length(); i++) {
				mod = binary.mod(new BigInteger("10"));
				binary = binary.divide(new BigInteger("10"));
				decimal = decimal.add(mod.multiply(BigInteger
						.valueOf((long) Math.pow(2, i))));
			}
			resultArray[j] = String.valueOf(decimal);
		}
		for (int j = 0; j < resultArray.length; j++) {
			System.out.println(resultArray[j]);
		}
	}

}
