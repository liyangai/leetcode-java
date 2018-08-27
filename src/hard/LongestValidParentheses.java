package hard;

public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		int len = s.length();
		if (len < 2)
			return 0;
		int leftN = 0;
		int leftR = 0;
		int max = 0;
		for (int i = 0; i < len - 1; i++) {
			if (s.charAt(i) == '(') {
				leftN = 1;
				leftR = 0;
				for (int j = i + 1; j < len ; j++) {
					if (s.charAt(j) == ')') {
						leftR++;
						if (leftR > leftN) {
							break;
						} else {
							max = Math.max(max, leftR);
						}
					} else {
						leftN++;
					}
				}

			}
		}
		return max * 2;
	}

	public static void main(String[] args) {
		LongestValidParentheses test = new LongestValidParentheses();
		test.longestValidParentheses("()");

	}

}
