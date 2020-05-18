public class Average {
	public static void main(String[] args) {
		double total = 0;
		double average = 0;
		for (String arg : args) {
			total = total + Integer.parseInt(arg);
		}
		average = total / args.length;
		if (total % args.length == 0) {
			System.out.println((int) average);
		} else {
			System.out.println(average);
		}
	}
}
