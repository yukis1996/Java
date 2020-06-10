package jp.co.aivick.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.aivick.demo.dao.RecipeDao;
import jp.co.aivick.demo.entity.Recipe;

@Service
public class RecipeService {

	@Autowired
	private RecipeDao recipeDao;
	
	public Recipe nameValidate(String name) {
		return recipeDao.name(name);
	}
	
	public Recipe findBy(String id) {
		return recipeDao.find(id);
	}
	
	public List<Recipe> findAll() {
		return this.recipeDao.findALl();
	}
	
	public List<Recipe> findSearch(String search, Integer beforeCal, Integer afterCal) {
		return this.recipeDao.search(search, beforeCal, afterCal);
	}
	
	public List<Recipe> findCal(Integer beforeCal, Integer afterCal) {
		return this.recipeDao.cal(beforeCal, afterCal);
	}
	
	@Transactional
	public Recipe create(Recipe recipe) {
		recipeDao.insert(recipe);
		return recipe;
	}
	
	@Transactional
    public Recipe update(Recipe recipe) {
        recipeDao.update(recipe);
        return recipe;
    }
}
