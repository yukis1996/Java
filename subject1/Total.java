public class Total {
	public static void main (String[] args) {
		int total = 0;
		for (String arg : args) {
			total = total + Integer.parseInt(arg);
		}
		System.out.println(total);
	}
}