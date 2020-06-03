package jp.co.aivick.demo.form;

import javax.validation.constraints.NotEmpty;

public class MenuForm {
	
	private Integer id;
	
	@NotEmpty
	private String name;
	
	private String category;
	
	private Integer price;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
        return name;
    }
	
	public void setName(String name) {
        this.name = name;
    }
	
	public String getCategory() {
        return category;
    }
	
	public void setCategory(String category) {
        this.category = category;
    }
	
	public Integer getPrice() {
		return price;
	}
	
	public void setPrice(Integer price) {
		this.price = price;
	}


}
