package Interfaces;

import java.util.List;

import Objects.Book;
import Objects.Category;

public interface Search_Inter {

	public List<Book> SearhcAllBooks();

	public List<Category> SearchCategories();

	public void AddBook();

}
