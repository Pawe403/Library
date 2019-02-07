package MainApp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import Interfaces.Search_Inter;
import Objects.Book;
import Objects.Search_impl;

public class Library {

	private static Search_Inter books = new Search_impl();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	findAllBooks();
	
//books.AddBook();

	books.DeleteBook();
	}
	
	public static void findAllBooks() {
		List<Book> book = books.SearchAllBooks();
		book.stream().forEach(p-> System.out.println(p));
		
	}

}
