public class Pair {
	private int key;
	private int value;
	public static void main(String[] args) {
		Pair p = new Pair(1,2);
		int first = p.first();
		int second = p.second();
		System.out.println(first);
		System.out.println(second);
	}

	public Pair(int key, int value) {
		this.key = key;
		this.value = value;
	}

	public int first() {
		return this.key;
	}

	public int second() {
		return this.value;
	}
}