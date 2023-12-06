package packDAO;

import java.util.List;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookDao bookDao = new BookDaoImpl();

        //Afficher tous les enregistrements de la table
        List<BookBean> allBooks = bookDao.displayAll();
        for (BookBean book : allBooks) {
            System.out.println(book.getBook_id() + " " + book.getTitle() + " " + book.getAuthor() + " " + book.getPrice());
        }

        //Insérer un nouveau livre
        BookBean newBook = new BookBean(0, "Nouveau Livre", "Nouvel Auteur", 40);
        bookDao.addBook(newBook);

        //Afficher le nouveau livre ajouté
        List<BookBean> foundBooks = bookDao.findBook("Nouveau Livre");
        if (!foundBooks.isEmpty()) {
            System.out.println("Nouveau livre ajouté :");
            for (BookBean book : foundBooks) {
                System.out.println(book.getBook_id() + " " + book.getTitle() + " " + book.getAuthor() + " " + book.getPrice());
            }
        }

        //Modifier le prix du livre
        newBook.setPrice(40);
        bookDao.updateBook(newBook);

        //Supprimer un livre
        bookDao.deleteBook(newBook.getBook_id());
	}

}
