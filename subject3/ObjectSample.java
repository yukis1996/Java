import java.util.List;

class ObjectSample {

	public static void main(String[] args) throws Exception {
		Recipe r1 = new Recipe("ハンバーグ", 200.5);
		Recipe r2 = new Recipe("目玉焼き", 120);
		Menu menu = new Menu("ハンバーグ弁当", "洋食", List.of(r1, r2));

        System.out.println(menu.getName());
		System.out.println(menu.getType());
		System.out.println(menu.getCal());
		System.out.println(menu.getRecipe().get(0).getName());
    }
}