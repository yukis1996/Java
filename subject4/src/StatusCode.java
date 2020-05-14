import java.util.HashMap;
import java.util.Map;

public class StatusCode {

	private static Map<Integer, String> map = new HashMap<Integer, String>() {
		{
		put(100, "Continue");
		put(103, "Early Hints");
		put(200, "Ok");
		put(204, "No Content");
		put(300, "Multiple Choice");
		put(302, "Found");
		put(400, "But Request");
		put(404, "Not Found");
		put(500, "Internal Server Error");
		put(505, "HTTP Version Not Supported");
		}
	};

	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);
		var value = valueCode(num);

		System.out.println(value);
	}

	public static String valueCode(int key) {
		return map.get(key);
	}
}
