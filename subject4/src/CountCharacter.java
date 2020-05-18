import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CountCharacter {

	  public static void main(String args[]){
		  var str = args[0];
	    try{
	      File f = new File(str);
	      BufferedReader br = new BufferedReader(new FileReader(f));
	      Map<String,Integer> word = new HashMap<>();

	      int ch;
	      int i = 1;
	      while((ch = br.read()) != -1){
	    	  var ff = (char)ch;
	    	  String s = String.valueOf(ff);
	    	  word.put(s, i);
	    	  i = word.get(s);
	    	  word.replace(s,i);
	    	  i++;

	      }
	      System.out.println(word.entrySet());
//	      for (Map.Entry<String, Integer> c1 : word.entrySet()) {
//				System.out.println(c1.getKey());// a b c
//				System.out.println(c1.getValue());// 赤 オレンジ 青
//			}
//	    	  var c1 = word.entrySet();
//				System.out.println(c1.getKey());// a b c
//				System.out.println(c1.getValue());// 赤 オレンジ 青
	      br.close();
	    }catch(FileNotFoundException e){
	      System.out.println(e);
	    }catch(IOException e){
	      System.out.println(e);
	    }
	  }

}
