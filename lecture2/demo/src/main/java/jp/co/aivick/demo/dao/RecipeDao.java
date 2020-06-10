package jp.co.aivick.demo.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import jp.co.aivick.demo.entity.Recipe;

@ConfigAutowireable
@Dao
public interface RecipeDao {
	
	@Select
	Recipe name(String name);

	@Select
	Recipe find(String id);
	
	@Select
	List<Recipe> findALl();
	
	@Select
	List<Recipe> search(String search, Integer beforeCal, Integer afterCal);
	
	@Select
	List<Recipe> cal(Integer beforeCal, Integer afterCal);
	
	@Insert
	int insert(Recipe recipe);
	
	@Update
    int update(Recipe recipe);
	
}
