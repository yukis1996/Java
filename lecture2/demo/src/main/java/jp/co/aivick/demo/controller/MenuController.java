package jp.co.aivick.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.aivick.demo.entity.Menu;
import jp.co.aivick.demo.entity.Recipe;
import jp.co.aivick.demo.form.MenuForm;
import jp.co.aivick.demo.service.MenuService;
import jp.co.aivick.demo.service.RecipeService;


@Controller
@RequestMapping("/menus")
public class MenuController {
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	RecipeService recipeService;
	
	@GetMapping("/create")
	public String showCreate(Model model) {
		model.addAttribute("menuForm", new MenuForm());
		List<Recipe> recipe = recipeService.findAll();
		model.addAttribute("recipeList", recipe);
		return "menus/create.html";
	}
	
	@PostMapping("/create")
	public String create(@Validated MenuForm menuForm, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "menus/create.html";
		}
		
		Menu menu = new Menu(null, menuForm.getName(), menuForm.getCategory(),menuForm.getPrice());
		
		menuService.create(menu, menuForm.getRecipe());	
		
		return "redirect:/";
	}
	
	@GetMapping("/list")
	public String list(@RequestParam String name, @RequestParam String category, Model model) {
		if (name == null && category == null) {
			List<Menu> menu = menuService.findAll();
			model.addAttribute("menus", menu);
			model.addAttribute("menuForm", new MenuForm());
			return "menus/list.html";
		}
		List<Menu> menuList = menuService.findSearch(name, category);
		model.addAttribute("menus",menuList);
		
		return "menus/list.html";
	}
}
