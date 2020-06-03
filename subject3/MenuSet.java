import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuSet {

	private List<Menu> menus;

	public MenuSet(List<Menu> menus) {
		this.menus = Collections.unmodifiableList(menus);
					//リストを読み取り専用とする
	}

	public List<Menu> getMenus() {
		return this.menus;
	}

	public List<Menu> getMenusByType(String type) {
		List<Menu> typeMenu = new ArrayList<Menu>();
		for (Menu menu :this.menus) {
			if (menu.getType().equals(type)) {
				typeMenu.add(menu);
			}
		}
		return typeMenu;
	}

	public List<Menu> getMenusByOverCalorie(int cal) {

		List<Menu> calMenu = new ArrayList<Menu>();
		for (Menu menu : this.menus) {
			if (menu.getCal() > cal) {
				calMenu.add(menu);
			}
		}
		return calMenu;
	}

	public List<Menu> getMenusBySpec(MenuSpec spec) {
		List<Menu> specMenu = new ArrayList<Menu>();
		for (Menu menu : this.menus) {
			if (spec.satisfiedBy(menu) == true) {
				specMenu.add(menu);
			}
		}
		return specMenu;
	}
}
