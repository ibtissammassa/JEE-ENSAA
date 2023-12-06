package packJDBC;

import java.sql.Connection;
import java.sql.SQLException;

public class App {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		biblioJDBC biblio ;
		biblio.biblioConnect();
//		Connection connection = biblio.biblioConnect();
//		if (connection != null) {
//		//Afficher tous les enregistrements de la table
//	        biblio.bookDisplay(connection);
//	    //Insérer un nouveau livre 
//	        int BookId = biblio.bookAdd(connection, "Nouveau Livre", "Nouvel Auteur", 30);
//	        if (BookId != -1) {
//	        	//Afficher le nouveau livre ajouté
//	            biblio.bookFind(connection, BookId);
//	            //Modifier le prix de ce livre
//	            biblio.bookUpdate(connection, BookId, 19.99);
//	            //Supprimer le livre
//	            biblio.bookDelete(connection, BookId);
//	        }

      // Fermez la connexion à la base de données
	        try {
	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    } else {
	        System.out.println("La connexion à la base de données a échoué.");
	    }
	}

}
