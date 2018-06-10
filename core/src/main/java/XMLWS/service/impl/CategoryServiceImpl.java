package XMLWS.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import XMLWS.model.Category;
import XMLWS.repository.CategoryRepository;
import XMLWS.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;

	@Override
	public List<Category> getAllCategories() {
		return (List<Category>) categoryRepo.findAll();
	}

	@Override
	public Category getCategory(Long id) {
		return categoryRepo.findOne(id);
	}

	@Override
	public Category addCategory(Category c) {
		Category newCategory = new Category();
		newCategory.setName(c.getName());
		return categoryRepo.save(newCategory);
	}

	@Override
	public Category modifyCategory(Category c, Long id) {
		Category updated = categoryRepo.findOne(id);
		updated.setName(c.getName());
		return categoryRepo.save(updated);
	}

	@Override
	public void deleteCategory(Long id) {
		Category categoryForDelete = categoryRepo.findOne(id);
		if (categoryForDelete == null) {
			throw new IllegalArgumentException("Tried to delete non-existant category");
		}
		categoryRepo.delete(categoryForDelete);
	}

}
