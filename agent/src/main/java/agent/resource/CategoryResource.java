package agent.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookingws.soap.AccomodationService;
import com.bookingws.soap.AccomodationServicePort;
import com.bookingws.soap.GetCategoriesRequest;
import com.bookingws.soap.GetCategoriesResponse;

import agent.model.Category;
import agent.repository.CategoryRepository;


@RestController
@RequestMapping(value = "/api/category")
public class CategoryResource {

	@Autowired
	private CategoryRepository categoryRepository;

	@RequestMapping(method = RequestMethod.GET,
            value = "/get-categories",
            produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Category>> getCategories() {
		
		// Category category = new Category();
		
		AccomodationService accomodationService = new AccomodationService();
		AccomodationServicePort accomodationServicePort = accomodationService.getAccomodationServicePortSoap11();
		
		GetCategoriesRequest request = new GetCategoriesRequest();
		request.setName("all");
		GetCategoriesResponse response = accomodationServicePort.getCategories(request);
		List<Category> categories = response.getCategory();
		
		for(Category c : categories) {
			categoryRepository.save(c);
		}
		
		
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}

}
