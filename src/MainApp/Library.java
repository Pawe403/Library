package MainApp;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import Interfaces.IO_Inter;
import Interfaces.Search_Inter;
import Objects.Book;
import Objects.Search_impl;

public class Library {

	private static Search_Inter books = new Search_impl();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// findAllBooks();
		try {
			IO_Inter.saveToFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//books.AddBook();

		// books.DeleteBook();
	}

	public static void findAllBooks() {
	
		List<Book> book = books.SearchAllBooks();
		book.stream().forEach(p -> System.out.println(p));

	}

}
