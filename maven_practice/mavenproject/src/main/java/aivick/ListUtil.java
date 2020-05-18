package aivick;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {
//	private static Object object;

	public static void main(String[] args) {
		// ②リストから偶数のみを抽出する
		var intList = List.of(1, 2, 3, 4, 5, 6);
		List<Integer> evenList = ListUtil.evensof(intList);
		for (Integer e : evenList) {
			System.out.println(e);
		}

		// ③指定した大きさと文字列からなるリストを作成
		List<String> hogeList = ListUtil.replicate(3, "hoge");
		System.out.println(hogeList);

		// ④zipの引数同士を組み合わせて抽出
		var zipList = ListUtil.zip(List.of(1, 2, 3), List.of(10, 9));
		System.out.println(zipList.toString());
		// toString()の記載せずとも自動的に呼び出し可能

		// ⑤値の約数を抽出しリスト化する
		var factorList = ListUtil.factors(15);
		System.out.println(factorList);

		// ⑥完全数を一覧として返す
		var perfect = ListUtil.perfects(500);
		System.out.println(perfect);

		var pa = ListUtil.pairs(List.of(1, 2, 3, 4));
		// var st = ListUtil.pairs(List.of("a", "b", "c"));
		System.out.println(pa);

		var sortedTest1 = ListUtil.sorted(List.of(1, 2, 3, 4));
		var sortedTest2 = ListUtil.sorted(List.of(3, 2, 5, 6));
		System.out.println(sortedTest1);
		System.out.println(sortedTest2);

		var pos = ListUtil.positions(10, List.of(10, 15, 20, 10, 10, 33));
		System.out.println(pos);

		var scalar = ListUtil.scalarProduct(List.of(1, 2, 3), List.of(4, 5, 6));
		System.out.println(scalar);

		var tetrads = ListUtil.zip4(List.of(1, 2, 3), List.of(10, 20, 30), List.of(100, 200, 300),
				List.of(1000, 2000, 3000));
		var firstTetrad = tetrads.get(0); //リストの最初の４つ組
		System.out.println(firstTetrad);
		var first = firstTetrad.first(); //1
		System.out.println(first);
		var tuple = firstTetrad.second();
		var second = tuple.first(); //10
		System.out.println(second);
		var pair = tuple.second();
		var thrid = pair.first(); //100
		System.out.println(thrid);
		var fourh = pair.second(); //1000
		System.out.println(fourh);
	}

	// ②evensofの処理
	public static List<Integer> evensof(List<Integer> intList) {
		List<Integer> evensList = new ArrayList<>();
		for (Integer e : intList) {
			if (e % 2 == 0) {
				evensList.add(e);
			}
		}
		return evensList;
	}

	// ③replicateの処理
	public static List<String> replicate(int item, String word) {
		List<String> strList = new ArrayList<>();
		for (int n = 0; n < item; n++) {
			strList.add(word);
		}
		return strList;
	}

	// ④zipの処理
	public static List<Pair<Integer, Integer>> zip(List<Integer> key, List<Integer> value) {
		List<Pair<Integer, Integer>> zipsList = new ArrayList<>();
		int small = Math.min(key.size(), value.size());
		for (int j = 0; j < small; j++) {
			Pair<Integer, Integer> pp = new Pair<>(key.get(j), value.get(j));
			zipsList.add(pp);
		}
		return zipsList;
	}

	// ⑤factorsの処理
	public static List<Integer> factors(int number) {
		List<Integer> fcList = new ArrayList<>();
		for (int n = 1; n <= number; n++) {
			if (number % n == 0) {
				fcList.add(n);
			}
		}
		return fcList;
	}

	// ⑥perfectsの処理
	public static List<Integer> perfects(int count) {
		List<Integer> pfList = new ArrayList<>();
		for (int p = 1; p <= count; p++) {
			int sum = 0;
			List<Integer> fact = factors(p);
			for (int ff : fact) {
				sum += ff;
			}
			if (sum - p == p) {
				pfList.add(p);
			}
		}
		return pfList;
	}

	public static List<Pair<Integer, Integer>> pairs(List<Integer> a) {
		List<Pair<Integer, Integer>> pList = new ArrayList<>();
		for (int d = 0; d < a.size() - 1; d++) {
			Pair<Integer, Integer> tt = new Pair<>(a.get(d), a.get(d + 1));
			pList.add(tt);
		}
		return pList;
	}

	public static boolean sorted(List<Integer> number) {
		var pairList = pairs(number);
		for (var pair : pairList) {
			if (pair.first() > pair.second()) {
				return false;
			}
		}
		return true;
	}

	public static List<Integer> positions(int num, List<Integer> numList) {
		List<Integer> posList = new ArrayList<>();
		for (int i = 0; i < numList.size(); i++) {
			posList.add(i);
		}
		List<Integer> position = new ArrayList<Integer>();
		var pairs = zip(posList, numList);
		for (var pair : pairs) {
			if (pair.second() == num) {
				position.add(pair.first());
			}
		}
		return position;
	}

	public static int scalarProduct(List<Integer> key, List<Integer> value) {
		int product = 0;
		int total = 0;
		for (int c = 0; c < key.size(); c++) {
			product = key.get(c) * value.get(c);
			total += product;
		}
		return total;
	}

	public static List<Pair<Integer, Pair<Integer, Pair<Integer, Integer>>>> zip4(List<Integer> first,
			List<Integer> second, List<Integer> third, List<Integer> fourth) {

		var min = Math.min(Math.min(first.size(), second.size()),
				Math.min(third.size(), fourth.size()));
		List<Pair<Integer, Pair<Integer, Pair<Integer, Integer>>>> zip4List = new ArrayList<>();

		for (int e = 0; e < min; e++) {
			zip4List.add(tetrad(first.get(e), second.get(e), third.get(e), fourth.get(e)));
		}

		return zip4List;

	}

	private static Pair<Integer, Pair<Integer, Pair<Integer, Integer>>> tetrad(Integer a, Integer b,
			Integer c, Integer d) {
		return new Pair<>(a, new Pair<>(b, new Pair<>(c, d)));

	}

}