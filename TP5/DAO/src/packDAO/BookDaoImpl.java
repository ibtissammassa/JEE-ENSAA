package packDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    private Connection connection = ConnectionFactory.getConnection();

    @Override
    public void addBook(BookBean book) {
        try {
            String sql = "INSERT INTO book (title, author, price) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setFloat(3, book.getPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateBook(BookBean book) {
        try {
            String sql = "UPDATE book SET title = ?, author = ?, price = ? WHERE book_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setFloat(3, book.getPrice());
            statement.setLong(4, book.getBook_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBook(long bookId) {
        try {
            String sql = "DELETE FROM book WHERE book_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, bookId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<BookBean> displayAll() {
        List<BookBean> books = new ArrayList<>();
        try {
            String sql = "SELECT * FROM book";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                long bookId = resultSet.getLong("book_id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                float price = resultSet.getFloat("price");

                books.add(new BookBean(bookId, title, author, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public List<BookBean> findBook(String kw) {
        List<BookBean> books = new ArrayList<>();
        try {
            String sql = "SELECT * FROM book WHERE title LIKE ? OR author LIKE ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + kw + "%");
            statement.setString(2, "%" + kw + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                long bookId = resultSet.getLong("book_id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                float price = resultSet.getFloat("price");

                books.add(new BookBean(bookId, title, author, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}
