package XMLWS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PostMapping("/add-category")
	public ResponseEntity<Category> addCategory(@RequestBody Category c) {

		Category categoryForAdd = cs.addCategory(c);
		return new ResponseEntity<Category>(categoryForAdd, HttpStatus.OK);
	}

	@PutMapping("/edit-category/{id}")
	public ResponseEntity<Category> editCategory(@PathVariable Long id, @RequestBody Category c) {
		return new ResponseEntity<Category>(cs.modifyCategory(c, id), HttpStatus.OK);
	}

	@DeleteMapping("/delete-category/{id}")
	public void deleteCategory(@PathVariable Long id) {
		cs.deleteCategory(id);
	}

}
