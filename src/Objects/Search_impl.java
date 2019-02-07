package Objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Interfaces.Search_Inter;

public class Search_impl implements Search_Inter {

	private Connection getConnection(Connection connection) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		return DriverManager.getConnection(
				"jdbc:mysql://localhost/library?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
				"root", "");
	}

	public void closeConnection(Connection connection) {
		if (connection == null) {
			return;
		} else {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Book> SearchAllBooks() {

		List<Book> books = new ArrayList<>();

		Connection connection = null;

		String sql = "SELECT * FROM books";

		try {
			connection = getConnection(connection);
			PreparedStatement stm = connection.prepareStatement(sql);
			ResultSet resultSet = stm.executeQuery();
			while (resultSet.next()) {
				Book book = new Book.Builder().setId(resultSet.getLong("id"))
						.setIdCategory(resultSet.getLong("id_category")).setTitle(resultSet.getString("title"))
						.setCategory(resultSet.getString("publisher")).setAuthor(resultSet.getString("author")).build();
				books.add(book);
			}
		} catch (SQLException ex) {
			ex.getStackTrace();
		} finally {
			closeConnection(connection);
		}

		return books;
	}

	@Override
	public List<Category> SearchCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void AddBook() {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		Integer id = null;
		String Title = null;
		String Publisher = null;
		String Author = null;

		Connection connection = null;

		String sql = "INSERT INTO books (ID_CATEGORY, TITLE, PUBLISHER, AUTHOR) VALUES (" + id + ",'" + Title + "','"
				+ Publisher + "','" + Author + "')";

		try {
			input = in.readLine();
			id = Integer.valueOf(input);

			input = in.readLine();
			Title = String.valueOf(input);

			input = in.readLine();
			Publisher = String.valueOf(input);

			input = in.readLine();
			Author = String.valueOf(input);

			connection = getConnection(connection);
			PreparedStatement stm = connection.prepareStatement(sql);

			if (stm.executeUpdate(sql) > 0) {
				System.out.println("Uda³o siê dodaæ Ksiazke");
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void DeleteBook() {
		// TODO Auto-generated method stub

		Connection connection = null;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String sql = "DELETE FROM books WHERE id = ?";
		int id;
		String input = "";
		try {
			connection = getConnection(connection);
			PreparedStatement stm = connection.prepareStatement(sql);
			input = reader.readLine();
			id = Integer.valueOf(input);
			stm.setInt(1,id);
			if(stm.executeUpdate()>0) {
				System.out.println("usunales ksiazke z ID " + id);
			}
			
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
				
		
	}

}
