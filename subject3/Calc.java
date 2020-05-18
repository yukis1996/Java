//import calc.Calculator;

public class Calc {

	public static void main(String[] args) throws IllegalAccessException {
		Calculator calculator = Calculator.create(args[0]);
		int result = calculator.calc(Integer.parseInt(args[1]), Integer.parseInt(args[2]));

		System.out.println(result);
	}

}
interface Calculator {
	public int calc(int x, int y);

	public static Calculator create(String op) throws IllegalAccessException {
		switch(op) {
		case "+":return new Sum();
		case "-":return new Minus();
		case "m":return new Multiplication();
		case "/":return new Division();
		default :
			throw new IllegalAccessException("invalid op");
		}
	}
}

class Sum implements Calculator {
	public int calc(int x, int y) {
		return x + y;
	}
}

class Minus implements Calculator {
	public int calc(int x, int y) {
		return x- y;
	}
}

class Multiplication implements Calculator {
	public int calc(int x, int y) {
		return x * y;
	}
}

class Division implements Calculator {
	public int calc(int x, int y) {
		return x / y;
	}
}



