package quick.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import quick.model.Book;

import java.util.List;

public interface BookRepository extends PagingAndSortingRepository<Book,Integer> {
    List<Book> findBooksByNameContaining(String words);
}
