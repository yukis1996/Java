package jp.co.aivick.demo.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import jp.co.aivick.demo.entity.Recipe;

@ConfigAutowireable
@Dao
public interface RecipeDao
{
    @Select
    Recipe find(Integer id);

    @Select
    List<Recipe> findAll();
}


