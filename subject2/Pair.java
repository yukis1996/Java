public class Pair {

	private  int first;
	private  int second;
	
	public static void main(String[] args) {
		Pair p = new Pair(1,2);
		System.out.println(p.getFirst());
		System.out.println(p.getSecond());
	}

	private Pair(int first, int second) {
		
		this.first = first;
		this.second = second;
	}
	public int getFirst() {
		return this.first;
	}
	public int getSecond() {
		return this.second;
	}


}