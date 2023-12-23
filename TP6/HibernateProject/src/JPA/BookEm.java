package JPA;

import java.util.List;

public interface BookEm {
	void bookAdd(Book book);
    void updateBook(Book book);
    void deleteBook(Long bookId);
    List<Book> bookDisplayAll();
    List<Book> bookFindByKw(String kw);
}
