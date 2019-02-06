package Objects;

public class Category {

	private Long id_category;
	private String categoryDesciption;

	public Long getId_category() {
		return id_category;
	}

	public void setId_category(Long id_category) {
		this.id_category = id_category;
	}

	public String getCategoryDesciption() {
		return categoryDesciption;
	}

	public void setCategoryDesciption(String categoryDesciption) {
		this.categoryDesciption = categoryDesciption;
	}

	@Override
	public String toString() {
		return "Category: Category id = " + id_category + ", Desciption = " + categoryDesciption;
	}
	
	

}
