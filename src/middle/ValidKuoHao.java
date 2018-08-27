package middle;

public class ValidKuoHao {
	public boolean isValid(String s) {
		return valid(s);
	}

	private boolean valid(String s) {
		int length = s.length();
		if (length % 2 == 1)
			return false;
		if (length == 0)
			return true;
		Character right = getRight(s.charAt(0));
		if (right == 'x')
			return false;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == right) {
				if (s.length() == 2)
					return true;
				if (i == s.length() - 1) {
					String leftString = s.substring(0, i);
					return valid(leftString);
				} else {
					String leftString = s.substring(0, i);
					String rightString = s.substring(i + 1);
					return valid(leftString) && valid(rightString);
				}

			}
		}
		return false;
	}

	private char getRight(char left) {
		if (left == '(') {
			return ')';
		} else if (left == '[') {
			return ']';
		} else if (left == '{') {
			return '}';
		} else {
			return 'x';
		}
	}
	
	public static void main(String[] args) {
		ValidKuoHao test = new ValidKuoHao();
		test.isValid("()[]{}");
	}
}
