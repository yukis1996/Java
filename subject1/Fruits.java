import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class Fruits {
	public static void main(String args[]) {
		String arg;
		arg = args[0];
		String Index[][] = new String[5][];
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
			switch (arg) {
				case "りんご":
					System.out.println(Index[0][1]);
					break;
				case "バナナ":
					System.out.println(Index[1][1]);
					break;
				case "みかん":
					System.out.println(Index[2][1]);
					break;
				case "ぶどう":
					System.out.println(Index[3][1]);
					break;
				case "もも":
					System.out.println(Index[4][1]);
					break;
				default:
					System.out.println("入力に不備があります");
					break;
			}
			br.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}