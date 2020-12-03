package quick.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import quick.model.Book;
import quick.model.Category;

public interface CategoryRepository extends CrudRepository<Category,Integer> {
}
