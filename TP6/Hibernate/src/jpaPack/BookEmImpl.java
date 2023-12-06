package jpaPack;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class BookEmImpl implements BookEm{

	private EntityManagerFactory emf;
    private EntityManager em;

    public BookEmImpl(EntityManagerFactory emf) {
        this.emf = emf;
        this.em = emf.createEntityManager();
    }

    @Override
    public void bookAdd(Book book) {
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
    }

    @Override
    public void updateBook(Book book) {
        em.getTransaction().begin();
        em.merge(book);
        em.getTransaction().commit();
    }

    @Override
    public void deleteBook(Long bookId) {
        em.getTransaction().begin();
        Book book = em.find(Book.class, bookId);
        if (book != null) {
            em.remove(book);
        }
        em.getTransaction().commit();
    }

    @Override
    public List<Book> bookDisplayAll() {
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b", Book.class);
        return query.getResultList();
    }

    @Override
    public List<Book> bookFindByKw(String kw) {
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.title LIKE :kw", Book.class);
        query.setParameter("kw", "%" + kw + "%");
        return query.getResultList();
    }

    public void close() {
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }

}
