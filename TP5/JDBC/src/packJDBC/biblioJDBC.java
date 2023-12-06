package packJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class biblioJDBC {
	public Connection biblioConnect() {
	    Connection connection = null;
	    try {
	        // Charger le pilote JDBC
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        // Établir la connexion
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblio", "MyUser", "1234");
	        System.out.println("Connexion à la base de données établie.");
	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	        System.err.println("Erreur de connexion à la base de données : " + e.getMessage());
	    }
	    return connection;
	}
	
	public void bookDisplay(Connection connection) {
	    try {
	        String sql = "SELECT * FROM book";
	        PreparedStatement statement = connection.prepareStatement(sql);
	        ResultSet result = statement.executeQuery();
	        
	        while (result.next()) {
	            int book_id = result.getInt("book_id");
	            String title = result.getString("Title");
	            String author = result.getString("Author");
	            double price = result.getDouble("Price");
	            System.out.println("ID: " + book_id + ", Titre: " + title + ", Auteur: " + author + ", Prix: " + price);
	        }
	        
	        statement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void bookFind(Connection connection, int bookId) {
	    try {
	        String sql = "SELECT * FROM book WHERE book_id = ?";
	        PreparedStatement statement = connection.prepareStatement(sql);
	        statement.setInt(1, bookId);
	        ResultSet result = statement.executeQuery();
	        
	        if (result.next()) {
	            int book_id = result.getInt("book_id");
	            String title = result.getString("Title");
	            String author = result.getString("Author");
	            double price = result.getDouble("Price");
	            System.out.println("ID FOUND: " + book_id + ", Titre: " + title + ", Auteur: " + author + ", Prix: " + price);
	        } else {
	            System.out.println("Aucun livre trouvé avec l'ID " + bookId);
	        }
	        
	        statement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public int bookAdd(Connection connection, String title, String author, double price) {
	    int newBookId = -1;
	    try {
	        String sql = "INSERT INTO book (Title, Author, Price) VALUES (?, ?, ?)";
	        PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
	        statement.setString(1, title);
	        statement.setString(2, author);
	        statement.setDouble(3, price);
	        
	        int rowsAffected = statement.executeUpdate();
	        
	        if (rowsAffected > 0) {
	            ResultSet generatedKeys = statement.getGeneratedKeys();
	            if (generatedKeys.next()) {
	                newBookId = generatedKeys.getInt(1);
	                System.out.println("Nouveau livre ajouté avec l'ID : " + newBookId);
	            }
	        } else {
	            System.out.println("Échec de l'ajout du nouveau livre.");
	        }
	        
	        statement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return newBookId;
	}
	
	public void bookUpdate(Connection connection, int bookId, double newPrice) {
	    try {
	        String sql = "UPDATE book SET Price = ? WHERE book_id = ?";
	        PreparedStatement statement = connection.prepareStatement(sql);
	        statement.setDouble(1, newPrice);
	        statement.setInt(2, bookId);
	        
	        int rowsAffected = statement.executeUpdate();
	        
	        if (rowsAffected > 0) {
	            System.out.println("Prix du livre avec l'ID " + bookId + " mis à jour avec succès.");
	        } else {
	            System.out.println("Échec de la mise à jour du prix du livre.");
	        }
	        
	        statement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void bookDelete(Connection connection, int bookId) {
	    try {
	        String sql = "DELETE FROM book WHERE book_id = ?";
	        PreparedStatement statement = connection.prepareStatement(sql);
	        statement.setInt(1, bookId);
	        
	        int rowsAffected = statement.executeUpdate();
	        
	        if (rowsAffected > 0) {
	            System.out.println("Livre avec l'ID " + bookId + " supprimé avec succès.");
	        } else {
	            System.out.println("Échec de la suppression du livre.");
	        }
	        
	        statement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
