package si.um.feri.zs.measurements.vao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Profile {

	public Profile() {
		
	}
	
	public Profile(String name, String surname, String email, double heigth) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.heigth = heigth;
	}

	private String name;
	
	private String surname;
	
	private String email;
	
	private double heigth;

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

	@Id
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getHeigth() {
		return heigth;
	}

	public void setHeigth(double heigth) {
		this.heigth = heigth;
	}

	@Override
	public String toString() {
		return "Profile [name=" + name + ", surname=" + surname + ", email=" + email + ", heigth=" + heigth + "] - "+super.toString();
	}
	
}
