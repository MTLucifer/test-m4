package quick.service;

import quick.model.Book;
import quick.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(Integer id);

    void save(Category category);

    void remove(Integer id);
}
