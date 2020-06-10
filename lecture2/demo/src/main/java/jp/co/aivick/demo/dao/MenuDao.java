package jp.co.aivick.demo.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;

import jp.co.aivick.demo.entity.Menu;


@ConfigAutowireable
@Dao
public interface MenuDao {

	@Select
	Menu find(String id);
	
	@Select
	List<Menu> findALl();
	
	@Select
	List<Menu> name(String name, String category);
	
	@Insert
	Result<Menu> insert(Menu menu);

}
