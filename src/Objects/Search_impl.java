package Objects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Interfaces.Search_Inter;

public class Search_impl implements Search_Inter {

	private Connection getConnection(Connection connection) throws SQLException {
		try {
			Class.forName("om.mysql.cj.jdbc.Driver0");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		return DriverManager.getConnection(
				"jdbc:mysql://localhost/libary?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
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
	public List<Book> SearhcAllBooks() {

		List<Book> books = new ArrayList<>();

		Connection connection = null;

		String sql = "SELECT * FROM ";

		try {
			connection = getConnection(connection);
			PreparedStatement stm = connection.prepareStatement(sql);
			ResultSet resultSet = stm.executeQuery();
			while (resultSet.next()) {
				Book book = new Book.Builder().setId(resultSet.getLong("")).setIdCategory(resultSet.getLong(""))
						.setTitle(resultSet.getString("")).setCategory(resultSet.getString(""))
						.setAuthor(resultSet.getString("")).build();
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
		// TODO Auto-generated method stub

	}

}
