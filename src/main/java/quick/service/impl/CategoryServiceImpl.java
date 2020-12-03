package quick.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import quick.model.Category;
import quick.repository.CategoryRepository;
import quick.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return null;
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public void remove(Integer id) {

    }
}
