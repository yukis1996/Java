
class Pair2<T,S> {
	private final T first;
	private final S second;

	public Pair2(T first, S second) {
		this.first = first;
		this.second = second;
	}

	public T first() {
		return this.first;
	}

	public S second() {
		return this.second;
	}


	public String toString() {
		return "(" + this.first + "," + this.second + ")";
	}
}