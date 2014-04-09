import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problem statement: Given a number, verify whether its prime or not
 * 
 * Input : First line of input will contain a number N = number of test cases.
 * Next N lines will contain number n as test case where 0<=n<=1000000000
 * 
 * Output : For each input case, print "PRIME" if the number is prime, else
 * print "NOT PRIME" (quotes for clarity)
 * 
 * @author Venugopal Madathil
 * 
 */
public class PrimeChecker {
	public static void main(String args[]) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int limit = Integer.parseInt(br.readLine());
		String inputArray[] = new String[limit];
		for (int i = 0; i < limit; i++) {
			inputArray[i] = br.readLine();
		}
		primeChecker(inputArray);
	}

	private static void primeChecker(String[] inputArray) {
		String[] resultArray = new String[inputArray.length];
		for (int i = 0; i < inputArray.length; i++) {
			int n = Integer.valueOf(inputArray[i]);
			int flag = 0;
			if (n <= 1) {
				resultArray[i] = "NOT PRIME";
			} else if (n == 2 || n == 3) {
				resultArray[i] = "PRIME";
			} else {
				for (int j = 2; j <= (int) Math.sqrt(n); j++) {
					if (n % j == 0) {
						flag = 1;
						break;
					}
				}
				if (flag == 1) {
					resultArray[i] = "NOT PRIME";
				} else {
					resultArray[i] = "PRIME";
				}
			}

		}

		for (int j = 0; j < resultArray.length; j++) {
			System.out.println(resultArray[j]);
		}

	}

}
