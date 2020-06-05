package jp.co.aivick.demo.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;


@Entity(immutable = true)
@Table(name = "menus")
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	 final private Integer id;
	
	@Column(name = "name")
	final private String name;
	
	@Column(name = "category")
	final private String category;
	
	@Column(name = "price")
	final private Integer price;
	
	public Menu(Integer id, String name, String category, Integer price) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
	}
	
	public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public String getCategory() {
        return category;
    }
    
    public Integer getPrice() {
        return price;
    }
}
