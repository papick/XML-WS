package agent.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agent.model.Category;
import agent.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public ArrayList<Category> findAllCategories() {
		
		System.out.println("TEST");
		
		return (ArrayList<Category>) categoryRepository.findAll();
	}

}
