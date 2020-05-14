import java.util.ArrayList;
import java.util.List;

class Menu extends Recipe{
	String type;
	public Menu(String name, String type, List<>(r1,r2)) {
		// super(name, kl);
		this.type = type;
	}

	public String getType() {
		return this.type;
	}
	
	public double getCal() {
		Recipe r1 = new Recipe("ハンバーグ", 200.5);
		Recipe r2 = new Recipe("目玉焼き", 120);
		return r1.getCal() + r2.getCal();
	}
	
	public static void main(String[] args) throws Exception {
		Recipe r1 = new Recipe("ハンバーグ", 200.5);
		Recipe r2 = new Recipe("目玉焼き", 120);
		
		Menu menu = new Menu("ハンバーグ弁当", "洋食", List.of(r1, r2));

        System.out.println(menu.getName()); 
		System.out.println(menu.getType());
		System.out.println(menu.getCal());
		// System.out.println(menu.getRecipes().get(0).getName());
    }
}
