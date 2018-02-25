package contract.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/** Person data model. */
@Entity
@Table(name = "profile")
public class Contract extends CommonBaseModel {

	private String name;
	private String company;
	private String image;
	private String email;
	private Date birthdate;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "contract", cascade = {CascadeType.ALL}, orphanRemoval = true)
	@JsonManagedReference
	private List<Address> addresses = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getPhone_number() {
		return phoneNumber;
	}

	public void setPhone_number(String phone_number) {
		this.phoneNumber = phone_number;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses.clear();
	    this.addresses.addAll(addresses);
	}

	

}
