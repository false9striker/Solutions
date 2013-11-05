public class BinaryCode {
	public String[] decode(String message) {
		String[] result = { "NONE", "NONE" };
		char[] q = message.toCharArray();
		int[] p;
		boolean flag = false;
		if (message.length() >= 1 && message.length() <= 50) {
			if (message.length() == 1
					&& (returnInt(q[0]) != 0 && returnInt(q[0]) != 1 && returnInt(q[0]) != 2)) {
				return result;
			}
			for (int j = 0; j < 2; j++) {
				flag = false;
				p = new int[message.length()];
				for (int i = 0; i < message.length(); i++) {
					if (i == 0) {
						p[i] = j;
					} else if (i == 1) {
						p[i] = returnInt(q[i - 1]) - p[i - 1];
						if (p[i] != 0 && p[i] != 1) {
							result[j] = "NONE";
							flag = true;
							break;
						}
					} else {
						p[i] = returnInt(q[i - 1]) - (p[i - 2] + p[i - 1]);
						if (p[i] != 0 && p[i] != 1) {
							result[j] = "NONE";
							flag = true;
							break;
						}
					}
				}
				if (!flag) {
					result[j] = "";
					for (int k = 0; k < p.length; k++) {
						result[j] += String.valueOf(p[k]);
					}
				}
			}
		}
		return result;
	}

	public int returnInt(char character) {
		return Character.getNumericValue(character);
	}
}
