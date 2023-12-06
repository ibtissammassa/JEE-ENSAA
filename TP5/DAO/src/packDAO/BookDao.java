package packDAO;

import java.util.List;

public interface BookDao {
	void addBook(BookBean book);
    void updateBook(BookBean book);
    void deleteBook(long bookId);
    List<BookBean> displayAll();
    List<BookBean> findBook(String kw);
}
