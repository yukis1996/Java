package aivick;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListUtil {

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
	public static List<Integer> evensof(List<Integer> intList) {		//List.of(1, 2, 3, 4, 5, 6)
		return intList.stream()											//stream起動
					  .filter(e -> e % 2 == 0)							//Listの中身を一つずつ検証、e % 2 == 0に該当するものだけ残す
					  .collect(Collectors.toList());					//List<Integer>を作成し前から順に詰める
	}


	// ③replicateの処理
	public static List<String> replicate(int item, String word) {		//(3, "hoge")
		return IntStream.range(0, item)									//IntStreamを起動rangeで回数を指定、大きさ（0,1,2）まで
						.mapToObj(i -> String.valueOf(word))			//全てStringのhogeに変える処理
						.collect(Collectors.toList());					//List<String>を作成し前から順に詰める
	}


	// ④zipの処理
	public static List<Pair<Integer, Integer>> zip(List<Integer> key, List<Integer> value) {	//List.of(1, 2, 3), List.of(10, 9)
		int small = Math.min(key.size(), value.size());										//リストの大きさが小さいサイズをsmallに入れる
		return IntStream.range(0, small)													//IntStream起動rangeの範囲、今回は(0, 1)
						.mapToObj(j -> new Pair<>(key.get(j), value.get(j)))				//Pair<> (1, 10), (2, 9)を作成
						.collect(Collectors.toList());										//List<Pair<Integer, Integer>>に前から詰める
	}


	// ⑤factorsの処理
	public static List<Integer> factors(int number) {		// 15
		return IntStream.range(1, number + 1)				//IntStream起動rangeは(1,14+1)
						.filter(f -> number % f == 0)		//15 % (1～15) = 0 に該当するものだけ抽出
						.boxed()							//int型  => Integer型にするもの
						.collect(Collectors.toList());		//List<Integer>に前から詰める
	}




	// ⑥perfectsの処理
	public static List<Integer> perfects(int count) {									// 500
		return IntStream.range(1, count + 1)											//IntStream起動rangeは(1,４９９+1)
						.mapToObj(s -> new Pair<Integer, List<Integer>>(s, factors(s))) //Pair (1,factors(1))を500まで 例) (15,List.of(1,3,5,15))
						.filter(p -> total(p.second(), p.first()) == p.first())			//totalの返り値 == 15(rangeの値) のものだけ抽出
						.map(Pair::first)												//Pair を firstだけ取り出して変換 ()
						.collect(Collectors.toList());									//List<Integer>に前から詰めていく
	}

	private static int total(List<Integer> numList, int num) {							// 例) (List.of(1,3,5,15), 15)
		return numList.stream()															// List.of(1,3,5,15)にstream()
				.filter(i -> i != num)													// num(15)と同じものを除く
				.mapToInt(Integer::valueOf)												// int型に変更
				.sum();																	// 全て足す
	}

	public static List<Pair<Integer, Integer>> pairs(List<Integer> a) {			//List.of(1, 2, 3, 4)
		return IntStream.range(0, a.size() -1)									//0 ～2 の大きさで行う
						.mapToObj(i -> new Pair<>(a.get(i), a.get(i + 1)))		//Pair<>に格納していく  (1,2),(2,3),(3,4)
						.collect(Collectors.toList());							//PairをリストにしてList<Pair<Integer, Integer>>の形へ
	}


	public static boolean sorted(List<Integer> number) {
		return pairs(number).stream()
							.noneMatch(s -> s.first() > s.second());
	}


	public static List<Integer> positions(int num, List<Integer> numList) {  //10, List.of(10, 15, 20, 10, 10, 33)
		List<Integer> posList = IntStream.range(0, numList.size()) //int => Integer
										 .boxed()
										 .collect(Collectors.toList());// List.of(0,1,2,3,4,5)

		return zip(posList, numList).stream()
									.filter(i -> i.second() == num)
									.map(Pair::first)
									.collect(Collectors.toList());
	}


	public static int scalarProduct(List<Integer> key, List<Integer> value) { //(List.of(1, 2, 3), List.of(4, 5, 6))
		return zip(key, value).stream()										//List <Pair (1, 4), (2, 5), (3, 6)>
							  .mapToInt(c -> c.first() * c.second())		// int 4, 10, 18
							  .sum();										//int 32
	}


	public static List<Pair<Integer, Pair<Integer, Pair<Integer, Integer>>>> zip4(List<Integer> first,
			List<Integer> second, List<Integer> third, List<Integer> fourth) {
		var min = Math.min(Math.min(first.size(), second.size()),Math.min(third.size(), fourth.size()));
		return IntStream.range(0, min)
						.mapToObj(e -> zipList(first.get(e), second.get(e), third.get(e), fourth.get(e)))
						.collect(Collectors.toList());
	}


	private static Pair<Integer, Pair<Integer, Pair<Integer, Integer>>> zipList(Integer a, Integer b,
			Integer c, Integer d) {
		return new Pair<>(a, new Pair<>(b, new Pair<>(c, d)));

	}

}
