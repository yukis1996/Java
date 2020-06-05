package jp.co.aivick.demo.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;

@Entity
@Table(name = "menu_recipe")
public class MenuRecipe {
	
	@Column(name = "menu_id")
	private Integer menu_id;
	
	@Column(name = "recipe_id")
	private Integer recipe_id;
	
	public Integer getMenuId() {
		return menu_id;	
	}
	
	public void setMenuId(Integer menu_id) {
		this.menu_id = menu_id;
	}
	
	public Integer getRecipeId() {
		return recipe_id;
	}
	
	public void setRecipeId(Integer recipe_id) {
		this.recipe_id = recipe_id;
	}
}
