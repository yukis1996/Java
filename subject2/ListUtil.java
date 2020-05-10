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
		System.out.println(zipList);
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
	public static List<Integer> zip(List<Integer> key, List<Integer> value) {
		List<Integer> zipsList = new ArrayList<>();
		int small = Math.min(key.size(), value.size());
		for(int j =0; j < small; j++) {
			zipsList.addAll(List.of(key.get(j),value.get(j)));
		}
		return zipsList;
	}
}

