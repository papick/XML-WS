package XMLWS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import XMLWS.model.Category;
import XMLWS.service.CategoryService;

@RestController
@RequestMapping(value = "/api/category")
public class CategoryController {
	
	@Autowired
	private CategoryService cs;
	
	@GetMapping("/get-categories")
	public ResponseEntity<List<Category>> getCategories() {
		
		List<Category> c = cs.getAllCategories();

		return new ResponseEntity<List<Category>>(c, HttpStatus.OK);
	}

}
