package jp.co.aivick.demo.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class RecipeForm {
	
	private Integer id;
	
	@NotEmpty
	private String name;
	
	@Positive
	@NotNull
	private Integer cal;
	
	 public String getName() {
	        return name;
	    }

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public Integer getCal() {
	        return cal;
	    }

	    public void setCal(Integer cal) {
	        this.cal = cal;
	    }

}
