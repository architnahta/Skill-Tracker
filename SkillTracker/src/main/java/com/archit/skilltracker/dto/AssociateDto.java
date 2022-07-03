package com.archit.skilltracker.dto;

import java.util.Objects;

import javax.validation.constraints.*;


public class AssociateDto {
	
	@NotNull
	@Pattern(regexp = "^CTS")
	private String associateId;
	
	@NotNull
	@Size(min = 5, max = 30)
	private String name;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	@Size(min = 10, max = 10)
	private String mobile;

	public String getAssociateId() {
		return associateId;
	}

	public void setAssociateId(String associateId) {
		this.associateId = associateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public int hashCode() {
		return Objects.hash(associateId, email, mobile, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssociateDto other = (AssociateDto) obj;
		return Objects.equals(associateId, other.associateId) && Objects.equals(email, other.email)
				&& Objects.equals(mobile, other.mobile) && Objects.equals(name, other.name);
	}
	
	
}
