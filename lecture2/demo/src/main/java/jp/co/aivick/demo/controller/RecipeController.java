package jp.co.aivick.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.aivick.demo.entity.Recipe;
import jp.co.aivick.demo.form.RecipeForm;
import jp.co.aivick.demo.service.RecipeService;


@Controller		/*コントローラーを定義*/
@RequestMapping("/recipes")		
/*クラスやメソッドに使用できる、クラスに使用した場合は親パスとして機能する
 * @RequestMapping(value="/recipes", method=RequestMethod.GET, headers="Accept=application/*", params="id=002")
 * このように条件を指定してあげることもできる */

public class RecipeController {

	/*@ComponentはインスタンスをSpring管理下に置き@AutowiredでSpring管理下のオブジェクトの中から適切なものを変数にセットする
	 * @Controller、@Service、@Repository は@Componentを継承しているためほぼ差異はない*/
	@Autowired	
	RecipeService recipeService;
	
	@GetMapping("/list")
	public String list(RecipeForm recipeForm, Model model) { /* StringはView名を返す*/
		List<Recipe> recipeList = recipeService.findSearch(recipeForm.getSearch(), recipeForm.getBeforeCal(), recipeForm.getAfterCal());
		model.addAttribute("recipes", recipeList);
		return "recipes/list.html";
	}
	
	
	@GetMapping("/create")
	public String showCreate(Model model) {
		model.addAttribute("recipeForm", new RecipeForm());
		return "recipes/create.html";
	}
	
	@PostMapping("/create")
	public String create(@Validated RecipeForm recipeForm, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "recipes/create.html";
		}
		if (recipeForm.getName().equals(recipeService.nameValidate(recipeForm.getName()))) {
			//ストリーム
			return "recipes/create.html";
		}
		
		Recipe recipe = new Recipe();
		recipe.setName(recipeForm.getName());
		recipe.setCal(recipeForm.getCal());
		Recipe createdRecipe = recipeService.create(recipe);
		
		return "redirect:/recipes/update/" + createdRecipe.getId();
	}
	
	@GetMapping("/update/{id}")
	public String showUpdate(@PathVariable("id") String id, Model model) {
		Recipe recipe = recipeService.findBy(id);
		RecipeForm recipeForm = new RecipeForm();
		recipeForm.setId(recipe.getId());
		recipeForm.setName(recipe.getName());
		recipeForm.setCal(recipe.getCal());
		model.addAttribute("recipeForm", recipeForm);
		return "recipes/update.html";
	}
	
	@PostMapping("/update/{id}")
	public String update(@PathVariable("id") String id, @Validated RecipeForm recipeForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "recipes/update.html";
		}
		
		Recipe recipe = recipeService.findBy(id);
		recipe.setName(recipeForm.getName());
		recipe.setCal(recipeForm.getCal());
		Recipe updateRecipe = recipeService.update(recipe);
		
		return "redirect:/recipes/update/" + updateRecipe.getId();
		
	}
}
