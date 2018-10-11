package helper;

public class BalancedParentheses {
	public static void main(String[] args) {
		String s = "()()";
		Stack<Character> st =new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			st.push(s.charAt(i));
		}
		st.show();
	}
}
