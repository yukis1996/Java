public class Sum {
	public static void main (String[] args) {
		String num1 = args[0];
		String num2 = args[1];

		int result = Integer.parseInt(num1) + Integer.parseInt(num2);

		System.out.println(result);
	}
}