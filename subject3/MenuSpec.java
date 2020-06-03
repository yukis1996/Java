
interface MenuSpec {

	public boolean satisfiedBy(Menu menu);
}

class MenuTypeSpec implements MenuSpec {

	private String menutype;

	public MenuTypeSpec(String menutype) {
		this.menutype = menutype;
	}

	@Override
	public boolean satisfiedBy(Menu menu) {
		return menu.getType().equals(this.menutype);

	}
}

class CalorieOverSpec implements MenuSpec {

	private int menucal;

	CalorieOverSpec(int menucal) {

		this.menucal = menucal;
	}

	@Override
	public boolean satisfiedBy(Menu menu) {
		return (menu.getCal() > menucal);
	}
}

class AndSpec implements MenuSpec {

	private MenuSpec menuSpec1;
	private MenuSpec menuSpec2;

	AndSpec(MenuSpec spec1, MenuSpec spec2) {
		this.menuSpec1 = spec1;
		this.menuSpec2 = spec2;
	}

	@Override
	public boolean satisfiedBy(Menu menu) {
		return menuSpec1.satisfiedBy(menu) && menuSpec2.satisfiedBy(menu);
	}

}

class OrSpec implements MenuSpec {

	private MenuSpec menuSpec1;
	private MenuSpec menuSpec2;

	OrSpec(MenuSpec spec1, MenuSpec spec2) {
		this.menuSpec1 = spec1;
		this.menuSpec2 = spec2;
	}

	@Override
	public boolean satisfiedBy(Menu menu) {
		return menuSpec1.satisfiedBy(menu) || menuSpec2.satisfiedBy(menu);
	}

}

class NotSpec implements MenuSpec {

	private MenuSpec menuSpec;

	NotSpec(MenuSpec spec) {
		this.menuSpec = spec;
	}

	@Override
	public boolean satisfiedBy(Menu menu) {
		return !menuSpec.satisfiedBy(menu);
	}

}

