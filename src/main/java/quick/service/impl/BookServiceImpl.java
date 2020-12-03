package quick.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import quick.model.Book;
import quick.repository.BookRepository;
import quick.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findOne(id);
    }

    @Override
    public List<Book> findByName(String words) {
        return bookRepository.findBooksByNameContaining(words);
    }

    @Override
    public void save(Book book) {

        bookRepository.save(book);
    }

    @Override
    public void remove(Integer id) {
        bookRepository.delete(id);
    }
}
