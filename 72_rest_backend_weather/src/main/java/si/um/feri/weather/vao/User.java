package si.um.feri.weather.vao;

import java.util.ArrayList;
import java.util.List;

public class User {

	String userId; //=email
	List<String> favouritePlaces=new ArrayList<String>();
	String name;
	String surname;
	double bodyHeigth;
	double bodyWeigth;

	public User() {
	}
	
	public User(String userId, List<String> favouritePlaces, String name, String surname, double bodyHeigth,double bodyWeigth) {
		super();
		this.userId = userId;
		this.favouritePlaces = favouritePlaces;
		this.name = name;
		this.surname = surname;
		this.bodyHeigth = bodyHeigth;
		this.bodyWeigth = bodyWeigth;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<String> getFavouritePlaces() {
		return favouritePlaces;
	}

	public void setFavouritePlaces(List<String> favouritePlaces) {
		this.favouritePlaces = favouritePlaces;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public double getBodyHeigth() {
		return bodyHeigth;
	}

	public void setBodyHeigth(double bodyHeigth) {
		this.bodyHeigth = bodyHeigth;
	}

	public double getBodyWeigth() {
		return bodyWeigth;
	}

	public void setBodyWeigth(double bodyWeigth) {
		this.bodyWeigth = bodyWeigth;
	}
	
}
