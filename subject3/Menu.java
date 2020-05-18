import java.util.List;

class Menu {
	String name;
	String type;
	private List<Recipe> recipe;

	public Menu(String name, String type, List<Recipe> recipe) {
		this.name = name;
		this.type = type;
		this.recipe = recipe;

	}

	public String getName() {
		return this.name;
	}

	public String getType() {
		return this.type;
	}

	public List<Recipe> getRecipe() {
		return this.recipe;
	}

	public double getCal() {
		int total = 0;
		for (Recipe recipe : this.recipe) {
			total += recipe.getCal();
		}
		return total;
	}
}
