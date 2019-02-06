package Objects;

public class Book {

	private Long id;
	private Long id_category;
	private String title;
	private String category;
	private String author;

	private Book(Builder builder) {
		this.id = builder.id;
		this.id_category = builder.id_category;
		this.title = builder.title;
		this.category = builder.category;
		this.author = builder.author;
	}
	
	public static class Builder {

		private Long id;
		private Long id_category;
		private String title;
		private String category;
		private String author;

		public Builder setId(Long id) {
			this.id = id;
			return this;
		}

		public Builder setIdCategory(Long id_category) {
			this.id_category = id;
			return this;
		}

		public Builder setTitle(String title) {
			this.title = title;
			return this;
		}

		public Builder setCategory(String category) {
			this.category = category;
			return this;
		}

		public Builder setAuthor(String Author) {
			this.author = Author;
			return this;
		}

		public Book build() {
			return new Book(this);
		}

	}

	public Long getId() {
		return id;
	}

	public Long getId_category() {
		return id_category;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public String getAuthor() {
		return author;
	}

	@Override
	public String toString() {
		return "Book Id = " + id + ", Category id = " + id_category + ", Title = " + title + ", Category = " + category
				+ ", Author = " + author;
	}

	
	
	

}
