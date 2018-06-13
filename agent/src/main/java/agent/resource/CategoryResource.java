package agent.resource;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import agent.model.Category;
import agent.resource.response.ResponseCategories;
import agent.service.CategoryService;

@RestController
@RequestMapping(value = "/api/category")
public class CategoryResource {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/all-categories")
	public ResponseEntity<ResponseCategories> getCategories() {

		ArrayList<Category> categories = categoryService.findAllCategories();

		return new ResponseEntity<>(new ResponseCategories(categories), HttpStatus.OK);
	}

}
