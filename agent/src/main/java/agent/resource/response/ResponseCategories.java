package agent.resource.response;

import java.util.ArrayList;

import agent.model.Category;

public class ResponseCategories {

	private ArrayList<Category> categories;

	public ResponseCategories() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseCategories(ArrayList<Category> categories) {
		super();
		this.categories = categories;
	}

	public ArrayList<Category> getCategories() {
		return categories;
	}

	public void setCategories(ArrayList<Category> categories) {
		this.categories = categories;
	}

}
