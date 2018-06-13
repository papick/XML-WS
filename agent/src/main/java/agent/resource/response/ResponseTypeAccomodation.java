package agent.resource.response;

import java.util.ArrayList;

import agent.model.TypeAccomodation;

public class ResponseTypeAccomodation {

	private ArrayList<TypeAccomodation> types;

	public ResponseTypeAccomodation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseTypeAccomodation(ArrayList<TypeAccomodation> types) {
		super();
		this.types = types;
	}

	public ArrayList<TypeAccomodation> getTypes() {
		return types;
	}

	public void setTypes(ArrayList<TypeAccomodation> types) {
		this.types = types;
	}

}
