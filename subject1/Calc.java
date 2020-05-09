public class Calc {
	public static void main (String[] args) {
		int result = 0;
		String operator = args[0];
		String num1 = args[1];
		String num2 = args[2];
		switch (operator) {
			case "+":
				result = Integer.parseInt(num1) + Integer.parseInt(num2);
				System.out.println(result);
				break;
			case "-":
				result = Integer.parseInt(num1) - Integer.parseInt(num2);
				System.out.println(result);
				break;
			case "m":
				result = Integer.parseInt(num1) * Integer.parseInt(num2);
				System.out.println(result);
				break;
			case "/":
				result = Integer.parseInt(num1) / Integer.parseInt(num2);
				System.out.println(result);
				break;
			default:
				System.out.println("四則演算記号を入力してください");
				break;
		}
	}
}