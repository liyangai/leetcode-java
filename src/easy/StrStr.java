package easy;

public class StrStr {
	public int strStr(String haystack, String needle) {
		int lenLeft = haystack.length();
		int lenRight = needle.length();
		if (lenLeft == 0) {
			return 0;
		}
		int left = 0, right = 0;
		for (int i = 0; i < lenLeft; i++) {

			if (haystack.charAt(i) == needle.charAt(0)) {
				if (lenRight == 1) {
					return i;
				}
				if (i + 1 <= lenLeft - 1) {
					if (i + lenRight < lenLeft ) {
						System.out.println(haystack.substring(i + 1, i + lenRight));
						System.out.println( needle.substring(1));
						if (haystack.substring(i + 1, i + lenRight).equals(needle.substring(1))) {
							return i;
						}
					}
					if (i + lenRight == lenLeft) {
						if (haystack.substring(i + 1).equals(needle.substring(1)) ) {
							return i;
						}
					}

				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
//		StrStr test = new StrStr();
//		test.strStr("hello","ll");
//		String s = "asdas";
		String t = "asdas";
//		String s1 = s.substring(0,2);
//		String s2 = t.substring(0,1);
		String s1 = "a";
		String s2 = new String("a");
		if(s1==s2){
			System.out.println('=');  
		}else{
			System.out.println('!');  
		}
	}
}
