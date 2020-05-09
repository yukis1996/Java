import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class FruitsAvg {
	public static void main(String args[]) {
		String Index[][] = new String[5][];
		double total = 0;
		double average = 0;
		try {
			File f = new File("fruits.csv");
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line;
			int count = 0;
			while((line = br.readLine()) != null){
			//strlist.add(str.split(","));
			//一行の内容を','で分割してそれぞれを[count=ノード番号]の２次元目の配列の要素として格納
			Index[count] = line.split(",");
			count++;
			}
			for (String arg: args) {
				switch (arg) {
						case "りんご":
						total = total + Integer.parseInt(Index[0][1]);
					break;
						case "バナナ":
						total = total + Integer.parseInt(Index[1][1]);
					break;
					case "みかん":
						total = total + Integer.parseInt(Index[2][1]);
						break;
					case "ぶどう":
						total = total + Integer.parseInt(Index[3][1]);
						break;
					case "もも":
						total = total + Integer.parseInt(Index[4][1]);
						break;
					default:
						System.out.println("入力に不備があります");
						break;
				}
			}
			average = total /args.length;
			if (total > 0) {
				if (total % args.length == 0 ) {
					System.out.println((int)average);
				} else {
					System.out.println(average);
				}	
			}
			br.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}