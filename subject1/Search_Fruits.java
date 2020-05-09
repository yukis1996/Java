import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class Search_Fruits {
	public static void main(String args[]) {
		int price = 0;
		price = Integer.parseInt(args[0]);
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
			if (price <= 100) {
				System.out.println(Index[0][0]+"、"+Index[1][0]+"、"+Index[2][0]+"、"+Index[3][0]+"、"+Index[4][0]);
			} else if (price <= 150) {
				System.out.println(Index[0][0]+"、"+Index[2][0]+"、"+Index[3][0]+"、"+Index[4][0]);
			} else if (price <= 200) {
				System.out.println(Index[0][0]+"、"+Index[3][0]+"、"+Index[4][0]);
			} else if (price <= 300) {
				System.out.println(Index[3][0]+"、"+Index[4][0]);
			} else if (price <= 400) {
				System.out.println(Index[4][0]);
			}
			br.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}