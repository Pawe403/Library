package Interfaces;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import Objects.Book;
import Objects.Search_impl;

public interface IO_Inter {

	static Search_Inter books = new Search_impl();

	

	public static void saveToFile() throws IOException {

		Function<Book, String> ListToString = p -> p.toString();

		List<Book> book = books.SearchAllBooks();

		
		String path = "C:/Users/Pawe³/eclipse-workspace/Library/plik.txt";

		FileWriter filewriter = null;

		try {
			filewriter = new FileWriter(path);
			for (int i = 0; i < book.size(); i++) {
				Book first1 = book.get(i);
				filewriter.write(ListToString.apply(first1));
			
			}
				
			
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			if (filewriter != null) {
				filewriter.close();
			}
		}

	}

	public String openFromFile();
}
