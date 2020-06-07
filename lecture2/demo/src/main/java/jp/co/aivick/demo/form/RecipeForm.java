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
	
	private String search;
	private Integer beforeCal;
	private Integer afterCal;
	
	
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
	    
		public String getSearch() {
			return search;
		}

		public void setSearch(String search) {
			this.search = search;
		}
		
		public Integer getBeforeCal() {
			return beforeCal;
		}

		public void setBeforeCal(Integer beforeCal) {
			this.beforeCal = beforeCal;
		}

		public Integer getAfterCal() {
			return afterCal;
		}

		public void setAfterCal(Integer afterCal) {
			this.afterCal = afterCal;
		}

}
