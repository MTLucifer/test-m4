package quick.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import quick.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book findById(Integer id);

    List<Book> findByName(String words);

    void save(Book book);

    void remove(Integer id);
}
