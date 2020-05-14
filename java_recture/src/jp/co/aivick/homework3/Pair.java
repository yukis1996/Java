package jp.co.aivick.homework3;

public class Pair<T,S> {
	private T key;
	private S value;
	public static void main(String[] args) {
		Pair<Integer,Integer> p = new Pair<>(1,2);
		int first = p.first();
		int second = p.second();
		System.out.println(first);
		System.out.println(second);
	}

	public Pair(T key, S value) {
		this.key = key;
		this.value = value;
	}

	public T first() {
		return this.key;
	}

	public S second() {
		return this.value;
	}
	@Override
	public String toString() {
		return "(" + this.key + "," + this.value + ")";
	}
}