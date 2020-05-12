import java.util.ArrayList;
import java.util.List;

public class ListUtil {
	public static void main(String[] args) {
		// ②リストから偶数のみを抽出する
		var intList = List.of(1,2,3,4,5,6);
		List<Integer> evenList = ListUtil.evensof(intList);
		for (Integer e : evenList) {
			System.out.println(e);
		}

		// ③指定した大きさと文字列からなるリストを作成
		List<String> hogeList = ListUtil.replicate(3, "hoge");
		System.out.println(hogeList);
		
		// ④zipの引数同士を組み合わせて抽出
		var zipList = ListUtil.zip(List.of(1,2,3), List.of(10,9));
		System.out.println(zipList.toString());
		// toString()の記載せずとも自動的に呼び出し可能

		// ⑤値の約数を抽出しリスト化する
		var factorList = ListUtil.factors(15);
		System.out.println(factorList);

		// ⑥完全数を一覧として返す
		var perfect = ListUtil.perfects(500);
		System.out.println(perfect);

		// var pa = ListUtil.pairs(List.of(1,2,3,4));
		// System.out.println(pa);

		var pos = ListUtil.positions(10, List.of(10,15,20,10,10,33));
		System.out.println(pos);
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
	public static List<Pair<Integer,Integer>> zip(List<Integer> key, List<Integer> value) {
		List<Pair<Integer,Integer>> zipsList = new ArrayList<>();
		int small = Math.min(key.size(), value.size());
		for(int j =0; j < small; j++) {
			Pair<Integer,Integer> pp = new Pair<>(key.get(j),value.get(j));
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

	
	// public static List<Pair<Integer,Integer>> pairs(List<Integer> a) {
	// 	List<Pair<Integer,Integer>> pList = new ArrayList<>();
	// 	for (int d = 0; d < a.size() -1; d++) {
	// 		Pair<Integer,Integer> tt = new Pair<>(a.get(d),a.get(d+1));
	// 		pList.add(tt);
	// 	}
	// 	return tt;
	// }

	public static List<Pair<Integer,Integer>> positions(int eee, List<Integer> yyy) {
		// List<Integer> posList = new ArrayList<>();
		List<Integer> eeeList = new ArrayList<>();
		List<Pair<Integer,Integer>> ii = new ArrayList<>();
		for (int b = 0; b < yyy.size(); b++) {
			eeeList.add(eee);
		}
		List<Pair<Integer,Integer>> uu = zip(eeeList,yyy);
		// for (int p =0; p < yyy.size(); p++) {
		// 	ii = uu.get(p);
		// }
		return uu;
	}
}

