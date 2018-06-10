package XMLWS.service;

import java.util.List;

import org.springframework.stereotype.Service;

import XMLWS.model.Category;

@Service
public interface CategoryService {
	
	public List<Category> getAllCategories();
	
	public Category getCategory(Long id);
	
	public Category addCategory(Category c);
	
	public Category modifyCategory(Category c,Long id);
	
	public void deleteCategory(Long id);

}
