
public class Main {

	public static void main(String[]args) {
		try {
			method1();

		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void method1() throws Exception {
		method3();
		method2();
	}

	private static void method2() throws Exception {
		throw new Exception("hoge");
	}

	private static void method3() {
	}


}
