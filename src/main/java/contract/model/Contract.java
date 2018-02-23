package contract.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/** Person data model. */
@Entity
@Table(name = "profile")
public class Contract extends CommonBaseModel {

	private String name;
	private String company;
	private String image;
	private String email;
	private Date birthdate;
	private String phone_number;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "contract", cascade = {CascadeType.ALL}, orphanRemoval = true)
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="contract")
	@JsonManagedReference
	private Set<Address> addresses;

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
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses.clear();
	    this.addresses.addAll(addresses);
	}

	

}
