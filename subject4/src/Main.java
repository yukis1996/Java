
public class Main {

	public static void main (String[] args) {
		var stringBox = new Pair2<>("str","ing");
		System.out.println(stringBox);
		System.out.println(stringBox.first());
		System.out.println(stringBox.second());
		var intBox = new Pair2<>(12,34);
		System.out.println(intBox);
		System.out.println(intBox.first());
		System.out.println(intBox.second());
	}

}
