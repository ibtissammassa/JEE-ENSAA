package jpaPack;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Créez une EntityManagerFactory en utilisant l'unité de persistance "Bookstore" du persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Bookstore");

        // Créez un EntityManager et un BookEmImpl en utilisant l'EntityManagerFactory
        BookEm bookEm = new BookEmImpl(emf);

        try {
            // Afficher tous les enregistrements de la table book
            List<Book> allBooks = bookEm.bookDisplayAll();
            System.out.println("Tous les livres dans la base de données :");
            for (Book book : allBooks) {
                System.out.println("Book ID: " + book.getBook_id());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Price: " + book.getPrice());
            }

            // Insérer un nouveau livre
            Book newBook = new Book(6,"Nouveau Livre","Nouvel Auteur",30);
            bookEm.bookAdd(newBook);
            System.out.println("Nouveau livre ajouté avec l'ID : " + newBook.getBook_id());

            // Afficher le nouveau livre ajouté
            List<Book> addedBooks = bookEm.bookFindByKw("Nouveau Livre");
            for (Book book : addedBooks) {
                System.out.println("Nouveau livre ajouté :");
                System.out.println("Book ID: " + book.getBook_id());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Price: " + book.getPrice());
            }

            // Modifier le prix du livre
            newBook.setPrice(50);
            bookEm.updateBook(newBook);
            System.out.println("Prix du livre mis à jour.");

            // Supprimer le livre
            bookEm.deleteBook(newBook.getBook_id());
            System.out.println("Livre supprimé.");
        } finally {
            // Fermez l'EntityManager et l'EntityManagerFactory
            emf.close();
        }
    }
}
